package com.Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.CRUD.*;

import com.Project.Entities.*;

@Service
public class WebServices {
	
	@Autowired
	private DirectionCRUD dc;
	
	@Autowired
	private DivisionCRUD dvc;
	
	@Autowired
	private ServiceeCRUD sc;
	
	@Autowired
	private EmployeeCRUD ec;
	
	@Autowired
	private RoleCRUD rc;
	
	
	@Autowired
	private MagazinCRUD mc;
	
	@Autowired
	private MagasinierCRUD mgc;
	
	@Autowired
	private FournisseurCRUD fc;
	
	@Autowired
	private FamilleCRUD fmc;
	
	@Autowired
	private ArticleCRUD ac;
	
	@Autowired
	private Bon_eCURD bc;
	
	@Autowired
	private DemandeCRUD dmc;
	
	@Autowired
	private Bon_sCRUD bsc;
	
	/// direction
	
	public void createdir(String nom) {
		Direction dir = new Direction();
		dir.setNom(nom);
	
		dc.save(dir);
		
	}
	
	public void updatedir(Direction dir) {
		dc.save(dir);
	}
	
	public Direction getDir(String nom) {
		return dc.findByNom(nom);
	}
	
	public ArrayList<String> getalldirname() {
		Iterable<Direction> dirs = dc.findAll();
		ArrayList<String> s = new ArrayList<String> ();
		
		for (Direction d :dirs ) {
			s.add(d.getNom());
		}
		
		return s;
	}
	
	/// division 
	
	public void creatediv(String nom,String nom_dir) {
		
		Direction dir = this.getDir(nom_dir);
		Division div = new Division();
		div.setNom(nom);
		div.setDir(dir);
		
		dvc.save(div);
		
	}
	
	public Division getDiv(String nom) {
		return dvc.findByNom(nom) ;
		
	}
	
	public void updatediv(Division d) {
		dvc.save(d);
	}
	
	
	
	public ArrayList<String> getalldivname() {
		Iterable<Division> divs = dvc.findAll();
		ArrayList<String> s = new ArrayList<String> ();
		
		for (Division d :divs ) {
			s.add(d.getNom());
		}
		
		return s;
	}
	
	
	/// service 
	public Servicee  getSer(String nom) {
		return  sc.findByNom(nom) ;
		
	}
	
	
	public void  updateser(Servicee s) {
		 sc.save(s) ;
		
	}
	
	
	public void createser(String nom,String nom_div) {
		
		Division div = this.getDiv(nom_div);
		Servicee ser = new Servicee();
		ser.setDiv(div);
		ser.setNom(nom);
		
		sc.save(ser);

		
	}
	
	public ArrayList<String> getallsername() {
		Iterable<Servicee> sers = sc.findAll();
		ArrayList<String> s = new ArrayList<String> ();
		
		for (Servicee ser :sers ) {
			s.add(ser.getNom());
		}
		
		return s;
	}
	
	
	/// Employee
	
	public String getemail(String nom,String prenom) {
		
		String email;
		
		String lname = nom.replace(" ", "").toLowerCase();
		String[] fname  = prenom.split(" ");
		
		String head = "";
		
		for (String s: fname) {
			head += s.substring(0,1).toLowerCase();
		}
		
		email = head+lname+"@sabmalek.com";
		
		return email;
	}
	
	public String getpass(String nom,String prenom) {
			
		String pass;
		
		String lname = nom.replace(" ", "").toLowerCase();
		String[] fname  = prenom.split(" ");
		
		String head = "";
		
		for (String s: fname) {
			head += s.substring(0,1).toLowerCase();
		}
		
		pass = head+lname;
		
		return pass;
		
	}
	public Employee getemp(String cin) {
		return ec.findByCin(cin);
	}
	public Employee getempemail(String email) {
		return ec.findByEmail(email);
	}
	
	public void createemp(String cin,String nom,String prenom,String tel,Division div,Servicee ser,String email,Role r) {
		
		
		Employee emp = new Employee();
		
		
		emp.setCin(cin);
		emp.setNom(nom);
		emp.setPrenom(prenom);
		emp.setTel(tel);
		emp.setDiv(div);
		emp.setSer(ser);
		emp.setEmail(email);
		emp.setR(r);
		ec.save(emp);
		
	}
	
