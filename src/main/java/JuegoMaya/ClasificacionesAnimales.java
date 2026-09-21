package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ClasificacionesAnimales extends javax.swing.JFrame {

    private String[][] animales = {{"Yik’el kaab", "Aéreos"}, {"Tsíimin", "Terrestres"}, {"K’éek’en", "Terrestres"},
            {"Áayim", "Acuáticos"}, {"T’u’ul", "Terrestres"}, {"Peech", "Terrestres"}, {"Miis", "Terrestres"},
            {"I'", "Aéreos"}, {"Báalam", "Terrestres"}, {"Xooch'", "Aéreos"}, {"Turix", "Aéreos"}, {"Péepen", "Aéreos"},
            {"Soots'", "Aéreos"}, {"Ch'ejun", "Aéreos"}, {"Peek'", "Terrestres"}, {"Kay", "Acuáticos"}, {"Koj", "Terrestres"},
            {"Àak", "Acuáticos"}, {"Kéej", "Terrestres"}, {"Kaan", "Terrestres"}
    };
    //Aéreos
    //Terrestres 
    //Acuáticos
    private int[] animal = new int[6];
    private int intentos;
    private boolean botonPresionado;
    private boolean primerB;
    private String animalO;
    private String tipoO;
    private JButton[] pbtn = new JButton[2];
    private String[][] opciones = new String[6][2];
    private String ultimaPalabra = "";
    Jugador jugador;
    BD mBD;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();

    public ClasificacionesAnimales(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");

        initComponents();
        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnImgSoporte);
        Botones.transparenciaButton(btnSonido1);
        if (reproductor.isMusicPlaying()) {
            btnSonido1.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido1.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido1.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido1.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }

        Botones.transparenciaButtonBorder(reiniciar);
        comenzarJuego();
        setResizable(false);
    }

    Timer timer = new Timer(250, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (botonPresionado && primerB) {
                boolean resultado = false;
                for (int i = 0; i < 6; i++) {
                    if ((animalO.equals(opciones[i][0])) && (tipoO.equals(opciones[i][1]))) {
                        resultado = true;
                        break;
                    }
                }
                if (resultado) {
                    pbtn[0].setBorderPainted(true);
                    pbtn[0].setEnabled(false);
                } else if (intentos > 0) {
                    intentos--;
                    lblIntentos.setText(intentos + "");
                } else {
                    intentos--;
                }

                if (ultimaPalabra.equals("Animal")) {
                    opcion7.setEnabled(true);
                    opcion8.setEnabled(true);
                    opcion9.setEnabled(true);
                } else {
                    if (!opcion1.isBorderPainted()) {
                        opcion1.setEnabled(true);
                    }
                    if (!opcion2.isBorderPainted()) {
                        opcion2.setEnabled(true);
                    }
                    if (!opcion3.isBorderPainted()) {
                        opcion3.setEnabled(true);
                    }
                    if (!opcion4.isBorderPainted()) {
                        opcion4.setEnabled(true);
                    }
                    if (!opcion5.isBorderPainted()) {
                        opcion5.setEnabled(true);
                    }
                    if (!opcion6.isBorderPainted()) {
                        opcion6.setEnabled(true);
                    }
                }
                comprobarGanador();
                if (intentos <= 0) {
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
            lblintentos.setVisible(true);
            lblIntentos.setVisible(true);
            intentos = 1;
        } else {
            intentos = 2;
            lblintentos.setVisible(true);
            lblIntentos.setVisible(true);
        }
        lblIntentos.setText(intentos + "");
        Random random = new Random();
        animal[0] = animales.length;
        animal[1] = animales.length;
        animal[2] = animales.length;
        animal[3] = animales.length;
        animal[4] = animales.length;
        animal[5] = animales.length;

        int cont = 0;
        int aleatorio;
        boolean repetido;
        while (cont < 6) {
            aleatorio = random.nextInt(animales.length);
            repetido = false;
            for (int i = 0; i < 6; i++) {
                if (animal[i] == aleatorio) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                animal[cont] = aleatorio;
            } else {
                cont--;
            }
            cont++;
        }
        for (int i = 0; i < 6; i++) {
            opciones[i][0] = animales[animal[i]][0];
            opciones[i][1] = animales[animal[i]][1];
        }

        String[] botones = {opciones[0][0], opciones[1][0], opciones[2][0], opciones[3][0], opciones[4][0], opciones[5][0]};

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
        opcion7.setEnabled(false);
        opcion8.setEnabled(false);
        opcion9.setEnabled(false);
        opcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcion9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        timer.start();
    }

    private void btnEnabled(JButton btn, String tipo) {
        ultimaPalabra = tipo;
        if (!botonPresionado) {
            if (ultimaPalabra.equals("Animal")) {
                animalO = btn.getText();
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
                opcion4.setEnabled(false);
                opcion5.setEnabled(false);
                opcion6.setEnabled(false);
                opcion7.setEnabled(true);
                opcion8.setEnabled(true);
                opcion9.setEnabled(true);
            } else {
                tipoO = btn.getToolTipText();
                opcion1.setEnabled(true);
                opcion2.setEnabled(true);
                opcion3.setEnabled(true);
                opcion4.setEnabled(true);
                opcion5.setEnabled(true);
                opcion6.setEnabled(true);
                opcion7.setEnabled(false);
                opcion8.setEnabled(false);
                opcion9.setEnabled(false);

            }

            pbtn[0] = btn;
            botonPresionado = true;
            primerB = false;
        } else {
            if (ultimaPalabra.equals("Animal")) {
                animalO = btn.getText();
            } else {
                tipoO = btn.getToolTipText();
            }
            pbtn[1] = btn;
            primerB = true;

        }

    }

    private void comprobarGanador() {
        if (opcion1.isBorderPainted() && opcion2.isBorderPainted()
                && opcion3.isBorderPainted() && opcion4.isBorderPainted()
                && opcion5.isBorderPainted() && opcion6.isBorderPainted()) {
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
        opcion7.setEnabled(false);
        opcion8.setEnabled(false);
        opcion9.setEnabled(false);
        opcion1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion6.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion7.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion8.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        opcion9.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        opcion7 = new javax.swing.JButton();
        opcion8 = new javax.swing.JButton();
        opcion9 = new javax.swing.JButton();
        btnSonido1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLASIFICACIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 58, 495, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setBorder(null);
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 37));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setBorder(null);
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setBorder(null);
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 188, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 12, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 12, 49, 15));

        opcion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion1.setText("jButton1");
        opcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 134, 147, -1));

        opcion2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion2.setText("jButton2");
        opcion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 134, 147, -1));

        opcion3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion3.setText("jButton3");
        opcion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 134, 147, -1));

        reiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 502, -1, -1));

        lblintentos.setText("Intentos:");
        jPanel1.add(lblintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 512, -1, -1));

        lblIntentos.setText("1");
        jPanel1.add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 512, 37, -1));

        opcion4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion4.setText("jButton4");
        opcion4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 188, 147, -1));

        opcion5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion5.setText("jButton5");
        opcion5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion5ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 188, 147, -1));

        opcion6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion6.setText("jButton6");
        opcion6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion6ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 188, 147, -1));

        opcion7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgAnimales/terrestres.jpeg"))); // NOI18N
        opcion7.setToolTipText("Terrestres");
        opcion7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion7ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 331, 147, -1));

        opcion8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgAnimales/aereos.jpeg"))); // NOI18N
        opcion8.setToolTipText("Aéreos");
        opcion8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion8ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 331, 147, -1));

        opcion9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        opcion9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgAnimales/acuaticos.jpeg"))); // NOI18N
        opcion9.setToolTipText("Acuáticos");
        opcion9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        opcion9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion9ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 331, 147, -1));

        btnSonido1.setBackground(new java.awt.Color(219, 239, 254));
        btnSonido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_sonido.png"))); // NOI18N
        btnSonido1.setBorder(null);
        btnSonido1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSonido1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_sonido1.png"))); // NOI18N
        btnSonido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonido1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSonido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosAnimales regresar = new JuegosAnimales(jugador);
        regresar.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Relaciona al animal en maya\ncon su clasificación correspondiente \n", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion1, "Animal");
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion2, "Animal");
    }//GEN-LAST:event_opcion2ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion3, "Animal");
    }//GEN-LAST:event_opcion3ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        timer.stop();
        comenzarJuego();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void opcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion4, "Animal");
    }//GEN-LAST:event_opcion4ActionPerformed

    private void opcion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion5ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion5, "Animal");
    }//GEN-LAST:event_opcion5ActionPerformed

    private void opcion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion6ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion6, "Animal");
    }//GEN-LAST:event_opcion6ActionPerformed

    private void opcion7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion7ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion7, "Tipo");
    }//GEN-LAST:event_opcion7ActionPerformed

    private void opcion8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion8ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion8, "Tipo");
    }//GEN-LAST:event_opcion8ActionPerformed

    private void opcion9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion9ActionPerformed
        if (!(botonPresionado && primerB))
            btnEnabled(opcion9, "Tipo");
    }//GEN-LAST:event_opcion9ActionPerformed

    private void btnSonido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonido1ActionPerformed
        if (!reproductor.isMusicPlaying()) {
            reproductor.cargarSonido("/sonidos/bgMusic.wav");
            reproductor.fadeIn(0.3f, 1000);
            reproductor.reproducirEnBucle();
            btnSonido1.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido1.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
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
            btnSonido1.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido1.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
            reproductor.setPlaying(false);
        }
    }//GEN-LAST:event_btnSonido1ActionPerformed

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
    private javax.swing.JButton btnSonido1;
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
    private javax.swing.JButton opcion7;
    private javax.swing.JButton opcion8;
    private javax.swing.JButton opcion9;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables
}
