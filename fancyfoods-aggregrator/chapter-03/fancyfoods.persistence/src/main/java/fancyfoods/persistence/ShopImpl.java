package fancyfoods.persistence;

import fancyfoods.food.*;

public class ShopImpl implements Shop {
	private Inventory inventory;
	private Accounting accounting;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setAccounting(Accounting accounting) {
		this.accounting = accounting;
	}

	
	public double purchase(String foodName, String customerName, int quantity) {
		Food food = inventory.getFood(foodName);
		inventory.removeStock(foodName, quantity);
		double totalPrice = quantity * food.getPrice();
		accounting.chargeToAccount(customerName, totalPrice);
		return accounting.getCustomer(customerName).getBalance();
	}
}
