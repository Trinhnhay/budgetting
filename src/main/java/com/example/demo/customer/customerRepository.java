package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository <customer,String> {

    @Query("SELECT s From customer s WHERE s.username = ?1")
    Optional <customer>  findUsernameCustomer (String username);

    @Query("SELECT s From customer s WHERE s.email = ?1")
    Optional <customer>  findEmailCustomer (String email);

    @Query("SELECT s From customer s WHERE s.username = ?1 and s.password=?2")
    Optional <customer> findAnAccount(String username, String password);
}
