package cs333.project_2.Service;

import javax.ws.rs.core.Response;

public class CORSFilter {
	
	public CORSFilter() {}
	
	public Response addCORS(Response.ResponseBuilder r) {
		return r.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600")
				.build();
	}
}