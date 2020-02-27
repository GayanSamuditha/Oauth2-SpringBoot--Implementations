package com.gayan.rentcloud.authorizationserver.repository;

import com.gayan.rentcloud.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

/**
 * @author Gayan Samuditha
 * @created 27/02/2020 - 1:24 AM
 */

public interface UserDetailRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String name);

}
