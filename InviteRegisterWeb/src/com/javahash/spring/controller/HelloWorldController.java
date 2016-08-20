package com.javahash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController { 
	String message = "Welcome to Spring MVC!";
    
	
	
	/*
	@GetMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe");

		return "welcome";
	}*/
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/hello")
	 public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		System.out.println("hello");
	   model.addAttribute("name", name);
	   //returns the view name
	   return "helloworld";
	 
	 }
	
	@RequestMapping("/hello1")
    public ModelAndView  hello1(@RequestParam(value="name", required=false, defaultValue="World") String name) {
    	System.out.println("hello");
    	System.out.println(name);
    	ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
    }

}
