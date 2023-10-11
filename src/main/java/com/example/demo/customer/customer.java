package com.example.demo.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="customer")
public class customer {

    @Id
    private String username;

    @Column(name = "password")
    private String password;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address" )
    private String address;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;


    public customer() {

    }
}

