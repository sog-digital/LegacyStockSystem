/**
 * 
 */
package com.sogeti.digital.lss.repository;

import java.util.List;

import com.sogeti.digital.lss.model.Product;

/**
 * @author NIRGOYAL
 *
 */
public interface StockRepo {
	
	/**
	 * @param product
	 * @return
	 */
	public boolean create(Product product);
	
	
	/**
	 * @param id
	 * @return
	 */
	public Product getStock(int id);
	
	/**
	 * @return
	 */
	public Product[] getAllTheStocks();
	
	/**
	 * 
	 * @param product
	 * @return boolean value
	 */
	public boolean update(Product product);
	
	/**
	 * This method allows the users to delete the stock on to the 
	 * Legacy Stock Control System
	 * 
	 * @param id is product id
	 * @return boolean value
	 */
	public boolean delete(int id);
	

}
