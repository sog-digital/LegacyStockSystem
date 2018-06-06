/**
 * 
 */
package com.sogeti.digital.lss.repository;

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
	

}
