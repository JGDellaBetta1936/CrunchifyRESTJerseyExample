package com.crunchify.restjersey;


/**
 * @author john.gold
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

@Path("/ctofservice")
public class CtoFService {
	static Logger log = Logger.getLogger(CtoFService.class.getName());
	
	
	@GET
	@Produces("application/json")
	public Response convertCtoF() {
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;

		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", Double.valueOf(celsius) );
 
		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertCtoFfromInput(@PathParam("c") Double c) {
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius * 9) / 5) + 32;

		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", Double.valueOf(celsius) );
 
		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}
}