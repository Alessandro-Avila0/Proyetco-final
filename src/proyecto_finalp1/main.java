/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;

/**
 *
 * @author aless
 */
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pokémon para elegir
        Pokemon pikachu = new Pokemon("Pikachu", 100, new String[]{"Trueno", "Impactrueno", "Rayo"});
        Pokemon charmander = new Pokemon("Charmander", 100, new String[]{"Llamarada", "Puño fuego", "Ardente"});
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 100, new String[]{"Látigo cepa", "Derribo", "Viento solar"});
        Pokemon squirtle = new Pokemon("Squirtle", 100, new String[]{"Hidrobomba", "Burbuja", "Pistola de agua"});

        // Crear el Entrenador con un Pokémon inicial
        Entrenador jugador = new Entrenador("Jugador", pikachu);

        // Mini historia inicial
        System.out.println("¡Bienvenido a la aventura Pokémon!");
        System.out.println("Eres un joven entrenador que ha recibido su primer Pokémon, ¡Pikachu! Pero hay más por venir...");

        // Menú principal
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Elegir un Pokémon");
            System.out.println("2. Mejorar Pokémon");
            System.out.println("3. Cambiar Pokémon");
            System.out.println("4. Ver Pokémon actual");
            System.out.println("5. Ir a la batalla");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Elegir un Pokémon
                    System.out.println("Elige un Pokémon:");
                    System.out.println("1. Pikachu");
                    System.out.println("2. Charmander");
                    System.out.println("3. Bulbasaur");
                    System.out.println("4. Squirtle");
                    System.out.print("Elige el número del Pokémon: ");
                    int elegido = scanner.nextInt();
                    switch (elegido) {
                        case 1: jugador.cambiarPokemon(pikachu); break;
                        case 2: jugador.cambiarPokemon(charmander); break;
                        case 3: jugador.cambiarPokemon(bulbasaur); break;
                        case 4: jugador.cambiarPokemon(squirtle); break;
                        default: System.out.println("Opción no válida."); break;
                    }
                    break;

                case 2: // Mejorar Pokémon
                    jugador.mejorarPokemon();
                    break;

                case 3: // Cambiar Pokémon
                    System.out.println("\nElige un nuevo Pokémon:");
                    System.out.println("1. Pikachu");
                    System.out.println("2. Charmander");
                    System.out.println("3. Bulbasaur");
                    System.out.println("4. Squirtle");
                    System.out.print("Elige el número del Pokémon: ");
                    int nuevoPokemon = scanner.nextInt();
                    switch (nuevoPokemon) {
                        case 1: jugador.cambiarPokemon(pikachu); break;
                        case 2: jugador.cambiarPokemon(charmander); break;
                        case 3: jugador.cambiarPokemon(bulbasaur); break;
                        case 4: jugador.cambiarPokemon(squirtle); break;
                        default: System.out.println("Opción no válida."); break;
                    }
                    break;

                case 4: // Ver Pokémon actual
                    jugador.mostrarPokemon();
                    break;

                case 5: // Ir a la batalla
                    System.out.println("¡La batalla comienza ahora!");
                    // Aquí iría el código para iniciar la batalla (en el siguiente avance).
                    break;

                case 6: // Salir
                    System.out.println("¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }

    }
}

