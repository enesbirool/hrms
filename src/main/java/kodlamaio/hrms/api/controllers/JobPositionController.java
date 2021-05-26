package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getall() {
        return this.jobPositionService.getPositions();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return jobPositionService.addJobPosition(jobPosition);
    }

}