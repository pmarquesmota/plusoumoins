package plusoumoins.meta;

import org.apache.logging.log4j.Logger;

import java.util.Random;

public abstract class Game {
	public String player_result_string = "";
	public String computer_result_string = "";
	public String computer_secret = getSecret();
	public String player_secret = "";
	public String result_guess = MetaGame.getResult();
	public String player_guess = "";
	public String computer_guess = "";
	public Logger logger = MetaGame.getLogger();
	public int player_tries = 0;

	/*
		L'ordinateur essaie de deviner un ensemble de chiffres
	 */
	public static String guess(String g, String resultat) {
		String guess_digit;
		char result_letter;
		String result_guess = "";

		/* Premier essai, on essaie des zéros */
		if (resultat == "") {
			for (int i=0; i<MetaGame.length;i++) {
				result_guess = result_guess +"0";
			}
			return result_guess;
		}
		/* sinon, pour chaque chiffre de la chaine de caractères, on essaie un chiffre plus grand ou plus petit
		   suivant les indications de ce qu'on a déjà deviné dans la chaine g
		 */
		for (int i = 0; i < MetaGame.length; i++) {
			guess_digit = g.substring(i, i + 1);
			result_letter = resultat.charAt(i);
			result_guess = result_guess + guess_digit(Integer.parseInt(guess_digit), result_letter);
		}
		return result_guess;
	}

	/*
		devine un chiffre suivant ce qu'on a déjà deviné dans g, et les indications de r
	 */
	public static String guess_digit(int g, char r) {
		switch (r) {
		case '+':
			g++;
			break;
		case '-':
			g--;
			break;
		case '=':
			break;
		}
		return Integer.toString(g);
	}

	/*
		Prend deux chaines de caractères qui représentent des chiffres et construit
		une comparaison du genre "+--="
	 */
	public static String make_string(String private_string, String public_string) {
		String resultat = "";
		String chiffre_secret;
		String chiffre_public;

		for (int i = 0; i < MetaGame.length; i++) {
			chiffre_secret = private_string.substring(i, i + 1);
			chiffre_public = public_string.substring(i, i + 1);
			resultat = resultat + compare(Integer.parseInt(chiffre_secret), Integer.parseInt(chiffre_public));
		}
		return resultat;
	}

	/*
		La meme chose que la méthode ci-dessus, mais avec des chiffres
	 */
	public static char compare(int a, int b) {
		if (a > b) {
			return '+';
		}
		if (a < b) {
			return '-';
		}
		if (a == b) {
			return '=';
		}
		return '?';
	}

	/*
		Construit un nombre au hasard que le joueur doit deviner
	 */
	public static String getSecret() {
		String computer_secret = "";

        Random rand = new Random();
        for (int i = 0; i<MetaGame.length; i++) {
        	computer_secret = computer_secret + Integer.toString(rand.nextInt(9));
        }

        return computer_secret;
	}

	/*
		La méthode implémentée par les sous-classes pour lancer les jeux
	 */
	public abstract void run();
}
