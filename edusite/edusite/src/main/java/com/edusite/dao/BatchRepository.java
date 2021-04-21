package com.edusite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

	public Optional<List<Batch>> findByBatchName(String batchName);
}
