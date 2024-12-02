/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;

/**
 *
 * @author aless
 */
public class Batalla {
public static void comenzarBatalla(Entrenador entrenador1, Entrenador entrenador2) {
    Pokemon pokemon1 = entrenador1.getPokemon();
    Pokemon pokemon2 = entrenador2.getPokemon();

    while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
        // Lógica de los turnos
        // Aquí cada Pokémon elije un ataque aleatorio
        int danio1 = (int) (Math.random() * 10) + 1; // Daño aleatorio
        int danio2 = (int) (Math.random() * 10) + 1;

        pokemon2.recibirDanio(danio1); // Pokémon 2 recibe daño
        pokemon1.recibirDanio(danio2); // Pokémon 1 recibe daño

        // Imprimir el estado después de cada turno
        System.out.println(pokemon1.getNombre() + " salud: " + pokemon1.getSalud());
        System.out.println(pokemon2.getNombre() + " salud: " + pokemon2.getSalud());
    }

    if (pokemon1.getSalud() > 0) {
        System.out.println(entrenador1.getNombre() + " gana la batalla!");
    } else {
        System.out.println(entrenador2.getNombre() + " gana la batalla!");
    }
}
}

