package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getall() {
        return this.jobSeekerService.getJobSeekers();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.addJobSeeker(jobSeeker);
    }

    @GetMapping("getByProductName")
    public DataResult<JobSeeker> getById(@RequestParam int id){
        return this.jobSeekerService.getById(id);
    }

}