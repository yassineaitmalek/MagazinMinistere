<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>L. Chef Division </title>
       

       
        <style><%@include file="/WEB-INF/css/style1.css"%></style>
        
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        

    </head>
    <body>
    
        
  	
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
  	
    
  	    
		${suc}
		${err}
  		
        <h3 align="center">La Liste des Chefs Divisions</h3>
		
		<div class="table-wrapper">
      	<table  cellspacing="0" border="1" class="fl-table">
      		<thead>
      			<tr>
                  	<th> CIN</th>
                    <th> Prénom</th>
                    <th> Nom </th>
                    <th> Email </th>
                    <th> Tel </th>
                    <th>Promotion</th>
                    <th> Supprimer</th>
              

            	

      				
      			</tr>
      		</thead>
      		<tbody>
      		 <c:forEach items="${sers}" var="e">
	     								
	     				<tr>
					<td>	${e.cin}		</td>
					<td>	${e.prenom}			</td>
                    <td>	${e.nom}		</td>
                    <td>	${e.email}		</td>
                    <td>	${e.tel}		</td>
                   
                  
                                  
                    <td><a  style='text-decoration:none;' href= "/dashboard/admin/list/chef_div/upd/${e.email}"	>Directeur</a></td>
                  	<td><a  style='text-decoration:none;' href= "/dashboard/admin/list/chef_div/del/${e.email}"		>supprimer</a></td>
                           
               	</tr>				
	     								
				</c:forEach>    
                  
				

            </tbody>

        	</table>
            
        </div>
  	
  	
  
    </body>

</html>
  