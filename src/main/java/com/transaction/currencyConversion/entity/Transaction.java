package com.transaction.currencyConversion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

//The annotation for Spring to understand that this class is an entity.
@Entity
//The annotation for Spring to understand that this entity will be a table within the database and that its name will be: transaction.
@Table(name = "transaction")
public class Transaction {

	/* class attributes */

	// The annotation for Spring to understand that it is id type attribute.
	@Id
	// The annotation so that the id is automatically generated to be a primary key
	// of the table.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTransaction;

	// The annotation to validate that the property is not null.
	@NotNull
	private double convertedValue;

	// The annotation to validate that the property is strictly positive.
	@Positive
	private double conversionRate;

	/*
	 * Class encapsulation, so that the attributes (private) of that class can only
	 * be accessed by other classes through these methods, controlling access to the
	 * attributes.
	 */

	public long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public double getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(double convertedValue) {
		this.convertedValue = convertedValue;
	}

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

}
