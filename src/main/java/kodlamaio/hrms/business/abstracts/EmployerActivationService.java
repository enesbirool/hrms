package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerActivation;

public interface EmployerActivationService {

    Result addActivationFromAdmin(EmployerActivation employerActivation);
    Result deleteActivationFromAdmin(EmployerActivation employerActivation);
}
