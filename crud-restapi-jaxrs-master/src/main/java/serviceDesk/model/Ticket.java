package serviceDesk.model;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import serviceDesk.model.enums.Priority;
import serviceDesk.model.enums.Status;


@Entity
//@Entity is an annotation in Java that is used to mark a class as a persistent entity in a relational database. 
//When a class is annotated with @Entity, it indicates that the class represents a table in the database and the instances of the class represent the rows in the table.

@Table(name = "Tickets")
//@Table is an annotation in Java that is used to specify the details of the table that an entity class should be mapped to. 
//It is often used in conjunction with the @Entity annotation to define the table name, schema, and other properties of the table.
public class Ticket {

	@Id
	//@Id is an annotation in Java that is used to indicate that a field or property is the primary key of an entity. 
        //It is used in JPA (Java Persistence API) applications to define the primary key of an entity class.
        @GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.AUTO) is an annotation in Java that is used to generate primary key values for an entity automatically. 
        
        private Long id;
	private String requestType;
	private String requestDetail; 
	private String notes;
	private Boolean isCompleted;
	private Integer status;
	private Integer priority;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	//@JsonFormat is an annotation in Java that is used to customize the serialization and deserialization of a Java object to JSON and vice versa. 
        //This annotation is commonly used in Spring applications that use Jackson library for JSON processing.
        private Instant updatedTime;

	@JsonIgnore
	//@JsonIgnore is an annotation in Java that is used to indicate that a field or a method should be ignored during serialization and deserialization of JSON data. 
        @ManyToOne
	//@ManyToOne is an annotation in Java that is used to define a many-to-one relationship between two entities in a JPA (Java Persistence API) application. 
        //It is used to define the mapping between two tables in a relational database where one table has a foreign key to the primary key of another table.
        @JoinColumn(name = "user_id")
	//@JoinColumn(name = "user_id") is an annotation in Java that is used to define the mapping between two tables in a JPA (Java Persistence API) application. 
        //It is used to specify the column name of the foreign key column in a many-to-one or one-to-one relationship between two entities.
        private User user;
	
        //Task 1:
        //Create two class constructors - one without any instance variable and another one with all instance variables 
	public Ticket() {
	}
	
	public Ticket(Long id, String requestType, String requestDetail, String notes, Boolean isCompleted,
			Instant updatedTime, User user) {
		this.id = id;
		this.requestType = requestType;
		this.requestDetail = requestDetail;
		this.notes = notes;
		this.isCompleted = isCompleted;
		this.updatedTime = updatedTime;
		this.user = user;
	}

	//Task 2:
        //Define Setters and Getters for the instance variables
        public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestDetail() {
		return requestDetail;
	}

	public void setRequestDetail(String requestDetail) {
		this.requestDetail = requestDetail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Instant getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Instant updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public User getUser() {
		return user;
	}
	
	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Priority getPriority() {
		return Priority.toEnum(priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", requestType=" + requestType + ", requestDetail=" + requestDetail + ", notes="
				+ notes + ", isCompleted=" + isCompleted + ", updatedTime=" + updatedTime + "]";
	}
}