	public void deleteemp(String email) {
		Employee e = this.getempemail(email);
		ec.delete(e);
	}
	
	public ArrayList<Employee> getemps(Role r) {
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		Iterable<Employee>es =  ec.findAll();
		 for (Employee e :es) {
			 if (e.getR().equals(r)) {
				 emps.add(e);
				 
			 }
		 }
		 
		 return emps;
	}
	
	
	public void updateemp(Employee e) {
		ec.save(e);
	}
	// role 
	
	public Role getR(String r) {
		return rc.findByR(r);
	}
	
	public void createR(String nom) {
		
		boolean found = false;
			
		try{
				found = this.getR(nom.toLowerCase()).getNom().equals(nom.toLowerCase());
			}

		catch(Exception e) { }
		
		if ( found == false ){ 
			Role r = new Role();
			r.setNom(nom.toLowerCase());
			rc.save(r);
		}
		
	}
	
	// magazin 
	
	public void createmag(String nom,String nom_dir) {
		
		Direction dir = this.getDir(nom_dir);
		Magazin  mag  = new Magazin();
		mag.setNom(nom);
		mag.setDir(dir);
		dir.setM(mag);
		mc.save(mag);
		dc.save(dir);
		
	}
	
	public Magazin getMag(String nom) {
		return mc.findByNom(nom) ;
		
	}
	
	
	
	public ArrayList<String> getallmagname() {
		Iterable<Magazin> divs = mc.findAll();
		ArrayList<String> s = new ArrayList<String> ();
		
		for (Magazin d :divs ) {
			s.add(d.getNom());
		}
		
		return s;
	}
	
	public void addfamille(Magazin m ,Famille f ) {
		
		List<Famille> l = m.getF();
		l.add(f);
		m.setF(l);
		mc.save(m);
		
	}
	
	public ArrayList<Magazin> getmagdir(Direction d){
		
		ArrayList<Magazin>  a = new ArrayList<Magazin> ();
		Iterable<Magazin> mags = mc.findAll();
		
		for( Magazin m : mags) {
			if(m.getDir().equals(d)) {
				a.add(m);
			}
		}
		return a;
	}
	
	
	public ArrayList<String> getmagdirname(Direction d){
		ArrayList<String>  a = new ArrayList<String> ();
		ArrayList<Magazin>  mags = this.getmagdir(d);
	
		
		for( Magazin m : mags) {
			
				a.add(m.getNom());
			
		}
		return a;
	}
	
	
	// magasinier
	
	public Magasinier getmagasinier(String cin) {
		return mgc.findByCin(cin);
	}
	
	public Magasinier getmagasinieremail(String email) {
		return mgc.findByemail(email);
	}
	
	public void deletemagasinier(String email) {
		Magasinier m = this.getmagasinieremail(email);
		mgc.delete(m);
	}
	
	public ArrayList<Magasinier> getmagasiniers(Role r) {
		
		ArrayList<Magasinier> emps = new ArrayList<Magasinier>();
		
		Iterable<Magasinier>es =  mgc.findAll();
		 for (Magasinier e :es) {
			 if (e.getR().equals(r)) {
				 emps.add(e);
				 
			 }
		 }
		 
		 return emps;
	}
	
	public void createmagasinier(String cin,String nom,String prenom,String tel,Magazin m,String email,Role r) {
		
		
		Magasinier emp = new Magasinier();
		
		emp.setCin(cin);
		emp.setNom(nom);
		emp.setPrenom(prenom);
		emp.setTel(tel);
		emp.setM(m);
		emp.setEmail(email);
		emp.setR(r);
		mgc.save(emp);
		
	}
	
	// fournissseur 
	
	public Fournisseur getfour(String nom) {
		return fc.findByNom(nom);
	}
	
	public void createfourr(String nom,String adress,String tel,String email,Role r) {
		
		
		Fournisseur emp = new Fournisseur();
		
		
		emp.setNom(nom);

		emp.setTel(tel);
		emp.setAdress(adress);
		emp.setEmail(email);
		emp.setR(r);
		fc.save(emp);
		
	}
	
	public  ArrayList<String> getallfourname(){
		ArrayList<String> fam = new ArrayList<String>();
		
		Iterable<Fournisseur> fs = fc.findAll();
		
		for (Fournisseur f : fs) {
			fam.add(f.getNom());
		}
		return fam;
	}
	
