package com.example.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_DEVELOPER")
public class Developer extends Person {

	//@Column(name = "PROG_LANG")
	//String programmingLanguage;
	
	@Column(name = "PROG_LANG")
	@ElementCollection
	@CollectionTable(name = "T_DEVELOPER_PROGRAMLANGUAGE", joinColumns = @JoinColumn(name="PERSON_ID"))
	Set<String> programmingLanguages;

	@ManyToMany(mappedBy = "developers")
	List<Project> projects;
}
