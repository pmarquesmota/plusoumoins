package plusoumoins.cli;

import plusoumoins.meta.MetaGame;

import java.util.Scanner;

public class Choose {
	/**
	 * Given a question, a minimum number and a maximum number, it returns a number
	 * between the minimum and the maximum.
	 * 
	 * @param question The question asked.
	 * @param minimum  The minimum number that can be accepted.
	 * @param maximum  The maximum number that can be accepted.
	 * @return The number chosen by the user.
	 */
	public static String choice(String question, boolean defenseur) {
		Scanner s = new Scanner(System.in);

		String line = "";
		String result_match = "";
		String match_singleton;
		if(defenseur){
			match_singleton = "[=+-]";
		} else {
			match_singleton = "\\d";
		}
        for (int i = 0; i< MetaGame.length; i++) {
        	result_match = result_match + match_singleton;
        }

		do {
			System.out.println(question);
			line = s.nextLine();
			if (!line.matches(result_match)) {
				System.out.println("Choix incorrect. Veuillez recommencer");
			}
		} while (!line.matches(result_match));
		return line;
	}
	
	/**
     * Given a question, a minimum number and a maximum number, it returns a number between the minimum and the maximum. 
	 * @param question The question asked.
	 * @param minimum The minimum number that can be accepted.
	 * @param maximum The maximum number that can be accepted.
	 * @return The number chosen by the user.
	 */
	public static int menu(String question, int minimum, int maximum) {
		Scanner s = new Scanner(System.in);
		int line = 0;
		
		do {
			try {
				System.out.println(question);
				line = s.nextInt();
				if (line < minimum || line > maximum) {
					System.out.println("Choix incorrect. Veuillez recommencer");
				}
			} catch(Exception e) {
				System.out.println("Choix incorrect. Veuillez recommencer et saisir un nombre");
				//Flush line before reading another
				if(s.hasNextLine()) {
					s.nextLine();
				}
				line = 0;
			}
		} while (line < minimum || line > maximum);
		return line;
	}

}
