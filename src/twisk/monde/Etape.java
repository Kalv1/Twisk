package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable {
    public String nom;
    public GestionnaireSuccesseurs gestionnaireSuccesseurs;

    public Etape(String nom) {
        this.nom = nom;
    }

    void ajouterSuccesseur(Etape... e) {
    }

    boolean estUneActivite() {
        return true;
    }

    boolean estUnGuichet() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
