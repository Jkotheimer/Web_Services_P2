package cs333.project_2.Service;

import javax.ws.rs.core.Response;

public class CORSFilter {
	
	public CORSFilter() {}
	
	public Response addCORS(Response.ResponseBuilder r) {
		return r.header("Access-Control-Allow-Origin", "*").build();
	}
}