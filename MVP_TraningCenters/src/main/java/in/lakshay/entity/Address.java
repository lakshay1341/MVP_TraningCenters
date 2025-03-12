package in.lakshay.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Address {
    
    @NotBlank(message = "{msg.address.detailed.required}")
    private String detailedAddress;
    
    @NotBlank(message = "{msg.address.city.required}")
    private String city;
    
    @NotBlank(message = "{msg.address.state.required}")
    private String state;
    
    @Digits(integer = 6, fraction = 0, message = "{msg.address.pincode.length}")
    private Long pincode;
}