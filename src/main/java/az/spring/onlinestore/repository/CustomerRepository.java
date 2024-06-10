package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
