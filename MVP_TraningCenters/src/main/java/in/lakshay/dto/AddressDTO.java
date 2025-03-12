package in.lakshay.dto;  

import jakarta.validation.constraints.NotBlank;  
import lombok.Data;  

@Data  
public class AddressDTO  
{  
   @NotBlank( message = "${msg.address.detailed.required}" )  
   private String detailedAddress ;  

   @NotBlank( message = "${msg.address.city.required}" )  
   private String city;    

   @NotBlank( message = "${msg.address.state.required}" )  
   private String state ;    

   private Long pincode ;   
}  
