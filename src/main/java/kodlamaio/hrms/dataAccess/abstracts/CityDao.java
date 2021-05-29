package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {
    List<City> findByCityName(String cityName);
    List<City> findByCityId(int id);
}
