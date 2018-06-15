package com.digital.tests.lss.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.lss.model.Product;
import com.sogeti.digital.lss.repository.StockRepoImpl;
import com.sogeti.digital.lss.service.StockServiceImpl;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class StockServiceTest {
	
	@Mocked
	private StockRepoImpl spi;
	
	@Tested
	private StockServiceImpl ssi;
	
	@Test	
	public void createStock() {
		
		Product product = new Product();
		product.setName("SOAP Services");
		product.setAmount(5);
		product.setPrice("5000");
		
		new Expectations() {
			{
				spi.create(product);
				result = 1;				
			}
		};

		assertEquals(1, ssi.create(product));
	}
	
	@Test	
	public void createStockWhenSendingNullObject() {

		new Expectations() {
			{
				result = -1;				
			}
		};

		assertEquals(-1, ssi.create(null));
	}
	
	@Test
	public void createStockFailsInCreatingNewStock() {
		
		Product product = new Product();
		product.setName("SOAP Services");
		product.setAmount(5);
		product.setPrice("5000");
		
		new Expectations() {
			{
				spi.create(product);
				result = -1;				
			}
		};

		assertEquals(-1, ssi.create(product));	
	}
	
	
	@Test
	public void getValidStock() {
		
		Product product = new Product();
		product.setId(1);

		new Expectations() {
			{
				spi.getStock(1);
				result = product;				
			}
		};

		assertEquals(1, ssi.getStock(1).getId());
	}
	
	@Test
	public void getStockbyInvalidStockId() {
		
		Product product = new Product();
		product.setId(-1);

		new Expectations() {
			{
				result = null;				
			}
		};

		assertNull(ssi.getStock(-1), "Null is returned by the getStock(-1) call");
	}
	
	
	@Test
	public void getStockWhenStockNotFound() {
		
		new Expectations() {
			{
				spi.getStock(2020);
				result = null;				
			}
		};

		assertNull(ssi.getStock(2020), "Null is returned when the Stock not found");
	}
	
	@Test
	public void getAllTheStocks() {
		
		Product[] productList = new Product[3];
		productList[0]=  new Product(1,"firstProduct","100.12",5);
		productList[1] = new Product(2,"secondProduct","200",10);
		productList[2] = new Product(3,"third Product","500.01",50);
		
		new Expectations() {
			{
				spi.getAllTheStocks();
				result = productList;				
			}
		};
		
		Product[] returnedList = ssi.getAllTheStocks();
		
		assertNotNull(returnedList, "make sure retuned list is not null");
		assertEquals(3, returnedList.length);
		assertEquals(productList, returnedList);
	}
	
	@Test
	public void updateStockDetails() {
		
		Product product = new Product();
		product.setId(5);
		product.setName("SOAP Services");
		product.setAmount(50);
		product.setPrice("5000");
		
		new Expectations() {
			{
				spi.update(product);
				result = true;				
			}
		};

		assertTrue("stock updated", ssi.update(product));
	}
	
	@Test
	public void updateStockDetailsWhenPassingNullObject() {
		
		new Expectations() {
			{
				result = false;				
			}
		};

		assertFalse("stock updated not update when passing null object to the service", ssi.update(null));
	}
	
	@Test
	public void updateStockDetailsFails() {
		
		Product product = new Product();
		product.setId(5);
		product.setName("SOAP Services");
		product.setAmount(50);
		product.setPrice("5000");
		
		new Expectations() {
			{
				spi.update(product);
				result = false;				
			}
		};

		assertFalse("stock update failed", ssi.update(product));
	}
	
	@Test
	public void deleteStock() {
		
		new Expectations() {
			{
				spi.delete(1);
				result = true;				
			}
		};

		assertTrue("delete a stock", ssi.delete(1));
	}
	
	@Test
	public void deleteStockWhenPassingZeroValue() {
		
		new Expectations() {
			{
				result = false;				
			}
		};

		assertFalse("delete a stock", ssi.delete(0));
	}
	
	@Test
	public void deleteStockFails() {
		
		new Expectations() {
			{
				spi.delete(1);
				result = false;				
			}
		};

		assertFalse("delete a stock fails", ssi.delete(1));
	}

}
