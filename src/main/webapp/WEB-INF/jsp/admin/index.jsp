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
    
	<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/admin/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(800%,0%);"><a href='#'>Paramétres</a>
			      <ul>
			              
				               		<li><a href='/dashboard/admin/add'>Ajouter</a></li>
				               		
				               		<li><a href='/dashboard/admin/list/'>Liste</a></li>
				      
				               		
									<li><a href='/dashboard/admin/changepass'>Changer MDP</a></li>
									
			            			<li><a href='/logout'>Logout </a></li>
			         
			      </ul>
			               
			               </li>
			             
			         
			      </ul>
			   </li>
   
			</ul>
		</div>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    
    <h1 style="text-align:center"> La page de l'Administrateur</h1>
    
    
    
    </body>
</html> 
	
