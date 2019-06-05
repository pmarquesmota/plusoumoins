package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;
import plusoumoins.cli.Choose;

public class Challenger extends Game {

    /*
        Lance le jeu
     */
	public void run() {
        logger.info("Début du mode Challenger");

        if(MetaGame.dev) {
            logger.info("Le nombre secret choisi par l'ordinateur est : " + computer_secret);
        }

        do {
            player_tries++;
            player_guess = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres", false);
            logger.info("Le joueur saisit : " + player_guess);

            computer_result_string = make_string(computer_secret, player_guess);
            logger.info("Résultat : " + computer_result_string);
        } while(!computer_result_string.equals(result_guess) && player_tries<MetaGame.tries);
        if (player_tries == MetaGame.tries){
            logger.info("Nombre d'essais maximal dépassé. Le joueur a perdu !");
        } else {
            logger.info("Le joueur a gagné !");
        }
	}

}
