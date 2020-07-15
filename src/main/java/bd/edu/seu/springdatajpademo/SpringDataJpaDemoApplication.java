package bd.edu.seu.springdatajpademo;

import bd.edu.seu.springdatajpademo.controller.CustomerController;
import bd.edu.seu.springdatajpademo.model.Customer;
import bd.edu.seu.springdatajpademo.repository.CustomerRepository;
import com.sun.istack.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringDataJpaDemoApplication {

    @Autowired
    private CustomerController customerController;

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerController customerController){
        return (args) -> {
            // save a few customer
            customerController.save(new Customer("Jack", "Bauer"));
            customerController.save(new Customer("Chloe", "O'Brian"));
            customerController.save(new Customer("Kim", "Bauer"));
            customerController.save(new Customer("David", "Palmer"));
            customerController.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for(Customer customer : customerController.findAll()){
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            @Nullable
            Customer customer = customerController.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customers found with findByLastName('Bauer'):");
            log.info("---------------------------------------------");
            customerController.fidnByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }
}
