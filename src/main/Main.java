package main;

import java.io.IOException;

import affichage.*;
import commande.*;




public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Commande cmd = new Commande(args);
		
		Tableau tableau = new Tableau(cmd.getPrevisions());

		tableau.afficher();
    }
	
}
