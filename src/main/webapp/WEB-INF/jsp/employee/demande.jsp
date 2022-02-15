<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Demande</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
    </head>
    <body>

  		  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/employee/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(700%,0%);"><a href='#'>Paramétres</a>
			      <ul>
			              
				        <li><a href='/dashboard/employee/demande'>Demande</a></li>
	
				          <li><a href='/dashboard/employee/mydems/wait'>Mes Demandes </a></li>
				          <li><a href='/dashboard/employee/mydems/accepted'>Demandes acceptees</a></li>     
				          <li><a href='/dashboard/employee/mydems/refused'>Demandes refusées</a></li> 
						<li><a href='/dashboard/employee/changepass'>Changer MDP</a></li>
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
		
		 <form method="post" action="/dashboard/employee/demande/process">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">
            
                <tr>
                        <td colspan="2" align="center">
                            <h3 for="niveau">Libilé : </h3>
                            <select  name="lib" size="1" class="selection" required>
                                            
                                            <option></option>
                                            <c:forEach items="${libs}" var="d">
	     										<option >${d}</option>
											</c:forEach>   
                                            
                            </select>
                            <br><br><br>
                        </td>
                       
                    </tr>
            

                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Quantité :  </h3>
                           <input type="text" placeholder="Qte" name="q" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
 
                 
                 <tr>
                        <td colspan="2" align="center">
                            <h3 for="niveau">Famille : </h3>
                            <select  name="f" size="1" class="selection" required>
                                            
                                            <option></option>
                                            <c:forEach items="${fam}" var="d">
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
    