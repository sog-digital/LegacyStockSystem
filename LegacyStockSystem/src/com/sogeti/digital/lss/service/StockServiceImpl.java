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
	
		if(product == null ) {
			
			return false;
		} else {
			
			return stockRepo.create(product);
		}
	}

	/* (non-Javadoc)
	 * @see com.sogeti.digital.lss.service.StockService#getStock(int)
	 */
	@Override
	public Product getStock(int id) {

		if( id > 0) {
		
			return stockRepo.getStock(id);
		} else {
			
			return null;
		}
	}

}
