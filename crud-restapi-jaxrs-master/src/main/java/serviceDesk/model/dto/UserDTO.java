package serviceDesk.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import serviceDesk.model.Ticket;
import serviceDesk.model.User;

//This class is the DTO class in which we use the varibales from Users and Tickets classes to create a singler call insteasd of separate calls on both classes
//This class will then be used in the UserResource class to retrieve the information for users and tickets
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

//Task 5:
//Here you will need to define 5 varibales: id with type long, email as String, name as string, phone as string, and tickets as ArrayList
	private Long id;
	private String email;
	private String name;
	private String phone;
	
	private List<Ticket> tickets = new ArrayList<>();

//Task 6:
//Create a constructor to invoke getters from User class
//You may need to create an instance of User class as method parameter
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.phone = user.getPhone();
		this.email = user.getEmail();
		this.tickets = user.getTickets();
	}
   
//Task 7:        
//Create a constructor with all instance variables	
	public UserDTO(Long id, String email, String name, String phone, List<Ticket> tickets) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.tickets = tickets;
	}

//Task 8:
//Create setters and getters
//Please note that you don't need to create setter for ticket variable
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
}