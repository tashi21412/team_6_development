<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="homepage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <meta charset="UTF-8">
    <title>Homepage</title>
  </head>

  <body>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
  

   

  <div id="main">

  <div class="w3-teal">
    <div class="w3-container">
      <h1>TRMS</h1>
    </div>
  </div>

 
  

  <div id = "profile">
    <div class="w3-card-4">
      <img src="profile_sub.png" alt="Profile">
      <div id="userinfo" class="w3-container w3-center">
        <p>Name: User's Name</p>
      </div>
    </div>
    <h2>Reimbursement History</h2>
    <div class="w3-responsive">
    <form method="get" class="w3-container">
      <table class="w3-table-all">
      <thead>
      <tr>
       <th>Event Date</th>
        <th>Event Time</th>
        
        <th>Location</th>
        <th>Description</th>
        
        <th>Cost</th>
        
        <th>Grading Format</th>
        <th>Event Type</th>
        <th>Justification</th>
      </tr>
	</thead>
	<tbody>
					<c:forEach var="form" items="${forms}">
					<tr>
						<td><c:out value="${form.eventDate}" /></td>
						
						<td><c:out value="${form.eventTime}" /></td> 
						<td><c:out value="${form.location}" /></td>
						<td><c:out value="${form.description}" /></td>
						
						<td><c:out value="${form.cost}" /></td>
						
						<td><c:out value="${form.gradingFormat}" /></td>
						<td><c:out value="${form.eventType}" /></td>
						<td><c:out value="${form.justification}" /></td>
						
			
				
					</tr>
				</c:forEach>
	</tbody>
      </table>
       </form>
    </div>

  </div>

 </body>
  
</html>