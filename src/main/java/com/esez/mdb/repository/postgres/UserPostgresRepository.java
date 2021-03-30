package com.esez.mdb.repository.postgres;


import com.esez.mdb.model.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserPostgresRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
