package com.todo_List.todoList.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todo_List.todoList.model.finishedListBean;
import com.todo_List.todoList.model.todoListBean;
import com.todo_List.todoList.service.finishedListService;
import com.todo_List.todoList.service.todoListService;

@Controller
public class todoListController {
	
	@Autowired
	private todoListService todoService;
	
	@Autowired
	private finishedListService finishedService;
	
	@RequestMapping(path = "/insertToDoList.controller",method = RequestMethod.GET)
	@ResponseBody
	public String insertToDoList(@RequestParam("listDiscription") String listDiscription) {
		Date date = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String creDate = sdFormat.format(date);
		
		todoListBean tdBean = new todoListBean();
		
		tdBean.setListDiscription(listDiscription);
//		tdBean.setUnfinished(unfinished);
		tdBean.setCreatedAt(creDate);
		
		todoService.insertTodoList(tdBean);
		
		return "insertSuccess";
		
	}
	
	@RequestMapping(path = "/insertFinishedList.controller",method = RequestMethod.GET)
	@ResponseBody
	public String insertFinishedList(@RequestParam("finishedDiscription") String finishedDiscription) {
		Date date = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String finishedDate = sdFormat.format(date);
		
		finishedListBean finBean = new finishedListBean();
		
		finBean.setFinishedAt(finishedDate);
		finBean.setFinishedDiscription(finishedDiscription);
		
		finishedService.insertFinishedList(finBean);
		
		return "insertSuccess";
	}
	
	@GetMapping(path = "/queryAllList")
	@ResponseBody
	public List<todoListBean> queryAllList() {
		return todoService.queryAll();
	}
	
	@GetMapping(path = "/queryAllfinishedList")
	@ResponseBody
	public List<finishedListBean> querrtAllFinishedList(){
		return finishedService.queryAll();
	}
	
	@GetMapping(path = "/deleteList")
	@ResponseBody
	public void  deletetodoList(Integer id) {
		todoService.deleteById(id);
	}

}
