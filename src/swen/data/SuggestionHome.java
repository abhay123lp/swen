package swen.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swen.persistence.HibernateUtil;

public class SuggestionHome {

	public List<Suggestion> suggest(long userId, int count) {
		Session session = HibernateUtil.getSession();
		String hql = "select a, rand() from Article a order by rand()";
		Query query = session.createQuery(hql);
		query.setMaxResults(count);
		final List<Object[]> articles = query.list();

		User user = (User) session.load(User.class, userId);
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for (Object[] data : articles) {
			Suggestion suggestion = new Suggestion(user, (Article) data[0],
					SuggestionStatus.PENDING, ((Double) data[1]).floatValue());
			save(suggestion);
			suggestions.add(suggestion);
		}
		return suggestions;
	}

	public void save(Suggestion suggestion) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(suggestion);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				session.close();
			}
			throw ex;
		}
	}
	
	public Suggestion load(long id) {
		Session session = HibernateUtil.getSession();
		String hql = "from Suggestion where id=:id";
		Query query = session.createQuery(hql);
		query.setLong("id", id);
		return (Suggestion) query.uniqueResult();
	}

}
