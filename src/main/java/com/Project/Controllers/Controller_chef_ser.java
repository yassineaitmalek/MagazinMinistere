package com.Project.Controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.Userdetail;
import com.Project.Userservice;
import com.Project.WebServices;
import com.Project.Entities.Article;
import com.Project.Entities.Demande;
import com.Project.Entities.Employee;
import com.Project.Entities.Famille;
import com.Project.Entities.Magazin;
import com.Project.Entities.User;
import com.Project.HTML.Error;
import com.Project.HTML.Success;

@org.springframework.stereotype.Controller

@RequestMapping(path="/dashboard/chef_ser") 
public class Controller_chef_ser {
	
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
		
		return "chef_ser/index";
	}
	
	
	@GetMapping(value = "/accdem")
	public String accdem(Model m,@RequestParam(required = false) String suc) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee e = ws.getempemail(email);
		
		ArrayList<Demande> dems =  ws.getDemswait(e.getSer());
		m.addAttribute("dems",dems);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "chef_ser/accdem";
		}
		catch (Exception ex){
			return "chef_ser/accdem";
		}
		
	}
	
	@GetMapping(value = "/accdem/refuse/{id}")
	public String refdem(@PathVariable String id, RedirectAttributes redirectAttributes) {
		Long i = Long.parseLong(id);
		
		ws.refusedem(i);
		
		redirectAttributes.addAttribute("suc", "21");
		return "redirect:/dashboard/chef_ser/accdem";
		
			
		
		}
	
	@GetMapping(value = "/accdem/accept/{id}")
	public String accdemande(@PathVariable String id, RedirectAttributes redirectAttributes) {
		Long i = Long.parseLong(id);
		
		Demande d = ws.getdemande(i).get();
		d.setEtat("accepted");
		Article a = d.getA();
		a.setQdisp(a.getQdisp()-d.getQte());
		ws.updateart(a);
		ws.updatedemande(d);
		
		ws.createbons(a, new Date(), d.getM(), d.getQte(), d.getE());
		
		
		
		redirectAttributes.addAttribute("suc", "22");
		return "redirect:/dashboard/chef_ser/accdem";
		
			
		
		}
	
	@GetMapping(value = "/demande")
	public  String dem(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee emp = ws.getempemail(email);
		
		ArrayList<String>  libs = ws.getlibs(emp.getDiv(),true);
		m.addAttribute("libs",libs);
		
		ArrayList<String>  fam = ws.getfam_mag(emp.getDiv(), true);
		m.addAttribute("fam",fam);
		
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "chef_ser/demande";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "chef_ser/demande";
			}
			catch (Exception ee){
				return "chef_ser/demande";
			}
		}
	}
	
	@PostMapping(value = "/demande/process")
	public  String demproc(@RequestParam String lib,@RequestParam String q,@RequestParam String f,RedirectAttributes redirectAttributes) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee emp = ws.getempemail(email);


	Integer qte = null;
	boolean found = false;
	try{
			 qte = Integer.parseInt(q);
		
		}

	catch(Exception e) {
		redirectAttributes.addAttribute("error", "19");
		return "redirect:/dashboard/chef_ser/demande"; 
		}
	
	
	Famille fam = ws.getf(f);
	Magazin m = emp.getDiv().getDir().getM();
	Article a = null;
	try{
		a = ws.getarticle(lib.toLowerCase(), fam, m);
		 found = a.getLib().equals(lib);
	}

	catch(Exception e) {

	}
	if ( found){ 
		
		if(a.getQdisp()<qte) {
			redirectAttributes.addAttribute("error", "21");
			return "redirect:/dashboard/chef_ser/demande";
		}else {
			
			ws.createdem(a, fam, m, emp, new Date(), "accepted",qte);
			
			
			a.setQdisp(a.getQdisp()-qte);
			ws.updateart(a);
		
			
			ws.createbons(a, new Date(), m, qte, emp);
			
		redirectAttributes.addAttribute("suc", "20");
		return "redirect:/dashboard/chef_ser/demande";
		}
		
		

	}
	else {
		redirectAttributes.addAttribute("error", "20");
		return "redirect:/dashboard/chef_ser/demande";
	}
		
		
		
	}
	
	
	@GetMapping(value = "/mydems")
	public String mydems(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee emp = ws.getempemail(email);
		ArrayList<Demande> dems = ws.getmyDems(emp, "accepted");
		m.addAttribute("dems",dems);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "chef_ser/mydems";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "chef_ser/mydems";
			}
			catch (Exception ee){
				return "chef_ser/mydems";
			}
		}
		
		
	}
	
	@GetMapping(value = "/demser/accepted")
	public String demaccepted(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee emp = ws.getempemail(email);
		ArrayList<Demande> dems = ws.getDemser(emp.getSer(), "accepted");
		m.addAttribute("dems",dems);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "chef_ser/demser";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "chef_ser/demser";
			}
			catch (Exception ee){
				return "chef_ser/demser";
			}
		}
		
		
	}
	
	@GetMapping(value = "/demser/refused")
	public String demrefused(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Employee emp = ws.getempemail(email);
		ArrayList<Demande> dems = ws.getDemser(emp.getSer(), "refused");
		m.addAttribute("dems",dems);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "chef_ser/demser";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "chef_ser/demser";
			}
			catch (Exception ee){
				return "chef_ser/demser";
			}
		}
		
		
	}
	
	
	// change pass
	
		@GetMapping(value = "/changepass")
	    public String changepass(@RequestParam(required = false) String error,Model model)  {
			
			try {
				Integer er = Integer.parseInt(error) ;
				model.addAttribute("error",err.error(er));
				return "chef_ser/changepass";
			}
			catch (Exception e){
				return "chef_ser/changepass";
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
					return "redirect:/dashboard/chef_ser/changepass";
				}
			}
			else {
				redirectAttributes.addAttribute("error", "17");
				return "redirect:/dashboard/chef_ser/changepass";
			}
			
			
			
	    }
	
}
