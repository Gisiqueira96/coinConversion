package com.transaction.currencyConversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.currencyConversion.entity.User;

//annotation for Spring to understand that this class is a repository.
@Repository
/*
 * The JPARepository interface is extended, because it has contracts ready to
 * manipulate the data being the parameters: User, which is the entity worked
 * and the type of id of the entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * Customized queries through query methods. In the case to search for the name
	 * that contains the typed characters and ignores if it is upper or lower case
	 * inside the attribute name.
	 */
	public List<User> findByNameContainingIgnoreCase(String name);
}
