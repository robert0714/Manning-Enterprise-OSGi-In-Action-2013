package fancyfoods.department.cheese.offers;

import java.util.List;

import fancyfoods.food.Food;
import fancyfoods.food.Inventory;
import fancyfoods.offers.SpecialOffer;

 
public class DesperateCheeseOffer implements SpecialOffer {

    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    
    public String getDescription() {
        return "A wonderful surprise for someone cheesy.";
    }

    
    public Food getOfferFood() {
        List<Food> cheeses = 
           inventory.getFoodsWhoseNameContains("cheese", 1);
        Food leastPopularCheese = cheeses.get(0);
        return leastPopularCheese;
    }
} 

