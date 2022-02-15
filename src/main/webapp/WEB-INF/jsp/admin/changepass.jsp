<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Change Password</title>
		
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
          
	</head>
	<body>
	
	 	<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/admin/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(800%,0%);"><a href='#'>Param�tres</a>
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
    
  	

		${error }
		
		
	    <div class="log" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );transform: translate(550px, 75px);">
	    	<br>
	        <form method='POST' action="/dashboard/admin/changepass/process/">
		        <h3 class="type">Ancien MDP </h3>
		        <input type="password" placeholder="MDP"  name='op' required autofocus class="box">
		        <h3 class="type">Nouveau MDP</h3>
		        <input type="password" placeholder="MDP" name='np' required autofocus class="box">
		        <h3 class="type">Confirmer MDP</h3>
		        <input type="password" placeholder="MDP" name ='cnp' required autofocus class="box">
		        
		        <input type="submit" value='Changer' name='change' class='bt' >
	        
	        </form>

	    
	    </div>
	</body>
</html>

