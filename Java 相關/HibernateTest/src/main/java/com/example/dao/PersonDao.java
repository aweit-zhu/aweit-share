package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entity.Developer;
import com.example.entity.IdCard;
import com.example.entity.Person;
import com.example.entity.Phone;

import jakarta.persistence.EntityManager;

public interface PersonDao {

	void save(EntityManager entityManager, Person person);

	void save(EntityManager entityManager, Developer developer);
	
	List<Person> findAllPersons(EntityManager entityManager);
	
	Optional<Person> findPersonByPersonId(EntityManager entityManager,Long personId);
	
	void addIdCard(EntityManager entityManager, IdCard idCard, Long personId);
	
	void save(EntityManager entityManager, IdCard idCard);
	
	Optional<IdCard> findIdCardByCardId(EntityManager entityManager, Long cardId);
	
	void addPhone(EntityManager entityManager, Phone phone, Long personId);
	
	Optional<Phone> findPhoneByPhoneNumber(EntityManager entityManager,String phoneNumber);
}
