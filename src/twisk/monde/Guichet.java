package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.io.Serializable;

/**
 * Classe Guichet
 *
 * @author Mathieu Steinbach Hugo & Lambert Calvin
 * @version 1.0
 */

public class Guichet extends Etape implements Serializable {

    private final int nbJetons;
    private final int semaphore;

    /**
     * Constructeur de guichet.
     *
     * @param nom Nom du guichet
     */
    public Guichet(String nom) {
        super(nom);
        this.nbJetons = 5; // 5 jetons par défaut
        FabriqueNumero singleton = FabriqueNumero.getInstance();
        this.semaphore = singleton.getNumeroSemaphore();
    }

    /**
     * Constructeur de guichet avec nom et nombre de jeton.
     *
     * @param nom Nom du guichet
     * @param nb  Nombre de jeton
     */
    public Guichet(String nom, int nb) {
        super(nom);
        this.nbJetons = nb;
        FabriqueNumero singleton = FabriqueNumero.getInstance();
        this.semaphore = singleton.getNumeroSemaphore();
    }

    /**
     * Getter estUnGuichet.
     *
     * @return Vrai
     */
    @Override
    public boolean estUnGuichet() {
        return true;
    }

    /**
     * Fonction de mise en string de guichet.
     *
     * @return Un string du guichet contenant le numéro, le nom, le nombre de jeton ainsi que le sémaphore
     */
    @Override
    public String toString() {
        return "Étape N°" + getNum() + " " + getNom() + " (" + getNbJetons() + " jetons et Semaphore n°" + getSemaphore() + ")";
    }

    /**
     * Fonction de mise en code C de guichet.
     *
     * @return Un string du code C d'un guichet
     */
    @Override
    public String toC() {
        return "P(" + "ids" + "," + getSemaphore() + "); \n" +
                "transfert(" + getNom().replaceAll("\\s+", "") + "," + getSuivant().getNom().replaceAll("\\s+", "") + "); \n" + "delai(" + getSuivant().getTemps() + "," + getSuivant().getEcartTemps() + ");\n" +
                "V(" + "ids" + "," + getSemaphore() + ");\n" + getSuivant().toC();
    }

    /**
     * Getter Semaphore.
     *
     * @return Le sémaphore du guichet
     */
    public int getSemaphore() {
        return semaphore;
    }

    /**
     * Getter nombre de jeton.
     *
     * @return Le nombre de jeton dans le guichet
     */
    public int getNbJetons() {
        return nbJetons;
    }

    /**
     * Getter suivant.
     *
     * @return L'activité restrainte suivante
     */
    @Override
    public ActiviteRestreinte getSuivant() {
        return (ActiviteRestreinte) getGestionnaireSuccesseurs().getEtapes().get(0);
    }
}
