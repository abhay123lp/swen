package swen.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swen.persistence.HibernateUtil;


public class ArticleHome {

	public List<Article> listByCategory(long categoryId, int start, int max) {
		Session session = HibernateUtil.getSession();
		String hql = "from Article where category.id=:catId " +
				"order by publishDate desc";
		Query query = session.createQuery(hql);
		query.setLong("catId", categoryId);
		query.setFirstResult(start);
		query.setMaxResults(max);
		return query.list();
	}
	
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
	
	public long count() {
		Session session = HibernateUtil.getSession();
		String hql = "select count(*) from Article";
		Query query = session.createQuery(hql);
		return (Long) query.uniqueResult();
	}

	public List<Article> list(int start, int max) {
		Session session = HibernateUtil.getSession();
		String hql = "from Article";
		Query query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(max);
		return query.list();
	}
	
	public List<Article> listHome(int count) {
		Session session = HibernateUtil.getSession();
		String hql = "from Article order by rand()";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.list();
	}
	
}
