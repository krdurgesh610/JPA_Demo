package org.jspiders.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindMerchantById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Merchant Id to display Details");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m = manager.find(Merchant.class, id);
		if (m != null) {
			System.out.println(m);
		} else {
			System.out.println("You have entered an Invalid Merchant id");
		}
	}

}
