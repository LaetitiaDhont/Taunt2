package com.taunt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taunt.model.CDC;
import com.taunt.util.HibernateUtil;

public class CDCDao {
	
	// Méthode pour afficher tout les cahiers des charges avec une ArrayList.

	public List<CDC> getAllCDC() {
		List<CDC> CDCbis = new ArrayList<CDC>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			CDCbis = session.createQuery("from CDC").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return CDCbis;
	}
}
