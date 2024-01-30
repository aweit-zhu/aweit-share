import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * 1. SELECT @@transaction_isolation; -- 查詢 MySQL 隔離級別 (預設:REPEATABLE-READ)
 */
public class EntityManagerFactoryTest
{
	
	EntityManagerFactory  emfEntityManagerFactory;
	EntityManager em1;
		
	@Before
	public void before() {
		emfEntityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
		em1 = emfEntityManagerFactory.createEntityManager();
	}

	//@Test
	public void test1() {
		EntityTransaction transaction = em1.getTransaction();
		try {
			transaction.begin();

			Employee employee = Employee.builder().name("aweit").build();
			em1.persist(employee);
			
			transaction.commit();
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//@Test
	public void test2() {
		showEmployee(em1,1);
	}
	
	/**
	 * 驗證：FlushModeType.COMMIT 的定義: 需要flush() 才可查詢 persist 的結果
	 */
    @Test
    public void test3()
    {
    	em1.setFlushMode(FlushModeType.COMMIT);
    	EntityTransaction transaction = em1.getTransaction();
		try {
			
			transaction.begin();
	    	
			Employee e1 = Employee.builder().name("billy").build();
			em1.persist(e1);

			System.out.println(e1);
			
			//Query query = em1.createNativeQuery("SELECT id, createDate, name FROM demo.employee where id=?", Employee.class);
			//query.setParameter(1, e1.getId());

			//List<Employee> employees = query.getResultList();
			
			//Assert.assertEquals(IsEmptyPredicateContext.EMPTY, employees);

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
    }
    
	public void showEmployee(EntityManager entityManager,String username) {
		Query query = entityManager.createNativeQuery(
				"SELECT id, createDate, name FROM demo.employee where name=?", Employee.class);
		query.setParameter(1, username);
		List<Employee> employees = query.getResultList();
		if(employees.size() ==0) {
			System.out.println("Not Found:" + username);
			return;
		}
		System.out.println(employees.get(0));
	}
	
	public void showEmployee(EntityManager entityManager,Integer employeeId) {
		Query query = entityManager.createNativeQuery(
				"SELECT id, createDate, name FROM demo.employee where id=?", Employee.class);
		query.setParameter(1, employeeId);
		List<Employee> employees = query.getResultList();
		if(employees.size() == 0) {
			System.out.println("Not Found:" + employeeId);
			return;
		}
		System.out.println(employees.get(0));
	}

}
