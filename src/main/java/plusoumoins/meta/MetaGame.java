package plusoumoins.meta;

import java.io.IOException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import plusoumoins.cli.Choose;
import plusoumoins.exception.FichierConfigurationException;
import plusoumoins.config.Parameters;
import plusoumoins.modes.Challenger;
import plusoumoins.modes.Defenseur;
import plusoumoins.modes.Duel;

public class MetaGame {
	public static int length;
	public static int tries;
	public static HashMap<String, String> parameters;
	public static boolean dev;
	public static Logger logger;
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MetaGame.logger = logger;
	}

	public static String getResult() {
		String r = "";

		for (int i = 0; i < length; i++) {
			r = r + "=";
		}
		return r;
	}
	
	public static void init_variables() throws IOException, FichierConfigurationException {
		parameters = Parameters.getListeParametres();
		length = Integer.parseInt(parameters.get("length"));
		dev = Boolean.parseBoolean(parameters.get("dev"));
		tries = Integer.parseInt(parameters.get("tries"));
		logger = LogManager.getLogger("main.java");
	}
	
	public static void run() throws IOException, FichierConfigurationException {
		init_variables();
		boolean play = true;
		int mode = 0;
		int choix = 2;

		do {
			if(choix == 2) {
				mode = Choose.menu("Choisissez votre mode\n1 - challenger\n2 - défenseur\n3 - duel", 1, 3);
			}
			Game game = instancieMode(mode);
			game.run();
			choix = Choose.menu("Le jeu est terminé. Voulez-vous\n1 - rejouer au même mode\n2 - lancer un autre mode (retour à l'écran de choix du début)\n3 - quitter l'application", 1, 3);
			if (choix == 3) {
				play = false;
			}
		} while(play == true);
	}

	public static Game instancieMode(int mode){
		switch (mode) {
			case 1:
				return new Challenger();
			case 2:
				return new Defenseur();
			case 3:
				return new Duel();
		}
		return new Challenger();
	}
}
