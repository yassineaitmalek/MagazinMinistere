<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>A. Famille</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
    </head>
    <body>
	    
  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/magasinier/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(700%,0%);"><a href='#'>Paramétres</a>
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
  	    
  	
			${suc}
		${err}
        
		<br><br> <br><br>
		
		
		
		 <form method="post" action="/dashboard/magasinier/famille/process">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">

                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Nom Famille :  </h3>
                           <input type="text" placeholder="Nom" name="nom" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
 
                  <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Description :  </h3>
                           <input type="textarea" placeholder="Description" name="des" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
                    
                     <tr>
                        <td colspan="2" align="center">
                            <h3 for="niveau">Magazin : </h3>
                            <select  name="nom_mag" size="1" class="selection" required>
                                            
                                            <option></option>         
	                                        <c:forEach items="${mags}" var="d">
	     										<option >${d}</option>
											</c:forEach>    
                    
                            </select>
                            <br><br><br>
                        </td>
                       
                    </tr>
                    
                

                    <tr>
                        <td height="100px" width="100px" align="center">
                            <input type="submit" value="Creer" name="create" class="block">
                        <td height="100px" width="100px" align="center">
                            <input type="reset" value="Initialiser " name="reset" class="block">
                            
                        </td>
                    </tr>

            </table>
            
                
        </form>
        
        <br><br>


		
    
    </body>
</html>
    