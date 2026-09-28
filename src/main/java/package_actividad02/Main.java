/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package package_actividad02;

/**
 *
 * @author victo
 */
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaEstudiante ventana =
                    new VentanaEstudiante();

            ventana.setVisible(true);
        });
    }
}
