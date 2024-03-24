package org.jspiders.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchantByMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id , name , Gst_Number , Email , Phone , Password");
		Merchant m = new Merchant();
		m.setId(sc.nextInt());
		m.setEmail(sc.next());
		m.setGst_number(sc.next());
		m.setName(sc.next());
		m.setPassword(sc.next());
		m.setPhone(sc.nextLong());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		m = manager.merge(m);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Merchant Updated with Id :-" + m.getId());
	}
}
