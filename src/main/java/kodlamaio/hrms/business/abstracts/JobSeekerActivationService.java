package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerActivation;

public interface JobSeekerActivationService {
    
    Result addEmailActivation(JobSeekerActivation jobSeekerActivation);
    Result deleteEmailActivation(JobSeekerActivation jobSeekerActivation);
}
