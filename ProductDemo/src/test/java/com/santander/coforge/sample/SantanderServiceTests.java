package com.santander.coforge.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.santander.coforge.sample.model.Product;
import com.santander.coforge.sample.repository.ProductRepo;
import com.santander.coforge.sample.service.ProductService;

@SpringBootTest()
public class SantanderServiceTests {
	
	
	@Mock
	private ProductRepo productRepo;
	
	@Autowired
	private ProductService productService;
	
	
	@Test
	@Order(1)
	public void saveProduct() {
		
		Product product = new Product(1,"Iron","Siska iron 499 rs","non secure");
		when(productRepo.save(product)).thenReturn(product);
		
		assertEquals(product, productService.saveProduct(product));
	}
	
	@Test
	@Order(2)
	public void testGetAllProducts() {
		
		when(productRepo.findAll()).thenReturn(Stream.of(new Product(1, "Iron", "Siska iron 699","non secure"),new Product(2, "TV", "MI TV 6699Rs", "non secure")).collect(Collectors.toList()));
		
		assertEquals(2, productService.fetchAllProducts().size());
	}

}
