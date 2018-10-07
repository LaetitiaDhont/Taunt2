package com.taunt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taunt.model.Users;
import com.taunt.util.HibernateUtil;

public class UsersDao {

	// Méthode ajouter une nouvel utilisateur
	
	public void addUser(Users user, String mailUtilisateur, String mdpUtilisateur) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		user = new Users();
		user.setMailUtilisateur(mailUtilisateur);
		user.setMdpUtilisateur(mdpUtilisateur);
		
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}

	}
	
	
	// Méthode pour delete un utilisateur

	public void deleteUser(int idUtilisateur) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Users user = (Users) session.load(Users.class, new Integer(idUtilisateur));
			session.delete(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	// Méthode pour update un utlisateur 
	

	public void updateUser(Users user) {
		
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
		
	}

}