	// famille
	
	
	public Famille createf(String nom,String des) {
		Famille f = new Famille();
		f.setNom(nom);
		f.setDes(des);
		fmc.save(f);
		
		return f;
	}
	
	public  ArrayList<String> getallfamname(){
		ArrayList<String> fam = new ArrayList<String>();
		
		Iterable<Famille> fs = fmc.findAll();
		
		for (Famille f : fs) {
			fam.add(f.getNom());
		}
		return fam;
	}
	
	public Famille getf(String nom) {
		return fmc.findByNom(nom);
	}
	
	
	public ArrayList<String> getfam_mag(Division d  ,boolean prv){
		ArrayList<String> a = new ArrayList<String>();
		
		if(prv) {
			for(Famille f : d.getDir().getM().getF()) {
				a.add(f.getNom());
			}
		}
		else {
			for(Famille f :d.getDir().getM().getF()) {
				if(!f.getNom().contains("_prv")) {
						a.add(f.getNom());
				}
			
			}
		}
		return a;
		
	}
	
	// article 
	
	public void createarticle(String lib,String raison,int qmax,int qmin,Famille f ,Magazin m) {
		 Article a = new Article();
		 
		a.setF(f);
		a.setLib(lib);
		a.setM(m);
		a.setRaison(raison);
		a.setQmin(qmin);
	
		a.setQmax(qmax);
		
		ac.save(a);
		
	}
	
	
	public Article getarticle(String lib,Famille f ,Magazin m) {
		
		Iterable<Article> as = ac.findBylib(lib);
		
		for (Article a : as ) {
			if(a.getF().equals(f) && a.getM().equals(m)) {
				return a;
			}
		
		}
		return null;
	}
	
	public ArrayList<String> getallartname(){
		ArrayList<String>  a = new ArrayList<String> ();
		Iterable<Article> as = ac.findAll();
		
		for( Article aa : as )
		{
			a.add(aa.getLib());
			
		}
		
		return a;
	}
	
	public ArrayList<Article> getartmags(Magazin m,boolean prv){
		ArrayList<Article> a = new ArrayList<Article>();
		Iterable<Article> arts = ac.findAll();
		
		if (prv) {
			
			for(Article art : arts) {
				if(art.getM().equals(m)) {
				a.add(art);
				}}
			
		}else {
			for(Article art : arts) {
				if(art.getM().equals(m)) {
					if(art.getF().getNom().contains("_prv")) {
						
					}else {
						a.add(art);
					}
					
				
				}}
			
		}
		

		
		return a;
		
	}
	
	
	public void updateart(Article a) {
		ac.save(a);
	}
	
	public ArrayList<String> getlibs(Division d,boolean prv){
		ArrayList<String>  a = new ArrayList<String> ();

			ArrayList<Article>  arts = this.getartmags(d.getDir().getM(), prv);
			for (Article art:arts) {
				a.add(art.getLib());
			
			
		}
		
		
		
		
		return a;
	}
	
	// bon entré
	
	public void createbone(Article a,Magazin m,Famille fm ,Fournisseur f,int qte,float prix,Date d) {
		
		Bon_e b = new Bon_e();
		b.setA(a);
		b.setF(f);
		b.setM(m);
		b.setDate(d);
		b.setFm(fm);
		b.setPrix(prix);
		b.setQte(qte);
		
		
		bc.save(b);
		
	}
	
	
	
	
	// demande 
	
	
	public void createdem(Article a,Famille f,Magazin m,Employee e,Date d,String etat,int q) {
		
		Demande dem = new Demande();
		dem.setD(d);
		dem.setA(a);
		dem.setE(e);
		dem.setEtat(etat);
		dem.setF(f);
		dem.setM(m);
		dem.setQte(q);
		dmc.save(dem);
	}
	
	public ArrayList<Demande> getDemswait(Servicee s){
		ArrayList<Demande> a = new ArrayList<Demande>();
		Iterable<Demande> d = dmc.findByetat("wait");
		
		for(Demande dm : d) {
			if(dm.getE().getSer().equals(s)) {
				a.add(dm);
			}
		}
		return a;
	}
	
