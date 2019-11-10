package parser;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import httpconnection.HttpConnection;

public class MetaWeather extends Parser {
	

	private int woeid;

	
	public MetaWeather(String ville, int nbJours) throws IOException  {
		super();
		this.ville = ville;
		this.nbJours = nbJours+1;
		
		this.nom = "MetaWeather";
		
		String woeidBuffer = (HttpConnection.returnStringBuffer("https://www.metaweather.com/api/location/search/?query="+this.ville)).toString();
		
		this.woeid = setWoeid(woeidBuffer);
		
		this.buffer = (HttpConnection.returnStringBuffer("https://www.metaweather.com/api/location/"+this.woeid)).toString();
				
		this.temperatures = setTemperatures(buffer);
	}


		
	
	private int setWoeid(String buffer) {
		
	    JSONArray jsonArr = new JSONArray(buffer);

        JSONObject jsonObj = jsonArr.getJSONObject(0);
        
        int woeid = jsonObj.getInt("woeid");
		
		return woeid;
		
	}
	
	private float[] setTemperatures(String buffer) {
		
		float[] temperatures = new float[nbJours];
		
		JSONObject jsonObj = new JSONObject(buffer);
		
		JSONArray consolidated_weather = jsonObj.getJSONArray("consolidated_weather");
        
        for (int i = 0; i < this.nbJours; i++) {
        	
        	JSONObject day = consolidated_weather.getJSONObject(i);
        	
        	float the_temp = day.getFloat("the_temp");
        		
        	temperatures[i] = the_temp;        	
			
		}

        return temperatures;
	}
	

	
	
	
	

}
