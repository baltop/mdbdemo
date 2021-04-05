package com.esez.mdb.repository.postgres;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esez.mdb.model.postgres.ContentInstance;


public interface ContentInstanceRepository extends JpaRepository<ContentInstance, Integer> {
	public List<ContentInstance> findAllByLabels(String labels);
}
