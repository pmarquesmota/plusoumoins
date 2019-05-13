package plusoumoins.modes;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import plusoumoins.meta.Game;
import plusoumoins.meta.MetaGame;
import plusoumoins.cli.Choose;
import plusoumoins.engine.Engine;

public class Challenger extends Game {

	public void run() {
        String r = "";
        String nb = "";
        String x = "";
        String result_guess = "";
        Logger logger = MetaGame.getLogger();
        
        logger.info("Début du mode Challenger");
        result_guess = MetaGame.getResult();
       
        Random rand = new Random();
        for (int i = 0; i<MetaGame.length; i++) {
        	x = x + Integer.toString(rand.nextInt(9));
        }
        if(MetaGame.dev) {
        	System.out.println("Le nombre secret est : " + x);
        }
        logger.info("Le nombre secret choisi par l'ordinateur est : " + x);
        
        do {
            nb = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres");
            logger.info("Le joueur saisit : " + nb);
            
            r = Engine.make_string(x, nb);
            System.out.println("Résultat : " + r);
            logger.info("Résultat : " + r);
        } while(!r.equals(result_guess));
        System.out.println("Gagné !");
        logger.info("Le joueur a gagné !");
	}

}
