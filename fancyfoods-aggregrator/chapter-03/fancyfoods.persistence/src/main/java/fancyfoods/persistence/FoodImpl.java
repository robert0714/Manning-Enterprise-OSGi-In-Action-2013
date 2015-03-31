package fancyfoods.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import fancyfoods.food.Food;

 

@Entity(name = "FOOD")
public class FoodImpl implements Food {

	@Id
	private String name;
	private double price;
	private int quantity;

	public FoodImpl() { 
	}

	public FoodImpl(String name, double price, int quantity) {
		this();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	//...
	 

	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	public int getQuantityInStock() {
		return this.quantity;
	}

	public void setQuantityInStock(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "There were " + getQuantityInStock() + " packs of " + getName()
				+ " in stock.";
	}

}
