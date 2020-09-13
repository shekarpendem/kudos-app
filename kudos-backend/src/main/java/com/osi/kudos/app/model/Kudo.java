package com.osi.kudos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kudos")
public class Kudo {

	private long id;
	private String kudoComment;
	private String kudoFrom;
//	private Employee employee;
	
	public Kudo() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "kudo_comment", nullable = true)
	public String getKudoComment() {
		return kudoComment;
	}
	public void setKudoComment(String kudoComment) {
		this.kudoComment = kudoComment;
	}
	
	@Column(name = "kudo_from", nullable = false)
	public String getKudoFrom() {
		return kudoFrom;
	}
	public void setKudoFrom(String kudoFrom) {
		this.kudoFrom = kudoFrom;
	}
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="eid")
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	@Override
	public String toString() {
		return "Kudo [id=" + id + ", kudoComment=" + kudoComment + ", kudoFrom=" + kudoFrom 
				+ "]";
	}
	
}
