package com.esez.mdb.model.postgres;

import javax.persistence.*;

@Entity
@Table(name="cars", schema = "zium")
public class Cars {
 
    @Id
    @Column(name="id")
    private int id;
    @Column(name="maker")
    private String maker;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
 
}
