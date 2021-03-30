package com.esez.mdb.repository.postgres;


import com.esez.mdb.model.postgres.Cars;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarsPostgresRepository extends JpaRepository<Cars, Integer> {

}
