window.onload = function(){
	
	document.getElementById("openNav").addEventListener("click",w3_open, false);
	document.getElementById("closeNav").addEventListener("click",w3_close, false);
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
            
            $("#content").replaceWith(document.getElementById("profile").innerHTML);
          	w3_close();
        });
 });


 $(document).ready(function(){
        $("#enterForm").click(function(){
            
            $("#content").replaceWith(document.getElementById("form").innerHTML);
          	w3_close();
        });
    });

 