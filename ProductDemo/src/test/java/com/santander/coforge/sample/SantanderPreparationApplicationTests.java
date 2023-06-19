package com.santander.coforge.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.santander.coforge.sample.model.Product;
import com.santander.coforge.sample.repository.ProductsH2Repo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SantanderPreparationControllerTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	ProductsH2Repo roductsH2Repo;
	
	private String baseUrl = "http://localhost:";
	
	private static RestTemplate restTemplate;
	
	// before running all test case it will execute this.
	@BeforeAll
	public static void init() {
		
		restTemplate = new RestTemplate();
	}
	
	// before running each test case it will execute this.
	@BeforeEach
	public void setUpBaseUrl() {
		baseUrl = baseUrl.concat(port+"").concat("/products");
	}
	

	@Test
	public void testAddProduct() {
		
		Product product = new Product(1, "Laptop", "DELL Laptop", "non secure");
		Product response =  restTemplate.postForObject(baseUrl+"/add", product, Product.class);
		
		assertEquals("Laptop", response.getName());
		assertEquals(1,roductsH2Repo.findAll().size());
		
		System.out.println("Records in table:"+ roductsH2Repo.findAll().size());
	
	}
	
	@Test
	public void testGetAllProducts() {
		
		Product product1 = new Product(1, "Laptop", "DELL Laptop", "non secure");
		Product product2 = new Product(2, "Mobile", "REAL Me", "non secure");
		Product product3 = new Product(3, "Watch", "Fossile", "non secure");
		
		List<Product> list = new ArrayList<>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		//List<Product> response =  restTemplate.postForObject(baseUrl+"/fetchAll", list, List<Product>.class);
		
				
	
	}

}
