package com.softengine.jwttest.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
	private String message;
	private int code;

	@Override
	public String toString() {
		return "Error [code=" + code + ", message=" + message + "]";
	}
}
