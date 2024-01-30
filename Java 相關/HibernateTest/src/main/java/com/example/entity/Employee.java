package com.example.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Integer id;
	
	@Column(nullable = false)
	String name;
	
//  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "employee")
	Set<Task> tasks = new LinkedHashSet<>();
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
}
