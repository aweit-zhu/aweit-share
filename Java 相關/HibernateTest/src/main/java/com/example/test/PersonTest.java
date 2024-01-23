package com.example.test;

import java.util.List;

import com.example.dao.PersonDao;
import com.example.dao.PersonDaoResposity;
import com.example.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonTest {

	public static PersonDao personDao = new PersonDaoResposity();

	public static void main(String[] args) {

		try (EntityManagerFactory emfEntityManagerFactory = Persistence
				.createEntityManagerFactory("org.hibernate.tutorial.jpa");
				EntityManager entityManager = emfEntityManagerFactory.createEntityManager();) {

			// Person person = Person.builder().firstName("朱").lastName("偉誌").build();
			// personDao.save(entityManager, person);

			// Developer developer =
			// Developer.builder().firstName("吳").lastName("玉舒").programmingLanguage("Java").build();
			// personDao.save(entityManager, developer);

			List<Person> persons = personDao.findAllPersons(entityManager);
			persons.stream().forEach(System.out::println);

			// IdCard idCard = IdCard.builder().idNumber("A127753814").issueDate(new
			// Date()).build();

			// personDao.addIdCardToPerson(entityManager, idCard, 1L);

			// Person person = personDao.findPersonById(entityManager, 1L).get();
			// System.out.println(person);

			// IdCard idCard = person.getIdCard();
			// idCard.setValid(true);
			// personDao.save(entityManager, idCard);
			// idCard = personDao.findIdCardByCardId(entityManager, idCard.getId()).get();
			// System.out.println(idCard);

			// Phone phone = Phone.builder().number("0922222646").build();
			// personDao.addPhone(entityManager, phone, 1L);

			// Phone phone = Phone.builder().number("0935851466").build();
			// personDao.addPhone(entityManager, phone, 2L);

			// String phoneNumber = "0922222646";
			// Phone phone = personDao.findPhoneByPhoneNumber(entityManager, phoneNumber).orElse(null);
			// Person person = phone.getPerson();
			// System.out.printf("%s%s Tel: %s%n", person.getFirstName(), person.getLastName(), phone.getNumber());
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
