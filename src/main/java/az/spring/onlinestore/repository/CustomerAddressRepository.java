package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
    @Query("SELECT ca FROM CustomerAddress ca WHERE ca.id = :id")
    CustomerAddress findByCustomerId(@Param("id") Long id);
}
