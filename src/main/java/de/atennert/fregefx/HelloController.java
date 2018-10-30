package de.atennert.fregefx;

import frege.prelude.PreludeBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Example Controller implementation. This is a connector between FXML (the controller is referenced
 * in the @link(main_screen.fxml) file) and Frege in terms of forwarding action calls to the Frege.
 *
 * Besides calling Frege functions it is not supposed to have any logic.
 */
public class HelloController {

    /**
     * Call a Frege function that performs IO.
     * @param e
     */
    @FXML
    public void doIO( ActionEvent e ) {
        PreludeBase.TST.performUnsafe( Hello.doIO.call() ).call();
    }

    /**
     * Call a Frege function that performs UI actions.
     * @param e
     */
    @FXML
    public void doUI( ActionEvent e ) {
        PreludeBase.TST.performUnsafe( Hello.doUI( () -> e ).call() ).call();
    }
}
