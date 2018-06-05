package com.digital.tests.lss.service;

import static org.junit.Assert.assertTrue;

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

}
