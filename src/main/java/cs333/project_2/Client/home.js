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
	old_login_btn.onclick = create_account();
	document.getElementsByClassName("confirm_password")[0].style.display = "block";
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
	login_btn.onclick = sign_in();
	document.getElementsByClassName("confirm_password")[0].style.display = "none";
	
}

/**
 * When the user wants to sign in:
 * 
 */
function sign_in() {
	
}

/**
 * When the user wants to create an account:
 * 
 */
function create_account() {
	
}
