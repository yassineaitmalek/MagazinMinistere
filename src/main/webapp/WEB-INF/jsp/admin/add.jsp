<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ajouter</title>
       
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
		
		
        
		<br><br> 
		
	  <h3 align="center">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	  Ajouter</h3>

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">
					  <tr>
                        <td colspan="2" align="center">
                              
                            <br> <br> <br>
                        </td>
                        
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                              <form  action="/dashboard/admin/add/dir" >
             						<input type="submit" value=" Direction"  class="block" align = "center" >
       					 		</form>

                            <br>
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/div" >
             						<input type="submit" value=" Division"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                
                   <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/ser" >
             						<input type="submit" value=" Service"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                
		  			 <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/mag" >
             						<input type="submit" value=" Magazin"  class="block" align = "center" >
       					 		</form>
  											<br>
                             
                        </td>
                        
                    </tr>
                
                   <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/employee" >
             						<input type="submit" value=" Employee"  class="block" align = "center" >
       					 		</form>
									  <br>
                             
                        </td>
                        
                    </tr>
                    
                   <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/magasinier" >
             						<input type="submit" value=" Magasinier"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                    
                       <tr>
                        <td colspan="2" align="center">
                              <form   action="/dashboard/admin/add/fournisseur" >
             						<input type="submit" value=" Fournisseur"  class="block" align = "center" >
       					 		</form>

                               <br>
                        </td>
                        
                    </tr>
                    
       
                
                
                
               

            </table>
            
                
    
        

   
		
    
    </body>
</html>
    