package com.Project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.Userdetail;
import com.Project.Entities.Role;
import com.Project.HTML.Error;
@org.springframework.stereotype.Controller

@RequestMapping(path="/") 
public class Controller{
	
	@Autowired 
	private Error err;
	
	public Role getRole() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Role  r = null;
		if (principal instanceof Userdetail) {
		   r = ((Userdetail)principal).getR();
		 
		}
		return r;
	}
	
	
	@RequestMapping(value = "/")
	public  String hi() {
		
		
		return "index";
	}
	

	
	@GetMapping(value = "/signin")
	public  String signin(@RequestParam(required = false) String error,Model m) {
		
		
		return "signin";
	}
	
	
	@RequestMapping(value = "/dashboard/check")
	public  String checkuser() {
		
		Role r = this.getRole();
		
		return "redirect:/dashboard/"+r.getNom()+"/";
		
	}
	
	
	
	
}
