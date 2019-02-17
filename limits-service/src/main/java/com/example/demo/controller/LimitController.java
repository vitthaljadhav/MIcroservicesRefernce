package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.LimitsBean;
import com.example.demo.config.LimitConfiguration;

@RestController
public class LimitController {

	@Autowired
	private LimitConfiguration config;
	@RequestMapping(value="/limits")
	public LimitsBean retriveBean() {
		LimitsBean limitsBean = new LimitsBean(config.getMin(),config.getMax());
		return limitsBean;
	}
}
