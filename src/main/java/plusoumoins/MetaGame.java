package plusoumoins;

import java.io.IOException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import plusoumoins.modes.Challenger;
import plusoumoins.modes.Defenseur;
import plusoumoins.modes.Duel;

public class MetaGame {
	public static int length;
	public static int mastermind_width = 3;
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
		logger = LogManager.getLogger(MetaGame.class);
	}
	
	public static void run() throws IOException, FichierConfigurationException {
		init_variables();

		int mode = Choose.menu("Choisissez votre mode\n1 - challenger\n2 - défenseur\n3 - duel", 1, 3);
		Game game = null;

		switch (mode) {
		case 1:
			game = new Challenger();
			break;
		case 2:
			game = new Defenseur();
			break;
		case 3:
			game = new Duel();
			break;
		}

		game.run();
	}
}
