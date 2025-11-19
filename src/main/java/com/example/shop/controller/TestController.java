package com.example.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Operation(
		summary = "테스트 API",
		description = "서비스가 정상적으로 동작하는지 확인하기 위한 엔드포인트."
	)
	@GetMapping("/test")
	public String test() {
		return "test response";
	}
}
