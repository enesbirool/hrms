package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> findByEmail(String email);

    JobSeeker getById(int id);

    @Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerLoginDto(c.email,c.password) From JobSeeker c")
    JobSeeker getLoginDetails();
}