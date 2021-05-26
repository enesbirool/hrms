package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getPositions() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.JobPositionListed);
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
        try {
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult(Messages.JobPositionAdded + jobPosition.getJobTitle());
        }catch (Exception e) {
            return new ErrorResult(Messages.JobPositionAddErrorExist);
        }
    }
}