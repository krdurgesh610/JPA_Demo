package org.jspiders.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyUsingEmailAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant Email Id & Password");
		String email = sc.next();
		String pass = sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
//		Query q = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		Query q= manager.createNamedQuery("VerifyUsingEmailAndPassword");
		q.setParameter(1, email);
		q.setParameter(2, pass);
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.err.println("Verification Successful");
			System.out.println(m);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Email & Password Entered");
		}
	}
}
