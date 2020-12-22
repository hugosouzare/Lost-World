package model;

import exceptions.EquipsException;

public class Item  {
	protected String name;
	protected int itemID;
	protected int price;

	public Item() {
		
	}
	
	public Item(String name, int itemID, int price) {
		this.name = name;
		this.itemID = itemID;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getItemID() {
		return itemID;
	}


}