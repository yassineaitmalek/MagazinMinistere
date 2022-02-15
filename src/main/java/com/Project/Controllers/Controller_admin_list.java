package com.Project.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.Userservice;
import com.Project.WebServices;
import com.Project.Entities.Direction;
import com.Project.Entities.Division;
import com.Project.Entities.Employee;
import com.Project.Entities.Magasinier;
import com.Project.Entities.Role;
import com.Project.Entities.Servicee;
import com.Project.Entities.User;
import com.Project.HTML.Error;
import com.Project.HTML.Success;

@org.springframework.stereotype.Controller
@RequestMapping(path="/dashboard/admin/list") 
public class Controller_admin_list {
	
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
		
		return "admin/list";
	}
	// list employees 
	
	@GetMapping(value = "/employee")
	public String listemployee(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		
		ArrayList<Employee> emps = ws.getemps(ws.getR("employee"));
		m.addAttribute("emps",emps);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "admin/list/employee";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "admin/list/employee";
			}
			catch (Exception ee){
				return "admin/list/employee";
			}
		}
		
		
	}
	
	@GetMapping(value = "/employee/del/{email}")
	public String delemp(@PathVariable String email, RedirectAttributes redirectAttributes) {
		ws.deleteemp(email);
		us.DeleteUser(email);
		
		redirectAttributes.addAttribute("suc", "9");
		return "redirect:/dashboard/admin/list/employee";
		
			
		
		}
	
	@GetMapping(value = "/employee/upchs/{email}")
	public String upchs(@PathVariable String email, RedirectAttributes redirectAttributes) {
		Role r = ws.getR("chef_ser");
		User u = us.getUser(email);
		Employee e = ws.getempemail(email);
		
		Servicee s = e.getSer();
		
		if (s.getChef_ser() == null) {
			e.setR(r);
			u.setR(r);
			
			s.setChef_ser(e);
		
			
			ws.updateemp(e);
			us.updateuser(u);
			ws.updateser(s);
			
			redirectAttributes.addAttribute("suc", "10");
			return "redirect:/dashboard/admin/list/employee";
		}
		else {
			redirectAttributes.addAttribute("error", "9");
			return "redirect:/dashboard/admin/list/employee";
		}
		
		}
	
	// list services 
	
		@GetMapping(value = "/chef_ser")
		public String listservice(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			
			ArrayList<Employee> sers = ws.getemps(ws.getR("chef_ser"));
			m.addAttribute("sers",sers);
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/list/chef_ser";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/list/chef_ser";
				}
				catch (Exception ee){
					return "admin/list/chef_ser";
				}
			}
			
			
		}
		
		@GetMapping(value = "/chef_ser/del/{email}")
		public String delchs(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Employee e = ws.getempemail(email);
			Servicee s = e.getSer();
			s.setChef_ser(null);
			ws.updateser(s);
			ws.deleteemp(email);
			us.DeleteUser(email);
			
			redirectAttributes.addAttribute("suc", "12");
			return "redirect:/dashboard/admin/list/chef_ser";
			

			}

		@GetMapping(value = "/chef_ser/upchd/{email}")
		public String upchd(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Role r = ws.getR("chef_div");
			User u = us.getUser(email);
			Employee e = ws.getempemail(email);
			
			Servicee s = e.getSer();
			Division d = e.getDiv() ;
			
			if (d.getChef_div() == null) {
				e.setR(r);
				u.setR(r);
				
				d.setChef_div(e);
				s.setChef_ser(null);
			
				
				ws.updateemp(e);
				us.updateuser(u);
				ws.updateser(s);
				ws.updatediv(d);
				
				redirectAttributes.addAttribute("suc", "11");
				return "redirect:/dashboard/admin/list/chef_ser";
			}
			else {
				redirectAttributes.addAttribute("error", "10");
				return "redirect:/dashboard/admin/list/chef_ser";
			}
			
			}
		
		// list chef div
		
		
		@GetMapping(value = "/chef_div")
		public String listdiv(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			
			ArrayList<Employee> sers = ws.getemps(ws.getR("chef_div"));
			m.addAttribute("sers",sers);
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/list/chef_div";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/list/chef_div";
				}
				catch (Exception ee){
					return "admin/list/chef_div";
				}
			}
			
			
		}
		
		@GetMapping(value = "/chef_div/del/{email}")
		public String delchd(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Employee e = ws.getempemail(email);
			Division  s = e.getDiv();
			s.setChef_div(null);
			ws.updatediv(s);
			ws.deleteemp(email);
			us.DeleteUser(email);
			
			redirectAttributes.addAttribute("suc", "13");
			return "redirect:/dashboard/admin/list/chef_div";
			

			}

		@GetMapping(value = "/chef_div/upd/{email}")
		public String upd(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Role r = ws.getR("directeur");
			User u = us.getUser(email);
			Employee e = ws.getempemail(email);
			
		
			Division d = e.getDiv() ;
			Direction dir = d.getDir();
			
			
			if (dir.getDirecteur() == null) {
				e.setR(r);
				u.setR(r);
				
				dir.setDirecteur(e);
				d.setChef_div(null);
				
			
				
				ws.updateemp(e);
				us.updateuser(u);
				ws.updatedir(dir);
				ws.updatediv(d);
				
				redirectAttributes.addAttribute("suc", "14");
				return "redirect:/dashboard/admin/list/chef_div";
			}
			else {
				redirectAttributes.addAttribute("error", "10");
				return "redirect:/dashboard/admin/list/chef_div";
			}
			
			}
		
		//dir 
		
		@GetMapping(value = "/dir")
		public String listdir(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			
			ArrayList<Employee> sers = ws.getemps(ws.getR("directeur"));
			m.addAttribute("sers",sers);
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/list/dir";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/list/dir";
				}
				catch (Exception ee){
					return "admin/list/dir";
				}
			}
			
			
		}
		
		@GetMapping(value = "/dir/del/{email}")
		public String deld(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Employee e = ws.getempemail(email);
			Division  s = e.getDiv();
			Direction dir = s.getDir();
			
			dir.setDirecteur(null);
			ws.updatedir(dir);
			ws.deleteemp(email);
			us.DeleteUser(email);
			
			redirectAttributes.addAttribute("suc", "15");
			return "redirect:/dashboard/admin/list/dir";
			

			}
		
		// magasigner
		
		@GetMapping(value = "/mag")
		public String listmag(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
			
			ArrayList<Magasinier> sers = ws.getmagasiniers(ws.getR("magasinier"));
			m.addAttribute("sers",sers);
			try {
				Integer sc = Integer.parseInt(suc) ;
				m.addAttribute("suc",succ.succ(sc));
				return "admin/list/magasinier";
			}
			catch (Exception e){
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("err",err.error(er));
					return "admin/list/magasinier";
				}
				catch (Exception ee){
					return "admin/list/magasinier";
				}
			}
			
			
		}
		
		@GetMapping(value = "/mag/del/{email}")
		public String delm(@PathVariable String email, RedirectAttributes redirectAttributes) {
			Magasinier e = ws.getmagasinieremail(email);
		
			ws.deletemagasinier(email);
			us.DeleteUser(email);
			
			redirectAttributes.addAttribute("suc", "16");
			return "redirect:/dashboard/admin/list/mag";
			

			}

}
