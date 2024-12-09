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
private Entrenador entrenador;
private JTextArea areaTexto;
private JTextField nombreTextField;

public GUI() {
    // Configuración básica de la ventana
    setTitle("Simulador de Batalla Pokémon");
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Crear y configurar el área de texto para mostrar la información
    areaTexto = new JTextArea();
    areaTexto.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(areaTexto);
    add(scrollPane, BorderLayout.CENTER);

    // Panel para botones y campos de texto
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 1));

    // Campo de texto para ingresar el nombre del entrenador
    panel.add(new JLabel("Nombre del Entrenador:"));
    nombreTextField = new JTextField();
    panel.add(nombreTextField);

    // Botón para setear el nombre del entrenador
    JButton setNombreButton = new JButton("Setear Nombre");
    setNombreButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setNombreEntrenador();
        }
    });
    panel.add(setNombreButton);

    // Botón para elegir un Pokémon
    JButton elegirButton = new JButton("Elegir Pokémon");
    elegirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elegirPokemon();
        }
    });
    panel.add(elegirButton);

    // Botón para mejorar un Pokémon
    JButton mejorarButton = new JButton("Mejorar Pokémon");
    mejorarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mejorarPokemon();
        }
    });
    panel.add(mejorarButton);

    // Botón para ver el equipo del entrenador
    JButton verEquipoButton = new JButton("Ver Equipo");
    verEquipoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarEquipo();
        }
    });
    panel.add(verEquipoButton);

    // Botón para iniciar batalla
    JButton batallaButton = new JButton("Iniciar Batalla");
    batallaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            iniciarBatalla();
        }
    });
    panel.add(batallaButton);

    // Botón para salir
    JButton salirButton = new JButton("Salir");
    salirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            salir();
        }
    });
    panel.add(salirButton);

    add(panel, BorderLayout.SOUTH);

    // Inicializar el entrenador con un nombre predeterminado
    entrenador = new Entrenador("Ash");
    setVisible(true);
}

// Método para setear el nombre del entrenador
private void setNombreEntrenador() {
    String nombre = nombreTextField.getText();
    if (!nombre.isEmpty()) {
        entrenador.setNombre(nombre);
        areaTexto.setText("¡Hola, " + nombre + "! Ahora eres el entrenador.\n");
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre.");
    }
}

// Método para elegir un Pokémon
private void elegirPokemon() {
    String[] opciones = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle"};
    String seleccion = (String) JOptionPane.showInputDialog(
            this,
            "Selecciona un Pokémon:",
            "Elegir Pokémon",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
    );

    if (seleccion != null) {
        Pokemon pokemon = switch (seleccion) {
            case "Pikachu" -> new Pokemon("Pikachu", 100, 50);
            case "Charmander" -> new Pokemon("Charmander", 120, 40);
            case "Bulbasaur" -> new Pokemon("Bulbasaur", 110, 45);
            case "Squirtle" -> new Pokemon("Squirtle", 90, 60);
            default -> throw new IllegalStateException("Opción no válida");
        };
        entrenador.agregarPokemon(pokemon);
        areaTexto.setText("¡Has elegido a " + pokemon.getNombre() + "!\n");
    }
}

// Método para mejorar un Pokémon (ataque o salud)
private void mejorarPokemon() {
    if (entrenador.getEquipo().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No tienes Pokémon para mejorar.");
        return;
    }

    Pokemon actual = entrenador.getPokemonActual();
    String[] opciones = {"Incrementar Ataque", "Incrementar Salud"};
    String seleccion = (String) JOptionPane.showInputDialog(
            this,
            "¿Qué deseas mejorar?",
            "Mejorar Pokémon",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
    );

    if (seleccion != null) {
        if (seleccion.equals("Incrementar Ataque")) {
            actual.setAtaque(actual.getAtaque() + 10);
            areaTexto.setText("¡El ataque de " + actual.getNombre() + " ha aumentado en 10 puntos!\n");
        } else if (seleccion.equals("Incrementar Salud")) {
            actual.setSalud(actual.getSalud() + 20);
            areaTexto.setText("¡La salud de " + actual.getNombre() + " ha aumentado en 20 puntos!\n");
        }
    }
}

// Método para mostrar el equipo del entrenador
private void mostrarEquipo() {
    StringBuilder sb = new StringBuilder("Equipo de " + entrenador.getNombre() + ":\n");
    if (entrenador.getEquipo().isEmpty()) {
        sb.append("No tienes Pokémon.");
    } else {
        for (Pokemon pokemon : entrenador.getEquipo()) {
            sb.append(pokemon).append("\n");
        }
    }
    areaTexto.setText(sb.toString());
}

// Método para iniciar la batalla
private void iniciarBatalla() {
    if (entrenador.getEquipo().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No tienes Pokémon para la batalla.");
        return;
    }
    Pokemon enemigo = new Pokemon("Enemigo", (int) (Math.random() * 100) + 50, (int) (Math.random() * 50) + 30);
    Pokemon jugador = entrenador.getPokemonActual();

    areaTexto.setText("¡Batalla entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!\n");

    while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
        enemigo.setSalud(enemigo.getSalud() - jugador.getAtaque());
        if (enemigo.getSalud() > 0) {
            jugador.setSalud(jugador.getSalud() - enemigo.getAtaque());
        }
    }

    if (jugador.getSalud() > 0) {
        areaTexto.append("¡Has ganado!\n");
    } else {
        areaTexto.append("Has perdido...\n");
    }
}

// Método para salir de la aplicación
private void salir() {
    int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
    if (opcion == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
}

public static void main(String[] args) {
    new GUI();
}
}

