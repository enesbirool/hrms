package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result cityAdd(City city) {
        if(existCityNameControl(city)==false){
            return new ErrorResult("Şehir Zaten mevcut");
        }
        city.setCityName(city.getCityName().toUpperCase());
        this.cityDao.save(city);
        return new SuccessResult("Şehir Başarıyla Eklendi "+city.getCityName());
    }

    @Override
    public Result cityDelete(City city) {
        city.setCityName(city.getCityName().toUpperCase(Locale.ROOT));
        this.cityDao.delete(city);
        if(existCityNameControl(city)){
            return new SuccessResult("Şehir Başarıyla silindi "+city.getCityName());
        }
        return new ErrorResult("Şehir silinemedi "+city.getCityName()+" city id ile birlikte deneyiniz "+city.getCityId());
    }

    @Override
    public DataResult<List<City>> getCities() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }

    private boolean existCityNameControl(City city){
        var cities = this.cityDao.findByCityName(city.getCityName().toUpperCase());
        if(!cities.isEmpty()){
            return false;
        }
        return true;
    }
}
