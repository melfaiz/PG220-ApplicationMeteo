package parser;


public class Parser {
	
	protected String nom;
	protected String ville;
	protected int nbJours;
	protected float temperatures[] = new float[nbJours + 1];
	protected String buffer;
	
	public float[] getTemperatures() {
		return this.temperatures;
	}
		
	public String getBuffer() {
		return this.buffer;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getVille() {
		return this.ville;
	}

	public int getNbJours() {
		return this.nbJours;
	}
	

}
