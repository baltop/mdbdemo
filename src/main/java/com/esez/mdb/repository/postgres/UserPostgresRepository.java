package com.esez.mdb.repository.postgres;


import com.esez.mdb.model.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserPostgresRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
	
	
	/*
	"resource_id"
	"resource_name"
	"parent_id"
	"create_at"
	"state_tag"
	"labels"
	"creator"
	"content_info"
	"content_size"
	"ontology_ref"
	"content"
	"timeof"
*/
}
