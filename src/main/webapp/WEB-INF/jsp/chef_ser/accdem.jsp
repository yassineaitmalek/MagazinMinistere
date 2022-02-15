<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Liste des Demandes </title>
       

       
        <style><%@include file="/WEB-INF/css/style1.css"%></style>
        
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        

    </head>
    <body>
    
  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/chef_ser/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(800%,0%);"><a href='#'>Paramétres</a>
			      <ul>
			              
				        <li><a href='/dashboard/chef_ser/demande'>Demande</a></li>
				        <li><a href='/dashboard/chef_ser/accdem'>Accepter Demande</a></li>
				          <li><a href='/dashboard/chef_ser/mydems'>Mes Demandes</a></li>
				          <li><a href='/dashboard/chef_ser/demser/accepted'>Demandes acceptees</a></li>     
				          <li><a href='/dashboard/chef_ser/demser/refused'>Demandes refusées</a></li> 
						<li><a href='/dashboard/chef_ser/changepass'>Changer MDP</a></li>
			            <li><a href='/logout'>Logout </a></li>
			         
			      </ul>
			               
			               </li>
			             
			         
			      </ul>
			   </li>
   
			</ul>
		</div>
    
  	
  	
  	    
		${suc}
		${err}
  		
        <h3 align="center">La Liste des Demandes</h3>
		
		<div class="table-wrapper">
      	<table  cellspacing="0" border="1" class="fl-table">
      		<thead>
      			<tr>
                  	<th> Nom</th>
                    <th> Prenom</th>
                   
                    <th> Article </th>
                    <th> Qte </th>
                    
                    <th>Accepter</th>
                    <th> Refuser</th>
              

            	

      				
      			</tr>
      		</thead>
      		<tbody>
      		 <c:forEach items="${dems}" var="dem">
	     								
	     				<tr>
					<td>	${dem.e.nom}		</td>
					<td>	${dem.e.prenom}			</td>
                    <td>	${dem.a.lib}		</td>
                    <td>	${dem.qte}		</td>
                 
                   
                  
                                  
                    <td><a  style='text-decoration:none;' href= "/dashboard/chef_ser/accdem/accept/${dem.id}"	>Accepter</a></td>
                  	<td><a  style='text-decoration:none;' href= "/dashboard/chef_ser/accdem/refuse/${dem.id}"		>Refuser</a></td>
                           
               	</tr>				
	     								
				</c:forEach>    
                  
				

            </tbody>

        	</table>
            
        </div>
  	
  	
  
    </body>

</html>
  