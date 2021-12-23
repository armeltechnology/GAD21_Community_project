package ng.community.application.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ng.community.application.model.Doctor;
import ng.community.application.model.Patient;
import ng.community.application.service.ServiceConsultation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/consultation")
public class DoctorController {
	
	private ServiceConsultation serviceconsultation;
	@Autowired
	public DoctorController(ServiceConsultation serviceconsultation) {
		
		this.serviceconsultation = serviceconsultation;
	}
	
	
	
	@GetMapping
	public List<Patient> getPatient(){
		return null;
		
	}
@DeleteMapping(path = "{patientName}")
public void deletePatient(@PathVariable("patientName" ) String patientName) {
	serviceconsultation.deletePatient(patientName);
}
	
@PutMapping
public void updatePatient(
		@PathVariable("patientId") Long patientId,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String email) {
	serviceconsultation.updatePatient(patientId, name, email);
	
	}
@RequestMapping(value = "/login", method = RequestMethod.GET)
public void login() {
	System.out.println("bien recu");
}




}
