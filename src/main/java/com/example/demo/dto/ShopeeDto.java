package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeDto {
	private String account;
	private String password;
	private String time;

	public ShopeeDto(String account, String password, String time) {
		super();
		this.account = account;
		this.password = password;
		this.time = time;
	}
}
