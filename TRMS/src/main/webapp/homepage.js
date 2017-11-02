window.onload = function(){
	
	document.getElementById("openNav").addEventListener("click",w3_open, false);
	document.getElementById("submitForm").addEventListener("click",sendForm,false);
	
}

function sendForm(){
	var mydata={"name":"abc","age":"21"};
	
	var xhr = new XMLHttpRequest();
	 
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			
		}
	}
	xhr.open("GET", "localhost:8080/SubmitForm", true);
	
	xhr.send(JSON.stringify(mydata));
}
	


function w3_open() {
  document.getElementById("main").style.marginLeft = "25%";
  document.getElementById("mySidebar").style.width = "25%";
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}
function w3_close() {
  document.getElementById("main").style.marginLeft = "0%";
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("openNav").style.display = "inline-block";
}


 $(document).ready(function(){
        $("#enterProfile").click(function(){
            
            //$("#content").replaceWith(document.getElementById("profile").innerHTML);
          	$("#content").hide();
          	$("#profile").show();
          	$("#form").hide();
          	w3_close();
          	
          	
        });
 });


 $(document).ready(function(){
        $("#enterForm").click(function(){
            $("#content").hide();
          	$("#profile").hide();
          	$("#form").show();
          	w3_close();
        });
    });
 $(document).ready(function(){
        $("#home").click(function(){
            $("#content").show();
          	$("#profile").hide();
          	$("#form").hide();
          	w3_close();
        });
    });
 