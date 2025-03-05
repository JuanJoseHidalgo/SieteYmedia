package sieteymedia;

import java.util.Scanner;
import recursos.Carta;

public class InterfaceConsola {
    private Scanner sc;

    public InterfaceConsola() {
        sc = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarCartas(String titulo, Carta[] cartas) {
        System.out.println(titulo + ":");
        int i = 0;
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
        System.out.println();
    }

    public char pedirOpcion() {
        System.out.println("¿Pides [C]arta o te [P]lantas?");
        return sc.next().trim().toUpperCase().charAt(0);
    }

    public static void main(String[] args) {
        SieteYMedia juego = new SieteYMedia();
        InterfaceConsola consola = new InterfaceConsola();
        consola.mostrarMensaje("- El usuario es el jugador y el ordenador la banca.");
        consola.mostrarMensaje("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
        consola.mostrarMensaje("- Las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
        consola.mostrarMensaje("- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
        consola.mostrarMensaje("- El jugador va pidiendo cartas a la banca de una en una.");
        consola.mostrarMensaje("- El jugador puede plantarse en cualquier momento.");
        consola.mostrarMensaje("- Si la suma de los valores de las cartas sacadas es superior a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.");
        consola.mostrarMensaje("- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está obligada a sacar cartas hasta empatar o superar al jugador.");
        consola.mostrarMensaje("- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
        consola.mostrarMensaje("- La banca no se puede plantar y tiene que empatar o superar la puntuación del jugador sin pasarse.");
        consola.mostrarMensaje("- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
        consola.mostrarMensaje("\nEmpecemos!!!\n");
        juego.jugar(consola);
    }
}