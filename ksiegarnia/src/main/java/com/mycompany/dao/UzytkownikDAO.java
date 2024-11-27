package com.mycompany.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.mycompany.entities.Uzytkownik;

//DAO - Data Access Object for Uzytkownik entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class UzytkownikDAO {
	private final static String UNIT_NAME = "my_persistence_unit";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Uzytkownik uzytkownik) {
		em.persist(uzytkownik);
	}

	public Uzytkownik merge(Uzytkownik uzytkownik) {
		return em.merge(uzytkownik);
	}

	public void remove(Uzytkownik uzytkownik) {
		em.remove(em.merge(uzytkownik));
	}

	public Uzytkownik find(Object id) {
		return em.find(Uzytkownik.class, id);
	}

	public List<Uzytkownik> getFullList() {
		List<Uzytkownik> list = null;

		Query query = em.createQuery("select u from Uzytkownik u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Uzytkownik> getList(Map<String, Object> searchParams) {
		List<Uzytkownik> list = null;

		// 1. Build query string with parameters
		String select = "select u ";
		String from = "from Uzytkownik u ";
		String where = "";
		String orderby = "order by u.nazwisko asc, u.imie";

		// search for surname
		String nazwisko = (String) searchParams.get("nazwisko");
		if (nazwisko != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "u.nazwisko like :nazwisko ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (nazwisko != null) {
			query.setParameter("nazwisko", nazwisko+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Uzytkownik objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
