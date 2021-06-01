package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    List<Employer> findByEmail(String email);

    @Query("Select new kodlamaio.hrms.entities.dtos.EmployerLoginDto(c.email,c.password) From Employer c")
    Employer getLoginDetails();
}