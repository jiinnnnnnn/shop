package com.example.shop.member;

import jakarta.validation.constraints.Size;

public record MemberRequest(
	String email,
	String name,
	String password,
	String phone,
	String saltKey,
	@Size(max = 5)
	String flag
) {
}
