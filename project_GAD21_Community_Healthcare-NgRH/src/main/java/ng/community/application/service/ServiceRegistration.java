package ng.community.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import ng.community.application.DAO.HospitalServiceRepository;
import ng.community.application.DAO.PatientRepository;
import ng.community.application.model.HospitalService;
import ng.community.application.model.Patient;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceRegistration {
	
	private HospitalServiceRepository hospitalrepository;
	private PatientRepository patientrepository;
	
	@Autowired
	public ServiceRegistration(HospitalServiceRepository hospitalrepository, PatientRepository patientrepository) {
		
		this.hospitalrepository = hospitalrepository;
		this.patientrepository = patientrepository;
	}

	
	public List<HospitalService> gethospitalservice(){
		return hospitalrepository.findAll();
		
	}

	public void addNewPatient(Patient patient) {
		Optional<Patient> patientoption= patientrepository.findPatientByEmail(patient.getEmail());
		
		if (patientoption.isPresent()) {
		throw new IllegalStateException("email taken");
		
	}
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedpassword = encoder.encode(patient.getPassword());
		patient.setPassword(encodedpassword);
		patientrepository.save(patient);
	}
	

	

}
