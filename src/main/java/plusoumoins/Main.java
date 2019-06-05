package plusoumoins;

import plusoumoins.exception.FichierConfigurationException;
import plusoumoins.meta.MetaGame;

import java.io.IOException;

public class Main {

    /*
        la méthode principale qui lance le jeu.
     */
    public static void main(String[] args) throws IOException, FichierConfigurationException {
    	MetaGame.run();
    }

}
