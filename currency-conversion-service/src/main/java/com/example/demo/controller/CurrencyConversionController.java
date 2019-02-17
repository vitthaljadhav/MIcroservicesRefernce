package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.CurrencyConversionBean;
import com.example.demo.bean.FindMinAndMax;
import com.example.demo.fign.CurrencyExchangeServiceProxy;
import com.example.demo.fign.LimitServiceProxy;
@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@Autowired
	private LimitServiceProxy limitproxy;

	@RequestMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> urlVarible = new HashMap<String, String>();
		urlVarible.put("from", from);
		urlVarible.put("to", to);
		// fegin problem 1
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				urlVarible);
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	@RequestMapping(value = "/currency-converter-fegin/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFegin(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retriveExchaneValue(from, to);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@RequestMapping(value="/both")
	public FindMinAndMax  getMinAndMaxValues() {
		FindMinAndMax retriveBean = limitproxy.retriveBean();
		return retriveBean;
	}
}
