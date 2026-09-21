package Util;

public class Carta {
    private int numero;
    private boolean habilitada;
    private int id;

    public Carta(int numero, int id) {
        this.numero = numero;
        this.habilitada = true;
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public int getId() {
        return id;
    }
}