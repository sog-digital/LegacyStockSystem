package com.digital.tests.lss.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
