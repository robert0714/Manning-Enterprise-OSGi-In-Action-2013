package fancyfoods.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fancyfoods.food.Food;
import fancyfoods.food.Inventory;

 
public class InventoryImpl implements Inventory {

    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    
    
    public FoodImpl getFood(String name) {
        return em.find(FoodImpl.class, name);
    }

    
    public void createFood(String name, double price, int quantity) {
        FoodImpl food = new FoodImpl(name, price, quantity);
        em.persist(food);
    } 

    
    
    public List<Food> getFoodsWhoseNameContains(String foodName,
                                                int maxResults) {
        String query = "SELECT f FROM FOOD f WHERE f.name LIKE '%" +
                  foodName + "%' ORDER BY f.quantity DESC";
        Query q = em.createQuery(query);

        q.setMaxResults(maxResults);
        List<Food> list = q.getResultList();

        return list;
    }

    
    public int getFoodCount() {
        Query query = em.createQuery("SELECT COUNT(f) FROM FOOD f");
        Number count = (Number) query.getSingleResult();
        return count.intValue();
    } 

    
    
    public int removeStock(String name, int quantity) {
        FoodImpl food = getFood(name);
        int currentLevel = food.getQuantityInStock();
        int newLevel = currentLevel - quantity;
        if (newLevel >= 0) {
            food.setQuantityInStock(newLevel);
            em.persist(food);
            return newLevel;
        } else {
            throw new IllegalArgumentException(
                "Cannot have level below 0: " + newLevel);
        }
    } 

}