	public void refusedem(Long id) {
		Optional<Demande> d = dmc.findById(id);
		
		Demande dd = d.get();
		dd.setEtat("refused");
		dmc.save(dd);
	}
	
	public Optional<Demande> getdemande(Long id) {
		return dmc.findById(id);
	}
	
	public void updatedemande(Demande d) {
		dmc.save(d);
	}
	
	
	public ArrayList<Demande> getmyDems(Employee e,String etat){
		 ArrayList<Demande> a = new  ArrayList<Demande>();
		 Iterable<Demande> dems = dmc.findAll();
		 
		 for(Demande d:dems) {
			 if(d.getE().equals(e) && d.getEtat().equals(etat)) {
				 a.add(d);
			 }
		 }
		 return a;
	}
	
	public ArrayList<Demande> getDemser(Servicee s,String etat){
		 ArrayList<Demande> a = new  ArrayList<Demande>();
		 Iterable<Demande> dems = dmc.findAll();
		 
		 for(Demande d:dems) {
			 if(d.getE().getSer().equals(s) && d.getEtat().equals(etat)) {
				 a.add(d);
			 }
		 }
		 return a;
	}
	
	public void createbons(Article a,Date d,Magazin m , int qte,Employee e) {
		Bon_s b = new Bon_s();
		
		b.setA(a);
		b.setD(d);
		b.setDelivred(false);
		b.setM(m);
		b.setQte(qte);
		b.setE(e);
		
		bsc.save(b);
	}
	
	public Iterable<Article> artundermin(){
		
		return ac.findByundermin();
	}
	
	
	
	public ArrayList<Servicee> getsers(Division d){
		ArrayList<Servicee> a = new ArrayList<Servicee>();
		
		Iterable<Servicee> sers = sc.findAll();
		
		for (Servicee s : sers) {
			if(s.getDiv().equals(d)) {
				a.add(s);
			}
		}
		return a;
	}
	
	
	public ArrayList<Bon_s> getbons(Magazin m,boolean d){
		ArrayList<Bon_s> a = new ArrayList<Bon_s>();
		Iterable<Bon_s> bs = bsc.findAll();
		
		for(Bon_s b : bs) {
			if(b.getM().equals(m) && (b.isDelivred() == d)) {
				a.add(b);
			}
		}
		return a;
		
	}
	
	public Optional<Bon_s> getbonsortie(Long id) {
		return bsc.findById(id);
	}
	
	public void updatebons(Bon_s s) {
		bsc.save(s);
	}
	
	
	
