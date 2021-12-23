package ng.community.application.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ng.community.application.model.Doctor;
import ng.community.application.model.Patient;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	public List<Doctor> findByNameStartsWith(String name);
	
	@Query("SELECT d FROM Patient d WHERE d.email = ?1")
	Doctor findByEmail(String email);
}
