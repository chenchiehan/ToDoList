package com.todo_List.todoList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todoList")
public class todoListBean {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "listDiscription")
	private String listDiscription;
	
	@Column(name="finished")
	private String finished;
	
	@Column(name="unfinished")
	private String unfinished;
	
	@Column(name="theStatus")
	private String theStatus;
	
	@Column(name="createdAt")
	private String createdAt;
	
	@Column(name="finishedAt")
	private String finishedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListDiscription() {
		return listDiscription;
	}

	public void setListDiscription(String listDiscription) {
		this.listDiscription = listDiscription;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getUnfinished() {
		return unfinished;
	}

	public void setUnfinished(String unfinished) {
		this.unfinished = unfinished;
	}

	public String getTheStatus() {
		return theStatus;
	}

	public void setTheStatus(String theStatus) {
		this.theStatus = theStatus;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(String finishedAt) {
		this.finishedAt = finishedAt;
	}
	
	
	
	

}
