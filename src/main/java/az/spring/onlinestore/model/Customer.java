package az.spring.onlinestore.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    @OneToOne
    @JoinColumn(name = "customer_address_id")
    private CustomerAddress customerAddress;

    @OneToOne
    @JoinColumn(name = "customer_payment_id")
    private CustomerPayment customerPayment;

    @OneToOne
    @JoinColumn(name = "order_details")
    private OrderDetails orderDetails;

}
