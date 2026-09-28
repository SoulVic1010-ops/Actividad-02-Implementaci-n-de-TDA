/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package_actividad02;

/**
 *
 * @author victo
 */
public class Estudiante extends Persona {

    private String matricula;
    private double[] calificaciones;

    public Estudiante(String nombre, int edad, String matricula,
            double[] calificaciones) {

        super(nombre, edad);
        setMatricula(matricula);
        setCalificaciones(calificaciones);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La matrícula no puede estar vacía."
            );
        }

        this.matricula = matricula.trim();
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        if (calificaciones == null || calificaciones.length == 0) {
            throw new IllegalArgumentException(
                    "Debe existir al menos una calificación."
            );
        }

        for (double calificacion : calificaciones) {
            if (calificacion < 0 || calificacion > 100) {
                throw new IllegalArgumentException(
                        "Las calificaciones deben estar entre 0 y 100."
                );
            }
        }

        this.calificaciones = calificaciones;
    }

    public double calcularPromedio() {
        double suma = 0;

        for (double calificacion : calificaciones) {
            suma += calificacion;
        }

        return suma / calificaciones.length;
    }

    public String determinarEstado() {
        if (calcularPromedio() >= 70) {
            return "APROBADO";
        }

        return "REPROBADO";
    }

    public double obtenerCalificacionMayor() {
        double mayor = calificaciones[0];

        for (int i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] > mayor) {
                mayor = calificaciones[i];
            }
        }

        return mayor;
    }

    public double obtenerCalificacionMenor() {
        double menor = calificaciones[0];

        for (int i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] < menor) {
                menor = calificaciones[i];
            }
        }

        return menor;
    }

    public boolean buscarCalificacion(double valor) {
        for (double calificacion : calificaciones) {
            if (calificacion == valor) {
                return true;
            }
        }

        return false;
    }

    public int contarAprobadasRecursivo() {
        return contarAprobadasRecursivo(0);
    }

    private int contarAprobadasRecursivo(int indice) {
        if (indice >= calificaciones.length) {
            return 0;
        }

        int aprobada = 0;

        if (calificaciones[indice] >= 70) {
            aprobada = 1;
        }

        return aprobada + contarAprobadasRecursivo(indice + 1);
    }

    public int contarReprobadas() {
        int contador = 0;

        for (double calificacion : calificaciones) {
            if (calificacion < 70) {
                contador++;
            }
        }

        return contador;
    }

    @Override
    public String obtenerInformacion() {

        String informacion = "";

        informacion += "DATOS DEL ESTUDIANTE\n";
        informacion += "-------------------------\n";
        informacion += "Nombre: " + nombre + "\n";
        informacion += "Edad: " + edad + "\n";
        informacion += "Matrícula: " + matricula + "\n";
        informacion += "Promedio: "
                + String.format("%.2f", calcularPromedio()) + "\n";
        informacion += "Estado: " + determinarEstado() + "\n";
        informacion += "Calificación mayor: "
                + obtenerCalificacionMayor() + "\n";
        informacion += "Calificación menor: "
                + obtenerCalificacionMenor() + "\n";
        informacion += "Aprobadas: "
                + contarAprobadasRecursivo() + "\n";
        informacion += "Reprobadas: "
                + contarReprobadas() + "\n";

        return informacion;
    }
}
