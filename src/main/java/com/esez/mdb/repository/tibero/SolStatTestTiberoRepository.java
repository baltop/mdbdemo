package com.esez.mdb.repository.tibero;

//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.esez.mdb.model.tibero.SolStatTest;
//
//
//public interface SolStatTestTiberoRepository extends JpaRepository<SolStatTest, Integer> {
//	
//	public List<SolStatTest> findByReason(@Param("reason") String reason);
//	
//	public List<SolStatTest> findByStatus(@Param("status") String status);
//	
////	@Query("SELECT id, TO_CHAR(now, 'yyyy-mm-dd hh24:mi:ss'), num, reason, status FROM SolStatTest K WHERE sysdate < (K.now + 30/1440)")
//	@Query("SELECT K FROM SolStatTest K WHERE sysdate < (K.now + 30/1440)")
//	public List<SolStatTest> findByLatestTime();
//}
//
