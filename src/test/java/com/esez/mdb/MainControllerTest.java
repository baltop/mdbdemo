package com.esez.mdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esez.mdb.model.tibero.IotTest;
import com.esez.mdb.repository.tibero.IotTestTiberoRepository;

@SpringBootTest
public class MainControllerTest {
	
	  Random random = new Random();
	  @Autowired
	  private IotTestTiberoRepository iotTestDao;
	    
	 @Test
	 public void putTestData() {
	    	IotTest myTest = new IotTest();
	    	int livingRoomNo = 0;
	    	float temperature = 0;
	    	float humidity = 0;
	    	long now = 0;
	    	
	    	now = (long) System.currentTimeMillis() / 1000;
	    	temperature = random.nextInt(1) + 15;
	    	humidity = random.nextInt(10) + 30;
	    	String stNow = Long.toString(now);
	    	
	    	myTest.setSenseTime(now);
	    	assertThat(myTest.getSenseTime()).isNotNull();
	    	myTest.setLivingRoomNo(livingRoomNo);
	    	assertThat(myTest.getLivingRoomNo()).isNotNull();
	    	myTest.setHumidity(humidity);
	    	assertThat(myTest.getHumidity()).isNotNull();
	    	myTest.setTemperature(temperature);
	    	assertThat(myTest.getTemperature()).isNotNull();
	    	
	    	iotTestDao.save(myTest);
	    	
	 }
}
