package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerActivationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.EmployerActivation;
import org.springframework.stereotype.Service;

@Service
public class EmployerActivationManager implements EmployerActivationService {


    @Override
    public Result addActivationFromAdmin(EmployerActivation employerActivation) {
        employerActivation.setActiveFromAdmin(true);
        return new SuccessResult("İş Veren Admin Tarafından onaylanmıştır");
    }

    @Override
    public Result deleteActivationFromAdmin(EmployerActivation employerActivation) {
        employerActivation.setActiveFromAdmin(false);
        return new SuccessResult("İş Verenin Admin Tarafından aktivasyonu kaldırılmıştır ");
    }
}
