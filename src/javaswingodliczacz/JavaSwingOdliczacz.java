/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingodliczacz;

import javax.swing.SwingUtilities;

/**
 *
 * @author marcin
 */
public class JavaSwingOdliczacz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                KlasaOdliczacz klasaOdliczacz = new KlasaOdliczacz();
            }
        });
    }
}
