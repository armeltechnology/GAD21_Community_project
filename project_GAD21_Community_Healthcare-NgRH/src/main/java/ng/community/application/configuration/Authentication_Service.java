package ng.community.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ng.community.application.DAO.PatientRepository;
import ng.community.application.model.Patient;

@Service
public class Authentication_Service implements UserDetailsService {
	@Autowired	
	private PatientRepository repop;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Patient patient = repop.findByEmail(email);
		
		if(patient== null  ) {
			throw new UsernameNotFoundException("Patient not found");
		}
		return new UserDetailsInfopatient(patient) ;
	}

}
