package ng.community.application.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.community.application.model.HospitalService;
@Repository
public interface HospitalServiceRepository extends JpaRepository<HospitalService, Long>{

}
