package com.santander.coforge.bitcoin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.santander.coforge.bitcoin.model.CurrencyRequest;
import com.santander.coforge.bitcoin.repo.BitcoinRepo;
import com.santander.coforge.bitcoin.service.BitcoinService;

@SpringBootTest
class BitcoinDemoApplicationTests {
	
	@Mock
	BitcoinRepo bitcoinRepo;
	
	@Autowired
	private BitcoinService bitcoinService;
	
	

	@Test
	@Order(1)
	public void testSaveCurrency() {
		
		CurrencyRequest currencyRequest = new CurrencyRequest(1, "IND", "%$#", 19,"Rupaya", 19);
		CurrencyRequest savedCurrencyRequest = bitcoinService.saveCurrency(currencyRequest);
		assertEquals(savedCurrencyRequest, bitcoinRepo.save(null));
		
	}

}
