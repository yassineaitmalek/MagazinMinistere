<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Bon Sortie </title>
       

       
        <style><%@include file="/WEB-INF/css/style1.css"%></style>
        
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        

    </head>
    <body>
        <body>
    
    
  		<div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard/magasinier/'>SABMALEK</a></li>
			   <li class='active' style="transform: translate(800%,0%);"><a href='#'>Paramétres</a>
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
  		
        <h3 align="center">La Liste des Bons de Sorties</h3>
		
		<div class="table-wrapper">
      	<table  cellspacing="0" border="1" class="fl-table">
      		<thead>
      			<tr>
                 
                    <th> Prénom</th>
                    <th> Nom </th>
                    <th> Email </th>
                    
                    <th>Libilé</th>
                    <th> Qte</th>
                    
                    <th>Famille</th>
              		<th>Date</th>
						
				
            	

      				
      			</tr>
      		</thead>
      		<tbody>
      		 <c:forEach items="${bons}" var="b">
	     								
	     				<tr>

					<td>	${b.e.prenom}			</td>
                    <td>	${b.e.nom}		</td>
                    <td>	${b.e.email}		</td>
                    <td>	${b.a.lib}		</td>
                   <td>	${b.qte}		</td>
                  <td>	${b.a.f.nom}		</td>
                  <td>	${b.d}		</td>
                                  
    
                 
                           
               	</tr>				
	     								
				</c:forEach>    
                  
				

            </tbody>

        	</table>
            
        </div>
  	
  	
  
    </body>

</html>
  