window.onload = function(){
	
	document.getElementById("register").addEventListener("click",signUp, false);


}
function checker(){
	console.log("checked");
}

function signUp(){

	 if (document.getElementById("password").innerHTML.value != document.getElementById("confirmpassword").innerHTML.value){
	 	
		$("#error").show();
	}
 	else {
 		console.log("correct password");
 		
 		var text = {"firstName":"John", "lastName":"Doe","username" : "johndoe" , "password":"mypassword"};
 		
 		//Step 1. Open XHR
 		var xhr = new XMLHttpRequest();
 		
 		//Step 2. function to handle ready state change of response
 		xhr.onreadystatechange = function() {
 			
 			if(xhr.readyState == 4 && xhr.status == 200){
 				
 				console.log(xhr.responseText);}
 			
 		}
 		
 		//Step 3. Open connection
 		xhr.open("GET", "http://localhost:8080/MYTRMS/RegistrationServlet", true);
 		
 		//Step 4. Send request
 		xhr.send();
 		
		
 	}

}

