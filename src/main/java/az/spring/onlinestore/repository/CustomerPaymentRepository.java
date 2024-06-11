package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.CustomerPayment;
import az.spring.onlinestore.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Long> {

    @Query("SELECT cp FROM CustomerPayment cp WHERE cp.id = :id")
    CustomerPayment findByCustomerId(@Param("id") Long id);
}
