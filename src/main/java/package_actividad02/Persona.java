/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package_actividad02;

/**
 *
 * @author victo
 */
public class Persona {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        this.nombre = nombre.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 1 || edad > 100) {
            throw new IllegalArgumentException(
                    "La edad debe estar entre 1 y 100 años."
            );
        }

        this.edad = edad;
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre + "\n"
                + "Edad: " + edad;
    }
}
