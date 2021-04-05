package com.esez.mdb.repository.tibero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esez.mdb.model.tibero.CjmTest;


public interface CjmTestTiberoRepository extends JpaRepository<CjmTest, Integer> {
	
	@Query("SELECT K FROM CjmTest K WHERE livingRoomNo=:livingRoomNo AND K.senseTime+1800 > :senseTime")
	public List<CjmTest> getLatestFindBySenseTime(
			@Param("livingRoomNo") int livingRoomNo,
			@Param("senseTime") long senseTime);
	
//	@Query("SELECT K FROM CJM_TEST K WHERE LIVING_ROOM_NO=:livingRoomNo AND (SENSE_TIME BETWEEN :startTime AND :endTime) ")
	public List<CjmTest> findALLByLivingRoomNoAndSenseTimeBetween(
			@Param("LIVING_ROOM_NO") int livingRoomNo, @Param("SENSE_TIME") long startTime, @Param("SENSE_TIME") long endTime);
	
//	@Query("SELECT K FROM CjmTest K WHERE K.livingRoomNo=:livingRoomNo AND (K.senseTime BETWEEN :startTime AND :endTime) ")
	@Query("SELECT K FROM CjmTest K WHERE K.livingRoomNo = ?1 AND (K.senseTime BETWEEN ?2 AND ?3) ")
	public List<CjmTest> qryTest(int livingRoomNo, long startTime, long endTime);
	
	public List<CjmTest> findByLivingRoomNo(@Param("LIVING_ROOM_NO") int livingRoomNo);
}

