package com.xuegao.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${config}")
	private String config;

	@ResponseBody
	@RequestMapping("/application/client/config")
	public String getConfig() {
		return config;
	}
	
}