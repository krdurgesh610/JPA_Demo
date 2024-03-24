package org.jspiders.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByGstNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant Gst_Number for Fetch all Details");
		String gst_number = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m from Merchant m where m.gst_number=?1");
		q.setParameter(1, gst_number);
		List<Merchant> merchants = q.getResultList();
		if(merchants.size()>0) {
			for(Merchant m:merchants) {
				System.out.println(m);
				System.out.println("------------------------------------");
			}
		}
		else {
			System.err.println("Invalid Merchant Gst_Number");
		}
	}
}
