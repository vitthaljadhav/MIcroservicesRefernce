package com.example.demo.service;

public class USTaxCalculationSerivce implements TaxCalculationSerivce {

	@Override
	public double getTaxRate() {
		return Double.valueOf(2.0);
	}

}
