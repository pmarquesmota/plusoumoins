package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.Choose;
import plusoumoins.Engine;
import plusoumoins.Game;
import plusoumoins.MetaGame;

public class Defenseur  extends Game {
	public void run() {
        String result_string = "";
        String x = "";
        String guess = "";
        String result_guess = MetaGame.getResult();
        Logger log;
        
        log = MetaGame.getLogger();
        log.error("Début du mode défenseur");
        
        x = Choose.choice("Veuillez saisir un nombre secret à " + MetaGame.length + " chiffres");
        log.error("Le nombre secret choisi par le joueur est : " + x);
        
        do {
            guess = Engine.guess(guess, result_string);
        	System.out.println("l'ordinateur essaie : " + guess);
        	log.error("l'ordinateur essaie : " + guess);
        	
        	result_string = Engine.make_string(x, guess);
            System.out.println("Résultat : " + result_string);
            log.error("Résultat : " + result_string);
        } while(!result_string.equals(result_guess));
        System.out.println("Gagné !");
        log.error("L'ordinateur a gagné !");
	}
}
