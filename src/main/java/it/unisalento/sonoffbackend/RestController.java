package it.unisalento.sonoffbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	OkHttpClient client = new OkHttpClient();

	@RequestMapping(value = "changeStatusOFF", method = RequestMethod.GET)
	public ResponseEntity<Boolean> changeStatusOFF() throws Exception {
		Request request = new Request.Builder().url("http://192.168.1.67:3000/changeStatusOFF").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new Exception();

	}

	@RequestMapping(value = "changeStatusON", method = RequestMethod.GET)
	public ResponseEntity<Boolean> changeStatusON() throws Exception {
		Request request = new Request.Builder().url("http://192.168.1.67:3000/changeStatusON").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new Exception();

	}

	
	  @RequestMapping(value="getStatus", method = RequestMethod.GET) public String getStatus() throws Exception{
		   Request request = new Request.Builder().url("http://192.168.1.67:3000/getStatus").build();
		   Response response = client.newCall(request).execute();
		   return response.toString();
	  }
	
}
