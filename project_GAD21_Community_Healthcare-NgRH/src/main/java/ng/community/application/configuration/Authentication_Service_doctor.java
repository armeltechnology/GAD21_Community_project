package ng.community.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ng.community.application.DAO.DoctorRepository;
import ng.community.application.model.Doctor;
@Service
public class Authentication_Service_doctor implements UserDetailsService {

	@Autowired	
	private DoctorRepository repod;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Doctor doctor= repod.findByEmail(email);
		
		if(doctor== null  ) {
			throw new UsernameNotFoundException("Doctor not found");
		}
		return new UserDetailsInfodoctor(doctor) ;
	}

}
