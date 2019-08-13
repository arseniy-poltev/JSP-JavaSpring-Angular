package com.tracking.system.company.client.repository;

import com.tracking.system.company.client.service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, String> {

    //	This has to be an interface, and extend from JpaRepository<M,T>
    /**
     * Uses {@link Optional} as return and parameter type.
     *
     * @param username username for find in repository
     * @return return specific client
     */
//    Client findByloginName(String username);
}
