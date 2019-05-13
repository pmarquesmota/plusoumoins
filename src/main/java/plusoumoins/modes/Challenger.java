package plusoumoins.modes;

import java.util.Random;

import org.apache.logging.log4j.Logger;

import plusoumoins.Game;
import plusoumoins.MetaGame;
import plusoumoins.Choose;
import plusoumoins.Engine;

public class Challenger extends Game {
	public void run() {
        String r = "";
        String nb = "";
        String x = "";
        String result_guess = "";
        Logger log;
        
        log = MetaGame.getLogger();
        log.error("Début du mode Challenger");
        result_guess = MetaGame.getResult();
       
        Random rand = new Random();
        for (int i = 0; i<MetaGame.length; i++) {
        	x = x + Integer.toString(rand.nextInt(9));
        }
        if(MetaGame.dev) {
        	System.out.println("Le nombre secret est : " + x);
        }
        log.error("Le nombre secret choisi par l'ordinateur est : " + x);
        
        do {
            nb = Choose.choice("Veuillez saisir un nombre à " + MetaGame.length + " chiffres");
            log.error("Le joueur saisit : " + nb);
            
            r = Engine.make_string(x, nb);
            System.out.println("Résultat : " + r);
            log.error("Résultat : " + r);
        } while(!r.equals(result_guess));
        System.out.println("Gagné !");
        log.error("Le joueur a gagné !");
	}

}
