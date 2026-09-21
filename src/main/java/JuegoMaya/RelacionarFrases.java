package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RelacionarFrases extends javax.swing.JFrame {
    private String[][] frases = {{"Bet uts", "Por favor"}, {"In yakumeech", "Te amo"}, {"Mix ba´al", "De nada"}, {"Bix a beel", "¿Cómo estás?"}, {"Kanáantabaj", "Cuídate"},
            {"Ka´akate´", "Más tarde"}, {"Tu'ux ka bin", "¿A dónde vas?"}, {"In k'aabae'", "Me llamo"}, {"Luba'an in wóol", "Estoy triste"}};

    private int[] palabras = new int[3];
    private int intentos;
    private boolean botonPresionado;
    private boolean primerB;
    private String fraseMaya;
    private String fraseEspaniol;
    private JButton[] pbtn = new JButton[2];
    private String[] opciones = new String[6];
    private String ultimaPalabra = "";
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    BD mBD;

    public RelacionarFrases(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");

        initComponents();
        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnImgSoporte);
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

    Timer timer = new Timer(250, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (botonPresionado && primerB) {
                boolean resultado = false;
                for (int i = 0; i < 3; i++) {
                    if ((fraseMaya.equals(opciones[i])) && (fraseEspaniol.equals(opciones[i + 3]))) {
                        resultado = true;
                        break;
                    }
                }
                if (resultado) {
                    pbtn[0].setBorderPainted(true);
                    pbtn[0].setEnabled(false);
                    pbtn[1].setBorderPainted(true);
                    pbtn[1].setEnabled(false);
                } else if (intentos > 0) {
                    intentos--;
                    lblIntentos.setText(intentos + "");
                } else {
                    intentos--;
                }

                if (ultimaPalabra.equals("Maya")) {
                    if (!opcion4.isBorderPainted()) opcion4.setEnabled(true);
                    if (!opcion5.isBorderPainted()) opcion5.setEnabled(true);
                    if (!opcion6.isBorderPainted()) opcion6.setEnabled(true);
                } else {
                    if (!opcion1.isBorderPainted()) opcion1.setEnabled(true);
                    if (!opcion2.isBorderPainted()) opcion2.setEnabled(true);
                    if (!opcion3.isBorderPainted()) opcion3.setEnabled(true);
                }
                comprobarGanador();
                if (intentos < 0) {
                    perder();
                }
                botonPresionado = false;
            }
        }
    });

    private void comenzarJuego() {
        botonPresionado = false;
        primerB = false;
        opcion1.setBorderPainted(false);
        opcion2.setBorderPainted(false);
        opcion3.setBorderPainted(false);
        opcion4.setBorderPainted(false);
        opcion5.setBorderPainted(false);
        opcion6.setBorderPainted(false);

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
        Random random = new Random();
        palabras[0] = 9;
        palabras[1] = 9;
        palabras[2] = 9;

        int cont = 0;
        int aleatorio;
        boolean repetido;
        while (cont < 3) {
            aleatorio = random.nextInt(frases.length);
            repetido = false;
            for (int i = 0; i < 3; i++) {
                if (palabras[i] == aleatorio) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                palabras[cont] = aleatorio;
            } else {
                cont--;
            }
            cont++;
        }

        opciones[0] = frases[palabras[0]][0];
        opciones[1] = frases[palabras[1]][0];
        opciones[2] = frases[palabras[2]][0];
        opciones[3] = frases[palabras[0]][1];
        opciones[4] = frases[palabras[1]][1];
        opciones[5] = frases[palabras[2]][1];

        String[] botones = {"", "", "", "", "", ""};
        cont = 0;
        while (cont < 3) {
            aleatorio = random.nextInt(3);
            repetido = false;
            for (int i = 0; i < 3; i++) {
                if (botones[i].equals(opciones[aleatorio])) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                botones[cont] = opciones[aleatorio];
            } else {
                cont--;
            }
            cont++;
        }
        cont = 3;
        while (cont < 6) {
            aleatorio = random.nextInt(3) + 3;
            repetido = false;
            for (int i = 3; i < 6; i++) {
                if (botones[i].equals(opciones[aleatorio])) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                botones[cont] = opciones[aleatorio];
            } else {
                cont--;
            }
            cont++;
        }

        opcion1.setText(botones[0]);
        opcion2.setText(botones[1]);
        opcion3.setText(botones[2]);
        opcion4.setText(botones[3]);
        opcion5.setText(botones[4]);
        opcion6.setText(botones[5]);
        opcion1.setEnabled(true);
        opcion2.setEnabled(true);
        opcion3.setEnabled(true);
        opcion4.setEnabled(true);
        opcion5.setEnabled(true);
        opcion6.setEnabled(true);
        timer.start();
    }

    private void btnEnabled(JButton btn, String lenguaje) {
        ultimaPalabra = lenguaje;
        if (!botonPresionado) {
            if (ultimaPalabra.equals("Maya")) {
                fraseMaya = btn.getText();
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
            } else {
                fraseEspaniol = btn.getText();
                opcion4.setEnabled(false);
                opcion5.setEnabled(false);
                opcion6.setEnabled(false);
            }

            pbtn[0] = btn;
            botonPresionado = true;
            primerB = false;
        } else {
            if (ultimaPalabra.equals("Maya")) {
                fraseMaya = btn.getText();
            } else {
                fraseEspaniol = btn.getText();
            }
            pbtn[1] = btn;
            primerB = true;

        }

    }

    private void comprobarGanador() {
        if (opcion1.isBorderPainted() && opcion2.isBorderPainted() &&
                opcion3.isBorderPainted() && opcion4.isBorderPainted() &&
                opcion5.isBorderPainted() && opcion6.isBorderPainted()) {
            if (intentos == 0 && jugador.getPuntuacion() >= 10) {
                puntuacion(10);
                new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/draw.wav");
                JOptionPane.showMessageDialog(this, "Ganaste 10 puntos.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
                JOptionPane.showMessageDialog(this, "Felicidades, ganaste 20 puntos.", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                puntuacion(20);
            }
            timer.stop();
            comenzarJuego();
        }
    }

    private void perder() {
        new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/lose.wav");
        JOptionPane.showMessageDialog(this, "Has perdido. Tu puntaje es: 0", "Perdiste :(", JOptionPane.INFORMATION_MESSAGE);
        opcion1.setEnabled(false);
        opcion2.setEnabled(false);
        opcion3.setEnabled(false);
        opcion4.setEnabled(false);
        opcion5.setEnabled(false);
        opcion6.setEnabled(false);
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
        opcion1 = new javax.swing.JButton();
        opcion2 = new javax.swing.JButton();
        opcion3 = new javax.swing.JButton();
        reiniciar = new javax.swing.JButton();
        lblintentos = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        opcion4 = new javax.swing.JButton();
        opcion5 = new javax.swing.JButton();
        opcion6 = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELACIONA FRASES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 66, 379, -1));

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
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setBorder(null);
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 0, 188, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 33, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 33, 49, 15));

        opcion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion1.setText("jButton1");
        opcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 155, 147, -1));

        opcion2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion2.setText("jButton2");
        opcion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 221, 147, -1));

        opcion3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion3.setText("jButton3");
        opcion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 286, 147, -1));

        reiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        reiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 404, -1, -1));

        lblintentos.setText("Intentos:");
        jPanel1.add(lblintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 410, -1, -1));

        lblIntentos.setText("1");
        jPanel1.add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 410, 37, -1));

        opcion4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion4.setText("jButton4");
        opcion4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 155, 147, -1));

        opcion5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion5.setText("jButton5");
        opcion5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion5ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 221, 147, -1));

        opcion6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion6.setText("jButton6");
        opcion6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion6ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 286, 147, -1));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrasesComunes regresar = new JuegosFrasesComunes(jugador);
        regresar.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Presiona la frase en maya y a continuación \npresiona la frase en español que le corresponde \n", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion1, "Maya");
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion2, "Maya");
    }//GEN-LAST:event_opcion2ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion3, "Maya");
    }//GEN-LAST:event_opcion3ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        timer.stop();
        comenzarJuego();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void opcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion4, "Español");
    }//GEN-LAST:event_opcion4ActionPerformed

    private void opcion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion5ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion5, "Español");
    }//GEN-LAST:event_opcion5ActionPerformed

    private void opcion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion6ActionPerformed
        if (!(botonPresionado && primerB)) btnEnabled(opcion6, "Español");
    }//GEN-LAST:event_opcion6ActionPerformed

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
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblintentos;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JButton opcion1;
    private javax.swing.JButton opcion2;
    private javax.swing.JButton opcion3;
    private javax.swing.JButton opcion4;
    private javax.swing.JButton opcion5;
    private javax.swing.JButton opcion6;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables
}
