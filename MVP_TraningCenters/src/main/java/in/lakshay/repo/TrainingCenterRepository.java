package in.lakshay.repo;

import in.lakshay.entity.TrainingCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenterEntity, Long> {
    boolean existsByCenterCode(String centerCode);
}