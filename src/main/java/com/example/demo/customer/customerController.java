package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path="customer")
public class customerController {
    private final customerService customerService;

    @Autowired
    public customerController(customerService customerService){
        this.customerService=customerService;
    }

   /* @GetMapping
    public List<customer> getCustomer(){
        return customerService.getCustomer();
    }
*/

    //Login to an Account
    @PostMapping(path = "login")
    public void loginToAccount (@RequestBody customer Customer){
        customerService.accountLogin(Customer);
    }

    //Register an account
    @PostMapping(path = "registration")
    public void registerNewAccount(@RequestBody customer Customer ){customerService.addNewAccount(Customer);
    }

    //Delete an account
    @DeleteMapping(path="delete/{username}")
    public void deleteCustomer (@PathVariable ("username")String username){customerService.deleteCustomer(username);
    }

    //Edit account information
    @PutMapping(path="update/{username}")
    public void uppdateCustomer(
            @PathVariable("username") String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address
    ){
        customerService.updateCustomer(username, password, firstName, lastName, phoneNumber, email, address);
    }
}
