package com.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements ApplicationRunner {
	
	@Autowired
	private WebServices ws; 
	
	@Autowired
	private Userservice us; 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			String [] roles = {"admin","employee","magasinier","chef_ser","chef_div","directeur","fournisseur"};
		
		for (String s : roles) {
			ws.createR(s.toLowerCase());
		}
		
		us.createadmin(ws.getR("admin"));
		
		
		}
		catch (Exception e) {
			
		}
		
	}

}
