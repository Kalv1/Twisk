package twisk.monde;


/**
 * Classe Activite
 * @author Mathieu Steinbach Hugo & Lambert Calvin
 * @version 1.0
 */

public class ActiviteRestreinte extends Activite {

    /**
     * Constructeur ActiviteRestreinte avec nom
     * @param nom Nom de l'activitée restreinte
     */
    public ActiviteRestreinte(String nom) {
        super(nom);
    }

    /**
     * Constructeur ActiviteRestreinte avec nom temps et ecart temps
     * @param nom Nom de l'activitée restreinte
     * @param t Temps de l'activitée restreinte
     * @param e EcartTemps de l'activitée restreinte
     */
    public ActiviteRestreinte(String nom, int t, int e) {
        super(nom, t, e);
    }

    @Override
    public String toC() {
        return "transfert(" + getNum() + "," + getSuivant().getNum() + ");\n" + getSuivant().toC();
    }

    /**
     * Getter du temps
     * @return Le temps de l'activitée restreinte
     */
    public int getTemps() {
        return temps;
    }

    /**
     * Getter de l'écart temps
     * @return L'écart temps de l'activitée restreinte
     */
    public int getEcartTemps() {
        return ecartTemps;
    }
}
