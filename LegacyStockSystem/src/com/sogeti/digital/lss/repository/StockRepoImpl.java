/**
 * 
 */
package com.sogeti.digital.lss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.model.Product;
import com.sogeti.digital.utils.DBUtils;

/**
 * @author NIRGOYAL
 *
 */
public class StockRepoImpl implements StockRepo {

	
	/* (non-Javadoc)
	 * @see com.sogeti.digital.lss.repository.StockRepo#create(com.sogeti.digital.lss.model.Product)
	 */
	@Override
	public boolean create(Product product) {
		boolean returnValue = true;
		
		
		String insertQuery = "Insert INTO stock.product (Name, price, amount, lastcreated, lastupdated) VALUES( '"+product.getName() +"'"
				+ ",'" + product.getPrice() +"'"
				+ "," + product.getAmount() +""
				+ ",'" + LocalDateTime.now().toString() +"'"
				+ ",'" + LocalDateTime.now().toString() +"')";

		try {
				
			DBUtils.runQuery(insertQuery);
		} catch(SQLException sqle) {
			System.out.println("excpetion in method create Product : " +sqle.getMessage());
			returnValue = false;
		} finally {
			DBUtils.close();
		}
			
		return returnValue;
	}

	@Override
	public Product getStock(int id) {
		
		Product product = null;
		String findStockQuery = "Select * from stock.product where productID="+ id +"";
		
		try {
			ResultSet rs = DBUtils.getResultSet(findStockQuery);
		
			if(rs != null && rs.next()) {
			
				product = new Product();
				product.setId(rs.getInt("productID"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setAmount(rs.getInt("amount"));
				
			}
		
		} catch(SQLException sqle) {
			System.out.println("excpetion in method getStock : " +sqle.getMessage());
		} finally {
			DBUtils.close();
		}
	
		return product;
	}
	
	
	

}
