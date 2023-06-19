package com.santander.coforge.bitcoin.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.santander.coforge.bitcoin.dto.BitcoinResponse;

@FeignClient(url="http://localhost:8080/currency", name="CURRENCY-CLIENT")
public interface FeignClientExample {

	@GetMapping("/getAllCurrencies")
	public BitcoinResponse getAllCurrencies();
}
