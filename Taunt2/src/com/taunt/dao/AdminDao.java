package com.taunt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taunt.util.HibernateUtil;
import com.taunt.model.Admin;
import com.taunt.model.Licence;

public class AdminDao {

	// Méthode pour ajouter une licence

	public void addLicence(Licence licence) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(licence);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
	}

	// Méthode pour supprimer une licence

	public void deleteLicence(int idLicence) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Licence licence = (Licence) session.load(Licence.class, new Integer(idLicence));
			session.delete(licence);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
	}

	// Méthode pour update une licence

	public void updateLicence(Licence licence) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(licence);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
	}

	// Méthode pour selectionner un admin par son id

	public Admin getAdminById(int idAdmin) {
		Admin admin = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from Admin where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", idAdmin);
			admin = (Admin) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return admin;
	}
}
