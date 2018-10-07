package com.taunt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taunt.model.Licence;
import com.taunt.util.HibernateUtil;

public class LicenceDao {

	// Méthode pour afficher toutes les licences 
	
	public List<Licence> getAllLicences() {
		List<Licence> Licencebis = new ArrayList<Licence>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Licencebis = session.createQuery("from Licence").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return Licencebis;
	}
}
