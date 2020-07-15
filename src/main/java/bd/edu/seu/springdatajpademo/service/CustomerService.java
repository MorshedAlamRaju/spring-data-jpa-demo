package bd.edu.seu.springdatajpademo.service;

import bd.edu.seu.springdatajpademo.model.Customer;
import bd.edu.seu.springdatajpademo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findByLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }

    public Customer findById(long id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
//        return customerRepository.findById(customer.getId().intValue());
    }

    public Collection<Customer> findAll(){
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }


}
