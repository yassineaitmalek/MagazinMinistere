<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Consultation</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
    </head>
    <body>

    	<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/directeur/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(700%,0%);"><a href='#'>Paramétres</a>
			      <ul>
			              
				        <li><a href='/dashboard/directeur/demande'>Demande</a></li>
			
				          <li><a href='/dashboard/directeur/mydems'>Mes Demandes</a></li>
				          
				          <li><a href='/dashboard/directeur/consult'>Consult</a></li>     
		
						<li><a href='/dashboard/directeur/changepass'>Changer MDP</a></li>
			            <li><a href='/logout'>Logout </a></li>
			         
			      </ul>
			               
			               </li>
			             
			         
			      </ul>
			   </li>
   
			</ul>
		</div>
		
		
    ${suc}
		${err}
		
		
        
		<br><br> 
		
	

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">
					  <tr>
                        <td colspan="2" align="center">
                              
                            <br> <br> <br>
                        </td>
                        
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                              <form  action="/dashboard/directeur/consult/consommation" >
             						<input type="submit" value=" Consommation"  class="block" align = "center" >
       					 		</form>

                            <br>
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/directeur/consult/fournisseur" >
             						<input type="submit" value=" Fournisseurs"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                
                   <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/directeur/consult/article" >
             						<input type="submit" value=" Articles"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                
		  			
                
                
               

            </table>
            
                
    
        

   
		
    
    </body>
</html>
    