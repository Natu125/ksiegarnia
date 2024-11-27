package com.mycompany.uzytkownik;

import java.io.IOException;
import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.mycompany.dao.UzytkownikDAO;
import com.mycompany.entities.Uzytkownik;

@Named
@ViewScoped
public class UzytkownikEditGETBB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_UZYTKOWNIK_LIST = "uzytkownikList?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private Uzytkownik uzytkownik = new Uzytkownik();
	private Uzytkownik loaded = null;

	@Inject
	FacesContext context;

	@EJB
	UzytkownikDAO uzytkownikDAO;

	public Uzytkownik getUzytkownik() {
		return uzytkownik;
	}

	public void onLoad() throws IOException {
		if (!context.isPostback()) {
			if (!context.isValidationFailed() && uzytkownik.getIdUzytkownika() != null) {
				loaded = uzytkownikDAO.find(uzytkownik.getIdUzytkownika());
			}
			if (loaded != null) {
				uzytkownik = loaded;
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
				// if (!context.isPostback()) { // possible redirect
				// context.getExternalContext().redirect("uzytkownikList.xhtml");
				// context.responseComplete();
				// }
			}
		}

	}

	public String saveData() {
		// no Uzytkownik object passed
		if (loaded == null) {
			return PAGE_STAY_AT_THE_SAME;
		}

		try {
			if (uzytkownik.getIdUzytkownika() == null) {
				// new record
				uzytkownikDAO.create(uzytkownik);
			} else {
				// existing record
				uzytkownikDAO.merge(uzytkownik);
			}
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystąpił błąd podczas zapisu", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		return PAGE_UZYTKOWNIK_LIST;
	}
}
