package in.lakshay.service;

import in.lakshay.dto.TrainingCenterDTO;
import in.lakshay.entity.TrainingCenterEntity;
import in.lakshay.repo.TrainingCenterRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class TrainingCenterService {
    
    private static final Logger logger = LoggerFactory.getLogger(TrainingCenterService.class);
    
    @Autowired
    private TrainingCenterRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    public TrainingCenterDTO createTrainingCenter(TrainingCenterDTO dto) {
        logger.info("Creating training center: {}", dto.getCenterName());
        
        if (repository.existsByCenterCode(dto.getCenterCode())) {
            throw new RuntimeException("{msg.center.code.exists}");
        }
        TrainingCenterEntity center = modelMapper.map(dto, TrainingCenterEntity.class);
        return mapToDTO(repository.save(center));
    }

    public List<TrainingCenterDTO> getAllTrainingCenters() {
        logger.info("{msg.center.fetch.all}");
        List<TrainingCenterEntity> centers = repository.findAll();
        List<TrainingCenterDTO> dtos = new ArrayList<>();
        for (TrainingCenterEntity center : centers) {
            dtos.add(mapToDTO(center));
        }
        return dtos;
    }

    private TrainingCenterDTO mapToDTO(TrainingCenterEntity entity) {
    	TrainingCenterDTO dto = modelMapper.map(entity, TrainingCenterDTO.class);
        return dto;
    }
}