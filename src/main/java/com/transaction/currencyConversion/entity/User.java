package com.transaction.currencyConversion.entity;

import javax.persistence.GeneratedValue;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//annotation for Spring to understand that this class is an entity.
@Entity
//annotation for Spring to understand that this entity will be a table within the database and that its name will be: user.
@Table(name = "user")
public class User {

	/* class attributes */

	// annotation for Spring to understand that it is id type attribute.
	@Id
	// annotation so that the id is automatically generated to be a primary key of the table.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;

	// annotation to validate that the property is not null or has white space.
	@NotBlank
	// annotation to validate that the annotated property has a maximum size only,
	// because it does not accept empty.
	@Size(max = 100)
	private String name;

	// Relationship of tables one user to many conversion data.
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("user")
	private List<DataConversion> dataConversion;
	
	
	/*
	 * Class encapsulation, so that the attributes (private) of that class can only
	 * be accessed by other classes through these methods, controlling access to the
	 * attributes.
	 */
	
	public User(long idUser, @NotBlank @Size(max = 100) String name) {
		super();
		this.idUser = idUser;
		this.name = name;
	}
	
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
