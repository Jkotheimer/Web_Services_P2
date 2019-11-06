/**
 * When the user wants to create an account:
 * - Add a confirm password button
 * - Turn the sign in button into a create account button
 * - Turn the create account button into a "back" button
 */
function switch_to_create_account() {
	var old_ca_btn = document.getElementsByClassName("create_account")[0];
	old_ca_btn.innerHTML = "Back";
	old_ca_btn.removeEventListener("click", switch_to_create_account);
	old_ca_btn.addEventListener("click", switch_to_login);
	
	var old_login_btn = document.getElementsByClassName("sign_in")[0];
	old_login_btn.innerHTML = "Create Account";
	old_login_btn.removeEventListener("click", sign_in);
	old_login_btn.addEventListener("click", create_account);
	
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
	ca_btn.removeEventListener("click",switch_to_login);
	ca_btn.addEventListener("click", switch_to_create_account);
	
	var login_btn = document.getElementsByClassName("sign_in")[0];
	login_btn.innerHTML = "Sign In";
	login_btn.removeEventListener("click", create_account);
	login_btn.addEventListener("click", sign_in);
	
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
}

/**
 * When the user wants to create an account:
 * - Grab the input fields for username and both passwords
 * - Check for a valid username and password and matching passwords
 * - Send a post request to the appropriate link with the given fields
 */
function create_account() {
	var error = null;
	
	var username = document.getElementsByName("username")[0].value;
	var password = document.getElementsByName("password")[0].value;
	var confirm_password = document.getElementsByName("confirm_password")[0].value;
	
	// Test for valid username and passwords
	if(!/^[a-zA-Z][a-zA-Z0-9]+$/.test(username)) error = "Invalid username - must be alphanumeric, starting with a letter";
	else if(password.length < 8) error = "Password too short - must be at least 8 characters";
	else if(password != confirm_password) error = "Non-matching passwords";
	
	if(error == null) {
		console.log("create_account\nusername: " + username + '\n' + "password: " + password);
	}
	else console.error(error);
}
