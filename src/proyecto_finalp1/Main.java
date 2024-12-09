/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author aless
 */

public class Main {

public static void logica(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Entrenador entrenador = new Entrenador("Ash");  // Nombre por defecto

    // Solicitar nombre del entrenador
    entrenador.setNombre(pedirNombreEntrenador());

    while (true) {
        System.out.println("Menú:");
        System.out.println("1. Elegir Pokémon");
        System.out.println("2. Mejorar Pokémon");
        System.out.println("3. Cambiar Pokémon");
        System.out.println("4. Ver Pokémon Actual");
        System.out.println("5. Ver Equipo");
        System.out.println("6. Iniciar Batalla");
        System.out.println("7. Salir");

        int opcion = validarEntrada(scanner, 1, 7);
        switch (opcion) {
            case 1:
                elegirPokemon(scanner, entrenador);
                break;
            case 2:
                mejorarPokemon(scanner, entrenador);
                break;
            case 3:
                cambiarPokemon(scanner, entrenador);
                break;
            case 4:
                verPokemonActual(entrenador);
                break;
            case 5:
                mostrarEquipo(entrenador);
                break;
            case 6:
                iniciarBatalla(entrenador);
                break;
            case 7:
                System.out.println("Saliendo...");
                return; // Sale del programa
        }
    }
}

// Validación de entrada
private static int validarEntrada(Scanner scanner, int min, int max) {
    int opcion = 0;
    while (true) {
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            if (opcion >= min && opcion <= max) {
                break;
            }
        }
        System.out.printf("Por favor, ingresa un número entre %d y %d: ", min, max);
        scanner.nextLine();  // Limpiar el buffer
    }
    return opcion;
}

// Método para pedir el nombre del entrenador
private static String pedirNombreEntrenador() {
    return JOptionPane.showInputDialog("Por favor, ingresa el nombre del entrenador:");
}

// Función para elegir un Pokémon
private static void elegirPokemon(Scanner scanner, Entrenador entrenador) {
    System.out.println("Selecciona tu Pokémon:");
    System.out.println("1. Pikachu 2. Charmander 3. Bulbasaur 4. Squirtle");
    int opcion = validarEntrada(scanner, 1, 4);
    Pokemon pokemon = switch (opcion) {
        case 1 -> new Pokemon("Pikachu", 100, 50);
        case 2 -> new Pokemon("Charmander", 120, 40);
        case 3 -> new Pokemon("Bulbasaur", 110, 45);
        case 4 -> new Pokemon("Squirtle", 90, 60);
        default -> throw new IllegalStateException("Opción invalida");
    };
    entrenador.agregarPokemon(pokemon);
    System.out.printf("¡Has elegido a %s! \n", pokemon.getNombre());
}

// Función para mejorar un Pokémon
private static void mejorarPokemon(Scanner scanner, Entrenador entrenador) {
    if (entrenador.getEquipo().isEmpty()) {
        System.out.println("No tienes Pokémon para mejorar.");
        return;
    }
    Pokemon actual = entrenador.getPokemonActual();
    System.out.println("Mejorando Pokémon...");
    System.out.println("1. Incrementar ataque 2. Incrementar salud");
    int opcion = validarEntrada(scanner, 1, 2);
    if (opcion == 1) {
        actual.setAtaque(actual.getAtaque() + 10);
        System.out.println("¡Ataque incrementado en 10 puntos!");
    } else {
        actual.setSalud(actual.getSalud() + 20);
        System.out.println("¡Salud incrementada en 20 puntos!");
    }
}

// Función para cambiar un Pokémon
private static void cambiarPokemon(Scanner scanner, Entrenador entrenador) {
    if (entrenador.getEquipo().size() < 2) {
        System.out.println("No tienes suficientes Pokémon para cambiar.");
        return;
    }
    System.out.println("Elige el índice del Pokémon al que deseas cambiar:");
    for (int i = 0; i < entrenador.getEquipo().size(); i++) {
        System.out.printf("%d. %s  ", i + 1, entrenador.getEquipo().get(i).getNombre());
    }
    int opcion = validarEntrada(scanner, 1, entrenador.getEquipo().size());
    entrenador.setPokemonActual(opcion - 1);
    System.out.printf("¡Has cambiado a %s!  ", entrenador.getPokemonActual().getNombre());
}

// Función para ver el Pokémon actual
private static void verPokemonActual(Entrenador entrenador) {
    if (entrenador.getEquipo().isEmpty()) {
        System.out.println("No tienes Pokémon.");
    } else {
        System.out.println(entrenador.getPokemonActual());
    }
}

// Función para mostrar el equipo del entrenador
private static void mostrarEquipo(Entrenador entrenador) {
    System.out.println("Equipo de " + entrenador.getNombre() + ":");
    if (entrenador.getEquipo().isEmpty()) {
        System.out.println("No tienes Pokémon.");
    } else {
        for (Pokemon pokemon : entrenador.getEquipo()) {
            System.out.println(pokemon);
        }
    }
}

// Función para iniciar la batalla
private static void iniciarBatalla(Entrenador entrenador) {
    if (entrenador.getEquipo().isEmpty()) {
        System.out.println("No tienes Pokémon para la batalla.");
        return;
    }
    Pokemon enemigo = new Pokemon("Enemigo", (int) (Math.random() * 100) + 50, (int) (Math.random() * 50) + 30);
    Pokemon jugador = entrenador.getPokemonActual();

    System.out.printf("¡Batalla entre %s y %s! ", jugador.getNombre(), enemigo.getNombre());
    while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
        enemigo.setSalud(enemigo.getSalud() - jugador.getAtaque());
        if (enemigo.getSalud() > 0) {
            jugador.setSalud(jugador.getSalud() - enemigo.getAtaque());
        }
    }
    if (jugador.getSalud() > 0) {
        System.out.println("¡Has ganado!");
    } else {
        System.out.println("Has perdido...");
    }
}
}
