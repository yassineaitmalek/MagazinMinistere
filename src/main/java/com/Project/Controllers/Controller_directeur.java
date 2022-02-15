package com.Project.Controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.poi.hpsf.HPSFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.Excel;
import com.Project.Userdetail;
import com.Project.Userservice;
import com.Project.WebServices;
import com.Project.Entities.Article;
import com.Project.Entities.Bon_s;
import com.Project.Entities.Demande;
import com.Project.Entities.Division;
import com.Project.Entities.Employee;
import com.Project.Entities.Famille;
import com.Project.Entities.Fournisseur;
import com.Project.Entities.Magazin;
import com.Project.Entities.Servicee;
import com.Project.Entities.User;
import com.Project.HTML.Error;
import com.Project.HTML.Success;

@org.springframework.stereotype.Controller

@RequestMapping(path="/dashboard/directeur") 
public class Controller_directeur {
	
	@Autowired
	private WebServices ws;
	
	@Autowired
	private Userservice us;
	
	@Autowired
	private Error err;
	
	@Autowired
	private Success succ;
	
	@Autowired
	private Excel xls ;
	
	@RequestMapping(value = "/")
	public  String hi() {
		
		return "directeur/index";
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
			return "directeur/demande";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "directeur/demande";
			}
			catch (Exception ee){
				return "directeur/demande";
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
		return "redirect:/dashboard/directeur/demande"; 
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
			return "redirect:/dashboard/directeur/demande";
		}else {
			
			ws.createdem(a, fam, m, emp, new Date(), "accepted",qte);
			
			
			a.setQdisp(a.getQdisp()-qte);
			ws.updateart(a);
		
			
			ws.createbons(a, new Date(), m, qte, emp);
			
		redirectAttributes.addAttribute("suc", "20");
		return "redirect:/dashboard/directeur/demande";
		}
		
		

	}
	else {
		redirectAttributes.addAttribute("error", "20");
		return "redirect:/dashboard/directeur/demande";
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
			return "directeur/mydems";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "directeur/mydems";
			}
			catch (Exception ee){
				return "directeur/mydems";
			}
		}
		
		
	}

	
	// change pass
	
		@GetMapping(value = "/changepass")
	    public String changepass(@RequestParam(required = false) String error,Model model)  {
			
			try {
				Integer er = Integer.parseInt(error) ;
				model.addAttribute("error",err.error(er));
				return "directeur/changepass";
			}
			catch (Exception e){
				return "directeur/changepass";
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
					return "redirect:/dashboard/directeur/changepass";
				}
			}
			else {
				redirectAttributes.addAttribute("error", "17");
				return "redirect:/dashboard/directeur/changepass";
			}
			
			
			
	    }
		
		@GetMapping(value = "/consult")
	    public String consult()  {

				return "directeur/consult";
			
			
	    }
		
		@GetMapping(value = "/consult/fournisseur")
	    public String consultfour(Model m,@RequestParam(required = false) String suc )  {
			
				
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String email = ((Userdetail)principal).getEmail();
				Employee emp = ws.getempemail(email);
				m.addAttribute("fam", emp.getDiv().getDir().getM().getF());
				
				try {
					Integer sc = Integer.parseInt(suc) ;
					m.addAttribute("suc",succ.succ(sc));
					return "directeur/consultfour";
				}
				catch (Exception e){
				return "directeur/consultfour";
				}
			
	    }
		
		
		@PostMapping(value = "/consult/fournisseur/process")
	    public String consultfourprocess(Model m ,  @RequestParam String f , @RequestParam String year , @RequestParam String ext ,HttpSession session ,RedirectAttributes redirectAttributes) throws HPSFException  {
			String file_path =session.getServletContext().getRealPath("/")+"WEB-INF\\output\\"+"fournisseur "+(new Date()).toString().replace(":", "_")+"."+ext;
			
			Famille fm = null;
			try {
				 fm = ws.getf(f.toLowerCase());
			}catch (Exception e) {
				
			}
				ArrayList<Fournisseur> four = ws.getconsultfour(fm, year);
				ArrayList data = new ArrayList ();
				String ss[] = {"id","nom","adress","email","tel"};
				ArrayList<String> headers = new ArrayList<String>();
				for (String s : ss) {
					headers.add(s);
				}
				for(Fournisseur fr : four) {
					ArrayList row = new ArrayList ();
					row.add(fr.getId().toString());
					row.add(fr.getNom());
					row.add(fr.getAdress());
					row.add(fr.getEmail());
					row.add(fr.getTel());
					data.add(row);
				}
				
				if(ext.equals("xls")) {
					xls.exportToExcel("Fournisseurs", headers, data, file_path);
				}
				
				if(ext.equals("pdf")) {
					xls.exportToPDF("Fournisseurs", headers, data, file_path.replace("pdf", "xls"));
				}
				
				redirectAttributes.addAttribute("suc", "24");
			
				return "redirect:/dashboard/directeur/consult/fournisseur";
			
			
	    }
		
		
		
		@GetMapping(value = "/consult/article")
	    public String consultart(Model m,@RequestParam(required = false) String suc )  {
			
				
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String email = ((Userdetail)principal).getEmail();
				Employee emp = ws.getempemail(email);
				m.addAttribute("fam", emp.getDiv().getDir().getM().getF());
				
				try {
					Integer sc = Integer.parseInt(suc) ;
					m.addAttribute("suc",succ.succ(sc));
					return "directeur/consultart";
				}
				catch (Exception e){
				return "directeur/consultart";
				}
			
	    }
		@PostMapping(value = "/consult/article/process")
	    public String consultartprocess(Model m ,  @RequestParam String f , @RequestParam String year,@RequestParam String month , 
	    		@RequestParam String ext ,HttpSession session ,RedirectAttributes redirectAttributes) throws HPSFException  {
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String email = ((Userdetail)principal).getEmail();
			
			Employee emp = ws.getempemail(email);
			
			
			String file_path =session.getServletContext().getRealPath("/")+"WEB-INF\\output\\"+"articles "+(new Date()).toString().replace(":", "_")+"."+ext;
			
			Famille fm = null;
			try {
				 fm = ws.getf(f.toLowerCase());
			}catch (Exception e) {
				
			}
				ArrayList<Article> arts = ws.consultart(emp.getDiv().getDir().getM(), fm, year, month);
				ArrayList data = new ArrayList ();
				String ss[] = {"id","lib" , "raison","qmax","qmin","qdisp","famille","magazin"};
				ArrayList<String> headers = new ArrayList<String>();
				for (String s : ss) {
					headers.add(s);
				}
				for(Article fr : arts) {
					ArrayList row = new ArrayList ();
					
					row.add(fr.getId().toString());
					row.add(fr.getLib());
					row.add(fr.getRaison());
					row.add(String.valueOf(fr.getQmax()));
					row.add(String.valueOf(fr.getQmin()));
					row.add(String.valueOf(fr.getQdisp()));
					row.add(fr.getF().getNom());
					row.add(fr.getM().getNom());
					data.add(row);
				}
				
				if(ext.equals("xls")) {
					xls.exportToExcel("Articles", headers, data, file_path);
				}
				
				if(ext.equals("pdf")) {
					xls.exportToPDF("Articles", headers, data, file_path.replace("pdf", "xls"));
				}
				
				redirectAttributes.addAttribute("suc", "24");
			
				return "redirect:/dashboard/directeur/consult/article";
			
			
	    }
		
		
		
		@GetMapping(value = "/consult/consommation")
	    public String consultcon(Model m,@RequestParam(required = false) String suc )  {
			
				
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String email = ((Userdetail)principal).getEmail();
				Employee emp = ws.getempemail(email);
				
				ArrayList<Division> div = ws.getAlldiv(emp.getDiv().getDir());
				ArrayList<Servicee> ser = ws.getAllser(emp.getDiv().getDir());
				
				m.addAttribute("di", div);
				m.addAttribute("ser", ser);
				
				try {
					Integer sc = Integer.parseInt(suc) ;
					m.addAttribute("suc",succ.succ(sc));
					return "directeur/consultcon";
				}
				catch (Exception e){
				return "directeur/consultcon";
				}
			
	    }
		
		@PostMapping(value = "/consult/consommation/process")
	    public String consultconprocess(Model m ,  @RequestParam String div ,  @RequestParam String ser , @RequestParam String year,@RequestParam String month , 
	    		@RequestParam String ext ,HttpSession session ,RedirectAttributes redirectAttributes) throws HPSFException  {
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String email = ((Userdetail)principal).getEmail();
			
			Employee emp = ws.getempemail(email);
			String file_path =session.getServletContext().getRealPath("/")+"WEB-INF\\output\\"+"consommation "+(new Date()).toString().replace(":", "_")+"."+ext;
			
			Servicee s = null;
			Division d = null;
			try {
				 d = ws.getDiv(div);
			}catch (Exception e) {
				
			}
			try {
				 s = ws.getSer(ser);
			}catch (Exception e) {
				
			}
			
			if( !(s == null) && !(d == null)) {
				if( !s.getDiv().equals(d) ) {
					
					redirectAttributes.addAttribute("error", "22");
					
					return "redirect:/dashboard/directeur/consult/consommation";
				}
			}
				ArrayList<Bon_s> arts = ws.getconsom(emp.getDiv().getDir(), d, s, year, month);
				ArrayList data = new ArrayList ();
				
				String ss[] = {"nom","prenom" , "email","Libilé","famille","qte"};
				ArrayList<String> headers = new ArrayList<String>();
				for (String h : ss) {
					headers.add(h);
				}
				for(Bon_s fr : arts) {
					ArrayList row = new ArrayList ();
					
					row.add(fr.getE().getPrenom());
					row.add(fr.getE().getNom());
					row.add(fr.getE().getEmail());
					row.add(fr.getA().getLib());
					row.add(fr.getA().getF().getNom());
					row.add(String.valueOf(fr.getQte()));
				
					data.add(row);
				}
				
				if(ext.equals("xls")) {
					xls.exportToExcel("Consommation", headers, data, file_path);
				}
				
				if(ext.equals("pdf")) {
					xls.exportToPDF("Consommation", headers, data, file_path.replace("pdf", "xls"));
				}
				
				redirectAttributes.addAttribute("suc", "24");
			
				return "redirect:/dashboard/directeur/consult/consommation";
			
			
	    }
		
	
		
	
}
