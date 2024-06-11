package az.spring.onlinestore.dto.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String postalCode;

    private String country;

    private String telephone;
    private String paymentType;

    private String provider;

    private Integer accountNo;

    private String expiry;

}
