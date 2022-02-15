<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html  xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
    <head>
    	
    	<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
        <title>SABMALEK</title>
       
     
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        
       
          
    </head>
    
    <body>
    
  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/magasinier/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(800%,0%);"><a href='#'>Paramétres</a>
			      <ul>

			<li><a href='/dashboard/magasinier/artalert'>Alertes</a></li>   
				<li><a href='/dashboard/magasinier/famille'>Ajouter Famille</a></li>    
			<li><a href='/dashboard/magasinier/article'>Ajouter Article</a></li>     
			<li><a href='/dashboard/magasinier/bone'>Bon Entré</a></li>     
			<li><a href='/dashboard/magasinier/bons/delivred'>Bon Sortie Livré</a></li>
				          
		 <li><a href='/dashboard/magasinier/bons/notdelivred'>Bon Sortie non Livré</a></li>  
				          
				           
		
						<li><a href='/dashboard/magasinier/changepass'>Changer MDP</a></li>
			            <li><a href='/logout'>Logout </a></li>
			         
			      </ul>
			               
			               </li>
			             
			         
			      </ul>
			   </li>
   
			</ul>
		</div>
    

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    
    <h1 style="text-align:center"> La page du Magasinier</h1>
    
    
    
    </body>
</html> 
	
