package com.brian.example.helloworld.controller;


import com.brian.example.helloworld.entity.Job;
import com.brian.example.helloworld.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/job")
@Api(value="jobs", description="Operations pertaining to Jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @ApiOperation(value = "Get Job by ID", response = Optional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved job"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{jobID}")
    public Optional<Job> getJobByID(@PathVariable Long jobID){
        return jobService.getJobById(jobID);
    }

    @GetMapping
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping //This is for creating
    public Job saveJob(@RequestBody Job job){

        return jobService.createJob(job);
    }

    @PutMapping //this is for updating
    public Job updateJob(@RequestBody Job job){

        return jobService.updateJob(job);
    }

    @DeleteMapping ("/{jobID}")//Delete
    public void deleteJob(@PathVariable Long jobID ){
        jobService.deleteJob(jobID);
        System.out.println("Job has been deleted");

    }


}
