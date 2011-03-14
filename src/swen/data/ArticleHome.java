package swen.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swen.persistence.HibernateUtil;


public class ArticleHome {

	public Article load(long id) {
		Session session = HibernateUtil.getSession();
		String hql = "from Article where id=:id";
		Query query = session.createQuery(hql);
		query.setLong("id", id);
		return (Article) query.uniqueResult();
	}

	public void save(Article article) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(article);
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
