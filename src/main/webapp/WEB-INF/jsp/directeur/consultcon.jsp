<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Consult Consommation</title>
       
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
		
		
        
		<br><br> <br><br>
		
		 <form method="post" action="/dashboard/directeur/consult/consommation/process">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">
            
                      <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Division :  </h3>
                        	<select  name="div" size="1" class="selection" required>
                                            
                                            <option></option>
                                             <option value="">None</option>
                                            <c:forEach items="${di}" var="d">
	     										<option >${d.nom}</option>
											</c:forEach> 
                                    
                                            
                            </select>
                            <br><br><br>
                            
                             
                        </td>
                        
					</tr>
					
					<tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Service :  </h3>
                        	<select  name="ser" size="1" class="selection" required>
                                            
                                            <option></option>
                                             <option value="">None</option>
                                            <c:forEach items="${ser}" var="d">
	     										<option >${d.nom}</option>
											</c:forEach> 
                                    
                                            
                            </select>
                            <br><br><br>
                            
                             
                        </td>
                        
					</tr>
					
					
                    <tr>
                       <td colspan="2" align="center">
                            <h3 for="matricule">Année :  </h3>
                        	<select  name="year" size="1" class="selection" required>
                                            
                                            <option value=""></option>
                                   <option value="">None</option>
	     										<option >2021</option>
											<option >2020</option>
                                    
                                            
                            </select>
                            <br><br><br>
                            
                             
                        </td>
                        
                    </tr>
                    
                           <tr>
                       <td colspan="2" align="center">
                            <h3 for="matricule">Mois :  </h3>
                        	<select  name="month" size="1" class="selection" required>
                                            
                                            <option value=""></option>
                                   <option value="">None</option>
	     										<option >01</option>
	     												<option >02</option>
	     														<option >03</option>
	     																<option >04</option>
	     																		<option >05</option>
	     																				<option >06</option>
	     												<option >07</option>
	     														<option >08</option>
		<option >09</option>
				<option >10</option>
						<option >11</option>
								<option >12</option>
										
                                    
                                            
                            </select>
                            <br><br><br>
                            
                             
                        </td>
                        
                    </tr>
                    
                     <tr>
                       <td colspan="2" align="center">
                       
                            <h3 for="type">Type : </h3>
                            
                            
                              <h3 for="type">	PDF : <input type="radio" name="ext" value="pdf"  class="check" required>  
                              					XLS : <input type="radio" name="ext" value="xls"  class="check"required>
                               </h3> 
                              
                        </td>
                            
                             
                        </tr>
                        
                  
                

                    <tr>
                        <td height="100px" width="100px" align="center">
                            <input type="submit" value="Generer" name="create" class="block">
                 
                    </tr>

            </table>
            
                
        </form>
        
        <br><br>

   
		
    
    </body>
</html>
    