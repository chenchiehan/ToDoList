package com.todo_List.todoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
	
	@GetMapping("mainpage.controller")
	public String processToDoList() {
		
		return "/todoList";
	}
	
	

}
