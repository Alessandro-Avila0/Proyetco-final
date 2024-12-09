/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aless
 */


    public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;
    private Pokemon pokemonActual;

    // Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    // Método para agregar un Pokémon al equipo
    public void agregarPokemon(Pokemon pokemon) {
        equipo.add(pokemon);
        if (pokemonActual == null) {
            pokemonActual = pokemon;
        }
    }

    // Getter para el equipo de Pokémon
    public List<Pokemon> getEquipo() {
        return equipo;
    }

    // Getter y Setter para el Pokémon actual
    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void setPokemonActual(int index) {
        if (index >= 0 && index < equipo.size()) {
            this.pokemonActual = equipo.get(index);
        }
    }

    // Método para cambiar el nombre del entrenador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para mostrar la información del entrenador
    @Override
    public String toString() {
        return "Entrenador: " + nombre;
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }
}


