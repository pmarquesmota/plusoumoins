package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.cli.Choose;
import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;

public class Defenseur  extends Game {
	public void run() {
        String result_string = "";
        String x = "";
        String guess = "";
        String result_guess = MetaGame.getResult();
        Logger log = MetaGame.getLogger();

        log.info("Début du mode défenseur");
        
        x = Choose.choice("Veuillez saisir un nombre secret à " + MetaGame.length + " chiffres");
        log.info("Le nombre secret choisi par le joueur est : " + x);
        
        do {
            guess = guess(guess, result_string);
        	log.info("l'ordinateur essaie : " + guess);
        	
        	result_string = make_string(x, guess);
            log.info("Résultat : " + result_string);
        } while(!result_string.equals(result_guess));
        log.info("L'ordinateur a gagné !");
	}
}
