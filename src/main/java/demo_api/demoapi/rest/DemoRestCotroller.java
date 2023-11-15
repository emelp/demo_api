package nl.eurus_api_demo.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.eurus_api_demo.entity.ExchangeRate;
import nl.eurus_api_demo.error.CurrencyNotFound;

@RestController
@RequestMapping("/api")
public class DemoAppRestController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/rates")
	public List<ExchangeRate> getRates() throws Exception {
		return loadData();
	}

	@GetMapping("/rates/{currency}")
	public ExchangeRate getRate(@PathVariable String currency) throws Exception {
		List<ExchangeRate> rates = loadData();
		ExchangeRate rate = rates.stream().filter(r -> r.getCurrency().equals(currency)).findFirst().orElse(null);
		if (rate == null) {
			throw new CurrencyNotFound("Rate for " + currency + " currency is not found.");
		}
		return rate;
	}

	public List<ExchangeRate> loadData() throws Exception {
		List<ExchangeRate> rates = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		rates.add(new ExchangeRate(formatter.parse("31-10-2023"), "EUR", 1.00));
		rates.add(new ExchangeRate(formatter.parse("31-10-2023"), "USD", 1.062796));
		rates.add(new ExchangeRate(formatter.parse("31-10-2023"), "GBP", 0.874160));
		return rates;
	}

}
