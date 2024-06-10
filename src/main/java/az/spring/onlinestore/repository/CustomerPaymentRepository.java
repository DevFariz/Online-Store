package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Long> {
}
