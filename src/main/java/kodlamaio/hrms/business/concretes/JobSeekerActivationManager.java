package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerActivationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeekerActivation;

public class JobSeekerActivationManager implements JobSeekerActivationService {
    @Override
    public Result addEmailActivation(JobSeekerActivation jobSeekerActivation) {
        jobSeekerActivation.setEmailConfirm(true);
        return new SuccessResult("Email ile doğrulama Başarılı");
    }

    @Override
    public Result deleteEmailActivation(JobSeekerActivation jobSeekerActivation) {
        jobSeekerActivation.setEmailConfirm(false);
        return new SuccessResult("Email doğrulaması admin tarafından silinmiştir");
    }
}
