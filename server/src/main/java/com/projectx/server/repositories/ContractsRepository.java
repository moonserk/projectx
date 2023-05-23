package com.projectx.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.projectx.server.entities.Contracts;

@RepositoryRestResource
public interface ContractsRepository extends CrudRepository<Contracts, Long>{
    
}
