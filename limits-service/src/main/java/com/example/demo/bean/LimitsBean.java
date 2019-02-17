package com.example.demo.bean;

public class LimitsBean {

	private int max;
	
	private int min;

	public LimitsBean(int min, int max) {
		super();
		this.max = max;
		this.min = min;
	}
	
	public LimitsBean() {
	}
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	
}
