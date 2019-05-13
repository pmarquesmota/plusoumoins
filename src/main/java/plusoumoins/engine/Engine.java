package plusoumoins.engine;

import java.util.Random;
import plusoumoins.meta.MetaGame;

public class Engine {
	public static String guess(String g, String resultat) {
		String guess_digit;
		char result_letter;
		String result_guess = "";
		
		
		if (resultat == "") {
			for (int i=0; i<MetaGame.length;i++) {
				result_guess = result_guess +"0";
			}
			return result_guess;
		}
		for (int i = 0; i < MetaGame.length; i++) {
			guess_digit = g.substring(i, i + 1);
			result_letter = resultat.charAt(i);
			result_guess = result_guess + guess_digit(Integer.parseInt(guess_digit), result_letter);
		}
		return result_guess;
	}

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

	public static String getSecret() {
		String computer_secret = "";
		
        Random rand = new Random();
        for (int i = 0; i<MetaGame.length; i++) {
        	computer_secret = computer_secret + Integer.toString(rand.nextInt(9));
        }

        return computer_secret;
	}
}
