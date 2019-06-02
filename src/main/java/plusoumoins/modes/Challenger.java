package plusoumoins.modes;

import org.apache.logging.log4j.Logger;

import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;
import plusoumoins.cli.Choose;

public class Challenger extends Game {

	public void run() {
        String r = "";
        String nb = "";
        String result_guess = "";
        Logger logger = MetaGame.getLogger();
        String computer_secret = getSecret();

        logger.info("Début du mode Challenger");
        result_guess = MetaGame.getResult();

        if(MetaGame.dev) {
            logger.info("Le nombre secret choisi par l'ordinateur est : " + computer_secret);
        }

        do {
            nb = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres");
            logger.info("Le joueur saisit : " + nb);
            
            r = make_string(computer_secret, nb);
            logger.info("Résultat : " + r);
        } while(!r.equals(result_guess));
        logger.info("Le joueur a gagné !");
	}

}
