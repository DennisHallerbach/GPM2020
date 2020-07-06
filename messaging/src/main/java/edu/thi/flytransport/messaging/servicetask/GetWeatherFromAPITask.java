package edu.thi.flytransport.messaging.servicetask;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GetWeatherFromAPITask implements JavaDelegate {
	
	private final static String OPEN_WEATHER_MAP_API="https://api.openweathermap.org/data/2.5/weather?q=Ingolstadt&appid=25ac9af50028c5fb972c5bff4fed785f";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// Source: https://openjdk.java.net/groups/net/httpclient/recipes.html
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(OPEN_WEATHER_MAP_API))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());
	    
	    int weatherId = 800; // default value
	    if (response.statusCode() == 200) {
	
		    // Get weather id; see https://openweathermap.org/weather-conditions for more information about weather id
		    String json = response.body();
		    int beginIndex = json.indexOf("id");
		    int endIndex = json.indexOf(",", beginIndex);
		    String weather = json.substring(beginIndex + 4, endIndex);
		    // convert to integer
		    weatherId = Integer.valueOf(weather);
	    }
	    execution.setVariable("weather", weatherId);
	    
	}

}
