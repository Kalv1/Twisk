package twisk.ecouteur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * Classe EcouteurSortie.
 *
 * @author Lambert Calvin & Mathieu Steinbach Hugo
 * @version 1.1
 */

public class EcouteurSortie implements EventHandler<ActionEvent> {

    private final MondeIG monde;

    /**
     * Constructeur EcouteurSortie.
     *
     * @param monde MondeIG
     */
    public EcouteurSortie(MondeIG monde) {
        this.monde = monde;
    }

    /**
     * Fonction handle.
     *
     * @param actionEvent ActionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        monde.gestionSortie();
    }
}
