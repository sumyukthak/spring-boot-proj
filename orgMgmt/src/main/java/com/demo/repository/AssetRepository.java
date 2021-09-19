package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
}