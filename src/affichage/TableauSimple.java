package affichage;

import parser.*;

public class TableauSimple {
	

	public static void afficher(Parser prevision) {

		String space;
		
		// Separator
		System.out.print("+");
		space = "-".repeat(15);		
		System.out.print(space);
		System.out.print("+");
		
		for (int i = 0; i < prevision.getNbJours(); i++) {
			space = "-".repeat(10);
			space = space + "+";
			System.out.print(space);
		}
		System.out.println();
		
		// Separator ends here
	

		
		// Header
		System.out.print("|");
		
		System.out.format("%1$-15s", prevision.getVille());

		
		System.out.print("|");
		
		for (int i = 0; i < prevision.getNbJours(); i++) {
			System.out.format("%1$-10s|","   J+"+i);
		}
		
		
		System.out.println();
		// header ends here
		

		// Separator
		System.out.print("+");
		space = "-".repeat(15);		
		System.out.print(space);
		System.out.print("+");
		
		for (int i = 0; i < prevision.getNbJours(); i++) {
			space = "-".repeat(10);
			space = space + "+";
			System.out.print(space);
		}
		System.out.println();
		// Separator ends here
		
		// Line
		System.out.print("|");
		
		System.out.format("%1$-15s", prevision.getNom());

		
		System.out.print("|");
		
		for (float temp : prevision.getTemperatures()) {
			System.out.format("%1$-10s|","  "+temp+"°");
		}
		
		
		System.out.println();
		// Line ends here
		
		// Separator
		System.out.print("+");
		space = "-".repeat(15);		
		System.out.print(space);
		System.out.print("+");
		
		for (int i = 0; i < prevision.getNbJours(); i++) {
			space = "-".repeat(10);
			space = space + "+";
			System.out.print(space);
		}
		System.out.println();
		// Separator ends here
		
	}
	
	

}
