import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Employee;
import com.example.entity.Task;

public class SessionFactoryTest {

	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

	SessionFactory sessionFactory;

	//@Before
	public void before() {
		try {
			sessionFactory = new MetadataSources(registry)
					.addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Task.class)
					.buildMetadata()
					.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	//@Test
	public void test1() {
		sessionFactory.inTransaction(session -> {
		    session.createNativeQuery("SELECT id, createDate, name FROM employee", Employee.class)   
		            .getResultList()   
		            .forEach(employee -> System.out.println(employee));
		});
	}
}
