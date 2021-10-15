package com.transaction.currencyConversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.currencyConversion.entity.Transaction;

//The annotation for Spring to understand that this class is a repository.
@Repository

/*
* The JPARepository interface is extended, because it has contracts ready to
* manipulate the data being the parameters: transaction, which is the entity worked
* and the type of id of the entity.
*/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List<Transaction>findByconvertedValue(double convertedValue);

}
