/**
 * When the user wants to create an account:
 * - Add a confirm password button
 * - Turn the sign in button into a create account button
 * - Turn the create account button into a "back" button
 */
function switch_to_create_account() {
	var old_ca_btn = document.getElementsByClassName("create_account")[0];
	old_ca_btn.innerHTML = "Back";
	old_ca_btn.onclick = switch_to_login;
	
	var old_login_btn = document.getElementsByClassName("sign_in")[0];
	old_login_btn.innerHTML = "Create Account";
	old_login_btn.onclick = create_account;
	
	document.title = "Client Create Account";
	
	handle_keypress = event => handle_keypress_facade(event, create_account);
	
	document.getElementsByClassName("confirm_password")[0].style.display = "block";
	clear_inputs();
}

/**
 * When the user presses the back button from create account:
 * - Remove confirm password button
 * - Revert create account button into sign in button
 * - Revert back button into create account button
 */
function switch_to_login() {
	var ca_btn = document.getElementsByClassName("create_account")[0];
	ca_btn.innerHTML = "Create Account";
	ca_btn.onclick = switch_to_create_account;
	
	var login_btn = document.getElementsByClassName("sign_in")[0];
	login_btn.innerHTML = "Sign In";
	login_btn.onclick = sign_in;
	
	document.title = "Client Login";
	
	handle_keypress = event => handle_keypress_facade(event, sign_in);
	
	document.getElementsByClassName("confirm_password")[0].style.display = "none";
	clear_inputs();
}

/**
 * When the user invokes a switch method, clear all the input fields
 */
function clear_inputs() {
	var inputs = Array.prototype.slice.call(document.getElementsByTagName("input"), 0);
	inputs.forEach(field => { field.value = ""; });
	var errors = Array.prototype.slice.call(document.getElementsByClassName("form_error"), 0);
	errors.forEach(field => { 
		field.style.display = "none";
		field.innerHTML = "";
	});
}

function handle_keypress_facade(event, func) {
	if(event != null && event.keyCode == 13) {
		event.preventDefault();
		func();
	}
}

/**
 * When the user wants to sign in:
 * - Grab the input fields for username and password
 * - Send a get request to the appropriate link with the given fields
 */
function sign_in() {
	var username = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	console.log("sign_in\nusername: " + username + '\n' + "password: " + password);
	document.location.href = "./search";
	// TODO: make get request to localhost uri
}

/**
 * When the user wants to create an account:
 * - Grab the input fields for username and both passwords
 * - Check for a valid username and password and matching passwords
 * - Send a post request to the appropriate link with the given fields
 */
function create_account() {
	var username = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	var confirm_password = document.getElementsByName("confirm_password")[0].value;
	
	if(acct_creation_error(username, password, confirm_password)) return;
	
	console.log("create_account\nusername: " + username + '\n' + "password: " + password);
	// TODO: make post request to localhost uri
}

/**
 * Check for account creation errors:
 * - The username must be alphanumeric, starting with a letter
 * - The password must be at least 8 characters long
 * - The passwords must match
 */
function acct_creation_error(username, password, confirm_password) {
	var error = null;
	var err_element = null;
	
	// Test for valid username and passwords
	if(!/^[a-zA-Z][a-zA-Z0-9]+$/.test(username)) {
		error = "Invalid username - must be alphanumeric, starting with a letter";
		err_element = document.getElementById("username_error");
	}
	else if(password.length < 8) {
		error = "Password too short - must be at least 8 characters";
		err_element = document.getElementById("password_error");
	}
	else if(password != confirm_password) {
		error = "Passwords do not match";
		err_element = document.getElementById("confirm_password_error");
	}
	if(error == null) return false;
	else {
		display_error(error, err_element);
		return true;
	}
}

function display_error(error, err_element) {
	err_element.innerHTML = error;
	err_element.style.display = "block";
	var form = document.getElementsByClassName("form")[0];
	form.addEventListener("keydown", function remove_error() {
		err_element.innerHTML = "";
		err_element.style.display = "none";
		form.removeEventListener("keydown", remove_error);
	})
}
