package com.esez.mdb.repository.tibero;

//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import org.springframework.data.repository.query.Param;
//
//import com.esez.mdb.model.tibero.IotTest;
//
//
//public interface IotTestTiberoRepository extends JpaRepository<IotTest, Integer> {
//	
//	@Query("SELECT K FROM IotTest K WHERE K.livingRoomNo=:livingRoomNo AND K.senseTime+1800 > :senseTime")
//	public List<IotTest> getLatestFindBySenseTime(
//			@Param("livingRoomNo") int livingRoomNo,
//			@Param("senseTime") long senseTime);
//
//	@Query("SELECT K FROM IotTest K WHERE K.livingRoomNo=:livingRoomNo AND senseTime BETWEEN :startTime AND :endTime")
//	public List<IotTest> findByLivingRoomNoAndSenseTimeBetween(
//			@Param("livingRoomNo") int livingRoomNo, 
//			@Param("startTime") long startTime, 
//			@Param("endTime") long endTime);
//	
//	public List<IotTest> findByLivingRoomNo(@Param("LIVING_ROOM_NO") int livingRoomNo);
//}

