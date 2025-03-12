package in.lakshay.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;

@Entity
@Data
public class TrainingCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String centerName;
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;
    
    @ElementCollection
    private List<String> coursesOffered;

    @CreationTimestamp
    @Column(updatable = false)
    private Long createdOn;

    private String contactEmail;
    private String contactPhone;
}