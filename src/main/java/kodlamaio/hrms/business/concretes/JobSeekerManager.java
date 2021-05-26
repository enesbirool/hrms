package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.HumanChecker;
import kodlamaio.hrms.core.utilities.EmailValidator;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private HumanChecker humanChecker;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,HumanChecker humanChecker) {
        this.jobSeekerDao = jobSeekerDao;
        this.humanChecker=humanChecker;
    }

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), Messages.JobSeekerListed);
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        try {
            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
                return new ErrorResult(Messages.EmailFormatError);
            }else if(!humanChecker.isValid(jobSeeker)){
                return new ErrorResult(Messages.HumanIdentityError);
            }
            else {
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult(Messages.JobSeekerAddedSuccess);
            }
        }catch (Exception e){
            if (e.getMessage()
                    .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult(Messages.ExistEMailError);
            } else {
                return new ErrorResult(Messages.JobSeekerAddErrorHumanIdentity);
            }

        }
    }
}
