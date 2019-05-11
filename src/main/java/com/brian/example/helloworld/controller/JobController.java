package com.brian.example.helloworld.controller;


import com.brian.example.helloworld.entity.Job;
import com.brian.example.helloworld.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/{jobID}")
    public Optional<Job> getJobByID(@PathVariable Long jobID){
        return jobService.getJobById(jobID);
    }

    @GetMapping
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping //This is for saving
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
