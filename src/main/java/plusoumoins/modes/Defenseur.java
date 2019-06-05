package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.cli.Choose;
import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;

public class Defenseur  extends Game {
	public void run() {
        Logger log = MetaGame.getLogger();

        log.info("Début du mode défenseur");
        
        player_secret = Choose.choice("Veuillez saisir un nombre secret à " + MetaGame.length + " chiffres", false);
        log.info("Le nombre secret choisi par le joueur est : " + player_secret);
        
        do {
            computer_guess = guess(computer_guess, player_result_string);
        	log.info("l'ordinateur essaie : " + computer_guess);

            player_result_string = Choose.choice("Veuillez donner le résultat de la comparaison avec votre chiffre secret", true);
            log.info("Résultat : " + player_result_string);
        } while(!player_result_string.equals(result_guess));
        log.info("L'ordinateur a gagné !");
	}
}
