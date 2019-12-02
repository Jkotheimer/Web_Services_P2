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
	if(user.addresslist.length == 0) document.getElementById("addresses").innerHTML = "You have no addresses on file";
	else {} // TODO fill html with addresses
	
	if(user.payinfo.length == 0) document.getElementById("payment_methods").innerHTML = "You have no payment methods on file";
	else {} // TODO fill html with payment infos
	
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
	
	const uri = "http://localhost:8081/" + user.accountType + "s/" + user.buyerID + "?new_username=" + new_username;
	var xhr = createRequest("POST", uri);
	xhr.send();
	xhr.onload = function() {
		if(xhr.status == 409) alert("Username already exists");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else {
			localStorage.setItem("user", xhr.response);
			user = JSON.parse(localStorage.getItem("user"));
			setUserItems();
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
	
	var uri = "http://localhost:8081/" + user.accountType + "s/" + user.buyerID + "?current_password=" + current_password + "&new_password=" + new_password;
	var xhr = createRequest("POST", uri);
	xhr.send();
	xhr.onload = function() {
		if(xhr.status == 401) alert("Current password incorrect");
		else if(xhr.status != 200) alert("Something went wrong :/");
		else alert("Password successfully changed!");
	}
}

function log_out() {
	localStorage.removeItem("user");
	window.location.href = "/";
}
