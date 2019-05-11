package com.brian.example.helloworld.service;

import com.brian.example.helloworld.dao.JobDao;
import com.brian.example.helloworld.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobDao jobDao;

    public Job createJob(Job job) {
        return jobDao.save(job);
    }

    public void  deleteJob(Long id) {
      jobDao.deleteById(id);
    }

    public Job updateJob(Job job) {
        return jobDao.save(job);
    }

    public Optional<Job> getJobById(Long id){

      return  jobDao.findById(id);

    }
    public Iterable<Job> getAllJobs(){
        return jobDao.findAll();
    }



}
