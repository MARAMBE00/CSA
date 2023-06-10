package serviceDesk.resources.exceptions;


//This defines a custom exception class called UserNotFoundException that extends the RuntimeException class in Java.

//The RuntimeException class is a subclass of the Exception class, and it is used to indicate that an unexpected error has occurred in the program.

//The UserNotFoundException class overrides the constructor of the RuntimeException class to take a String message as a parameter. 
//This message will be used to provide a more descriptive error message when the exception is thrown.

//By extending RuntimeException, the UserNotFoundException class becomes an unchecked exception, which means that it does not need to be declared in a method's throws clause. 
//Instead, it can be thrown anywhere in the code, and it will propagate up the call stack until it is caught by a catch block or the program terminates.

//This custom exception class can be used to handle cases where a user is not found in the system, and it can provide a more meaningful error message to the user or the developer.

public class UserNotFoundExceptioon extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundExceptioon(String msg) {
		super(msg);
	}
}
