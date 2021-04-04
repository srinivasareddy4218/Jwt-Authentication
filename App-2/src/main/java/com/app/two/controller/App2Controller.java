package com.app.two.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class App2Controller {

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello From App2";
	}
}
