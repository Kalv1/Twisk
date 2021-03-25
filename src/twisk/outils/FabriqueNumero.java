package twisk.outils;

/**
 * Classe FabriqueNumero
 * @author Mathieu Steinbach Hugo & Lambert Calvin
 * @version 1.0
 */

public class FabriqueNumero {

    private static final FabriqueNumero instance = new FabriqueNumero();
    int cptEtape;
    int cptSemaphore;

    /**
     * Constructeur de FabriqueNumero
     */
    private FabriqueNumero() {
        cptEtape = 0;
        cptSemaphore = 1;
    }

    /**
     * Getter de l'instance de FabriqueNumero
     * @return L'instance de FabriqueNumero
     */
    public static FabriqueNumero getInstance() {
        return instance;
    }

    /**
     * Getter du numero d'étape
     * @return Le numéro de l'étape actuelle
     */
    public int getNumeroEtape() {
        cptEtape++;
        return cptEtape - 1;
    }

    /**
     * Getter sémaphore
     * @return Le numéro du guichet actuelle
     */
    public int getNumeroSemaphore() {
        cptSemaphore++;
        return cptSemaphore - 1;
    }

    /**
     * Reset de du nombre d'étape et de sémaphore
     */
    public void reset() {
        cptEtape = 0;
        cptSemaphore = 1;
    }
}