package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.cli.Choose;
import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;

public class Duel  extends Game {

	public void run() {
		logger.info("Début du mode duel");
		
        player_secret = Choose.choice("Veuillez saisir un nombre secret à " + MetaGame.length + " chiffres");
        logger.info("Le nombre secret choisi par le joueur est : " + player_secret);
        
        if(MetaGame.dev) {
			logger.info("Le nombre secret choisi par l'ordinateur est : " + computer_secret);
        }
        do {
        	computer_play();
        	player_play();
        } while(!(computer_result_string.equals(result_guess) || player_result_string.equals(result_guess)));
        show_winner();
	}

	private void computer_play() {
		computer_guess = guess(computer_guess, computer_result_string);
        logger.info("l'ordinateur essaie : " + computer_guess);
        
    	computer_result_string = make_string(player_secret, computer_guess);
    	
        logger.info("Résultat : " + computer_result_string);
	}

	private void player_play() {
        player_guess = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres");
        logger.info("le joueur essaie : " + player_guess);
        player_result_string = make_string(computer_secret, player_guess);
        logger.info("Résultat : " + player_result_string);
	}
	
	private void show_winner() {
        if(player_result_string.equals(result_guess)) {
        	logger.info("Le joueur a gagné !");
        } else {
        	logger.info("L'ordinateur a gagné !");
        }
	}
}
