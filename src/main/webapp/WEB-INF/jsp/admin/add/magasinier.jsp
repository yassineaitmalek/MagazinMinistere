<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>A. Magasinier</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
    </head>
    <body>
	<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/admin/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(700%,0%);"><a href='#'>Paramétres</a>
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
  	
    ${suc}
		${err}
		
		
        
		<br><br> <br><br>
		
		 <form method="post" action="/dashboard/admin/add/magasinier/process">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">

                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">CIN :  </h3>
                           <input type="text" placeholder="cin" name="cin" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
 
                    <tr>
                        <td>
                            <h3 for="nom">Prénom : </h3>
                            
                            <input type="text" placeholder="Prenom" name="prenom" required autofocus class="box"> 
                        </td>
                        <td>
                            <h3 for="prenom">Nom : </h3>
                            
                            <input type="text" placeholder="Nom" name="nom" required autofocus class="box">
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Tel :  </h3>
                           <input type="text" placeholder="Telephone" name="tel" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
                    
                    
                     <tr>
                        <td colspan="2" align="center" >
                            <h3 for="niveau">Magazin : </h3>
                            <select  name="mag" size="1" class="selection" required>
                                            
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
    