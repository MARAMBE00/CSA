package serviceDesk.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import serviceDesk.model.User;
import serviceDesk.model.dto.UserDTO;
import serviceDesk.model.dto.UserDTOInput;
import serviceDesk.resources.exceptions.UserNotFoundExceptioon;
import serviceDesk.services.UserService;

//Task 9:
//Create a Path for users resource
@Path("/users")
public class UserResource {

	private static final Logger LOGGER = Logger.getLogger(UserResource.class);

	private UserService service;

	public UserResource() {
		this.service = new UserService();
	}
//Task 10:
//Create POST request with media type JSON
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response save(UserDTOInput userDTO) {
		User user = service.insert(userDTO);
		return Response
				.status(200)
				.entity("Registration has been done" + user.toString())
				.build();
	}
//Task 11:
//Create PUT request to update the resource with a specific id - define media type as JSON
//Then pass the id parameter to the method
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("id") Long id, User user) {
	
//Task 12:            
//Using the Response class, invoke the status method with code 200 
//Then invoke entity method and specify a message like registration completed
//Then, invoke the build method to create the whole response
//Finally, Catch the exception stating that user is not found and log the error

                try {
			service.update(id, user);
			return Response
					.status(200)
					.entity("Registration completed.")
					.build();
			
		} catch (UserNotFoundExceptioon e) {

                        LOGGER.error(e);
//Task 13:
//Using the Response class, invoke the status method with code 404 
//Then invoke entity method and specify a message like User Not Found
//Finally, invoke the build method to create the whole response
                        return Response
					.status(404)
					.entity("User with id: " + id + " not found!")
					.build();
		}		
	}

//Task 14:
//Define DELETE method to delte a resource with specific id
//specify the media type as JSON
//Pass the parameter id to the method
        @DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") Long id) {
		try {
			service.delete(id);
//Task 15:
//Using the Response class, invoke the status method with code 200 
//Then invoke entity method and specify a message like user is removed
//Then, invoke the build method to create the whole response
//Finally, Catch the exception stating that user is not found and log the associated error

                        return Response
					.status(200)
					.entity("User is removed.")
					.build();
		} catch (UserNotFoundExceptioon e) {
			LOGGER.error(e);
//Task 16:
//Using the Response class, invoke the status method with code 404 
//Then invoke entity method and specify a message like User Not Found with specified id
//Finally, invoke the build method to create the whole response
                        return Response
					.status(404)
					.entity("User with id: " + id + " not found!")
					.build();
		} 
	}

//Task 17:
//Create GET method to retrieve the information for a specific user based on id
//Define media type as JSON
//Path the parameter to the method
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User findById(@PathParam("id") Long id) {
		return service.findUserById(id);
	}

//Task 18:
//Create GET method to retrieve the information for a specific user based on name
//Define media type as JSON
//Path the parameter to the method
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName(@PathParam("name") String name) {
		List<UserDTO> usersDTO = service.findUsersByName(name);
		GenericEntity<List<UserDTO>> entities = new GenericEntity<List<UserDTO>>(usersDTO) {
		};
		return Response
				.ok(entities)
				.build();
	}

//Task 19:
//Create GET method to retrieve the information for all users
//define JSON as media type
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllUsers() {
			List<UserDTO> users = service.findAll();
			GenericEntity<List<UserDTO>> entities = new GenericEntity<List<UserDTO>>(users) {
			};
			return Response
					.ok(entities)
					.build();
	}
}
