/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;

/**
 *
 * @author aless
 */
    public class Pokemon {
    private String nombre;
    private int salud;
    private int ataque;

    // Constructor
    public Pokemon(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    // Método toString para mostrar información del Pokémon
    @Override
    public String toString() {
        return "Pokémon: " + nombre + " | Salud: " + salud + " | Ataque: " + ataque;
    }
}

