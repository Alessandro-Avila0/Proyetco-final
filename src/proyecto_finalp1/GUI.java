/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_finalp1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author aless
 */
   public class GUI extends JFrame {
    // cosas necesarias para la interfaz gráfica
    private Entrenador entrenador; // El objeto Entrenador que contiene la lógica del juego
    private JTextArea textArea; // Área de texto donde se mostrarán los mensajes y resultados
    private JComboBox<String> pokemonComboBox; // ComboBox para la selección de Pokémon
    private JButton elegirPokemonButton, mejorarPokemonButton, cambiarPokemonButton, verEquipoButton, iniciarBatallaButton, salirButton;

    // Constructor de la clase GUI
    public GUI() {
        // Configuración de la ventana principal
        setTitle("Juego Pokémon");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Inicialización del objeto Entrenador, el nombre inicial es "Ash"
        entrenador = new Entrenador("Ash");

        // Configuración del área de texto para mostrar información y resultados
        textArea = new JTextArea(10, 40);
        textArea.setEditable(false); // No editable para que el usuario solo vea la salida
        JScrollPane scrollPane = new JScrollPane(textArea); // Añadir scroll en caso de que el texto se exceda
        add(scrollPane);

        // Botones de las opciones que el jugador podrá seleccionar
        elegirPokemonButton = new JButton("Elegir Pokémon");
        mejorarPokemonButton = new JButton("Mejorar Pokémon");
        cambiarPokemonButton = new JButton("Cambiar Pokémon");
        verEquipoButton = new JButton("Ver Equipo");
        iniciarBatallaButton = new JButton("Iniciar Batalla");
        salirButton = new JButton("Salir");

        // Añadir los botones a la interfaz gráfica
        add(elegirPokemonButton);
        add(mejorarPokemonButton);
        add(cambiarPokemonButton);
        add(verEquipoButton);
        add(iniciarBatallaButton);
        add(salirButton);

        // Pedir al jugador que ingrese su nombre
        String nombreEntrenador = JOptionPane.showInputDialog(this, "Por favor, ingresa tu nombre de entrenador:");
        // Si no se ingresa un nombre, asignar "Ash" como predeterminado
        if (nombreEntrenador != null && !nombreEntrenador.trim().isEmpty()) {
            entrenador.setNombre(nombreEntrenador); // Actualizar el nombre del entrenador
        } else {
            entrenador.setNombre("Ash");  // Nombre por defecto si no se ingresa uno
        }

        // Configuración de eventos para cada botón
        elegirPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegirPokemon(); // Llamar al método para elegir un Pokémon
            }
        });

        mejorarPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mejorarPokemon(); // Llamar al método para mejorar un Pokémon
            }
        });

        cambiarPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPokemon(); // Llamar al método para cambiar de Pokémon
            }
        });

        verEquipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verEquipo(); // Llamar al método para ver el equipo
            }
        });

        iniciarBatallaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla(); // Llamar al método para iniciar la batalla
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del juego
            }
        });
    }

    // Método para elegir un Pokémon
    private void elegirPokemon() {
        // Opciones disponibles para que el jugador elija
        String[] opciones = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle"};
        // Cuadro de diálogo para seleccionar un Pokémon
        String seleccion = (String) JOptionPane.showInputDialog(this, "Elige tu Pokémon:", "Seleccionar Pokémon", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (seleccion != null) {
            // Crear el Pokémon seleccionado
            Pokemon pokemon = switch (seleccion) {
                case "Pikachu" -> new Pokemon("Pikachu", 100, 50);
                case "Charmander" -> new Pokemon("Charmander", 120, 40);
                case "Bulbasaur" -> new Pokemon("Bulbasaur", 110, 45);
                case "Squirtle" -> new Pokemon("Squirtle", 90, 60);
                default -> throw new IllegalStateException("Opción no válida");
            };
            entrenador.agregarPokemon(pokemon); // Agregar el Pokémon al equipo del entrenador
            textArea.setText("¡Has elegido a " + pokemon.getNombre() + "!"); // Mostrar el mensaje
        }
    }

    // Método para mejorar el Pokémon
    private void mejorarPokemon() {
        if (entrenador.getEquipo().isEmpty()) {
            textArea.setText("No tienes Pokémon para mejorar."); // Mensaje si no hay Pokémon
            return;
        }
        Pokemon actual = entrenador.getPokemonActual(); // Obtener el Pokémon actual
        String[] opciones = {"Incrementar ataque", "Incrementar salud"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Elige la mejora:", "Mejorar Pokémon", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (seleccion != null) {
            // Si elige mejorar ataque
            if (seleccion.equals("Incrementar ataque")) {
                actual.setAtaque(actual.getAtaque() + 10);
                textArea.setText("¡Ataque de " + actual.getNombre() + " incrementado en 10 puntos!");
            } 
            // Si elige mejorar salud
            else {
                actual.setSalud(actual.getSalud() + 20);
                textArea.setText("¡Salud de " + actual.getNombre() + " incrementada en 20 puntos!");
            }
        }
    }

    // Método para cambiar de Pokémon
    private void cambiarPokemon() {
        if (entrenador.getEquipo().size() < 2) {
            textArea.setText("No tienes suficientes Pokémon para cambiar."); // Mensaje si no tienes suficientes Pokémon
            return;
        }
        // Mostrar los Pokémon disponibles para cambiar
        String[] opciones = new String[entrenador.getEquipo().size()];
        for (int i = 0; i < entrenador.getEquipo().size(); i++) {
            opciones[i] = entrenador.getEquipo().get(i).getNombre();
        }
        // Cuadro de diálogo para seleccionar el Pokémon
        String seleccion = (String) JOptionPane.showInputDialog(this, "Elige el Pokémon al que deseas cambiar:", "Cambiar Pokémon", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (seleccion != null) {
            // Cambiar al Pokémon seleccionado
            for (int i = 0; i < entrenador.getEquipo().size(); i++) {
                if (entrenador.getEquipo().get(i).getNombre().equals(seleccion)) {
                    entrenador.setPokemonActual(i);
                    textArea.setText("¡Has cambiado a " + seleccion + "!");
                    return;
                }
            }
        }
    }

    // Método para ver el equipo de Pokémon del entrenador
    private void verEquipo() {
        if (entrenador.getEquipo().isEmpty()) {
            textArea.setText("No tienes Pokémon."); // Mensaje si no tienes Pokémon
            return;
        }
        StringBuilder sb = new StringBuilder("Equipo:\n");
        // Mostrar todos los Pokémon en el equipo
        for (Pokemon p : entrenador.getEquipo()) {
            sb.append(p.getNombre()).append(" - Ataque: ").append(p.getAtaque()).append(" - Salud: ").append(p.getSalud()).append("\n");
        }
        textArea.setText(sb.toString()); // Mostrar en el área de texto
    }

    // Método para iniciar una batalla
    private void iniciarBatalla() {
        if (entrenador.getEquipo().isEmpty()) {
            textArea.setText("No tienes Pokémon para la batalla."); // Mensaje si no tienes Pokémon
            return;
        }
        // Crear un Pokémon enemigo con atributos aleatorios
        Pokemon enemigo = new Pokemon("Enemigo", (int) (Math.random() * 100) + 50, (int) (Math.random() * 50) + 30);
        Pokemon jugador = entrenador.getPokemonActual(); // Obtener el Pokémon actual del entrenador

        // Crear mensaje de batalla
        StringBuilder sb = new StringBuilder();
        sb.append("¡Batalla entre ").append(jugador.getNombre()).append(" y ").append(enemigo.getNombre()).append("!\n");

        // Simulación de la batalla
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            sb.append(jugador.getNombre()).append(" ataca a ").append(enemigo.getNombre()).append(" con ").append(jugador.getAtaque()).append(" puntos de daño.\n");
            enemigo.setSalud(enemigo.getSalud() - jugador.getAtaque());
            if (enemigo.getSalud() > 0) {
                sb.append(enemigo.getNombre()).append(" ataca a ").append(jugador.getNombre()).append(" con ").append(enemigo.getAtaque()).append(" puntos de daño.\n");
                jugador.setSalud(jugador.getSalud() - enemigo.getAtaque());
            }
        }

        // Mostrar el resultado de la batalla
        if (jugador.getSalud() > 0) {
            sb.append("¡Has ganado la batalla!");
        } else {
            sb.append("Has perdido la batalla...");
        }
        textArea.setText(sb.toString()); // Mostrar resultado en el área de texto
    }

    // Método principal para ejecutar la interfaz gráfica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true); // Mostrar la ventana
            }
        });
    }
}

