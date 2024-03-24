package org.jspiders.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Merchant m = new Merchant();
		System.out.println("Enter the Name");
		m.setName(sc.next());
		System.out.println("Enter the gst_Number");
		m.setGst_number(sc.next());
		System.out.println("Enter the Phone");
		m.setPhone(sc.nextLong());
		System.out.println("Enter the Email");
		m.setEmail(sc.next());
		System.out.println("Enter the password");
		m.setPassword(sc.next());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		manager.persist(m);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Merchant Saved with ID:-" + m.getId());

	}

}
