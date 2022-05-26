package com.todo_List.todoList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finishedList")
public class finishedListBean {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "finishedDiscription")
	private String finishedDiscription;
	
	@Column(name = "finishedAt")
	private String finishedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinishedDiscription() {
		return finishedDiscription;
	}

	public void setFinishedDiscription(String finishedDiscription) {
		this.finishedDiscription = finishedDiscription;
	}

	public String getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(String finishedAt) {
		this.finishedAt = finishedAt;
	}
	

}
