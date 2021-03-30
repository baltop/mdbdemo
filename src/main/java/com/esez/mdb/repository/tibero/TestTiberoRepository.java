package com.esez.mdb.repository.tibero;

import com.esez.mdb.model.tibero.Test;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestTiberoRepository extends JpaRepository<Test, Integer> {
}

