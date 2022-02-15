<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Chercher Demandes</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
    </head>
    <body>
	  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/chef_div/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(700%,0%);"><a href='#'>Paramétres</a>
			      <ul>
			              
				        <li><a href='/dashboard/chef_div/demande'>Demande</a></li>
			
				          <li><a href='/dashboard/chef_div/mydems'>Mes Demandes</a></li>
				          
				          <li><a href='/dashboard/chef_div/demdiv'>Demandes Services</a></li>     
		
						<li><a href='/dashboard/chef_div/changepass'>Changer MDP</a></li>
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
		
		
		
		 <form method="post" action="/dashboard/chef_div/demser/">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">
					
				<tr>
				<td> 
				<br><br><br>
				</td>
				
				</tr>
                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Nom Service :  </h3>
                             <select  name="ser" size="1" class="selection" required>
                                            
                                            <option></option>         
	                                        <c:forEach items="${sers}" var="d">
	     										<option >${d.nom}</option>
											</c:forEach>    
                    
                            </select>
                            
                              <br><br><br> <br><br><br>
                        </td>
                        
                    </tr>
 
                  
                    
                     <tr>
                        <td colspan="2" align="center">
                            <h3 for="niveau">Etat: </h3>
                            <select  name="etat" size="1" class="selection" required>
                                            
                                            <option></option>         
	                                 			<option ></option>
	     										<option value="accepted">Acceptée</option>
	     										<option value="refused">Refusée</option>
	     										<option value="wait">En Attente</option>
											  
                    
                            </select>
                            <br><br><br>
                        </td>
                       
                    </tr>
                    
                

                    <tr>
                        <td height="100px" width="100px" align="center"  colspan="2" align="center">
                            <input type="submit" value="Chercher" name="create" class="block">
                             <br><br><br>
                     </td>
                    </tr>

            </table>
            
                
        </form>
        
        <br><br>

       

   
		
    
    </body>
</html>
    