package fancyfoods.persistence;

import javax.persistence.*;

public class AppManagedInventory {

	public void doStuff() {
		EntityManagerFactory entityManagerFactory = null;
		FoodImpl food = null;
		
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		em.getTransaction().begin();
		try {
			em.persist(food); 
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		} 
	}

}
