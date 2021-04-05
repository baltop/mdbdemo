package com.esez.mdb.model.tibero;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cjm_test")
@SequenceGenerator(sequenceName="cjmtestseq", name = "cjmtestseqname", initialValue=1)
public class CjmTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cjmtestseq")
	@Column(name = "id")
	private int id;
	
    @Column(name="living_room_no")
    private int livingRoomNo;
    @Column(name="temperature")
    private float temperature;
    @Column(name="humidity")
    private float humidity;
    @Column(name="sense_time")
    private long senseTime;
    
	public int getLivingRoomNo() {
		return livingRoomNo;
	}
	public void setLivingRoomNo(int livingRoomNo) {
		this.livingRoomNo = livingRoomNo;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public long getSenseTime() {
		return senseTime;
	}
	public void setSenseTime(long senseTime) {
		this.senseTime = senseTime;
	}    
    
}
