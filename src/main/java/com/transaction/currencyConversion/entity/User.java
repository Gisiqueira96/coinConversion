package com.transaction.currencyConversion.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//annotation for Spring to understand that this class is an entity.
@javax.persistence.Entity
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

	/*
	 * Class encapsulation, so that the attributes (private) of that class can only
	 * be accessed by other classes through these methods, controlling access to the
	 * attributes.
	 */
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
