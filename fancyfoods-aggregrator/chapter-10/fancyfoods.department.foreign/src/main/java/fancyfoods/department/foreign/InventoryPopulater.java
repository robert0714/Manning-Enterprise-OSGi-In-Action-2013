package fancyfoods.department.foreign;

import fancyfoods.food.Inventory;

 
public class InventoryPopulater {

	private Inventory inventory;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void populate() {
		boolean isInventoryPopulated = (inventory.getFoodCount() > 0);

		if (!isInventoryPopulated) {
			inventory.createFood("Foreign Sushi", 3.45, 10);
			inventory.createFood("Foreign Borscht", 1.81, 15);
		}
	}
}

