package kodlamaio.hrms.core.adapters.mernisAdapter;

import kodlamaio.hrms.core.HumanChecker;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.mernisService.RGGKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapterManager implements HumanChecker {


    public boolean isValid(JobSeeker jobSeeker) {
        boolean result=false;
        RGGKPSPublicSoap soap=new RGGKPSPublicSoap();

        try{
            result=soap.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()),
                    jobSeeker.getFirstName().toUpperCase(),
                    jobSeeker.getLastName().toUpperCase(),
                    jobSeeker.getBirthDate().getYear());
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }
}
