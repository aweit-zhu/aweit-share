package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entity.Developer;
import com.example.entity.IdCard;
import com.example.entity.Person;
import com.example.entity.Phone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class PersonDaoResposity implements PersonDao {

	@Override
	public void save(EntityManager entityManager, Person person) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

	@Override
	public void save(EntityManager entityManager, Developer developer) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(developer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

	/**
	 * 執行一次SQL，產生 JOIN 結果：inner join fetch
	 */
	@Override
	public List<Person> findAllPersons(EntityManager entityManager) {
		TypedQuery<Person> query = entityManager.createQuery(
				"from Person p left join fetch p.idCard left join fetch p.phones", Person.class);
		return query.getResultList();
	}

	@Override
	public Optional<Person> findPersonByPersonId(EntityManager entityManager, Long personId) {
		TypedQuery<Person> query = entityManager.createQuery(
				"from Person p where p.Id = :id left join fetch p.idCard left join fetch p.phones", Person.class);
		query.setParameter("id", personId);
		return Optional.ofNullable(query.getSingleResult());
	}

	@Override
	public void addIdCard(EntityManager entityManager, IdCard idCard, Long personId) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			
			Person person = findPersonByPersonId(entityManager, personId).orElse(null);
			
			if (person != null) {
				transaction.begin();
				person.setIdCard(idCard);

				entityManager.persist(idCard);
				entityManager.persist(person);
				transaction.commit();
			}

		} catch (Exception e) {
			transaction.rollback();
		}
	}

	@Override
	public void save(EntityManager entityManager, IdCard idCard) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(idCard);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

	@Override
	public Optional<IdCard> findIdCardByCardId(EntityManager entityManager, Long cardId) {
		TypedQuery<IdCard> query = entityManager.createQuery(
				"select i from IdCard i where i.Id = :id", IdCard.class);
		query.setParameter("id", cardId);
		return Optional.ofNullable(query.getSingleResult());
	}

	@Override
	public void addPhone(EntityManager entityManager, Phone phone, Long personId) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			Person person = findPersonByPersonId(entityManager, personId).orElse(null);
			if (person != null) {
				transaction.begin();
				
				// 情境1. 直觀地，先建立Person的關係，再統一儲存(OK，且只會執行一次SQL)
				phone.setPerson(person);
				entityManager.persist(phone);
		
				// 情境2. 先建立Phone，再更新Person(OK，先INSERT再UPDATE)
				//entityManager.persist(phone);
				//phone.setPerson(person);
				
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
		}
	}

	
	@Override
	public Optional<Phone> findPhoneByPhoneNumber(EntityManager entityManager, String phoneNumber) {
		TypedQuery<Phone> query = entityManager.createQuery(
				"from Phone p inner join fetch p.person where p.number = :number ", Phone.class);
		query.setParameter("number", phoneNumber);
		return Optional.ofNullable(query.getSingleResult());
	}
}
