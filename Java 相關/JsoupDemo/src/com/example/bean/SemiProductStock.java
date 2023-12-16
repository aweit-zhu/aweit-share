package com.example.bean;

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
	
}
