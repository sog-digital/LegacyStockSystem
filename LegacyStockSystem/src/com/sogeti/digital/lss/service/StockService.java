package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Product;

public interface StockService {
	
	/**
	 * This method allows the users to create a new stock on the Legacy Stock Control Sytem
	 * @param product have details for a new stock
	 * @return boolean value 
	 */
	public boolean create(Product product);
	
}
