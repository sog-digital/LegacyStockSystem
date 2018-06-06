package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Product;

public interface StockService {
	
	/**
	 * This method allows the users to create a new stock on the Legacy Stock Control System
	 * @param product have details for a new stock
	 * @return boolean value 
	 */
	public boolean create(Product product);
	
	
	/**
	 * This method allows the users to get the details of a stock from 
	 * the Legacy Stock Control System
	 * 
	 * @param id product id
	 * @return Product details object
	 */
	public Product getStock(int id);
	
}
