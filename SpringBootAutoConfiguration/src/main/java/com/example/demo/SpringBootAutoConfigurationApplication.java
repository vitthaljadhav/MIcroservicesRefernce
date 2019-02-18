package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.condition.CATaxcalculationTypeCondition;
import com.example.demo.condition.USTaxcalculationTypeCondition;
import com.example.demo.service.CATaxCalculationSerivice;
import com.example.demo.service.TaxCalculationSerivce;
import com.example.demo.service.USTaxCalculationSerivce;

@SpringBootApplication
public class SpringBootAutoConfigurationApplication {

	private static Logger log=LoggerFactory.getLogger(SpringBootAutoConfigurationApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAutoConfigurationApplication.class, args);
	}
	
	@Bean(name="taxCalculationSerivce")
	@Conditional(USTaxcalculationTypeCondition.class)
	public TaxCalculationSerivce usTaxCalculationSerivce() {
		log.info("Instatiating US tax bean");
	return new USTaxCalculationSerivce();
	}
	
	@Bean(name="taxCalculationSerivce")
	@Conditional(CATaxcalculationTypeCondition.class)
	public TaxCalculationSerivce calculationSerivce() {
		log.info("Instatiating Canada tax bean");
		return new CATaxCalculationSerivice();
	}
}

