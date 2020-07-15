package bd.edu.seu.springdatajpademo.controller;

import bd.edu.seu.springdatajpademo.model.Customer;
import bd.edu.seu.springdatajpademo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    String Home(Model model){
        model.addAttribute("helloMsg", "Hello World!");
        return "index";
    }

    public Customer save(Customer customer){
        return customerService.save(customer);
    }

    public Customer findById(long id){
        return customerService.findById(id);
    }

    public List<Customer> fidnByLastName(String lastName){
        return customerService.findByLastName(lastName);
    }

    public Collection<Customer> findAll(){
        return customerService.findAll();
    }

}
