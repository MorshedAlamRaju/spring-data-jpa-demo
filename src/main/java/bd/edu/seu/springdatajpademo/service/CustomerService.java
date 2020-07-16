package bd.edu.seu.springdatajpademo.service;

import bd.edu.seu.springdatajpademo.model.Customer;
import bd.edu.seu.springdatajpademo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    final private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
//        customerList = new HashMap<Long, Customer>();
//        Customer customer1 = new Customer(1l, "Chandler", "Bing");
//        Customer customer2 = new Customer(2l, "Phoebe", "Buffey");
//        Customer customer3 = new Customer(3l, "Joey", "Tribbiani");
//        Customer customer4 = new Customer(4l, "Ross", "Geller");
//        Customer customer5 = new Customer(5l, "Monica", "Geller");
//        Customer customer6 = new Customer(6l, "Rachel", "Green");
    }

    public List<Customer> findAll(){
        List<Customer> customerList = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    public Customer findById(long id){
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer){
        customerRepository.save(customer);
        return customerRepository.findById(customer.getId()).get();
    }

    public boolean deleteCustomer(long id){
        customerRepository.deleteById(id);
        return customerRepository.findById(id) == null;
    }
}
