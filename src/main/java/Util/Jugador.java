package Util;

public class Jugador {
    private String usuario = "";
    private String contrasenia = "";
    private int puntuacion = 0;
    private boolean offline = false;

    public Jugador(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void actualizarPuntuacion(int puntuacion) {
        this.puntuacion += puntuacion;
        if (this.puntuacion < 0) {
            this.puntuacion = 0;
        }
    }

    public boolean isOffline() {
        return offline;
    }

    public void offline() {
        this.offline = true;
    }
}
