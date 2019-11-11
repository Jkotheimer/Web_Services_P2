/**
 * When the user wants to switch between actions:
 * - Hide one of the content boxes
 * - Display the other content box
 */
function toggle_actions() {
	var search = document.getElementById("search_content");
	var post = document.getElementById("post_content");
	var toggle_btn = document.getElementById("toggle_actions");
	var header = document.getElementsByTagName("h")[0];
	
	if(search.style.display == "none") {
		search.style.display = "block";
		post.style.display = "none";
		toggle_btn.innerHTML = "Post a new product";
		header.innerHTML = "Search for a product";
		document.title = "Search";
		
	} else {
		search.style.display = "none";
		post.style.display = "block";
		toggle_btn.innerHTML = "Search for a product";
		header.innerHTML = "Post a new product";
		document.title = "Post New Product"
	}
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
