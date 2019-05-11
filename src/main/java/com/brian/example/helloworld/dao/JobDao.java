package com.brian.example.helloworld.dao;

import com.brian.example.helloworld.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends CrudRepository<Job, Long> {

}
