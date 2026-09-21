package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Random;

public class OrdenaPalabras extends javax.swing.JFrame {

    BD mBD;
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    private String[][] palabras = {{"ki'imak", "in", "wóol", "Estoy feliz"}, {"luba'an", "in", "wóol", "Estoy triste"},
            {"bix u k'", "aaba'", "a na'", "¿Cómo se llama tu papá?"}, {"bix u k'", "aaba'", "yuum", "¿Cómo se llama tu mamá?"},
            {"in", "k'aaba", "'e'", "Me llamo"}, {"tu'ux", "ka", "bin", "¿A dónde vas?"}, {"jach", "níib", "óolal", "Muchas gracias"}};
    private int palabra;
    int intentos;
    private int palabraActual;
    private String[] opciones = new String[3];

    public OrdenaPalabras(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");
        initComponents();

        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }

        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnImgSoporte);
        Botones.transparenciaButtonBorder(opcion1);
        Botones.transparenciaButtonBorder(opcion2);
        Botones.transparenciaButtonBorder(opcion3);
        Botones.transparenciaButtonBorder(reiniciar);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }
        comenzarJuego();
        setResizable(false);
    }

    private void comenzarJuego() {
        if (jugador.getPuntuacion() == 0) {
            lblintentos.setVisible(false);
            lblIntentos.setVisible(false);
            intentos = 0;
        } else {
            intentos = 1;
            lblintentos.setVisible(true);
            lblIntentos.setVisible(true);
        }

        lblIntentos.setText(intentos + "");
        palabraActual = 0;
        Random random = new Random();
        palabra = random.nextInt(palabras.length);
        palabrap1.setText("          ");
        palabrap2.setText("          ");
        palabrap3.setText("          ");
        lblPalabra.setText(palabras[palabra][3]);
        opciones[0] = palabras[palabra][0];
        opciones[1] = palabras[palabra][1];
        opciones[2] = palabras[palabra][2];

        String[] botones = {"", "", ""};
        int cont = 0;
        while (cont < 3) {
            int opcionAl = random.nextInt(3);
            boolean repetido = false;
            for (int i = 0; i < 3; i++) {
                if (botones[i].equals(opciones[opcionAl])) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                botones[cont] = opciones[opcionAl];
            } else {
                cont--;
            }
            cont++;
        }
        opcion1.setText(botones[0]);
        opcion2.setText(botones[1]);
        opcion3.setText(botones[2]);
        opcion1.setEnabled(true);
        opcion2.setEnabled(true);
        opcion3.setEnabled(true);
    }

    private boolean comprobarPalabra(String palabraB) {
        boolean resultado = palabras[palabra][palabraActual].equals(palabraB);
        if (resultado) {
            switch (palabraActual) {
                case 0:
                    palabrap1.setText(palabraB);
                    break;
                case 1:
                    palabrap2.setText(palabraB);
                    break;
                case 2:
                    palabrap3.setText(palabraB);
                    break;
            }
            palabraActual++;
            if (palabraActual > 2) {
                new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
                JOptionPane.showMessageDialog(this, "Felicidades, ganaste 20 puntos.", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                puntuacion(20);
                comenzarJuego();
            }
        } else if (intentos > 0 && jugador.getPuntuacion() > 0) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/error.wav");
            JOptionPane.showMessageDialog(this, "Vuelve a intentarlo ", "Respuesta incorrecta", JOptionPane.INFORMATION_MESSAGE);
            intentos--;
            lblIntentos.setText(intentos + "");
            puntuacion(-10);
        } else {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/lose.wav");
            JOptionPane.showMessageDialog(this, "Has perdido. Tu puntaje es: 0", "Perdiste :(", JOptionPane.INFORMATION_MESSAGE);
            opcion1.setEnabled(false);
            opcion2.setEnabled(false);
            opcion3.setEnabled(false);
        }
        return resultado;
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();
        btnImgSoporte = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        palabrap1 = new javax.swing.JLabel();
        palabrap2 = new javax.swing.JLabel();
        opcion1 = new javax.swing.JButton();
        opcion2 = new javax.swing.JButton();
        opcion3 = new javax.swing.JButton();
        reiniciar = new javax.swing.JButton();
        lblPalabra = new javax.swing.JLabel();
        lblintentos = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        palabrap3 = new javax.swing.JLabel();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDENA PALABRAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 66, 397, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setBorder(null);
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 37));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setBorder(null);
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setBorder(null);
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 0, 188, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 33, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 33, 49, 15));

        Font font = new Font("Segoe UI", Font.BOLD, 24);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        palabrap1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        palabrap1.setFont(font.deriveFont(attributes));
        palabrap1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        palabrap1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(palabrap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 194, 98, 29));

        //Font font = new Font("Segoe UI", Font.BOLD, 24);
        //Map attributes = font.getAttributes();
        //attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        palabrap2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        palabrap2.setFont(font.deriveFont(attributes));
        palabrap2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        palabrap2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(palabrap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 194, 96, 29));

        opcion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion1.setText("pt1");
        opcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 296, 71, -1));

        opcion2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion2.setText("pt2");
        opcion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 296, 68, -1));

        opcion3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion3.setText("pt3");
        opcion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 296, 72, -1));

        reiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        reiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 377, 83, -1));

        lblPalabra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 134, 521, 29));

        lblintentos.setText("Intentos:");
        jPanel1.add(lblintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 360, -1, -1));

        lblIntentos.setText("1");
        jPanel1.add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 360, 37, -1));

        //Font font = new Font("Segoe UI", Font.BOLD, 24);
        //Map attributes = font.getAttributes();
        //attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        palabrap3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        palabrap3.setFont(font.deriveFont(attributes));
        palabrap3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        palabrap3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(palabrap3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 194, 98, 29));

        btnSonido.setBackground(new java.awt.Color(219, 239, 254));
        btnSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_sonido.png"))); // NOI18N
        btnSonido.setBorder(null);
        btnSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSonido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_sonido1.png"))); // NOI18N
        btnSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrasesComunes regresar = new JuegosFrasesComunes(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Ordena las palabras en maya presionando los \nbotones de abajo en el orden correcto respecto \na la traducción en español", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        if (comprobarPalabra(opcion1.getText())) {
            if (palabraActual != 0) {
                opcion1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        if (comprobarPalabra(opcion2.getText())) {
            if (palabraActual != 0) {
                opcion2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_opcion2ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        if (comprobarPalabra(opcion3.getText())) {
            if (palabraActual != 0) {
                opcion3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_opcion3ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        comenzarJuego();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void btnSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonidoActionPerformed
        if (!reproductor.isMusicPlaying()) {
            reproductor.cargarSonido("/sonidos/bgMusic.wav");
            reproductor.fadeIn(0.3f, 1000);
            reproductor.reproducirEnBucle();
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
            reproductor.setPlaying(true);
        } else {
            reproductor.fadeOut(1000);
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    reproductor.detener();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
            reproductor.setPlaying(false);
        }
    }//GEN-LAST:event_btnSonidoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(completarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(completarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(completarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(completarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new completarPalabras(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblPalabra;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblintentos;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JButton opcion1;
    private javax.swing.JButton opcion2;
    private javax.swing.JButton opcion3;
    private javax.swing.JLabel palabrap1;
    private javax.swing.JLabel palabrap2;
    private javax.swing.JLabel palabrap3;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables
}
