package com.Project.HTML;

import org.springframework.stereotype.Service;

@Service
public class Error {
	
	private String body(String msg) {
		
		String style =  "style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'";
		
		String err = "<h2 "+style+">"+msg+"</h2> ";
		
		return err;
		
	}
	
	public String error(int i) {
		
		if( i == 1) {
			return body("Direction existe deja");
			
		}
		else if (i==2) {
			return body("Division existe deja");
		}
		
		else if (i==3) {
			return body("Service existe deja");
		}
		
		else if (i==4) {
			return body("Employee existe deja ");
		}
		
		else if (i==5) {
			return body("le service est eronee");
		}
		
		else if (i==6) {
			return body("Magazin existe deja");
		}
		
		else if (i==7) {
			return body("Magasinier existe deja");
		}
		
		else if (i==8) {
			return body("Fournisseur existe deja");
		}
		
		else if (i==9) {
			return body("Chef Service existe deja");
		}
		
		else if (i==9) {
			return body("Chef Division existe deja");
		}
		
		else if (i==10) {
			return body("Directeur existe deja");
		}
		
		else if (i==11) {
			return body("Famille existe deja");
		}
		
		else if (i==12) {
			return body("Magazin ne contient pas la Famille selectione");
		}
		
		else if (i==13) {
			return body("Les nombre entre sont eronees");
		}
		
		else if (i==14) {
			return body("Article  existe deja");
		}
		
		
		else if (i==15) {
			return body("Combo Article Magazin Famille n'existe pas ");
		}
		else if (i==16) {
			return body("Qte + Qte disponible surpasse la Qte maximale ");
		}
		
		else if (i==17) {
			return body("L'ancien mot de passe est incorrecte");
		}
		else if (i==18) {
			return body("Le nouveau mot de passe n'est pas confirmé ");
		}
		
		else if (i==19) {
			return body("La Qte entre n'est pas un nombre ");
		}
		
		else if (i==20) {
			return body("Combo article Famille n'existe pas");
		}
		
		else if (i==21) {
			return body("la Qte desire surpasse la Qte disponible");
		}
		
		else if (i==22) {
			return body("Combo Division Servicce n'existe pas");
		}
		
		else {
			return "";
		}
		
	}
}
