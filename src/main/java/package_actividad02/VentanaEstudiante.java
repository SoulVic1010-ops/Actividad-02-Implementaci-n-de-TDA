/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package_actividad02;

/**
 *
 * @author victo
 */

import javax.swing.*;
import java.awt.*;

public class VentanaEstudiante extends JFrame {

private JTextField txtNombre;
private JTextField txtEdad;
private JTextField txtMatricula;
private JTextField txtCalificaciones;

private JTextArea txtResultado;

private JButton btnCalcular;
private JButton btnLimpiar;
private JButton btnSalir;

public VentanaEstudiante() {

    setTitle("Actividad 02 - TDA en Java");
    setSize(650, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    crearInterfaz();
}

private void crearInterfaz() {

    JPanel panelPrincipal = new JPanel();
    panelPrincipal.setLayout(new BorderLayout(10, 10));
    panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );

    JLabel lblTitulo = new JLabel(
            "ACTIVIDAD 02 - IMPLEMENTACIÓN DE TDA",
            SwingConstants.CENTER
    );

    lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));

    panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

    JPanel panelDatos = new JPanel();
    panelDatos.setLayout(new GridLayout(6, 2, 10, 10));

    panelDatos.add(new JLabel("Nombre:"));
    txtNombre = new JTextField();
    panelDatos.add(txtNombre);

    panelDatos.add(new JLabel("Edad:"));
    txtEdad = new JTextField();
    panelDatos.add(txtEdad);

    panelDatos.add(new JLabel("Matrícula:"));
    txtMatricula = new JTextField();
    panelDatos.add(txtMatricula);

    panelDatos.add(new JLabel("Calificaciones:"));
    txtCalificaciones = new JTextField();
    panelDatos.add(txtCalificaciones);

    panelDatos.add(new JLabel("Ejemplo:"));
    panelDatos.add(new JLabel("80, 90, 75, 60, 95"));

    panelDatos.add(new JLabel("Autor:"));

    JLabel lblAutor = new JLabel(
            "LUIS ALBERTO MENDOZA SAN JUAN"
    );

    lblAutor.setFont(new Font("Arial", Font.BOLD, 12));
    panelDatos.add(lblAutor);

    txtResultado = new JTextArea();
    txtResultado.setEditable(false);
    txtResultado.setFont(
            new Font("Monospaced", Font.PLAIN, 14)
    );

    JScrollPane scroll = new JScrollPane(txtResultado);

    JPanel panelCentro = new JPanel(
            new BorderLayout(10, 10)
    );

    panelCentro.add(panelDatos, BorderLayout.NORTH);
    panelCentro.add(scroll, BorderLayout.CENTER);

    panelPrincipal.add(
            panelCentro,
            BorderLayout.CENTER
    );

    JPanel panelBotones = new JPanel();

    btnCalcular = new JButton(
            "Procesar estudiante"
    );

    btnLimpiar = new JButton("Limpiar");
    btnSalir = new JButton("Salir");

    panelBotones.add(btnCalcular);
    panelBotones.add(btnLimpiar);
    panelBotones.add(btnSalir);

    panelPrincipal.add(
            panelBotones,
            BorderLayout.SOUTH
    );

    btnCalcular.addActionListener(
            e -> procesarEstudiante()
    );

    btnLimpiar.addActionListener(
            e -> limpiarCampos()
    );

    btnSalir.addActionListener(
            e -> System.exit(0)
    );

    add(panelPrincipal);
}

private void procesarEstudiante() {

    try {

        String nombre = txtNombre.getText();

        int edad = Integer.parseInt(
                txtEdad.getText()
        );

        String matricula =
                txtMatricula.getText();

        String textoCalificaciones =
                txtCalificaciones.getText();

        String[] datos =
                textoCalificaciones.split(",");

        double[] calificaciones =
                new double[datos.length];

        for (int i = 0; i < datos.length; i++) {

            calificaciones[i] =
                    Double.parseDouble(
                            datos[i].trim()
                    );
        }

        Estudiante estudiante =
                new Estudiante(
                        nombre,
                        edad,
                        matricula,
                        calificaciones
                );

        String resultado =
                estudiante.obtenerInformacion();

        resultado +=
                "\n-------------------------\n";

        txtResultado.setText(resultado);

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Verifica que la edad y las calificaciones tengan valores numéricos.",
                "Error de datos",
                JOptionPane.ERROR_MESSAGE
        );

    } catch (IllegalArgumentException ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error de validación",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

private void limpiarCampos() {

    txtNombre.setText("");
    txtEdad.setText("");
    txtMatricula.setText("");
    txtCalificaciones.setText("");
    txtResultado.setText("");

    txtNombre.requestFocus();
}
}

