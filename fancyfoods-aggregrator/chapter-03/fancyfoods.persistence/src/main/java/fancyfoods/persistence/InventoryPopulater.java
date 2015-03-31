package fancyfoods.persistence;

import fancyfoods.food.Inventory;

 
public class InventoryPopulater {

	private Inventory inventory;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void populate() {
		boolean isInventoryPopulated = (inventory.getFoodCount() > 0);

		if (!isInventoryPopulated) {
			inventory.createFood("Blue cheese", 3.45, 10);
			inventory.createFood("Wensleydale cheese", 1.81, 15);
			inventory.createFood("Normal chocolates", 6.99, 8);
		}
	}
}

