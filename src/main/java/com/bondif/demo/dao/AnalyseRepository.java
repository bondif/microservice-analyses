package com.bondif.demo.dao;

import com.bondif.demo.entities.Analyse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AnalyseRepository extends MongoRepository<Analyse, String> {
}
