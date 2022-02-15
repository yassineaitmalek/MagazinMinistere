<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Se Connecter  </title>
       
        <link rel = "shortcut icon" type = 'img/png' href="/WEB-INF/images/INSEA_logo.png" >
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        

    </head>
    <body>
            
	    <div id='cssmenu'>
			<ul>
			   <li><a href='/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(1225px,0%);"><a href='/signin'>	Se Connecter	</a></li>
		
	
			</ul>
		</div>


		${err}
 		<div class="log" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 ); transform: translate(550px, 75px);">
            <form method="post" action="/signin">
	        	<br><br>
	            <h2 align="center" class="title">	Se Connecter</h2>
	                <br>
	         
	                <h2 class="type"> Email </h2>
	
	                <input type="text" placeholder="Email" name="email" required autofocus class="box">   
	                <br><br>
	
	                <h2 class="type">MDP </h2>

	                <input type="password" placeholder="Mot de Passe" name="password" required class="box">
	               
	                <input type="submit" value="Connecter" name="connect" class="bt">
                
            </form>
            
            

 
        </div>
        
    </body>
</html>

