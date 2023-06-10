package serviceDesk.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import serviceDesk.dao.IUserDAO;
import serviceDesk.dao.impl.UserDAO;
import serviceDesk.model.User;
import serviceDesk.model.dto.UserDTO;
import serviceDesk.model.dto.UserDTOInput;
import serviceDesk.resources.exceptions.UserNotFoundExceptioon;

public class UserService {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);
        
	private IUserDAO<User, Long> userDao;

	public UserService() {
		this.userDao = new UserDAO();
	}

	public User findUserById(Long id) {
		try {
			User user = userDao.findById(id);

			if (user == null) {
				throw new UserNotFoundExceptioon("User with id: " + id + " not found.");
			}

			return user;
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

//The code represents a method findUsersByName that returns a list of UserDTO objects. 
//The method takes a String parameter name, which is used to search for users with the matching name in the database. 
        
	public List<UserDTO> findUsersByName(String name) {
		LOGGER.info("NAME : " + name);
		try {
			List<User> users = userDao.findByName(name);
                        
                        
                        
//The following code converts the list of User objects to a list of UserDTO objects. 
//The stream() method is used to convert the users list to a Stream object, which can be processed using the map() method. 
//The map() method is used to convert each User object to a UserDTO object using a lambda expression. 
//Finally, the collect() method is used to collect the UserDTO objects into a list.
                        return users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		} catch (Exception e) {
			LOGGER.error(e);
			throw new WebApplicationException(500);
		}
	}

	public List<UserDTO> findAll() {
		try {
			return userDao.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		} catch (Exception e) {
			LOGGER.error(e);
			throw new WebApplicationException(500);
		}
	}

	public User insert(UserDTOInput userDTO) {
		try {
			User user = fromDTO(userDTO);
			return userDao.saveOrUpdate(user);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new WebApplicationException(e);
		}
	}

	public User update(Long id, User user) {
		try {
			User newObj = findUserById(id);

			updateData(newObj, user);
			userDao.saveOrUpdate(newObj);
			return newObj;

		} catch (Exception e) {
			LOGGER.error(e);
			throw new WebApplicationException(e);
		}
	}

        
//Task 20:
//Define a public method called delete
//Please note that this class will not return anything
//Define a parameter id as an argument for the method
//Create an instance of User class and invoke findUserById method and pass id as its parameter
//invoke delete method, using userDao variable - Please note the delete method will accept an argument to get the id for the user
//Log the error 
//Throw WebApplicationException with code 500
	public void delete(Long id) {
		try {
			User user = findUserById(id);
			userDao.delete(user.getId());

		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	public User fromDTO(UserDTOInput objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getPhone(), objDTO.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		User user = new User(objDTO.getId(), objDTO.getName(), objDTO.getPhone(), objDTO.getEmail());
		objDTO.getTickets().forEach(ticket -> user.addTicket(ticket));
		return user;
	}

	private void updateData(User newObj, User user) {
		newObj.setId(user.getId());
		newObj.setName(user.getName());
		newObj.setPhone(user.getPhone());
		newObj.setEmail(user.getEmail());
	}

}
