/**
 * 
 */




function validate() {

	var email = document.getElementById("Email").value;
	if (email.match("[a-zA-Z0-9_-]@[a-z]*.com")) {

		
		return true;

	}
	else {


		return false;


	}


}



function partnerValidation() { //For uid validation to be exactly 8 numbers

 var uid = document.getElementById("uid").value
 if(uid.toString().length != 8) {
 	
 	alert("Please enter an exact 8 digit number");
 	return false;
 
 }
 
 else {
 
 
 return true;
 }



}

function SignUpAjax(address) {

	var request = new XMLHttpRequest();
	var data ='';
	/* add your code here to grab all parameters from form*/
	data += "firstName=" + document.getElementById("firstName").value
		+ "&";
	data += "lastName=" + document.getElementById("lastName").value +
		"&";
	data += "email=" + document.getElementById("email").value +
		"&";
	data += "password=" + document.getElementById("password").value;

	console.log(data);

	request.open("GET", (address + "?" + data), true);
	request.onreadystatechange = function() {
		handler(request);
	};
	request.send();



}


function handler(request){
 if ((request.readyState == 4) && (request.status == 200)){
 var target = document.getElementById("result");
 target.innerHTML = request.responseText;
 console.log(request.response);
 

 }
} 