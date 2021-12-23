package ng.community.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ng.community.application.DAO.DoctorRepository;
import ng.community.application.DAO.HospitalServiceRepository;
import ng.community.application.model.Doctor;
import ng.community.application.model.HospitalService;

@SpringBootApplication
public class ProjectGad21CommunityHealthcareNgRhApplication implements CommandLineRunner {
	@Autowired
	private DoctorRepository doctrepo;
	@Autowired
	private HospitalServiceRepository hosprepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectGad21CommunityHealthcareNgRhApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		 
		
		HospitalService serv1= hosprepo.save(new HospitalService(null, "General", 5000, null));
		HospitalService serv2= hosprepo.save(new HospitalService(null, "COVID19", 15000, null));
		HospitalService serv3= hosprepo.save(new HospitalService(null, "psychiatrie", 8000, null));
		
		
		
	doctrepo.save(new Doctor(null, "ngounou armel", "ngounouarmel45@yahoo.fr", encoder.encode("12345"), 456, "General Hospital", serv1));
	doctrepo.save(new Doctor(null, "Maguella Ariane", "anrianemaguella@yahoo.fr", encoder.encode("12345"), 455, "central Hospital", serv2));
	doctrepo.save(new Doctor(null, "arrey john", "arreyjohn@yahoo.fr", encoder.encode("12345"), 123, "Regional Hospital", serv1));
	doctrepo.save(new Doctor(null, "Firmin houkoulam", "firmin@yahoo.fr", encoder.encode("12345"), 459, "central Hospital", serv3));
	
		
	}
	

}
