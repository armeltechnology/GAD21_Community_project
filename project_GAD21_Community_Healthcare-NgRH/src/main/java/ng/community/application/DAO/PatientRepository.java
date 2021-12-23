package ng.community.application.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ng.community.application.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	public List<Patient> findByNameContains(String nom);
	Optional<Patient> findPatientByEmail(String email);
	@Query("SELECT p FROM Patient p WHERE p.email = ?1")
	Patient findByEmail(String email);
	

}
