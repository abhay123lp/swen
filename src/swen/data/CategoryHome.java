package swen.data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import swen.persistence.HibernateUtil;

public class CategoryHome {

	public Category load(long id) {
		Session session = HibernateUtil.getSession();
		String hql = "from Category where id=:id";
		Query query = session.createQuery(hql);
		query.setLong("id", id);
		return (Category) query.uniqueResult();
	}

	public List<Category> list() {
		Session session = HibernateUtil.getSession();
		String hql = "from Category order by name asc";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public long count() {
		Session session = HibernateUtil.getSession();
		String hql = "select count(*) from Category";
		Query query = session.createQuery(hql);
		return (Long) query.uniqueResult();
	}
	
}
