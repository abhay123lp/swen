package swen.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swen.persistence.HibernateUtil;

public class UserHome {
	
	public User load(long id) {
		Session session = HibernateUtil.getSession();
		String hql = "from User where id=:id";
		Query query = session.createQuery(hql);
		query.setLong("id", id);
		return (User) query.uniqueResult();
	}

	public User load(String name) {
		Session session = HibernateUtil.getSession();
		String hql = "from User where name=:name";
		Query query = session.createQuery(hql);
		query.setString("name", name);
		return (User) query.uniqueResult();
	}
	
	public void save(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				session.close();
			}
			throw ex;
		}
	}
	
}
