package org.jspiders.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllGstNumbers {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m.gst_number from Merchant m");
		List<String> phs = q.getResultList();
		for (String ph : phs) {
			System.out.println(ph);
		}
	}
}
