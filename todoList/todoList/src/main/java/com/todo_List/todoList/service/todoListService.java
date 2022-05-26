package com.todo_List.todoList.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_List.todoList.model.todoListBean;
import com.todo_List.todoList.model.todoListRepository;

@Service
@Transactional
public class todoListService {
	
	@Autowired
	private todoListRepository todoRes;
	
	
	public void insertTodoList(todoListBean todoBean) {
		todoRes.save(todoBean);
	}
	
	public List<todoListBean> queryAll(){
		return todoRes.findAll();
	}
	
	public void deleteById(Integer id) {
		todoRes.deleteById(id);
	}

}
