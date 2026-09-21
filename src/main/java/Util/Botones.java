package Util;

import javax.swing.*;

public class Botones {
    public static void transparenciaButton(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
    }

    public static void transparenciaButtonBorder(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
    }
}
