package com.sogeti.digital.lss.service;

import java.util.List;

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
	
	/**
	 * This method allows the users to get the list of all the stocks
	 * from the Legacy Stock Control System
	 * 
	 * @return all the stocks list
	 */
	public Product[] getAllTheStocks();
	
	/**
	 * This method allows the users to update the stock details on to the 
	 * Legacy Stock Control System
	 * 
	 * @param product
	 * @return boolean value
	 */
	public boolean update(Product product);
	
	
}
