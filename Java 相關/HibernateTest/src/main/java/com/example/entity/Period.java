package com.example.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Period {

	@Column(name = "START_DATE")
	Date startDate;
	
	@Column(name = "END_DATE")
	Date endDate;
}
