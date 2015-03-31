package fancyfoods.chocolate;

import fancyfoods.food.Food;

public class SquareChocolates implements Food {

	
	public String getName() {
		return "Normal chocolates";
	}

	
	public double getPrice() {
		return 6.99;
	}

	
	public int getQuantityInStock() {
		return 20;
	}
}
