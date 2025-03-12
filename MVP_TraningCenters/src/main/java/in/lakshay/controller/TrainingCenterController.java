package in.lakshay.controller;  

import in.lakshay.dto.TrainingCenterDTO;  
import in.lakshay.service.TrainingCenterService;  
import jakarta.validation.Valid;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  

import java.util.List;    

@RestController  
@RequestMapping("/api/training-centers")  
public class TrainingCenterController  
{    
    private static final Logger logger = LoggerFactory.getLogger(TrainingCenterController.class);    

    @Autowired  
    private TrainingCenterService service ;  

    @PostMapping  
    public ResponseEntity<TrainingCenterDTO> createTrainingCenter( @Valid @RequestBody TrainingCenterDTO dto )  
    {  
        logger.info( "Received request to create training center: {}" , dto.getCenterName() ) ;  
        TrainingCenterDTO savedCenter = service.createTrainingCenter( dto ) ;  
        logger.info( "Successfully created training center with code: {}" , savedCenter.getCenterCode() ) ;  
        return new ResponseEntity<>( savedCenter , HttpStatus.CREATED ) ;  
    }  

    @GetMapping  
    public ResponseEntity<List<TrainingCenterDTO>> getAllTrainingCenters()  
    {  
        logger.info( "Received request to fetch all training centers" ) ;  
        List<TrainingCenterDTO> centers = service.getAllTrainingCenters() ;  
        logger.info( "Returning {} training centers" , centers.size() ) ;  
        return new ResponseEntity<>( centers , HttpStatus.OK ) ;  
    }  
}  
