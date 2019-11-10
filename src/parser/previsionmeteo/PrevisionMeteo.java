package parser.previsionmeteo;

import java.io.IOException;

import org.json.JSONObject;

import httpconnection.HttpConnection;
import parser.Parser;

public class PrevisionMeteo extends Parser{
	
	
	public PrevisionMeteo(String ville, int nbJours) throws IOException {
		super();
		this.ville = ville;
		this.nbJours = nbJours+1;
		
		this.nom = "PrevisonMeteo";
		
		this.buffer = (HttpConnection.returnStringBuffer("https://www.prevision-meteo.ch/services/json/"+this.ville)).toString();
				
		this.temperatures = setTemperatures(this.buffer);
	}


	private float[] setTemperatures(String buffer) {
		
		float[] temperatures = new float[nbJours];
		
        JSONObject jsonData = new JSONObject(buffer);
        
        for (int i = 0; i < this.nbJours; i++) {
        	
        	JSONObject day = jsonData.getJSONObject("fcst_day_"+i);

        	int temperatureMax = day.getInt("tmax");
        	int temperatureMin = day.getInt("tmin");
        	int temperatureMoy = (temperatureMax + temperatureMin) / 2 ;
        	
        	temperatures[i] = temperatureMoy;        	
			
		}
        return temperatures;
	}
	
	
	
	

}
