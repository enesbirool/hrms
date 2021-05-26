package kodlamaio.hrms.core.adapters.mernisAdapter;

import kodlamaio.hrms.core.HumanChecker;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.mernisService.EROKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MernisAdapterManager implements HumanChecker {


    public boolean isValid(JobSeeker jobSeeker) {
        boolean result=false;
        EROKPSPublicSoap soap=new EROKPSPublicSoap();

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
