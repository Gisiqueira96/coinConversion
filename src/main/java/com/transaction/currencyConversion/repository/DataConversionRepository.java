package com.transaction.currencyConversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.currencyConversion.entity.DataConversion;

//The annotation for Spring to understand that this class is a repository.
@Repository

/*
 * The JPARepository interface is extended, because it has contracts ready to
 * manipulate the data being the parameters: User, which is the entity worked
 * and the type of id of the entity.
 */
public interface DataConversionRepository extends JpaRepository<DataConversion, Long> {

	public List<DataConversion> findBycurrencyOriginContainingIgnoreCase (String currencyOrigin);
	
	public List<DataConversion> findBydestinationCurrencyContainingIgnoreCase (String destinationCurrency);
	
}
