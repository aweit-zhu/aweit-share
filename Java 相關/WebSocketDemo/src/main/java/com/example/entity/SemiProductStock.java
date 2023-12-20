package com.example.entity;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemiProductStock {

	private String stockName;
	
	private String stockNumber;
	
	private String price;
	
	private String priceChange;
	
	private String trading;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
