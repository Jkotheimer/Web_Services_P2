var user;
function load() {
	user = JSON.parse(localStorage.getItem("user"));
	if(user == undefined) window.location.href = "/";
	console.log(user);
	setUserItems();
}

function setUserItems() {
	document.getElementById("username").innerHTML = user.username;
	document.getElementById("account_type").innerHTML = user.accountType;
	document.getElementById("current_username").innerHTML = user.username;
	back();
	if(user.address.length == 0) document.getElementById("addresses").innerHTML = "You have no addresses on file";
	else {
		var container = document.getElementById("addresses");
		container.innerHTML = "";
		for(let i = 0; i < user.address.length; i++) {
			var address = user.address[i];
			var html = "<div class='setting'>" +
							address.street + "<br/>" +
							address.city + ", " + address.state + " " + address.zipcode + 
						"</div>";
			container.innerHTML += html;
		}
	}
	
	if(user.payInfos.length == 0) document.getElementById("payment_methods").innerHTML = "You have no payment methods on file";
	else {
		var container = document.getElementById("payment_methods");
		container.innerHTML = "";
		for(let i = 0; i < user.address.length; i++) {
			var payinfo = user.payInfos[i];
			var html = "<div class='setting'>" +
							payinfo.creditCardHolder + "<br/>" + 
							payinfo.creditCardNum + "<br/>" +
							payinfo.expDate + 
						"</div>";
			container.innerHTML += html;
		}
	} 
	
	if(user.orders.length == 0) document.getElementById("orders").innerHTML = "You haven't ordered any products yet";
	else {} // TODO fill html with orders
}

/**
 * Send a search request for the given product name to the server
 */
function search() {
	var search_key = document.getElementsByName("search")[0].value;
	var result_area = document.getElementById("search_results");
	result_area.innerHTML = search_key;
	// TODO: make get request to local host uri
}

/**
 * Send a post request to post the given product and it's details to the server
 */
function post() {
	var p_name = document.getElementsByName("product")[0].value;
	var p_price = document.getElementsByName("price")[0].value;
	var p_description = document.getElementsByName("description")[0].value;
	var result_area = document.getElementById("post_result");
	result_area.innerHTML = p_name + "<br>" + p_price + "<br>" + p_description;
	// TODO: make post request to local host uri
}

function show_user_content() {
	document.getElementById("search_content").style.display = "none";
	document.getElementById("post_content").style.display = "none";
	document.getElementById("user_content").style.display = "block";
}

function back() {
	document.getElementById("user_content").style.display = "none";
	if(user.accountType == "buyer") document.getElementById("search_content").style.display = "block";
	else document.getElementById("post_content").style.display = "block";
}

function change_username() {
	var new_username = document.getElementById("new_username").value;
	if(new_username == "") alert("New username field is empty");
	
	const uri = "http://localhost:8081/" + user.accountType + "s/" + user.id + "?action=username";
	var xhr = createRequest("POST", uri);
	xhr.send(new_username);
	xhr.onload = function() {
		if(xhr.status == 409) alert("Username already exists");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			localStorage.setItem("user", xhr.response);
			user = JSON.parse(localStorage.getItem("user"));
			setUserItems();
			show_user_content();
			document.getElementById("new_username").value = "";
		}
	}
}

function change_password() {
	var current_password = document.getElementById("current_password").value;
	var new_password = document.getElementById("new_password").value;
	var confirm_new_passord = document.getElementById("confirm_new_password").value;
	
	// Check validity of given passwords
	if(new_password != confirm_new_passord) {
		alert("Passwords do not match");
		return;
	} else if(new_password.length < 8) {
		alert("New password is too short");
		return;
	}
	var data = JSON.stringify({
		current_password : current_password,
		new_password : new_password
	});
	var uri = "http://localhost:8081/" + user.accountType + "s/" + user.id + "?action=password";
	
	var xhr = createRequest("POST", uri);
	xhr.setRequestHeader("Content-Type", "text/plain")
	xhr.onload = function() {
		if(xhr.status == 401) alert("Current password incorrect");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			document.getElementById("current_password").value = "";
			document.getElementById("new_password").value = "";
			document.getElementById("confirm_new_password").value = "";
			alert("Password successfully changed!");
		}
	}
	xhr.send(data);
	
}

function toggle_add_address() {
	var form= document.getElementById("address_form");
	if(form.style.display == "block") form.style.display = "none";
	else form.style.display = "block";
}

function add_address() {
	var street = document.getElementsByName("street_address")[0].value;
	var city = document.getElementsByName("city")[0].value;
	var state = document.getElementsByName("state")[0].value;
	var zip = document.getElementsByName("zip")[0].value;
	if(street == "" || city == "" || state == "" || zip == undefined) {
		alert("One or more fields missing");
		return;
	}
	var data = JSON.stringify({
		street: street,
		city: city,
		state: state,
		zipcode: zip
	});
	var uri = "http://localhost:8081/" + user.accountType + "s/" + user.id + "?action=address";
	
	var xhr = createRequest("POST", uri);
	xhr.setRequestHeader("Content-Type", "text/plain")
	xhr.onload = function() {
		if(xhr.status == 400) alert("Format Error");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			localStorage.setItem("user", xhr.response);
			user = JSON.parse(localStorage.getItem("user"));
			document.getElementsByName("street_address")[0].value = "";
			document.getElementsByName("city")[0].value = "";
			document.getElementsByName("state")[0].value = "";
			document.getElementsByName("zip")[0].value = "";
			toggle_add_address();
			setUserItems();
			show_user_content();
			alert("Address successfully added!") ;
		}
	}
	xhr.send(data);
}

function toggle_add_payment() {
	var form= document.getElementById("payment_form");
	if(form.style.display == "block") form.style.display = "none";
	else form.style.display = "block";
}

function add_payment() {
	var card_number = document.getElementsByName("card_number")[0].value;
	var card_holder = document.getElementsByName("card_holder")[0].value;
	var exp_date = document.getElementsByName("exp_date")[0].value;
	var ccv = document.getElementsByName("ccv")[0].value;
	if(card_holder == "" || card_number == ""|| exp_date == "" || ccv == undefined) {
		alert("One or more fields missing");
		return;
	}
	var data = JSON.stringify({
		creditCardHolder: card_holder,
		creditCardNum: card_number,
		expDate: exp_date,
		ccv: ccv
	});
	var uri = "http://localhost:8081/" + user.accountType + "s/" + user.id + "?action=payment";
	
	var xhr = createRequest("POST", uri);
	xhr.setRequestHeader("Content-Type", "text/plain")
	xhr.onload = function() {
		if(xhr.status == 400) alert("Format Error");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			localStorage.setItem("user", xhr.response);
			user = JSON.parse(localStorage.getItem("user"));
			document.getElementsByName("card_holder")[0].value = "";
			document.getElementsByName("card_number")[0].value = "";
			document.getElementsByName("exp_date")[0].value = "";
			document.getElementsByName("ccv")[0].value = "";
			toggle_add_payment();
			setUserItems();
			show_user_content();
			alert("Payment method successfully added!") ;
		}
	}
	xhr.send(data);
}

function log_out() {
	localStorage.removeItem("user");
	window.location.href = "/";
}

function delete_user() {
	var uri = "http://localhost:8081/" + user.accountType + "s/" + user.id;
	var xhr = createRequest("DELETE", uri);
	xhr.onload = function() {
		if(xhr.status == 400) alert("Format Error");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			localStorage.removeItem("user");
			window.location.href = "/";
		}
	}
	xhr.send();
}
