package ng.community.application.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import ng.community.application.DAO.PatientRepository;
import ng.community.application.configuration.Authentication_Service;
import ng.community.application.model.Patient;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceConsultation {
	
	private PatientRepository patientrepository;
	
	
	private Authentication_Service patauthservice;
	
	@Autowired
	public ServiceConsultation(PatientRepository patientrepository,Authentication_Service patauthservice) {
		
		this.patientrepository = patientrepository;
		
		
		this.patauthservice=patauthservice;
	}

	
	
	public void deleteStudent() {
		
	}


	public void deletePatient(String name) {
		boolean exists= patientrepository.existsById(null);
		if (!exists){
			throw new IllegalStateException("Patient with name"+"does not exists");		
		}patientrepository.deleteById(null);
		
	}
	@Transactional
	public void updatePatient(Long patientId, String name,String email) {
		
		Patient patient =patientrepository.findById(patientId)
						.orElseThrow(() -> new IllegalStateException(
								
								"student with id "+"does not exits"));
		
			if(name !=null && name.length()>0 &&
					!Objects.equals(patient.getName(), name)) {
				patient.setName(name);
			}
				

			if(email !=null && email.length()>0 &&
					!Objects.equals(patient.getEmail(), email)) {
				Optional<Patient> patientoptional = patientrepository.findPatientByEmail(email);
				if(patientoptional.isPresent()) {
					throw new IllegalStateException("email taken");
				}
				patient.setEmail(email);
			}
			
			
	}


	

}
