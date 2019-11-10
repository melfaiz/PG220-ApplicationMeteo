package affichage;

import parser.*;

public class TableauSimple {
	
	int nbJours;
	String ville;
	String nom;
	float[] temperatures;
	

	public TableauSimple(Parser prevision) {
		super();
		this.nbJours = prevision.getNbJours();
		this.ville = prevision.getVille();
		this.nom = prevision.getNom();
		this.temperatures = prevision.getTemperatures();
		
	}

	public void afficher() {

		
		

		printHeader();

		// Separator
		
		// Separator ends here
		
		// Line
		System.out.print("|");
		
		System.out.format("%1$-15s", this.nom);

		
		System.out.print("|");
		
		for (float temp : this.temperatures) {
			System.out.format("%1$-10s|","  "+temp+"°");
		}
		
		
		System.out.println();
		// Line ends here
		printSeparator();
		// Separator


		// Separator ends here
		
	}
	
	private void printSeparator() {
		String space;
		
		// Separator
		System.out.print("+");
		space = "-".repeat(15);		
		System.out.print(space);
		System.out.print("+");
		
		for (int i = 0; i < this.nbJours; i++) {
			space = "-".repeat(10);
			space = space + "+";
			System.out.print(space);
		}
		System.out.println();
		
		// Separator ends here
	}
	
	private void printHeader() {
		// Header
		
		printSeparator() ;
		
		System.out.print("|");
		
		System.out.format("%1$-15s", this.ville);

		
		System.out.print("|");
		
		for (int i = 0; i < this.nbJours; i++) {
			System.out.format("%1$-10s|","   J+"+i);
		}
		
		
		System.out.println();
		
		printSeparator();  
		// header ends here
	}
	
	

}
