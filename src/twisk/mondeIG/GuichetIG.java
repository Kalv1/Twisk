package twisk.mondeIG;

/**
 * Classe EcouteurDeselection.
 *
 * @author Lambert Calvin & Mathieu Steinbach Hugo
 * @version 1.1
 */

public class GuichetIG extends EtapeIG {

    private int nbJetons;
    private int sensSortie; // 0 = sortie à droite, 1 = sortie à gauche.

    /**
     * Constructeur ActiviteIG.
     *
     * @param nom  String
     * @param idf  String
     * @param larg int
     * @param haut int
     */
    public GuichetIG(String nom, String idf, int larg, int haut, int nbJetons) {
        super(nom, idf, larg, haut);
        this.nbJetons = nbJetons;
    }

    /**
     * Getter nombre de jeton.
     *
     * @return int
     */
    public int getNbJetons() {
        return nbJetons;
    }

    /**
     * Setter nombre de jeton
     *
     * @param nbJetons int
     */
    public void setNbJetons(int nbJetons) {
        this.nbJetons = nbJetons;
    }

    /**
     * Fonction permettant de savoir si l'étpae est un guichet.
     *
     */
    @Override
    public boolean estUnGuichet() {
        return true;
    }

    /**
     * Setter du sens de sortie d'un guichet.
     * @param sensSortie int
     */
    public void setSensSortie(int sensSortie) {
        this.sensSortie = sensSortie;
    }

    /**
     * Getter du sens de sortie d'un guichet.
     * @return int
     */
    public int getSensSortie() {
        return sensSortie;
    }
}
