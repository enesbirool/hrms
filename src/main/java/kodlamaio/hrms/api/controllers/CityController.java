package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("add")
    public Result cityAdd(@RequestBody City city){
        return this.cityService.cityAdd(city);
    }

    @GetMapping("getall")
    public DataResult<List<City>> getCities(){
        return this.cityService.getCities();
    }

    @DeleteMapping("delete")
    public Result deleteCity(City city){
        return this.cityService.cityDelete(city);
    }
}
