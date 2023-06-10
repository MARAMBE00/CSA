package serviceDesk.dao;

import java.io.Serializable;
import java.util.List;

import serviceDesk.model.User;


//The code defines an interface IUserDAO that provides CRUD (Create, Read, Update, Delete) operations for an entity named Users.

//The interface has two generic type parameters T and PK where T represents the type of the entity class and PK represents the type of the primary key of the entity class. 
//The primary key type extends Serializable.

//The saveOrUpdate method is used to save or update the given entity instance to the database. 
//It takes an instance of type T as a parameter and returns the saved or updated entity instance. If an error occurs during the operation, it throws an exception.

//The delete method is used to delete an entity instance from the database by primary key. 
//It takes a parameter of type PK which represents the primary key of the entity instance to be deleted.

//The findById method is used to find an entity instance by primary key. 
//It takes a parameter of type PK which represents the primary key of the entity instance to be found. It returns the entity instance if it exists in the database, otherwise it returns null.

//The findByName method is used to find a list of entity instances by name. 
//It takes a parameter of type String which represents the name of the entity instances to be found. It returns a list of entity instances that match the given name.

//The findAll method is used to find all the entity instances from the database. It returns a list of all the entity instances present in the database.



public interface IUserDAO<T, PK extends Serializable>{

	User saveOrUpdate(T Users) throws Exception;
	
	void delete(PK id);
	
	T findById(PK id);
	
	
	List<T> findByName(String name);
	
	List<T> findAll();
}
