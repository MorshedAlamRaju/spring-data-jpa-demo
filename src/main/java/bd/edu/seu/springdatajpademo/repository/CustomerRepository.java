package bd.edu.seu.springdatajpademo.repository;

import bd.edu.seu.springdatajpademo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> { //  for own ref: JpaSpecificationExecutor
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
    List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);
    List<Customer> findByLastNameAndFirstNameAllIgnoreCase(String firstName, String lastName);
    List<Customer> findPeopleDistinctByLastNameOrFirstName(String firstName, String lastName);
    Customer findFirstByOrderByLastNameAsc();
    List<Customer> findFirst10ByLastName(String lastName, Sort sort);
    Page<Customer> queryFirst10ByLastName(String lastName, Pageable pageable);
}
