package com.mycompany.uzytkownik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;

import com.mycompany.dao.UzytkownikDAO;
import com.mycompany.entities.Uzytkownik;

@Named
@RequestScoped
public class UzytkownikListBB {
	private static final String PAGE_UZYTKOWNIK_EDIT = "uzytkownikEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwisko;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	UzytkownikDAO uzytkownikDAO;
		
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<Uzytkownik> getFullList(){
		return uzytkownikDAO.getFullList();
	}

	public List<Uzytkownik> getList(){
		List<Uzytkownik> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwisko != null && nazwisko.length() > 0){
			searchParams.put("nazwisko", nazwisko);
		}
		
		//2. Get list
		list = uzytkownikDAO.getList(searchParams);
		
		return list;
	}

	public String newUzytkownik(){
		Uzytkownik uzytkownik = new Uzytkownik();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("uzytkownik", uzytkownik);
		
		//2. Pass object through flash	
		flash.put("uzytkownik", uzytkownik);
		
		return PAGE_UZYTKOWNIK_EDIT;
	}

	public String editUzytkownik(Uzytkownik uzytkownik){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("uzytkownik", uzytkownik);
		
		//2. Pass object through flash 
		flash.put("uzytkownik", uzytkownik);
		
		return PAGE_UZYTKOWNIK_EDIT;
	}

	public String deleteUzytkownik(Uzytkownik uzytkownik){
		uzytkownikDAO.remove(uzytkownik);
		return PAGE_STAY_AT_THE_SAME;
	}
}
