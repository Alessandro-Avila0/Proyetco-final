/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;

/**
 *
 * @author aless
 */
   public class Entrenador {
    private String nombre;
    private Pokemon pokemon;
   


    public Entrenador(String nombre, Pokemon pokemon) {
        this.nombre = nombre;
        this.pokemon = pokemon;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void mejorarPokemon() {
        System.out.println("Mejorando Pokémon...");
        pokemon.setSalud(pokemon.getSalud() + 20); // Ejemplo de mejora
        System.out.println("¡La salud de " + pokemon.getNombre() + " ha aumentado!");
    }

    public void cambiarPokemon(Pokemon nuevoPokemon) {
        this.pokemon = nuevoPokemon;
        System.out.println("¡Has cambiado a " + nuevoPokemon.getNombre() + "!");
    }

    public void mostrarPokemon() {
        pokemon.mostrarInformacion();
    }
}
