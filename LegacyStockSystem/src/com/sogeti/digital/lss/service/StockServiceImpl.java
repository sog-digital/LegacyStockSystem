/**
 * 
 */
package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Product;
import com.sogeti.digital.lss.repository.StockRepo;
import com.sogeti.digital.lss.repository.StockRepoImpl;

/**
 * @author NIRGOYAL
 *
 */
public class StockServiceImpl implements StockService {
	
	StockRepo stockRepo = new StockRepoImpl();

	/* (non-Javadoc)
	 * @see com.sogeti.digital.lss.service.StockService#create(com.sogeti.digital.lss.model.Product)
	 */
	@Override
	public boolean create(Product product) {
	
		return stockRepo.create(product);
	}
	
	
	

}
