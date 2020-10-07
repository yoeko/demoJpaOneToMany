package presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Formateur;
import metier.Formation;

public class Lanceur {

	public static void main(String[] args) {
		
		// 1. Ouverture unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-onetomany");
		EntityManager em = emf.createEntityManager();
		
		// 2. Ouverture transaction 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	3. Instanciation Objet métier
		Formation formation = new Formation("Hibernate");
		Formateur formateur1 = new Formateur("Sall", "Chekina", 8);
		Formateur formateur2 = new Formateur("Mbiandou", "Douglas", 12);
		
		formation.getFormateurs().add(formateur1);
		formation.getFormateurs().add(formateur2);
		
		//	4. Persistence Objet/Relationnel : création d'un enregistrement en base
		em.persist(formateur1);
		em.persist(formateur2);
		em.persist(formation);
		
		//	5. Fermeture transaction
		tx.commit();
		
		//	6. Fermeture unité de travail JPA
		em.close();
		emf.close();		
		
	}

}
