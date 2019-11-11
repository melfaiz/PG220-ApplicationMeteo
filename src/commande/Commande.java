package commande;

import java.io.IOException;

import parser.Parser;
import parser.metaweather.MetaWeather;
import parser.previsionmeteo.PrevisionMeteo;

public class Commande {
	
	String ville;
	int nbJours;
	Parser[] previsions;
	
	public Commande(String[] args) throws IOException {
		
		
		super();
		
		for (int i = 0; i < args.length; i++) {
			
			String string = args[i];
			if ( string.equals("-l")) {
				
				this.ville = args[i+1];	
				
			}else if(string.equals("-j")){
				
				this.nbJours = Integer.parseInt(args[i+1]);
				
			}
		}
		
		
		Parser prevision0 = new MetaWeather(this.ville, this.nbJours);
		Parser prevision1 = new PrevisionMeteo(this.ville, this.nbJours);
		
		Parser[] previsions = {prevision0,prevision1};
		this.previsions = previsions;
	}

	public String getVille() {
		return ville;
	}

	public int getNbJours() {
		return nbJours;
	}

	public Parser[] getPrevisions() {
		
		return this.previsions;
	}
	
	


	


}
