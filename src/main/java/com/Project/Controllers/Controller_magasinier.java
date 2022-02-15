package com.Project.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.Project.Entities.*;
import com.Project.HTML.Error;
import com.Project.HTML.Success;

@org.springframework.stereotype.Controller

@RequestMapping(path="/dashboard/magasinier") 
public class Controller_magasinier {

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
		
		return "magasinier/index";
	}
	
	// change pass
	
	@GetMapping(value = "/changepass")
    public String changepass(@RequestParam(required = false) String error,Model model)  {
		
		try {
			Integer er = Integer.parseInt(error) ;
			model.addAttribute("error",err.error(er));
			return "magasinier/changepass";
		}
		catch (Exception e){
			return "magasinier/changepass";
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
				return "redirect:/dashboard/magasinier/changepass";
			}
		}
		else {
			redirectAttributes.addAttribute("error", "17");
			return "redirect:/dashboard/magasinier/changepass";
		}
		
		
		
    }
	
	/// bons 
	
	@GetMapping(value = "/bons/notdelivred")
	public  String dem(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Magasinier  emp = ws.getmagasinieremail(email);
		
		ArrayList<Bon_s>  bons = ws.getbons(emp.getM(),false);
		m.addAttribute("bons",bons);
		

		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "magasinier/bons_not";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "magasinier/bons_not";
			}
			catch (Exception ee){
				return "magasinier/bons_not";
			}
		}
	}
	
	@GetMapping(value = "/bons/delivred")
	public  String bonsdelivered(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((Userdetail)principal).getEmail();
		
		Magasinier  emp = ws.getmagasinieremail(email);
		
		ArrayList<Bon_s>  bons = ws.getbons(emp.getM(),true);
		m.addAttribute("bons",bons);
		

		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "magasinier/bons";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "magasinier/bons";
			}
			catch (Exception ee){
				return "magasinier/bons";
			}
		}
	}
	
	@GetMapping(value = "/bons/livrer/{id}")
	public  String livrer(Model m, @PathVariable String id,RedirectAttributes redirectAttributes) {
	
		Bon_s b = ws.getbonsortie(Long.parseLong(id)).get();
		b.setDelivred(true);
		ws.updatebons(b);
		
		redirectAttributes.addAttribute("suc", "23");
		return "redirect:/dashboard/magasinier/bons/notdelivred";
	
	
	}

	// article
	@GetMapping(value = "/article")
	public  String addart(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		ArrayList<String>  mags = ws.getallmagname();
		m.addAttribute("mags",mags);
		
		
		
		ArrayList<String>  fam = ws.getallfamname();
		m.addAttribute("fam",fam);
		
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "magasinier/article";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "magasinier/article";
			}
			catch (Exception ee){
				return "magasinier/article";
			}
		}
	}
	
	
	

	@PostMapping(value = "article/process")
	public  String addarticleproc(
			@RequestParam String lib ,@RequestParam String raison ,
			@RequestParam String qmax,@RequestParam String qmin,
			@RequestParam String m,@RequestParam String f,
			RedirectAttributes redirectAttributes
			) {
		
	boolean found = false;
	
	Famille fam = ws.getf(f.toLowerCase());
	Magazin mag = ws.getMag(m.toLowerCase());
	

	boolean a = false;
	for(Famille fa : mag.getF()) {
		if(fa.equals(fam)) {
			a = true;
		}
	}
	
	if( ! a ) {
		redirectAttributes.addAttribute("error", "12");
		return "redirect:/dashboard/magasinier/article";
	}
	
	try {
			int []  q = {Integer.parseInt(qmax),Integer.parseInt(qmin)};
	}
	catch (Exception e){
		redirectAttributes.addAttribute("error", "13");
		return "redirect:/dashboard/magasinier/article";
	}
	
	try{
			found = ws.getarticle(lib.toLowerCase(), fam, mag).getLib().equals(lib.toLowerCase());
		
		}

	catch(Exception e) { }
	
	if (! found){ 
		int []  q = {Integer.parseInt(qmax),Integer.parseInt(qmin)};
		ws.createarticle(lib.toLowerCase(), raison.toLowerCase(), q[0], q[1], fam, mag);
		
				redirectAttributes.addAttribute("suc", "18");
				return "redirect:/dashboard/magasinier/article";

		
			}
	else {
		
	
		redirectAttributes.addAttribute("error", "14");
		return "redirect:/dashboard/magasinier/article";
	}
	}
	
	// Bon entre 
	
	
	@GetMapping(value = "/bone")
	public  String addbone(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
		ArrayList<String>  mags = ws.getallmagname();
		m.addAttribute("mags",mags);
		
		ArrayList<String>  four = ws.getallfourname();
		m.addAttribute("four",four);
		
		ArrayList<String>  fam = ws.getallfamname();
		m.addAttribute("fam",fam);
		
		ArrayList<String> arts = ws.getallartname();
		m.addAttribute("arts",arts);
		try {
			Integer sc = Integer.parseInt(suc) ;
			m.addAttribute("suc",succ.succ(sc));
			return "magasinier/bone";
		}
		catch (Exception e){
			try {
				Integer er = Integer.parseInt(error) ;
				m.addAttribute("err",err.error(er));
				return "magasinier/bone";
			}
			catch (Exception ee){
				return "magasinier/bone";
			}
		}
	}
	
	
	@PostMapping(value = "/bone/process")
	public  String addbonproc(
			@RequestParam String a ,@RequestParam String four ,
			@RequestParam String q,@RequestParam String prixu,
			@RequestParam String m,@RequestParam String f,
			RedirectAttributes redirectAttributes
			) {
		
	boolean found = false;
	
	Famille fam = ws.getf(f.toLowerCase());
	Magazin mag = ws.getMag(m.toLowerCase());
	Fournisseur fourni = ws.getfour(four);

	boolean c = false;
	for(Famille fa : mag.getF()) {
		if(fa.equals(fam)) {
			c = true;
		}
	}
	
	if( ! c ) {
		redirectAttributes.addAttribute("error", "12");
		return "redirect:/dashboard/magasinier/bone";
	}
	
	try {
			int  qte = Integer.parseInt(q);
			float prix = 	Float.parseFloat(prixu)*qte;
	}
	catch (Exception e){
		redirectAttributes.addAttribute("error", "13");
		return "redirect:/dashboard/magasinier/bone";
	}
	
	try{
			found = ws.getarticle(a.toLowerCase(), fam, mag).getLib().equals(a.toLowerCase());
		
		}

	catch(Exception e) { }
	
	if ( found){ 
		
		int  qte = Integer.parseInt(q);
		float prix = 	Float.parseFloat(prixu)*qte;

		Article art =  ws.getarticle(a.toLowerCase(), fam, mag);
		
		if (art.getQmax()<qte+art.getQdisp()) {
			redirectAttributes.addAttribute("error", "16");
			return "redirect:/dashboard/magasinier/bone";
		}
		
		else {
			
			art.setQdisp(qte + art.getQdisp());
			ws.createbone(art, mag, fam, fourni, qte, prix, new Date());
			ws.updateart(art);
				redirectAttributes.addAttribute("suc", "19");
				return "redirect:/dashboard/magasinier/bone";
		}
		
			

		
			}
	else {
		
	
		redirectAttributes.addAttribute("error", "15");
		return "redirect:/dashboard/magasinier/bone";
	}
	}
	
	// Famille 
	
			@GetMapping(value = "/famille")
			public  String addfam(Model m,@RequestParam(required = false) String suc,@RequestParam(required = false) String error) {
				ArrayList<String>  mags = ws.getallmagname();
				m.addAttribute("mags",mags);
				try {
					Integer sc = Integer.parseInt(suc) ;
					m.addAttribute("suc",succ.succ(sc));
					return "magasinier/famille";
				}
				catch (Exception e){
					try {
						Integer er = Integer.parseInt(error) ;
						m.addAttribute("err",err.error(er));
						return "magasinier/famille";
					}
					catch (Exception ee){
						return "magasinier/famille";
					}
				}
			}
			
			@PostMapping(value = "/famille/process")
			public  String addfamilleproc(
					@RequestParam String des ,@RequestParam String nom_mag ,
					@RequestParam String nom,
					RedirectAttributes redirectAttributes
					) {
				
			boolean found = false;
				
			try{
					
					List<Famille> fs = ws.getMag(nom_mag.toLowerCase()).getF();
					
					for (Famille f: fs) {
						if (f.getNom().equals(nom.toLowerCase())) {
							found = true;
							break;
						}
					}
				}

			catch(Exception e) { }
			
			if (! found){ 
				Magazin m = ws.getMag(nom_mag.toLowerCase());
				
				Famille f = ws.createf(nom.toLowerCase(), des.toLowerCase());
				ws.addfamille(m, f);
				
						redirectAttributes.addAttribute("suc", "17");
						return "redirect:/dashboard/magasinier/famille";

				
					}
			else {
				redirectAttributes.addAttribute("error", "11");
				return "redirect:/dashboard/magasinier/famille";
			}
			}
		// alertes
			@GetMapping(value = "/artalert")
		    public String artalert(@RequestParam(required = false) String error,Model m)  {
				Iterable<Article> s = ws.artundermin();
				m.addAttribute("arts",s);
				try {
					Integer er = Integer.parseInt(error) ;
					m.addAttribute("error",err.error(er));
					return "magasinier/artalert";
				}
				catch (Exception e){
					return "magasinier/artalert";
				}
				
		    }	
			
			


}
