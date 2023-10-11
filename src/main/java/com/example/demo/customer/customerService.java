package com.example.demo.customer;

import com.example.demo.exception.requestException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class customerService {

    private final customerRepository customerRepository;

    @Autowired
    public customerService(customerRepository CustomerRepository) {
        this.customerRepository = CustomerRepository;
    }

    public List<customer> getCustomer() {
        return customerRepository.findAll();
    }

     public void addNewAccount (customer customer){

        Optional <customer> customerOptionalUsername = customerRepository
                  .findUsernameCustomer(customer.getUsername());

        Optional <customer> customerOptionalEmail = customerRepository
                 .findEmailCustomer(customer.getEmail());

        if (customerOptionalUsername.isPresent()){
              throw new requestException("This username is used");
          }
        if (customerOptionalEmail.isPresent()){
             throw new requestException("This email address is used");
         }
        customerRepository.save(customer);
    }

    public void deleteCustomer(String username){

        if (!customerRepository.existsById(username)){
            throw new requestException("The username does not exist");
        }
        customerRepository.deleteById(username);
    }

    @Transactional
    public void updateCustomer(String username, String password, String firstName, String lastName , String phoneNumber, String email, String address){
        customer customer = customerRepository.findById(username)
                .orElseThrow(()-> new requestException(
                        "This account does not exist"
                ));
        if(password !=null && !password.isEmpty() && !Objects.equals(customer.getPassword(),password)){
            customer.setPassword(password);
        }
        if(firstName !=null && !firstName.isEmpty() && !Objects.equals(customer.getFirstName(),firstName)){
            customer.setFirstName(firstName);
        }

        if(lastName !=null && !lastName.isEmpty() && !Objects.equals(customer.getLastName(),lastName)){
            customer.setLastName(lastName);
        }
        if(phoneNumber !=null && !phoneNumber.isEmpty() && !Objects.equals(customer.getPhoneNumber(),phoneNumber)){
            customer.setPhoneNumber(phoneNumber);
        }
        if(email !=null && !email.isEmpty() && !Objects.equals(customer.getEmail(),email)){
            customer.setEmail(email);
        }
        if(address !=null && !address.isEmpty() && !Objects.equals(customer.getAddress(),address)){
            customer.setAddress(address);
        }
    }

    public void accountLogin(customer customer) {
        Optional <customer> customerOptionalUsername = customerRepository
                .findAnAccount(customer.getUsername(), customer.getPassword());
        if (customerOptionalUsername.isEmpty()){
            throw new requestException("Invalid username/password");
        }
    }
}
