package serviceDesk.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//EntityManager provides an interface to manage entities in a database. 
//It is used to create, read, update, and delete (CRUD) database records as well as to control transactions.
//The EntityManager interface provides methods to persist, find, and remove entities, as well as to create and execute queries.
//It is used to manage the lifecycle of entity instances, which includes creating, retrieving, updating, and deleting entities from the database.
import javax.persistence.EntityManager;

//EntityManagerFactory is an interface in Java that represents a factory for EntityManager instances, which are used to interact with a database using JPA
//is responsible for creating and managing EntityManager instances. 
//It is typically created once at the start of an application and used to create multiple EntityManager instances as needed. 
//An EntityManagerFactory is thread-safe and can be shared by multiple threads.
import javax.persistence.EntityManagerFactory;


//The Persistence class is used to create an EntityManagerFactory instance
import javax.persistence.Persistence;

import serviceDesk.model.Ticket;
import serviceDesk.model.User;


//This class defines a JPAUtil class that manages the creation and access to the EntityManager object used for persistence operations in a JPA application.
public class JPAUtil {
	
	private EntityManagerFactory factory;
	
	private static JPAUtil instance;

	private JPAUtil() {
		this.factory = Persistence.createEntityManagerFactory("JPAUtil");
	}
        
        
//The getInstance() method returns a JPAUtil singleton instance, which is used to create the EntityManagerFactory and load initial data into the database.
	public static synchronized JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
			instance.new PopulatingDatabase(instance.factory).loadScriptSQL();
		}
		return instance;
	}
	
//The getEntityManager() method returns an EntityManager object that can be used to perform persistence operations on entities.

	public EntityManager getEntityManager() {
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
	
//The PopulatingDatabase class is an inner class of JPAUtil that is responsible for loading initial data into the database. 

	class PopulatingDatabase {	
		
		private EntityManagerFactory factory;		
	
		public PopulatingDatabase(EntityManagerFactory factory) {
			this.factory = factory;
		}

//In the loadScriptSQL() method, several User and Ticket objects are created and persisted to the database using the setDefaultEntity() method.
//Each User object is associated with a Ticket object, and each Ticket object has a reference to the associated User object. 


		public void loadScriptSQL() {
			
			List<User> users = new ArrayList<>();
			User u1 = new User(null, "Joana Pires", "9192-0595", "joana@email.com.br");
			Ticket t1 = new Ticket(null, null, null, null, null, null, u1);
			u1.addTicket(t1);	
			
			User u2 = new User(null, "Marcia Moura", "9192-3593", "marcia@email.com.br");
			Ticket t2 = new Ticket(null, null, null, null, null, null, u2);
			u2.addTicket(t2);
			
			User u3 = new User(null, "Olivia dos Santos", "9194-5596", "rita@email.com.br");
			Ticket t3 = new Ticket(null, null, null, null, null, null, u3);
			u3.addTicket(t3);
			
			User u4 = new User(null, "Bruna Alvez", "9192-6566", "bruninha@email.com.br");
			Ticket t4 = new Ticket(null, null, null, null, null, null, u4);
			u4.addTicket(t4);
			
			User u5 = new User(null, "Marta Rios dos Santos", "9195-3395", "marta@email.com.br");
			Ticket t5 = new Ticket(null, null, null, null, null, null, u5);
			u5.addTicket(t5);
			
			users.addAll(Arrays.asList(u1,u2,u3,u4,u5));
			users.forEach(c -> setDefaultEntity(c));		
		}

//The setDefaultEntity() method uses the EntityManager to persist the User object to the database.
		private void setDefaultEntity(User user) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();		
		}  
	}
}
