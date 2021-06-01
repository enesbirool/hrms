package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeekerActivation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerActivationDao extends JpaRepository<JobSeekerActivation,Integer> {
}
