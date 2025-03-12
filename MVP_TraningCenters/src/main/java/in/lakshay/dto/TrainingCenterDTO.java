package in.lakshay.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class TrainingCenterDTO {
    @NotBlank(message = "{msg.center.name.required}")
    @Size(max = 40, message = "{msg.center.name.length}")
    private String centerName;

    @NotBlank(message = "{msg.center.code.required}")
    @Size(min = 12, max = 12, message = "{msg.center.code.length}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{msg.center.code.format}")
    private String centerCode;

    private AddressDTO address;
    
    @NotNull(message = "{msg.center.capacity.required}")
    private Integer studentCapacity;
    
    private List<String> coursesOffered;
    
    
    @Email(message = "{msg.center.email.invalid}")
    private String contactEmail;
    
    @NotBlank(message = "{msg.center.phone.required}")
    @Pattern(regexp = "^[0-9]{10}$", message = "{msg.center.phone.format}")
    private String contactPhone;
}