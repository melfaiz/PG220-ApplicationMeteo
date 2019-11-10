package main;

import parser.metaweather.*;
import parser.previsionmeteo.*;

import affichage.*;


import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String nomVille = args[1];
		 
		int nbjours = Integer.parseInt(args[3]);		

	
		MetaWeather prevision = new MetaWeather(nomVille, nbjours);
		
		TableauSimple tab = new TableauSimple(prevision);
		
		tab.afficher();
    }
	
}
