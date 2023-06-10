package serviceDesk.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//This class is mainly used in the UserService class to create a new resource using the POST request
public class UserDTOInput implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String name;
	private String phone;
      

	
	
	public UserDTOInput() {
	}
	
	public UserDTOInput(Long id, String email, String name, String phone) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
                
		
	}

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


     
}