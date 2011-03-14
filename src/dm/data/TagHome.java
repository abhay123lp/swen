package dm.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dm.persistence.HibernateUtil;

public class TagHome {

	public Tag load(String name) {
		Session session = HibernateUtil.getSession();
		String hql = "from Tag where name=:name";
		Query query = session.createQuery(hql);
		query.setString("name", name);
		return (Tag) query.uniqueResult();
	}
	
	public Tag load(long id) {
		Session session = HibernateUtil.getSession();
		String hql = "from Tag where id=:id";
		Query query = session.createQuery(hql);
		query.setLong("id", id);
		return (Tag) query.uniqueResult();
	}
	
	public void save(Tag tag) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(tag);
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
