package com.Project.HTML;

import org.springframework.stereotype.Service;

@Service
public class Success {
	
	private String body(String msg) {
		
		String style =  "style ='text-align: center;   color: #68d026;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'";
		
		String err = "<h2 "+style+">"+msg+"</h2> ";
		
		return err;
		
	}
	
	public String succ(int i ) {
		
		if( i == 1) {
			return this.body("Direction a ete creer avec succes");
		}
		else if ( i == 2) {
			return this.body("Division a ete creer avec succes");
		}
		
		else if ( i == 3) {
			return this.body("Service a ete creer avec succes");
		}
		
		else if ( i == 4) {
			return this.body("Employee a ete creer avec succes");
		}
		
		else if ( i == 5) {
			return this.body("Admin a ete creer avec succes");
		}
		
		else if ( i == 6) {
			return this.body("Magazin a ete creer avec succes");
		}
		
		else if ( i == 7) {
			return this.body("Magasinier a ete creer avec succes");
		}
		
		else if ( i == 8) {
			return this.body("Fournisseur a ete creer avec succes");
		}
		
		else if ( i == 9) {
			return this.body("Employee a ete supprimé avec succes");
		}
		
		else if ( i == 10) {
			return this.body("Employee est devenu un chef de service avec succes");
		}
		
		else if ( i == 11) {
			return this.body("Chef Service est devenu un chef de Division avec succes");
		}
		
		else if ( i == 12) {
			return this.body("Chef Service  a ete supprimé avec succes");
		}
		
		else if ( i == 13) {
			return this.body("Chef Division  a ete supprimé avec succes");
		}
		
		else if ( i == 14) {
			return this.body("Chef Division est devenu un Directeur  avec succes");
		}
		
		else if ( i == 15) {
			return this.body("Directeur  a ete supprimé avec succes");
		}
		else if ( i == 16) {
			return this.body("Magasinier  a ete supprimé avec succes");
		}
		
		else if ( i == 17) {
			return this.body("Famille a ete creer avec succes");
		}
		else if ( i == 18) {
			return this.body("Article a ete creer avec succes");
		}
		
		else if ( i == 19) {
			return this.body("Bon d'entré a ete creer avec succes");
		}
		else if ( i == 20) {
			return this.body("Demande a ete creer avec succes");
		}
		
		else if ( i == 21) {
			return this.body("Demande est refusee");
		}
		
		else if ( i == 22) {
			return this.body("Demande est acceptee");
		}
		

		else if ( i == 23) {
			return this.body("Bon de Sortie est Livré");
		}
		
		else if ( i == 24) {
			return this.body("Le fichier est généré");
		}
		else {
			return "";
		}
		
	}

}
