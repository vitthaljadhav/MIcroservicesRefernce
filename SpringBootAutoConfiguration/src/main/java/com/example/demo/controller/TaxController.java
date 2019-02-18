package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SpringBootAutoConfigurationApplication;
import com.example.demo.service.TaxCalculationSerivce;

@RestController
public class TaxController {
	private static Logger log=LoggerFactory.getLogger(SpringBootAutoConfigurationApplication.class);
	
	@Qualifier("taxCalculationSerivce")
	@Autowired
	private TaxCalculationSerivce calculationSerivce;
	@RequestMapping(value="/bean")
	public void condition() {
		log.info("Teating the Bean {}",calculationSerivce.getTaxRate());
	}

}
