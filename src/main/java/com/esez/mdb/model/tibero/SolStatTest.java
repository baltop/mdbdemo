package com.esez.mdb.model.tibero;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sol_stat_test")
@SequenceGenerator(sequenceName="soltestseq", name = "ziumsoltestseq", initialValue=1)
public class SolStatTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="soltestseq")
	@Column(name = "id")
	private int id;
	
    @Column(name="now")
    private Date now;
    @Column(name="num")
    private String num;
    @Column(name="reason")
    private String reason;
    @Column(name="status")
    private String status;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getNow() {
		return now;
	}
	public void setNow(Date now) {
		this.now = now;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
