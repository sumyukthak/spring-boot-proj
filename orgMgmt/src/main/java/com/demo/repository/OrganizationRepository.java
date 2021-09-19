package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}