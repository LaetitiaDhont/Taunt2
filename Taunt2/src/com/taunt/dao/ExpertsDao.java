package com.taunt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taunt.model.Experts;
import com.taunt.util.HibernateUtil;

public class ExpertsDao {

	// Méthode pour afficher tout les experts

	public List<Experts> getAllExperts() {
		List<Experts> Expertsbis = new ArrayList<Experts>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Expertsbis = session.createQuery("from Experts").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return Expertsbis;
	}
}
