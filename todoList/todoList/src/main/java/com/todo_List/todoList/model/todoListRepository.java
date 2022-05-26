package com.todo_List.todoList.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface todoListRepository extends JpaRepository<todoListBean, Integer> {
	
	

}
