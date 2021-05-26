package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerActivation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerActivationDao extends JpaRepository<EmployerActivation,Integer> {
}
