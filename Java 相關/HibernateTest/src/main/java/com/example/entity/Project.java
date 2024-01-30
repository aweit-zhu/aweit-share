package com.example.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PROJECT")
public class Project {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Enumerated(EnumType.STRING)
	ProjectType projectType;
	
	@Embedded
	Period period;
	
	@ElementCollection
	@CollectionTable(name = "T_BILLING_PERIOD", joinColumns = @JoinColumn(name="PROJECT_ID"))
	List<Period> billingPeriods;
	
	@ManyToMany
	@JoinTable(
		name = "T_PERSON_PROJECT", 
		joinColumns = {
				@JoinColumn(name="PROJECT_ID",referencedColumnName = "ID")
		},
		inverseJoinColumns = {
				@JoinColumn(name="DEVELOPER_ID",referencedColumnName = "ID")
		}
	)
	List<Developer> developers;
}
