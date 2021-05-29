package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    Result cityAdd(City city);
    Result cityDelete(City city);
    DataResult<List<City>> getCities();
}
