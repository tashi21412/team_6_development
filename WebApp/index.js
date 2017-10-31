window.onload = function(){
	
	document.getElementById("register").addEventListener("click",signUp, false);


}

function signUp(){

	 if (document.getElementById("password").innerHTML.value != document.getElementById("confirmpassword").innerHTML.value){
	 	
		$("#error").show();
	}
 	else {
 		console.log("password Matched")	
 		
		
 	}

}

