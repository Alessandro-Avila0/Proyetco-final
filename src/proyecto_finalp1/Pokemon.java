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
    // Atributos del pokemon
    private String nombre;
    private int salud;
    private String[] ataques;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
    public void setAtaques(String[] ataques) {
        this.ataques = ataques;
    }

    // Constructor
    public Pokemon(String nombre, int salud, String[] ataques) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataques = ataques;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
    }

    public String[] getAtaques() {
        return ataques;
    }

    public void mostrarInformacion() {
        System.out.println("Pokémon: " + nombre + " | Salud: " + salud);
        System.out.println("Ataques disponibles: ");
        for (String ataque : ataques) {
            System.out.println("- " + ataque);
        }
    }
}
