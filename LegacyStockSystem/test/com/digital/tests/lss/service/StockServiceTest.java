package com.digital.tests.lss.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
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
				result = true;				
			}
		};

		assertTrue("create stock", ssi.create(product));
	}
	
	@Test	
	public void createStockWhenSendingNullObject() {

		new Expectations() {
			{
				result = false;				
			}
		};

		assertFalse("create stock failed", ssi.create(null));
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
				result = false;				
			}
		};

		assertFalse("create stock failure", ssi.create(product));	
		
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

}
