package plusoumoins.exception;

/*
	Exception levée quand on fait une erreur dans le fichier de configuration
 */
public class FichierConfigurationException extends Exception {
	public FichierConfigurationException() {
		System.out.println("Il y a une erreur dans votre fichier de configuration !");
	}
}
