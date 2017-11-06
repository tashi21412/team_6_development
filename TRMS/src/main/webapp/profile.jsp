<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="homepage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <meta charset="UTF-8">
    <title>Profile</title>
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
    <form action="ViewFormsServlet" method="post" class="w3-container">
      <table class="w3-table-all">
      <thead>
      
      <tr>

            <th><input style="visibility: hidden; display: none;"/></th>

       <th>Event Date</th>
        <th>Event Time</th>
        
        <th>Location</th>
        <th>Description</th>
        
        <th>Cost</th>
        
        <th>Grading Format</th>
        <th>Event Type</th>
        <th>Justification</th>
        <th>Status</th>
        <c:forEach var="form" items="${forms}">
						 <c:choose>
   						 <c:when test="${form.status.equals('BC-APPROVED')}">
   						 <th>Grade</th>
   						  </c:when>
 						</c:choose>   
 						</c:forEach>     
      </tr>
	</thead>
	<tbody>
					<c:forEach var="form" items="${forms}">
					<tr>
								<c:choose>
   						 <c:when test="${!form.status.equals('BC-APPROVED')}">
					<td><input style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
											 <c:choose>
   						 <c:when test="${form.status.equals('BC-APPROVED')}">
					<td><input type="number" name="formID" value="<c:out value="${form.formID}"/>" style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
						<td><c:out value="${form.eventDate}" /></td>
						
						<td><c:out value="${form.eventTime}" /></td> 
						<td><c:out value="${form.location}" /></td>
						<td><c:out value="${form.description}" /></td>
						
						<td><c:out value="${form.cost}" /></td>
						
						<td><c:out value="${form.gradingFormat}" /></td>
						<td><c:out value="${form.eventType}" /></td>
						<td><c:out value="${form.justification}" /></td>
						<td><c:out value="${form.status}" /></td>
						 <c:choose>
   						 <c:when test="${form.status.equals('BC-APPROVED')}">
   						 <td><select class="w3-select"
									id="grade" name="grade" >
										<option value="<c:out value="${form.grade}" />"></option>
										<option value="PASSED">PASSED</option>

										<option value="FAILED">FAILED</option>

								</select></td>
   						  </c:when>
 						</c:choose>
						
			
				
					</tr>
				</c:forEach>
	</tbody>
      </table>
              <c:forEach var="form" items="${forms}">
						 <c:choose>
   						 <c:when test="${form.status.equals('BC-APPROVED')}">
   						  <button type="submit" class="w3-btn w3-teal">Submit</button>
   						  </c:when>
 						</c:choose>   
 						</c:forEach>
     
       </form>
    </div>

  </div>

 </body>
  
</html>