	public ArrayList<Fournisseur> getconsultfour(Famille fa ,String year  ){
		
			Iterable<Bon_e>  bon = bc.findAll();
		 ArrayList<Fournisseur> a = new  ArrayList<Fournisseur>();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
			
			boolean y = !year.equals("");

			boolean f = ! (fa == null);
		 
		if( f && y  ) {
			
			for(Bon_e b : bon ) {
				
				if(  b.getF().equals(fa) && (simpleDateFormat.format(b.getDate()).toUpperCase().equals(year))   ) {
					a.add(b.getF());
				}
				
			}
		}
			
		else  if( f && !y  ) {
			
			for(Bon_e b : bon ) {
				
				if(  b.getF().equals(fa)   ) {
					a.add(b.getF());
				}
				
			}
		} 
		
		else 		if( !f && y  ) {
			
			for(Bon_e b : bon ) {
				
				if(  (simpleDateFormat.format(b.getDate()).toUpperCase().equals(year))   ) {
					a.add(b.getF());
				}
				
			}
		}

		else {
			for( Fournisseur four : fc.findAll()) {
				a.add(four);
			}
			
		}
		return a;
		
	
		
	}
	
	
	public ArrayList<Article> consultart(Magazin mag,Famille fa ,String year,String month){
		 ArrayList<Article> a = new  ArrayList<Article>();
		Iterable<Bon_e> bs = bc.findAll();
		
		boolean y = !year.equals("");
		boolean m= !month.equals("");
		boolean f = ! (fa == null);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
		
		 if(   f &  y &  m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && b.getFm().equals(fa) && ( simpleDateFormat.format(b.getDate()).toUpperCase().equals(year) ) && (simpleDateFormat2.format(b.getDate()).toUpperCase().equals(month))) {
					 a.add(b.getA());
				 }
			 }
		 }
		 
		 else if(   f &  y &  !m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && b.getFm().equals(fa) && ( simpleDateFormat.format(b.getDate()).toUpperCase().equals(year) ) ) {
					 a.add(b.getA());
				 }
			 }
		 }
		 else if(   f &  !y &  m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && b.getFm().equals(fa)  && (simpleDateFormat2.format(b.getDate()).toUpperCase().equals(month))) {
					 a.add(b.getA());
				 }
			 }
		 }
		 
		 else if(   f &  !y &  !m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && b.getFm().equals(fa) ) {
					 a.add(b.getA());
				 }
			 }
		 }
		 
		 else if(   !f &  y &  m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && ( simpleDateFormat.format(b.getDate()).toUpperCase().equals(year)) && (simpleDateFormat2.format(b.getDate()).toUpperCase().equals(month))) {
					 a.add(b.getA());
				 }
			 }
		 }
		 
		 else if(   !f &  y &  !m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag) && ( simpleDateFormat.format(b.getDate()).toUpperCase().equals(year) ) ) {
					 a.add(b.getA());
				 }
			 }
		 }
		 
		 else if(   !f &  !y &  m      ) {
			 for(Bon_e b : bs) {
				 if (b.getM().equals(mag)  && (simpleDateFormat2.format(b.getDate()).toUpperCase().equals(month))) {
					 a.add(b.getA());
				 }
			 }
		 }

		 else {
			 for(Article art : ac.findAll()) {
				 if(art.getM().equals(mag)) {
					 a.add(art);
				 }
			 }
		 }
		
		
		 return a;
		 
	}
	
	public ArrayList<Division> getAlldiv(Direction dir){
		ArrayList<Division> a = new ArrayList<Division>();
		Iterable<Division> div = dvc.findAll();
		
		for(Division d : div) {
			if(d.getDir().equals(dir)) {
				a.add(d);
			}
		}
		return a;
		
	}
	
	public ArrayList<Servicee> getAllser(Direction dir){
		ArrayList<Servicee> a = new ArrayList<Servicee>();
		Iterable<Servicee> ser = sc.findAll();
		
		for(Servicee d : ser) {
			if(d.getDiv().getDir().equals(dir)) {
				a.add(d);
			}
		}
		
		return a;
	}
	
	
	public ArrayList<Bon_s> getconsom(Direction dir,Division div,Servicee ser,String year,String month){
		ArrayList<Bon_s> a = new ArrayList<Bon_s>();
		Iterable<Bon_s> bs = bsc.findAll();
		
		boolean y = !year.equals("");
		boolean m= !month.equals("");
		
		boolean d = ! (div == null);
		boolean s =  ! (ser == null);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
		



		if(  !d && !s && !m && y    ) {
		            for(Bon_s b : bs) {
		                if( (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && !s && m && !y     ) {
		            for(Bon_s b : bs) {
		                if( (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month))   ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && !s && m && y    ) {
		            for(Bon_s b : bs) {
		                if( (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month)) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && s && !m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getSer().equals(ser)    ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && s && !m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getSer().equals(ser) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && s && m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getSer().equals(ser) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month))    ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  !d && s && m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getSer().equals(ser) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month)) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && !s && !m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div)   ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && !s && !m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && !s && m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month))   ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && !s && m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month)) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && s && !m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && b.getE().getSer().equals(ser)   ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && s && !m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && b.getE().getSer().equals(ser) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && s && m && !y     ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && b.getE().getSer().equals(ser) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month))    ) {
		                    a.add(b);
		                }
		            }
		        
		        }
		
		
		else if(  d && s && m && y    ) {
		            for(Bon_s b : bs) {
		                if( b.getE().getDiv().equals(div) && b.getE().getSer().equals(ser) && (simpleDateFormat2.format(b.getD()).toUpperCase().equals(month)) && (simpleDateFormat.format(b.getD()).toUpperCase().equals(year))  ) {
		                    a.add(b);
		                }
		            }
		        
		        }

		
		
		else {
			for(Bon_s b : bs) {
				if(  b.getE().getDiv().getDir().equals(dir)) {
					a.add(b);
				}
			}
		
		}
		
		return a;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
