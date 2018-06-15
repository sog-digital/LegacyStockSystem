/**
 * 
 */
package com.sogeti.digital.lss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	public int create(Product product) {
		int returnValue = -1;
		
		
		String insertQuery = "Insert INTO stock.product (Name, price, amount, lastcreated, lastupdated) VALUES( '"+product.getName() +"'"
				+ ",'" + product.getPrice() +"'"
				+ "," + product.getAmount() +""
				+ ",'" + LocalDateTime.now().toString() +"'"
				+ ",'" + LocalDateTime.now().toString() +"')";

		try {
				
			returnValue = DBUtils.runInsertQuery(insertQuery);
		} catch(SQLException sqle) {
			System.out.println("excpetion in method create Product : " +sqle.getMessage());
			returnValue = -1;
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

	@Override
	public Product[] getAllTheStocks() {
		
		Product[] products = null;
		List<Product> productList = new ArrayList<Product>();
		
		String findStockQuery = "Select * from stock.product";
		
		try {
			ResultSet rs = DBUtils.getResultSet(findStockQuery);
		
			if(rs != null ) {
				
				while(rs.next()) {

					Product product = new Product();
					product.setId(rs.getInt("productID"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getString("price"));
					product.setAmount(rs.getInt("amount"));
					productList.add(product);
				}
			 	
			}
		
		} catch(SQLException sqle) {
			System.out.println("excpetion in method getAllTheStocks : " +sqle.getMessage());
		} finally {
			DBUtils.close();
		}
		
		if(!productList.isEmpty() && productList.size() > 0 ) {
			products = new Product[productList.size()];
			products = productList.toArray(products);
		}
	
		return products;
	}

	@Override
	public boolean update(Product product) {
		
		boolean returnValue = false;
		
		String updateQuery = "Update stock.product SET name='"+ product.getName() +"'"
				+ ",amount=" + product.getAmount() 
				+ ",price='" + product.getPrice() +"'"
				+ ",lastUpdated='" + LocalDateTime.now().toString() +"' WHERE productID =" + product.getId();

		try {
				
			DBUtils.runQuery(updateQuery);
			returnValue = true;
		} catch(SQLException sqle) {
			System.out.println("excpetion in method update : " +sqle.getMessage());
			
		} finally {
			DBUtils.close();
		}
		return returnValue;
	}

	@Override
	public boolean delete(int id) {
		boolean returnValue = false;
		
		String updateQuery = "Delete from stock.product WHERE productID =" + id;

		try {
				
			DBUtils.runQuery(updateQuery);
			returnValue = true;
		} catch(SQLException sqle) {
			System.out.println("excpetion in method update : " +sqle.getMessage());
			
		} finally {
			DBUtils.close();
		}
		
		
		return returnValue;
	}

}
