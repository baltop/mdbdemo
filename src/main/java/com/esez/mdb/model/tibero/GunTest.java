package com.esez.mdb.model.tibero;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gun_test")
@SequenceGenerator(sequenceName="guntestseq", name = "guntestseqname", initialValue=1)
public class GunTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="guntestseq")
	@Column(name = "id")
	private int id;
	
    @Column(name="name")
    private String name;
    @Column(name="value")
    private int value;
    @Column(name="company")
    private String company;    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
