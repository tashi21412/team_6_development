<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="homepage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <meta charset="UTF-8">
    <title>Admin page</title>
  </head>
  
    <body>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	

  <div class="w3-teal">
    <button id="openNav" class="w3-button w3-teal w3-xlarge"><i class="material-icons">arrow_back</i></button>
    <div class="w3-container">
      <h1>TRMS</h1>
    </div>
  </div>
  
  <div id = "requestNotification">
   <h2>Reimbursement Request</h2>
    <div class="w3-responsive">
    <c:choose>
    <c:when test="${username.equals('Supervisor')}">
    <form action="SupervisorServlet" method="post">

      <table class="w3-table-all">
<thead>
      <tr>
      <th><input style="visibility: hidden; display: none;"/></th>
        <th>Username</th>
       <th>Event Date</th>
        <th>Event Time</th>
        
        <th>Location</th>
        <th>Description</th>
        
        <th>Cost</th>
        
        <th>Grading Format</th>
        <th>Event Type</th>
        <th>Justification</th>
        <th>Status</th>
      </tr>
	</thead>
	<tbody>
					<c:forEach var="form" items="${formsDS}">
					<tr>
																 <c:choose>
   						 <c:when test="${form.status.equals('PENDING')}">
					<td><input type="number" name="formID" value="<c:out value="${form.formID}"/>" style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
						<td><input type="text" name="username" value="<c:out value="${form.username}"/>"/></td>
						<td><c:out value="${form.eventDate}" /></td>
						
						<td><c:out value="${form.eventTime}" /></td> 
						<td><c:out value="${form.location}" /></td>
						<td><c:out value="${form.description}" /></td>
						
						<td><c:out value="${form.cost}" /></td>
						
						<td><c:out value="${form.gradingFormat}" /></td>
						<td><c:out value="${form.eventType}" /></td>
						<td><c:out value="${form.justification}" /></td>
						<td><select class="w3-select"
									id="status" name="status" >
										<option value="<c:out value="${form.status}" />">PENDING</option>
										<option value="APPROVED">APPROVED</option>

										<option value="DENIED">DENIED</option>

								</select></td>
						  
						
			
				
					</tr>
				</c:forEach>
	</tbody>
      </table>
        <button type="submit" class="w3-btn w3-teal">Submit</button>
      </form>
        </c:when>
    </c:choose>
        <c:choose>
    <c:when test="${username.equals('Head')}">
    <form action="HeadServlet" method="post">

      <table class="w3-table-all">
<thead>
      <tr>
      <th><input style="visibility: hidden; display: none;"/></th>
        <th>Username</th>
       <th>Event Date</th>
        <th>Event Time</th>
        
        <th>Location</th>
        <th>Description</th>
        
        <th>Cost</th>
        
        <th>Grading Format</th>
        <th>Event Type</th>
        <th>Justification</th>
        <th>Status</th>
      </tr>
	</thead>
	<tbody>
					<c:forEach var="form" items="${formsDH}">
					<tr>
					 <c:choose>
   						 <c:when test="${form.status.equals('DS-APPROVED')}">
					<td><input type="number" name="formID" value="<c:out value="${form.formID}"/>" style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
						<td><input type="text" name="username" value="<c:out value="${form.username}"/>"/></td>
						<td><c:out value="${form.eventDate}" /></td>
						
						<td><c:out value="${form.eventTime}" /></td> 
						<td><c:out value="${form.location}" /></td>
						<td><c:out value="${form.description}" /></td>
						
						<td><c:out value="${form.cost}" /></td>
						
						<td><c:out value="${form.gradingFormat}" /></td>
						<td><c:out value="${form.eventType}" /></td>
						<td><c:out value="${form.justification}" /></td>
						<td><select class="w3-select"
									id="status" name="status" >
										<option value="<c:out value="${form.status}" />">PENDING</option>
										<option value="APPROVED">APPROVED</option>

										<option value="DENIED">DENIED</option>

								</select></td>
						  
						
			
				
					</tr>
				</c:forEach>
	</tbody>
      </table>
        <button type="submit" class="w3-btn w3-teal">Submit</button>
      </form>
        </c:when>
    </c:choose>
        <c:choose>
    <c:when test="${username.equals('BenCo')}">
    <form action="BenCoServlet" method="post">

      <table class="w3-table-all">
<thead>
      <tr>

            <th><input style="visibility: hidden; display: none;"/></th>
            

        <th>Username</th>
       <th>Event Date</th>
        <th>Event Time</th>
        
        <th>Location</th>
        <th>Description</th>
        
        <th>Cost</th>
        
        <th>Grading Format</th>
        <th>Event Type</th>
        <th>Justification</th>
        <th>Status</th>
 
      </tr>
	</thead>
	<tbody>
					<c:forEach var="form" items="${formsBC}">
					<tr>
									 <c:choose>
   						 <c:when test="${!form.status.equals('DH-APPROVED') or !form.status.equals('GRADE SUBMITTED')}">
					<td><input style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
																 <c:choose>
   						 <c:when test="${form.status.equals('DH-APPROVED')}">
					<td><input type="number" name="formID" value="<c:out value="${form.formID}"/>" style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>																 <c:choose>
   						 <c:when test="${form.status.equals('GRADE SUBMITTED')}">
					<td><input type="number" name="formID" value="<c:out value="${form.formID}"/>" style="visibility: hidden; display: none;"/></td>
					 </c:when>
 						</c:choose>
						<td><input type="text" name="username" value="<c:out value="${form.username}"/>"/></td>
						<td><c:out value="${form.eventDate}" /></td>
						
						<td><c:out value="${form.eventTime}" /></td> 
						<td><c:out value="${form.location}" /></td>
						<td><c:out value="${form.description}" /></td>
						
						<td><c:out value="${form.cost}" /></td>
						
						<td><c:out value="${form.gradingFormat}" /></td>
						<td><c:out value="${form.eventType}" /></td>
						<td><c:out value="${form.justification}" /></td>


														<c:choose>
   						 <c:when test="${form.status.equals('DH-APPROVED')}">
						<select class="w3-select"
									id="status" name="status" >
										<option value="<c:out value="${form.status}" />">PENDING</option>
										<option value="APPROVED">APPROVED</option>

										<option value="DENIED">DENIED</option>

								</select>
						</c:when>
 						</c:choose>
								<c:choose>
   						 <c:when test="${form.status.equals('GRADE SUBMITTED')}">
   						 <td><select class="w3-select"
									id="status" name="status" >
										<option value="<c:out value="${form.status}" />"></option>
										<option value="REIMBURSED">REIMBURSED</option>

										<option value="REIMBURSEMENT REJECTED">REIMBURSEMENT REJECTED</option>

								</select></td>
   						  </c:when>
 						</c:choose>
								</td>

						
			
				
					</tr>
				</c:forEach>
	</tbody>
      </table>
        <button type="submit" class="w3-btn w3-teal">Submit</button>
      </form>
        </c:when>
    </c:choose>
    </div>

  </div>

   </body>
  
</html>