package com.todo_List.todoList.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_List.todoList.model.finishedListBean;
import com.todo_List.todoList.model.finishedListRepository;

@Service
@Transactional
public class finishedListService {
	
	@Autowired
	private finishedListRepository finishRes;
	
	public void insertFinishedList(finishedListBean finishBean) {
		
		finishRes.save(finishBean);
	}
	
	public List<finishedListBean> queryAll(){
		return finishRes.findAll();
	}
	
	
	

}
