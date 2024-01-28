package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {

		try (EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
				EntityManager entityManager = emfEntityManagerFactory.createEntityManager();) {

	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
