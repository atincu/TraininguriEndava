package com.endava.Web;

import java.io.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

	public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException {
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpRequest = new HttpGet("http://petstore.swagger.wordnik.com/api/api-docs");
		HttpResponse httpResponse = httpClient.execute(httpRequest);

		ObjectMapper objectMapper = new ObjectMapper();
		Pet pet = objectMapper.readValue(httpResponse.getEntity().getContent(),Pet.class);

		PrintWriter out = new PrintWriter("Pet.html");
		out.println("<html>");
		out.println("<header>");
		out.println("Information about pets!");
		out.println("</header>");
		out.println("<body>");
		out.println("Api Version is "+ pet.getApiVersion());
		out.println("Swagger Version is " + pet.getSwaggerVersion());
		out.println("<header>");
		out.println("Apis are: ");
		out.println("</header>");
		out.println("Path [");
		for (int i = 0; i < pet.getApis().length; i++ )
			out.print(pet.getApis()[i].getPath() + " ");
		out.println("]");
		out.println("and description [");
		for (int i = 0; i < pet.getApis().length; i++ )
			out.println(pet.getApis()[i].getDescription());	
		out.println("]");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}	
}
