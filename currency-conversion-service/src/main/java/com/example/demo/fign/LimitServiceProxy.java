package com.example.demo.fign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.FindMinAndMax;

@FeignClient(name="limits-service",url="localhost:8080")
public interface LimitServiceProxy {
	@RequestMapping(value="/limits")
	public FindMinAndMax retriveBean();
}
