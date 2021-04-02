package com.esez.mdb.model.tibero;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sol_stat_test")
public class SolStatTest {
	
	@Id
	@Column(name = "id")
	private int id;
	
    @Column(name="now")
    private String date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
