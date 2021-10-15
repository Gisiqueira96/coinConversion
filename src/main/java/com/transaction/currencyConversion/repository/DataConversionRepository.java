package com.transaction.currencyConversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.currencyConversion.entity.DataConversion;

//The annotation for Spring to understand that this class is a repository.
@Repository

/*
 * The JPARepository interface is extended, because it has contracts ready to
 * manipulate the data being the parameters: data conversion, which is the
 * entity worked and the type of id of the entity.
 */
public interface DataConversionRepository extends JpaRepository<DataConversion, Long> {

	/*
	 * Customized queries through query methods. In case of searching a source
	 * currency that contains the typed characters and ignore if it is in upper or
	 * lower case inside the attribute.
	 */
	public List<DataConversion> findBycurrencyOriginContainingIgnoreCase(String currencyOrigin);

	/*
	 * Customized queries through query methods. In case of searching for a
	 * destination currency that contains the typed characters and ignore if it is
	 * in upper or lower case inside the attribute.
	 */

	public List<DataConversion> findBydestinationCurrencyContainingIgnoreCase(String destinationCurrency);

}
