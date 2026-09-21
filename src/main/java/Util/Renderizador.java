package Util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Renderizador extends DefaultTableCellRenderer {
    private Jugador jugadorActual; // Jugador actual en sesión

    public Renderizador(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtén el componente de celda predeterminado
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica que el usuario de la fila sea el mismo que el del jugador actual
        Object usuarioFilaObj = table.getValueAt(row, 0); // Columna 0 es "Usuario"
        if (usuarioFilaObj != null) {
            String usuarioFila = usuarioFilaObj.toString();
            if (usuarioFila.equals(jugadorActual.getUsuario())) {
                componente.setForeground(Color.BLACK); // Texto negro
                componente.setFont(componente.getFont().deriveFont(Font.BOLD)); // Negritas
            }
        }
        return componente;
    }
}