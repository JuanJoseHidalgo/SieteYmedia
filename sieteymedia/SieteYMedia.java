package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    private final Baraja baraja;
    private final Carta[] cartasJugador;
    private final Carta[] cartasBanca;

    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar();
        // se van pidiendo cartas al jugar, pero matemáticamente a partir de 15 siempre
        // nos pasamos
        // hay 12 cartas de valor medio punto, si sacara estas 12 luego cartas con valor 1
        // vemos que a partir de 15 cartas siempre se pasa
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }

    public void jugar(InterfaceConsola consola) {
        consola.mostrarMensaje("Inicio del juego");
        turnoJugador(consola);
        turnoBanca(consola);
        consola.mostrarMensaje("Adios");
    }

    private void turnoJugador(InterfaceConsola consola) {
        char opc = 'C';
        consola.mostrarMensaje("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasJugador, c);
            consola.mostrarCartas("Tus cartas", cartasJugador);
            double valor = valorCartas(cartasJugador);
            consola.mostrarMensaje("Valor de cartas: " + valor);
            if (valor < 7.5) {
                opc = consola.pedirOpcion();
            }
        }
    }

    private void turnoBanca(InterfaceConsola consola) {
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            consola.mostrarMensaje("Jugador, te has pasado en tu jugada anterior, gana la banca");
            return;
        }
        consola.mostrarMensaje("\n\nTurno de banca ...");
        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
        consola.mostrarCartas("Cartas de la banca", cartasBanca);
        double valorBanca = valorCartas(cartasBanca);
        consola.mostrarMensaje("Valor de mis cartas (banca): " + valorBanca);
        if (valorBanca > 7.5) {
            consola.mostrarMensaje("Me pasé, ganas tú, jugador");
        } else {
            consola.mostrarMensaje("Gana la banca");
        }
    }

    private double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int i = 0;
        while (cartas[i] != null) {
            int val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }
        return total;
    }

    private void insertarCartaEnArray(Carta[] cartas, Carta c) {
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }
}