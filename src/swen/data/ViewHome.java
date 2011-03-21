package swen.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swen.persistence.HibernateUtil;

public class ViewHome {

	public void save(View view) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(view);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				session.close();
			}
			throw ex;
		}
	}

	public long count(long articleId) {
		Session session = HibernateUtil.getSession();
		String hql = "select count(*) from View where article.id=:artId";
		Query query = session.createQuery(hql);
		query.setLong("artId", articleId);
		return (Long) query.uniqueResult();
	}

}
