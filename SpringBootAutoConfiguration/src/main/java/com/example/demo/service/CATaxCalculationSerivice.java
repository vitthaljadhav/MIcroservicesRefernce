package com.example.demo.service;


public class CATaxCalculationSerivice implements TaxCalculationSerivce{

	@Override
	public double getTaxRate() {
		return Double.valueOf(1.5);
	}

}

