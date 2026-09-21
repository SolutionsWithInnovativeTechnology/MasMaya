package Util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class BD {
    private static Connection Conection;
    private static Statement Consulta;
    private static ResultSet Resultado;

    private final String bd;
    private final String user;
    private final String password;

    private String SQL_AGREGAR = "INSERT INTO jugadores (usuario, contrasenia, "
            + "puntuacion) VALUES (?, ?, 0)";
    private String SQL_LOGIN = "SELECT * FROM jugadores WHERE (usuario, "
            + "contrasenia) = (?, ?)";
    private String SQL_PUNTUACIONES = "SELECT usuario, puntuacion "
            + "FROM jugadores ORDER BY puntuacion DESC";
    private String SQL_ACTUALIZAR_PUNTUACION = "UPDATE jugadores "
            + "SET puntuacion = ? WHERE (usuario = ?)";

    public BD(String bd, String user, String password) {
        this.bd = bd;
        this.user = user;
        this.password = password;
    }

    public boolean conectar() {
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Conection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/" + bd, user, password);
            return Conection != null;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException |
                 NoSuchMethodException | SecurityException | InvocationTargetException | SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {
            BD.Conection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Jugador agregarJugador(String us, String pw) {
        Jugador jugador;
        PreparedStatement pst;
        try {
            pst = Conection.prepareStatement(SQL_AGREGAR);
            pst.setString(1, us);
            pst.setString(2, pw);
            pst.executeUpdate();
            jugador = new Jugador(us, pw);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getErrorCode() == 1062) {
                jugador = new Jugador(" ", "");
                return jugador;
            } else {
                return null;
            }
        }
        return jugador;
    }

    public Jugador loginJugador(String us, String pw) {
        Jugador jugador;
        PreparedStatement pst;
        try {
            pst = Conection.prepareStatement(SQL_LOGIN);
            pst.setString(1, us);
            pst.setString(2, pw);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jugador = new Jugador(rs.getString("usuario"), rs.getString("contrasenia"));
                jugador.setPuntuacion(rs.getInt("puntuacion"));
            } else {
                jugador = new Jugador(" ", "");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return jugador;
    }

    public ArrayList cargarPuntuaciones() {
        ArrayList<Jugador> Jugadores = new ArrayList<>();
        try {
            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery(SQL_PUNTUACIONES);
            while (Resultado.next()) {
                Jugador nJugador = new Jugador(Resultado.getString("usuario"), "");
                nJugador.setPuntuacion(Resultado.getInt("puntuacion"));
                Jugadores.add(nJugador);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return Jugadores;
    }

    public void actualizarPuntuacion(Jugador jugador) {
        PreparedStatement pst;
        try {
            pst = Conection.prepareStatement(SQL_ACTUALIZAR_PUNTUACION);
            pst.setInt(1, jugador.getPuntuacion());
            pst.setString(2, jugador.getUsuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
