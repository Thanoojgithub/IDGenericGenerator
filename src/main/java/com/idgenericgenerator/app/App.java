package com.idgenericgenerator.app;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idgenericgenerator.pojo.Book;
import com.idgenericgenerator.pojo.Customer;
import com.idgenericgenerator.util.HibernateUtil;
import com.idgenericgenerator.util.RandomUtils;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(new Customer(RandomUtils.generateRandomString(12)));
			session.save(new Book(RandomUtils.generateRandomString(12)));
			tx.commit();
		} catch (RuntimeException e) {
			try {
				if (tx != null) {
					tx.rollback();
				}
			} catch (RuntimeException rbe) {
				logger.error("Couldn’t roll back transaction", rbe);
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
