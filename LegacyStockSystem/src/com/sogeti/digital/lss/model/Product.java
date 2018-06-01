package com.sogeti.digital.lss.model;

public class Product {
	
	private int id;
	private String name;
	private String price;
	private int amount;
	private String lastCreated;
	private String lastUpdated;
	
	public Product() {}
	
	public Product(int id, String name, String price, int amount) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the lastCreated
	 */
	public String getLastCreated() {
		return lastCreated;
	}
	/**
	 * @param lastCreated the lastCreated to set
	 */
	public void setLastCreated(String lastCreated) {
		this.lastCreated = lastCreated;
	}
	/**
	 * @return the lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	

}
