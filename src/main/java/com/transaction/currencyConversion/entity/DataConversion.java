package com.transaction.currencyConversion.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

//The annotation for Spring to understand that this class is an entity.
@Entity
//The annotation for Spring to understand that this entity will be a table within the database and that its name will be: data_conversion.
@Table(name = "data_conversion")
public class DataConversion {

	/* class attributes */

	// The annotation for Spring to understand that it is id type attribute.
	@Id
	// The annotation so that the id is automatically generated to be a primary key
	// of the table.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConversion;

	// The annotation to validate that the property is not null or has white space.
	@NotBlank
	// The annotation to validate that the property has a minimum and maximum size,
	// because it does not accept empty.
	@Size(min = 3, max = 3)
	private String currencyOrigin;

	@Positive
	private double value;

	// The annotation to validate that the property is not null or has white space.
	@NotBlank
	// The annotation to validate that the property has a minimum and maximum size,
	// because it does not accept empty.
	@Size(min = 3, max = 3)
	private String destinationCurrency;

	// The annotation to validate that the property is working with time
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	/*
	 * Class encapsulation, so that the attributes (private) of that class can only
	 * be accessed by other classes through these methods, controlling access to the
	 * attributes.
	 */

	public long getIdConversion() {
		return idConversion;
	}

	public void setIdConversion(long idConversion) {
		this.idConversion = idConversion;
	}

	public String getCurrencyOrigin() {
		return currencyOrigin;
	}

	public void setCurrencyOrigin(String currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
