package bd.edu.seu.springdatajpademo.controller;

import bd.edu.seu.springdatajpademo.model.Customer;
import bd.edu.seu.springdatajpademo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
   final private CustomerService customerService;

   public CustomerController(CustomerService customerService){
      this.customerService = customerService;
   }

   List<Customer> findAll(){
      return customerService.findAll();
   }

   @GetMapping(value = "/")
   String homePage(Model model){
      List<Customer> customerList = new ArrayList<Customer>();
      customerList.addAll(customerService.findAll());
      model.addAttribute("customerList", customerList);
      return "home";
   }

   @GetMapping(value = "/addCustomer")
   public String addForm(Model model){
      model.addAttribute("Customer", new Customer());
      model.addAttribute("status", "");
      return "addCustomer";
   }

   @PostMapping(value = "/addCustomer")
   public String submitAddForm(@RequestParam(value = "id", required = true) String id,
                               @RequestParam(value = "firstName", required = true) String firstName,
                               @RequestParam(value = "lastName") String lastName, Model model){
      Long customerId = Long.parseLong(id);
      Customer customer = new Customer(customerId, firstName, lastName);
      customerService.createCustomer(customer);
      if(customerService.findById(customer.getId()) == customer)
         model.addAttribute("status", "Successfully added");
      else model.addAttribute("status", "An Error occurred!! Please try again!!!");
      return "addCustomer";
   }

   @GetMapping(value = "/deleteCustomer")
   String deleteCustomerForm(Model model){
      model.addAttribute("status", "");
      return "deleteCustomer";
   }

   @PostMapping(value = "/deleteCustomer")
   public String submitDeleteForm(@RequestParam(value = "id", required = true) String id, Model model){
      System.out.println("Customer id is : " + id);
      if(customerService.findById(Integer.parseInt(id)) == null){
         System.out.println("Customer doesn't exist!!");
         model.addAttribute("status", "Customer doesn't exist");
         return "deleteCustomer";
      }

      customerService.deleteCustomer(Integer.parseInt(id));
      model.addAttribute("status", "Customer removed from database");
      return "deleteCustomer";

   }

   @GetMapping(value = "/findCustomer")
   String findCustomer(Model model){
      model.addAttribute("status", "");
      return "findCustomer";
   }

   @PostMapping(value = "/findCustomer")
   String findCustomer(@RequestParam(value = "id", required = true) String id, Model model){
      int customerId = Integer.parseInt(id);
      if(customerService.findById(customerId) == null){
         model.addAttribute("status", "Customer doesn't exist");
         return "findCustomer";
      }
      Customer customer = customerService.findById(customerId);
      model.addAttribute("customer", customer);
      return "findCustomer";
   }
}
