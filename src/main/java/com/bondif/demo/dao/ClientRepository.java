package com.bondif.demo.dao;

import com.bondif.demo.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ClientRepository extends MongoRepository<Client, String> {
    public Collection<Client> findAllByNomContaining(String nom);
}
