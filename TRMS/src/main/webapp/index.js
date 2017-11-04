window.onload = function(){
	
//		document.getElementById("register").addEventListener("click",signUp, false);
}

function signUp(){

}



$(document).ready(function(){
    $("#register").submit(function(){
    	
    	console.log("register clicked");
    	
    	console.log(firstName + " " + lastName);
    	
    	var xhr = new XMLHttpRequest();
    	
    	var stuff2 = document.getElementById("stuff2");
    	
    	var person = {};
    
    person.firstName = $('#firstName').val();
    	person.lastName = $('#lastName').val();
    	person.email = $('#email').val();
    	person.username = $('#username').val();
    	person.password = $('#password').val();
    	xhr.onreadystatechange = function(){
    		
    		switch(xhr.readyState) {
    		
    		case 0:
    				
    			stuff2.innerHTML = "Request not initialized";
    			break;
    		
    		case 1: 
    			stuff2.innerHTML = "initialized connection";
    			break;
    			
    		case 2: 
    			stuff2.innerHTML = "Request Recieved";
    			break;
    			
    		case 3:
    			stuff2.innerHTML = "Processing";
    			break;
    			
    		case 4:
    			if(xhr.status == 200){
    				
    				alert("You are signed up");
    				$("#signUpPage").hide();
    				$("#signInPage").hide();
    				
    				
    			}
    			
    			else{
    				
    				stuff2.innerHTML = "EROOR with request, status code: " + xhr.status;
    				
    			}
    			break;
    		
    		}
    		
    	}
    	
    	xhr.open("POST", "RegistrationServlet", true);
    	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    	var data = "person="+JSON.stringify(person);
    	xhr.send(data);
    	
      
    });
});

$(document).ready(function(){
    $("#logingIn").submit(function(){
    	
    	console.log("log In clicked");
    	
   
    	
    	var xhr = new XMLHttpRequest();
    	
    	var loginPerson = {};
    
    loginPerson.userName = $('#username').val();
    	loginPerson.password = $('#password').val();
  
    	xhr.onreadystatechange = function(){
    		
    		switch(xhr.readyState) {
    		
    		case 0:
    				
    			stuff2.innerHTML = "Request not initialized";
    			break;
    		
    		case 1: 
    			stuff2.innerHTML = "initialized connection";
    			break;
    			
    		case 2: 
    			stuff2.innerHTML = "Request Recieved";
    			break;
    			
    		case 3:
    			stuff2.innerHTML = "Processing";
    			break;
    			
    		case 4:
    			if(xhr.status == 200){
    				
    				alert("You are signed up");
    				$("#signUpPage").hide();
    				$("#signInPage").hide();
    				
    				
    			}
    			
    			else{
    				
    				alert("Ooops! Something went wrong");
    				
    			}
    			break;
    		
    		}
    		
    	}
    	
    	xhr.open("POST", "LoginServlet", true);
    	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    	var data = "person="+JSON.stringify(loginPerson);
    	xhr.send(data);
    	
      
    });
});




