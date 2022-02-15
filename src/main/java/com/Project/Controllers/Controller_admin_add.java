package com.Project.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.Project.Userdetail;
import com.Project.Userservice;
import com.Project.WebServices;
import com.Project.Entities.*;
import com.Project.HTML.Success;
import com.Project.HTML.Error;


@org.springframework.stereotype.Controller

@RequestMapping(path="/dashboard/admin") 
public class Controller_admin_add{
	
	@Autowired
	private WebServices ws;
	
	@Autowired
	private Userservice us;
	
	@Autowired
	private Error err;
	
	@Autowired
	private Success succ;
	
	@RequestMapping(value = "/")
	public  String hi() {
		
		return "admin/index";
	}
	
	
	@RequestMapping(value = "/add")
	public  String addpage() {
		
		return "admin/add";
	}
	

	
	
	/// direction 
	@RequestMapping(value = "/add/dir")
	public  String adddir(@RequestParam(required = false) String suc,@RequestParam(required = false) String error,Model m) {
		
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "admin/add/dir";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "admin/add/dir";
			}
			catch (Exception ee){
				return "admin/add/dir";
			}
		}
		
		
	}
	
	@PostMapping(value = "/add/dir/process")
	public  String adddirpeoc(@RequestParam String nom,RedirectAttributes redirectAttributes) {
		
	boolean found = false;
		
	try{
			found = ws.getDir(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
		}

	catch(Exception e) { }
	
	if (! found){ 
		
		ws.createdir(nom.toLowerCase());
		redirectAttributes.addAttribute("suc", "1");
		return "redirect:/dashboard/admin/add/dir";
	}
	else {
		redirectAttributes.addAttribute("error", "1");
		return "redirect:/dashboard/admin/add/dir";
	}
		
		
		
	}
	
	
	
	/// Division 
	@GetMapping(value = "/add/div")
	public  String adddiv(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		ArrayList<String> s = ws.getalldirname();
		m.addAttribute("dirs",s);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "admin/add/div";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "admin/add/div";
			}
			catch (Exception ee){
				return "admin/add/div";
			}
		}
		
	}
	
	
	@PostMapping(value = "/add/div/process")
	public  String adddivproc(@RequestParam String nom,@RequestParam String nom_dir,RedirectAttributes redirectAttributes) {
		
	boolean found = false;
		
	try{
			
			found = ws.getDiv(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
		}

	catch(Exception e) { }
	
	if (! found){ 
		
		ws.creatediv(nom.toLowerCase(), nom_dir.toLowerCase());
		redirectAttributes.addAttribute("suc", "2");
		return "redirect:/dashboard/admin/add/div";

	}
	else {
		redirectAttributes.addAttribute("error", "2");
		return "redirect:/dashboard/admin/add/div";
	}
		
		
		
	}
	
	
	/// Service 
	
	@GetMapping(value = "/add/ser")
	public  String addser(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		ArrayList<String> s = ws.getalldivname();
		m.addAttribute("divs",s);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "admin/add/ser";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "admin/add/ser";
			}
			catch (Exception ee){
				return "admin/add/ser";
			}
		}
	}
	
	
	@PostMapping(value = "/add/ser/process")
	public  String addserproc(@RequestParam String nom,@RequestParam String nom_div,RedirectAttributes redirectAttributes) {
		
	boolean found = false;
		
	try{
			
			found = ws.getSer(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
		}

	catch(Exception e) { }
	
	if (! found){ 
		
		ws.createser(nom.toLowerCase(), nom_div.toLowerCase());
		redirectAttributes.addAttribute("suc", "3");
		return "redirect:/dashboard/admin/add/ser";

	}
	else {
		redirectAttributes.addAttribute("error", "3");
		return "redirect:/dashboard/admin/add/ser";
	}
		
		
	}
	
	
	//employee
	
	@GetMapping(value = "/add/employee")
	public  String addemployee(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		
		ArrayList<String> divs = ws.getalldivname();
		m.addAttribute("divs",divs);
		ArrayList<String> sers = ws.getallsername();
		m.addAttribute("sers",sers);
		
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "admin/add/employee";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "admin/add/employee";
			}
			catch (Exception ee){
				return "admin/add/employee";
			}
		}
	}
	
	@PostMapping(value = "/add/employee/process")
	public  String addemployeeproc(
			@RequestParam String cin , @RequestParam String tel ,@RequestParam String prenom ,@RequestParam String r,
			@RequestParam String nom,@RequestParam String div,@RequestParam String ser
			,RedirectAttributes redirectAttributes
			) {
		
	boolean found = false;
		
	try{
			
			found = ws.getemp(cin.toLowerCase()).getCin().equals(cin.toLowerCase());
		}

	catch(Exception e) { }
	
	if (! found){ 
		String email = cin.toLowerCase()+"@sabmalek.com";
		String pass = cin.toLowerCase();
		
		Role role = ws.getR(r.toLowerCase());
	
		
			if (role.getNom().equals("admin")) {
				
				ws.createemp(cin.toLowerCase(), nom.toLowerCase(), prenom.toLowerCase(), tel.toLowerCase(), null, null, email,role );
				us.CreateUser(email, pass, role);
				redirectAttributes.addAttribute("suc", "5");
				return "redirect:/dashboard/admin/add/employee";
	
			}
			else  {
				Division d = ws.getDiv(div.toLowerCase());
				Servicee s = ws.getSer(ser.toLowerCase());
				
				if (s.getDiv().equals(d)) {
					ws.createemp(cin.toLowerCase(), nom.toLowerCase(), prenom.toLowerCase(), tel.toLowerCase(), d, s, email,role );
				us.CreateUser(email, pass, role);
				
				redirectAttributes.addAttribute("suc", "4");
				return "redirect:/dashboard/admin/add/employee";
	
				}
				
				else {
					redirectAttributes.addAttribute("error", "5");
					return "redirect:/dashboard/admin/add/employee";
				}
				
				
				
			}
		
	}
	else {
		redirectAttributes.addAttribute("error", "4");
		return "redirect:/dashboard/admin/add/employee";
	}

		
		
		
	}
	
	
	// Magazin 
	
	
 
		@GetMapping(value = "/add/mag")
		public  String addmag(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			ArrayList<String> s = ws.getalldirname();
			m.addAttribute("dirs",s);
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/add/mag";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/add/mag";
				}
				catch (Exception ee){
					return "admin/add/mag";
				}
			}
			
		}
		
		
		@PostMapping(value = "/add/mag/process")
		public  String addmagproc(@RequestParam String nom,@RequestParam String nom_dir,RedirectAttributes redirectAttributes) {
			
		boolean found = false;
		
		Direction dir = ws.getDir(nom_dir.toLowerCase());
		if (dir.getM() != null) {
			redirectAttributes.addAttribute("error", "6");
			return "redirect:/dashboard/admin/add/mag";
		}
			
		try{
				
				found = ws.getMag(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
			}

		catch(Exception e) { }
		
		if (! found){ 
			
			ws.createmag(nom.toLowerCase(), nom_dir.toLowerCase());
			redirectAttributes.addAttribute("suc", "6");
			return "redirect:/dashboard/admin/add/mag";

		}
		else {
			redirectAttributes.addAttribute("error", "6");
			return "redirect:/dashboard/admin/add/mag";
		}
			
			
			
		}
		
		// magasinier
		
		
		@GetMapping(value = "/add/magasinier")
		public  String addmagasinier(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			
			ArrayList<String> mags = ws.getallmagname();
			m.addAttribute("mags",mags);
		
			
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/add/magasinier";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/add/magasinier";
				}
				catch (Exception ee){
					return "admin/add/magasinier";
				}
			}
		}
		
		@PostMapping(value = "/add/magasinier/process")
		public  String addmagasinierproc(
				@RequestParam String cin , @RequestParam String tel ,@RequestParam String prenom ,
				@RequestParam String nom,@RequestParam String mag
				,RedirectAttributes redirectAttributes
				) {
			
		boolean found = false;
			
		try{
				
				found = ws.getmagasinier(cin.toLowerCase()).getCin().equals(cin.toLowerCase());
			}

		catch(Exception e) { }
		
		if (! found){ 
			String email = cin.toLowerCase()+"@sabmalek.com";
			String pass = cin.toLowerCase();
			
			Role role = ws.getR("magasinier");
			Magazin m = ws.getMag(mag.toLowerCase());
			ws.createmagasinier(cin.toLowerCase(), nom.toLowerCase(), prenom.toLowerCase(), tel.toLowerCase(), m, email, role);
			us.CreateUser(email, pass, role);
					
					redirectAttributes.addAttribute("suc", "7");
					return "redirect:/dashboard/admin/add/magasinier";

			
				}
		else {
			redirectAttributes.addAttribute("error", "7");
			return "redirect:/dashboard/admin/add/magasinier";
		}

			
			
		}
	
		// fournisseur 
		
		@GetMapping(value = "/add/fournisseur")
		public  String addfournisseur(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		
			
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/add/fournisseur";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/add/fournisseur";
				}
				catch (Exception ee){
					return "admin/add/fournisseur";
				}
			}
		}
		
		@PostMapping(value = "/add/fournisseur/process")
		public  String addfournisseurproc(
				@RequestParam String adress , @RequestParam String tel ,@RequestParam String email ,
				@RequestParam String nom,
				RedirectAttributes redirectAttributes
				) {
			
		boolean found = false;
			
		try{
				
				found = ws.getfour(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
			}

		catch(Exception e) { }
		
		if (! found){ 
		
			
			Role role = ws.getR("fournisseur");
			
			ws.createfourr(nom.toLowerCase(), adress.toLowerCase(), tel.toLowerCase(), email.toLowerCase(), role);
	
					redirectAttributes.addAttribute("suc", "8");
					return "redirect:/dashboard/admin/add/fournisseur";

			
				}
		else {
			redirectAttributes.addAttribute("error", "8");
			return "redirect:/dashboard/admin/add/fournisseur";
		}
		}
		
		
		

		
		@GetMapping(value = "/changepass")
	    public String changepass(@RequestParam(required = false) String error,Model model)  {
			
			try {
				Integer er = Integer.parseInt(error) ;
				model.addAttribute("error",err.error(er));
				return "admin/changepass";
			}
			catch (Exception e){
				return "admin/changepass";
			}
			
	    }
		@PostMapping(value = "/changepass/process/")
		public String changepassprocess( @RequestParam String op ,@RequestParam String np ,
				@RequestParam String cnp , RedirectAttributes redirectAttributes)  {
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String email = ((Userdetail)principal).getEmail();
			
			User u = us.getUser(email);

			if (us.Matchpass(op, u.getPass()) ){
				
				if(np.equals(cnp)) {
					us.UpdatePasswordUser(u, np);
					return "redirect:/logout";
				}
				else {
					redirectAttributes.addAttribute("error", "18");
					return "redirect:/dashboard/admin/changepass";
				}
			}
			else {
				redirectAttributes.addAttribute("error", "17");
				return "redirect:/dashboard/admin/changepass";
			}
			
			
			
			
	    }
		
}
