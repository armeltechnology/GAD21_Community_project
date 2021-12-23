package ng.community.application.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ng.community.application.model.HospitalService;
import ng.community.application.model.Patient;
import ng.community.application.service.ServiceRegistration;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/registration")
public class PatientController {
	
	private ServiceRegistration serviceregistration;
	@Autowired
	public PatientController(ServiceRegistration serviceregistration) {
		
		this.serviceregistration = serviceregistration;
	}
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
	public List<HospitalService> gethospitalservice(){
		return serviceregistration.gethospitalservice();
		
	}
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
	public void register(@RequestBody Patient patient) {
		serviceregistration.addNewPatient(patient);
		
	}

	

}
