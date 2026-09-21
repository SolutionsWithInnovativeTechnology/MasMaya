package Util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartonGenerator {
    private static final int NUM_CARTAS = 16;
    private static final int NUM_BOTONES = 9;

    public List<Carta> generarCarton() {
        List<Carta> carton = new ArrayList<>();
        List<Integer> numerosDisponibles = new ArrayList<>();

        // Generar una lista con los números del 1 al NUM_CARTAS
        for (int i = 1; i <= NUM_CARTAS; i++) {
            numerosDisponibles.add(i);
        }

        // Mezclar la lista para obtener un orden aleatorio
        Collections.shuffle(numerosDisponibles);

        // Seleccionar los primeros NUM_BOTONES números de la lista mezclada para el cartón
        for (int i = 0; i < NUM_BOTONES; i++) {
            int numero = numerosDisponibles.get(i);
            carton.add(new Carta(numero, numero));
        }

        return carton;
    }

    public List<ImageIcon> cargarImagenes() {
        List<ImageIcon> listaImagenes = new ArrayList<>();
        for (int i = 1; i <= NUM_CARTAS; i++) {
            listaImagenes.add(new ImageIcon(getClass().getResource("/imgLoteria/" + i + ".png")));
        }
        return listaImagenes;
    }

    public void establecerCarton(List<Carta> carton, List<ImageIcon> listaImagenes, List<JButton> botones) {
        for (int i = 0; i < carton.size(); i++) {
            Carta carta = carton.get(i);
            int idCarta = carta.getId(); // Obtener el identificador único de la carta

            // Asociar el identificador único con la imagen del botón
            botones.get(i).putClientProperty("id", idCarta);
            botones.get(i).setIcon(listaImagenes.get(carta.getNumero() - 1));
        }
    }
}
