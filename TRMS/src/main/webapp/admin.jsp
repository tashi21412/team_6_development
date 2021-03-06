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
   <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">

    <a href="#" id="home"class="w3-bar-item w3-button"><i class="material-icons">home</i>Home</a>
    <a href= "#" id="enterProfile"class="w3-bar-item w3-button"><i class="material-icons">person</i>Profile </a>
    <a href="#" id="enterForm" class="w3-bar-item w3-button"><i class="material-icons">content_paste</i>Reimbursement Form</a>
    <c:choose>
    <c:when test="${username.equals('Supervisor')}">
 	<a href="SupervisorServlet"  class="w3-bar-item w3-button"><i class="material-icons">error_outline</i>Reimbursement Requests</a>
 	</c:when>
 	</c:choose>
 	<c:choose>
    <c:when test="${username.equals('Head')}">
 	<a href="HeadServlet"  class="w3-bar-item w3-button"><i class="material-icons">error_outline</i>Reimbursement Requests</a>
 	</c:when>
 	</c:choose>
 	<c:choose>
    <c:when test="${username.equals('BenCo')}">
 	<a href="BenCoServlet"  class="w3-bar-item w3-button"><i class="material-icons">error_outline</i>Reimbursement Requests</a>
 	</c:when>
 	</c:choose>
    <a href="index.html" id="Log Out"class="w3-bar-item w3-button"><i class="material-icons">exit_to_app</i>Log Out</a>
    </div>

   

  <div id="main">

  <div class="w3-teal">
    <button id="openNav" class="w3-button w3-teal w3-xlarge">&#9776; </button>
    <div class="w3-container">
      <h1>TRMS</h1>
    </div>
  </div>

 
  <div id = "content">
      <img src="tiger.jpg" alt="Car" style="width:100%">

      <div class="w3-container">
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus aliquet eros urna, non mattis sem volutpat in. Fusce mauris felis, vehicula vitae sodales sit amet, elementum eu augue. Donec vitae mauris et leo finibus porta. Phasellus ac mi accumsan, consequat est sed, imperdiet purus. Nullam nec venenatis augue, viverra commodo turpis. Vestibulum lacinia scelerisque metus, et scelerisque felis pharetra ac. Integer pharetra quis neque at fermentum. In volutpat elit et pretium ullamcorper. Suspendisse vel quam placerat, interdum risus in, blandit dui. Ut nec arcu id sem lacinia ornare in luctus tortor. Nulla at felis consequat, semper tellus vitae, porta dolor. Nullam tortor nisl, vestibulum eu quam ut, dictum sollicitudin augue. Integer viverra tincidunt mauris nec efficitur.
      <br>
      <br>
      Donec egestas aliquet congue. Sed vel mauris ex. Pellentesque facilisis sem non dignissim consequat. Sed mollis eros sit amet leo finibus semper. Phasellus auctor dolor eros, at elementum lectus ornare et. Proin malesuada porttitor rhoncus. Etiam pharetra nisl nunc, elementum hendrerit massa finibus eu. Proin at scelerisque erat. Nulla efficitur id tellus vel lacinia. In efficitur enim sed turpis tempus bibendum id eget nisi. Quisque porttitor efficitur est, ac dignissim lectus luctus eget.
      <br>
      <br>
      Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis vel dui ac arcu gravida accumsan. Ut nunc tellus, finibus a auctor non, feugiat aliquet diam. Ut id turpis quis metus ultricies fringilla pretium vel orci. Ut non arcu interdum, egestas est non, rhoncus sem. Vivamus in magna quis erat molestie lacinia. Morbi ultricies ultricies ultricies. Praesent vel facilisis orci. Curabitur et justo facilisis, tristique lorem non, sollicitudin dui. Ut gravida risus non tellus tincidunt, eu venenatis odio consectetur. Nullam lobortis quam lorem, pellentesque euismod turpis facilisis nec.
      <br>
      <br>
      Aliquam blandit commodo enim in aliquet. Praesent sed dui odio. Integer a finibus ante. Morbi vitae velit non purus semper commodo ut sit amet enim. Nunc faucibus felis massa, vel hendrerit nisl dapibus at. In enim sem, condimentum non eros vel, placerat viverra nulla. Integer viverra egestas rutrum. Pellentesque ut egestas nunc. Donec lobortis, mi quis commodo aliquam, sapien nisi scelerisque nibh, eu consequat nisi arcu a dolor. Nunc ac efficitur libero. Suspendisse a ultricies odio. Nulla consectetur, metus eu vestibulum molestie, neque dui fermentum nibh, vitae eleifend ligula libero id leo. Phasellus vel sapien at neque auctor ornare dignissim placerat justo.</p>
      </div>
  </div>

  <div id = "profile" hidden = "true">
    <div class="w3-card-4">
      <img src="profile_sub.png" alt="Profile">
      <div id="userinfo" class="w3-container w3-center">
        <p>Name: User's Name</p>
      </div>

    </div>

    <h2>Reimbursement History</h2>
    <div class="w3-responsive">
      <table class="w3-table-all">
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
      </tr>
      <tr>
        <td>Jill</td>
        <td>Smith</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
      </tr>
      <tr>
        <td>Eve</td>
        <td>Jackson</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
      </tr>
      <tr>
        <td>Adam</td>
        <td>Johnson</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
      </tr>
      </table>
    </div>

  </div>
<!--  <div id = "requestNotification" hidden = "true">
   <h2>Reimbursement Request</h2>
    <div class="w3-responsive">
      <table class="w3-table-all">
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
        <th>Points</th>
      </tr>
      <tr>
        <td>Jill</td>
        <td>Smith</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
        <td>50</td>
      </tr>
      <tr>
        <td>Eve</td>
        <td>Jackson</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
        <td>94</td>
      </tr>
      <tr>
        <td>Adam</td>
        <td>Johnson</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
        <td>67</td>
      </tr>
      </table>
    </div>

  </div>
-->
  <div id= "form" hidden="true">
    <div class="w3-container">
      <h2>Reimbursement Form</h2>
    </div>

    <form class="w3-container">
      <label class="w3-text-teal" ><b>Cost</b></label>
      <input class="w3-input w3-border w3-light-grey" type="text" placeholder = "$">

      <label class="w3-text-teal"><b>Event Description</b></label>
      <input class="w3-input w3-border w3-light-grey" type="text" placeholder = "Description">

      <label class="w3-text-teal" style ="height:200px"><b>Justification</b></label>
      <input class="w3-input w3-border w3-light-grey" type="text" placeholder = "Reason To Participate">


      <label class="w3-text-teal" ><b>Justification</b></label>
      <select class="w3-select" name="option">
        <option value="" disabled selected>Choose your option</option>
        <option value="1">University Course</option>
        <option value="2">Seminar</option>
        <option value="3">Certification Preparation Classes</option>
        <option value="4">Certification</option>
        <option value="5">Technical Training</option>
        <option value="6">Other</option>
      </select>

       <label class="w3-text-teal" ><b>Attachment</b></label>
       <input class="w3-input w3-border w3-light-grey" type="file" name ="file" placeholder = "Reason To Participate">
       
      <button class="w3-btn w3-blue-grey attchButton">Submit</button>

     

    </form>
  </div>


  </div>


	<script src="admin.js"></script>
 </body>
  
</html>