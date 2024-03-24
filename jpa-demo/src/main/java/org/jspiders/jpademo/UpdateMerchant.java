package org.jspiders.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m = manager.find(Merchant.class, 2);
		m.setPassword("durgesh@123");
		m.setName("Durgesh");
		m.setEmail("durgesh@gmail.com");
		m.setGst_number("dk123");
		m.setPhone(8051231489L);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}

}
