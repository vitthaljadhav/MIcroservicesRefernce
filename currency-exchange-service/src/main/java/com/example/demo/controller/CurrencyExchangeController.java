package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ExchangeValue;
import com.example.demo.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	@Autowired
	private ExchangeValueRepository repositry;
	
	@RequestMapping(value="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchaneValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		
		ExchangeValue exchangeValue = repositry.findByFromAndTo(from, to);
		//ExchangeValue exchangeValue = new ExchangeValue(pickedValue.getId(), pickedValue.getFrom(),pickedValue.getTo(), pickedValue.getMultipleConversion());
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;	
	}
}
