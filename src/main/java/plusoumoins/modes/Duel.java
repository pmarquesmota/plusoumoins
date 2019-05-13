package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.cli.Choose;
import plusoumoins.engine.Engine;
import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;

public class Duel  extends Game {
	String player_secret = "";
	String player_result_string = "";
	String player_guess = "";
	String computer_secret = "";
	String computer_result_string = "";
	String computer_guess = "";
	String result_guess = "";
	Logger log;
	
	public void run() {
		log = MetaGame.getLogger();
		result_guess = MetaGame.getResult();
		log.error("Début du mode duel");
		
        player_secret = Choose.choice("Veuillez saisir un nombre secret à " + MetaGame.length + " chiffres");
        log.error("Le nombre secret choisi par le joueur est : " + player_secret);
        
        computer_secret = Engine.getSecret();
        log.error("Le nombre secret choisi par l'ordinateur est : " + computer_secret);
        if(MetaGame.dev) {
        	System.out.println("Le nombre secret est : " + computer_secret);
        }
        do {
        	computer_play();
        	player_play();
        } while(!(computer_result_string.equals(result_guess) || player_result_string.equals(result_guess)));
        show_winner();
	}

	private void computer_play() {
		computer_guess = Engine.guess(computer_guess, computer_result_string);
        System.out.println("l'ordinateur essaie : " + computer_guess);
        log.error("l'ordinateur essaie : " + computer_guess);
        
    	computer_result_string = Engine.make_string(player_secret, computer_guess);
    	
        System.out.println("Résultat : " + computer_result_string);
        log.error("Résultat : " + computer_result_string);
	}

	private void player_play() {
        player_guess = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres");
        log.error("le joueur essaie : " + player_guess);
        player_result_string = Engine.make_string(computer_secret, player_guess);
        System.out.println("Résultat : " + player_result_string);
        log.error("Résultat : " + player_result_string);
	}
	
	private void show_winner() {
        if(player_result_string.equals(result_guess)) {
        	System.out.println("Vous avez gagné !");
        	log.error("Le joueur a gagné !");
        } else {
        	System.out.println("L'ordinateur a gagné !");
        	log.error("L'ordinateur a gagné !");
        }
	}
}
