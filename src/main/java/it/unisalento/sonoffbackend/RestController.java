package it.unisalento.sonoffbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	OkHttpClient client = new OkHttpClient();
	
	String host = "http://localhost:8081/";

	@RequestMapping(value = "changeStatusOFF", method = RequestMethod.GET)
	public ResponseEntity<Boolean> changeStatusOFF() throws Exception {
		Request request = new Request.Builder().url(host+"changeStatusOFF")
				.get()
				.build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new Exception();

	}

	@RequestMapping(value = "changeStatusON", method = RequestMethod.GET)
	public ResponseEntity<Boolean> changeStatusON() throws Exception {
		Request request = new Request.Builder().url(host+"changeStatusON")
				.get()
				.build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new Exception();

	}

	  @RequestMapping(value="getStatus", method = RequestMethod.GET) 
	  public String getStatus() throws Exception{
		   Request request = new Request.Builder().url(host+"getStatus")
					.get()
				   .build();
		   Response response = client.newCall(request).execute();
		   return response.body().string();
	  }
	  
	  @RequestMapping(value="saveToken", method = RequestMethod.POST) 
	  public ResponseEntity<String> saveToken(@RequestBody String token) throws Exception{
		  String tokenValue = token.split("=")[1];

		  
	        com.squareup.okhttp.RequestBody formBody = new FormEncodingBuilder()
	                .add("token", tokenValue)
	                .build();
		   
	        Request request = new Request.Builder().url(host+"saveToken")
	        		.post(formBody)
				   .build();
		   Response response = client.newCall(request).execute();
		return new ResponseEntity<String>(HttpStatus.OK);
	  }
	
}
