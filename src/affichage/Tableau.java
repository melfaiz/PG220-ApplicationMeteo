package affichage;

import parser.*;

public class Tableau {
	
	String ville;
	Parser[] previsions;

	int nbJours;
	
	public Tableau(Parser[] previsions) {
		super();
		this.previsions = previsions;
		this.ville = previsions[0].getVille();
		this.nbJours = previsions[0].getNbJours();

	}
	
	public void afficher() {
		
		printSeparator();
		
		printHeader();
		
		printSeparator();
		
		for (int i = 0; i < previsions.length; i++) {
			
			printPrevision(previsions[i]);
			printSeparator();
			
		}

		
	}
	
	private void printSeparator() {
		String space;
		
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
		

	}
	
	
	private void printHeader() {
		String header= "";
		
		header = header +"|";
		
		header += String.format("%1$-15s", this.ville);

		
		header +="|";
		
		for (int i = 0; i < this.nbJours; i++) {
			header += String.format("%1$-10s|","   J+"+i);
		}
 		System.out.println(header);
	}
	

	
	private void printPrevision(Parser prevision) {
		
		System.out.print("|");
		
		System.out.format("%1$-15s", prevision.getNom());

		
		System.out.print("|");

		for (float temp : prevision.getTemperatures()) {
			System.out.format("%1$-10s|","  "+temp+"°");
		}
		
		System.out.println();
	}
	
	

}
