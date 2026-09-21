package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sumas extends javax.swing.JFrame {
    private int numero1, numero2;
    int intentos;
    private int[] opciones = new int[3];
    BD mBD;
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();

    public Sumas(Jugador jugador) {
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
        Botones.transparenciaButton(btnImgPista);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }

        Botones.transparenciaButtonBorder(opcion1);
        Botones.transparenciaButtonBorder(opcion2);
        Botones.transparenciaButtonBorder(opcion3);
        Botones.transparenciaButtonBorder(reiniciar);
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
        Random random = new Random();
        numero1 = random.nextInt(6);
        numero2 = random.nextInt(6);

        String imagenPath1 = "/imgCartas/png" + String.valueOf(numero1) + ".png";
        String imagenPath2 = "/imgCartas/png" + String.valueOf(numero2) + ".png";

        // Redimensionar las imágenes proporcionalmente
        ImageIcon icon1 = new ImageIcon(getClass().getResource(imagenPath1));
        ImageIcon icon2 = new ImageIcon(getClass().getResource(imagenPath2));

        // Obtener las dimensiones originales de las imágenes
        int originalWidth1 = icon1.getIconWidth();
        int originalHeight1 = icon1.getIconHeight();
        int originalWidth2 = icon2.getIconWidth();
        int originalHeight2 = icon2.getIconHeight();

        // Definir el tamaño máximo deseado (por ejemplo, un ancho máximo de 100 píxeles)
        int maxWidth = 100;
        int maxHeight = 100;

        // Redimensionar la imagen 1 proporcionalmente
        double scale1 = Math.min((double) maxWidth / originalWidth1, (double) maxHeight / originalHeight1);
        int newWidth1 = (int) (originalWidth1 * scale1);
        int newHeight1 = (int) (originalHeight1 * scale1);
        Image image1 = icon1.getImage().getScaledInstance(newWidth1, newHeight1, Image.SCALE_SMOOTH);

        // Redimensionar la imagen 2 proporcionalmente
        double scale2 = Math.min((double) maxWidth / originalWidth2, (double) maxHeight / originalHeight2);
        int newWidth2 = (int) (originalWidth2 * scale2);
        int newHeight2 = (int) (originalHeight2 * scale2);
        Image image2 = icon2.getImage().getScaledInstance(newWidth2, newHeight2, Image.SCALE_SMOOTH);

        // Asignar las imágenes redimensionadas
        numeroOperacion1.setIcon(new ImageIcon(image1));
        numeroOperacion2.setIcon(new ImageIcon(image2));

        opciones[0] = -1;
        opciones[1] = -1;
        opciones[2] = -1;

        opciones[0] = numero1 + numero2;
        String imagenSumaResta = "/img/suma.png";
        ImageIcon sumaIcon = new ImageIcon(getClass().getResource(imagenSumaResta));
        Image sumaImage = sumaIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar a 50x50
        sumaIcon = new ImageIcon(sumaImage);
        operacion.setIcon(sumaIcon);


        int opcion;
        for (int i = 1; i < 3; i++) {
            do {
                opcion = random.nextInt(20);  // Generar un número aleatorio entre 0 y 19
            } while (opcion == opciones[0] || opcion == opciones[1] || opcion == opciones[2]);
            opciones[i] = opcion;
        }

        // Mezclar las opciones de manera aleatoria
        String[] botones = {"", "", ""};
        int cont = 0;
        while (cont < 3) {
            int opcionAl = random.nextInt(3);
            boolean repetido = false;
            for (int i = 0; i < 3; i++) {
                if (botones[i].equals(String.valueOf(opciones[opcionAl]))) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                botones[cont] = String.valueOf(opciones[opcionAl]);
            } else {
                cont--;  // Volver a intentar si ya se encontró una opción repetida
            }
            cont++;
        }

        // Asignar las opciones a los botones
        opcion1.setText(botones[0]);
        opcion2.setText(botones[1]);
        opcion3.setText(botones[2]);

        // Habilitar los botones
        opcion1.setEnabled(true);
        opcion2.setEnabled(true);
        opcion3.setEnabled(true);
    }

    private void comprobarPalabra(String respuestaJugador) {
        int resultadoCorrecto = 0;

        resultadoCorrecto = numero1 + numero2;

        int respuesta = Integer.parseInt(respuestaJugador);
        if (respuesta == resultadoCorrecto) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste 20 puntos.", "¡Ganaste", JOptionPane.INFORMATION_MESSAGE);
            puntuacion(20);
            comenzarJuego();
        } else if (intentos > 0) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/error.wav");
            JOptionPane.showMessageDialog(this, "Vuelve a intentarlo.", "Respuesta incorrecta", JOptionPane.INFORMATION_MESSAGE);
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
        reiniciar = new javax.swing.JButton();
        lblintentos = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        numeroOperacion1 = new javax.swing.JLabel();
        numeroOperacion2 = new javax.swing.JLabel();
        operacion = new javax.swing.JLabel();
        opcion1 = new javax.swing.JButton();
        opcion2 = new javax.swing.JButton();
        opcion3 = new javax.swing.JButton();
        btnImgPista = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUMAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 66, 419, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setBorder(null);
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 35, 35));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setBorder(null);
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 35, 35));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setBorder(null);
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 35, 35));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 0, 188, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 33, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 33, 49, 15));

        reiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        reiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 487, 82, -1));

        lblintentos.setText("Intentos:");
        jPanel1.add(lblintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 487, -1, -1));

        lblIntentos.setText("1");
        jPanel1.add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 487, 37, -1));

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));

        numeroOperacion1.setBackground(new java.awt.Color(255, 237, 213));
        numeroOperacion1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        numeroOperacion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroOperacion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 35, 29), 3, true));

        numeroOperacion2.setBackground(new java.awt.Color(255, 237, 213));
        numeroOperacion2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        numeroOperacion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroOperacion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 35, 29), 3, true));

        operacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        operacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(numeroOperacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(numeroOperacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(numeroOperacion2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numeroOperacion1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 138, -1, -1));

        opcion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        opcion1.setText("opcion1");
        opcion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 359, 150, 110));

        opcion2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        opcion2.setText("opcion2");
        opcion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 359, 150, 110));

        opcion3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        opcion3.setText("opcion3");
        opcion3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        jPanel1.add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 359, 150, 110));

        btnImgPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngPista.png"))); // NOI18N
        btnImgPista.setBorder(null);
        btnImgPista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgPista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngPista1.png"))); // NOI18N
        btnImgPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgPistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 485, 40, 40));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosNumeros regresar = new JuegosNumeros(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Selecciona la opcion correspondiente a la\nsuma o resta que aparece en pantalla.", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        comprobarPalabra(opcion1.getText());
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        comprobarPalabra(opcion2.getText());
    }//GEN-LAST:event_opcion2ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        comprobarPalabra(opcion3.getText());
    }//GEN-LAST:event_opcion3ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        comenzarJuego();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void btnImgPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgPistaActionPerformed
        pistaSumas pista = new pistaSumas(jugador);
        pista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgPistaActionPerformed

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
    private javax.swing.JButton btnImgPista;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblintentos;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JLabel numeroOperacion1;
    private javax.swing.JLabel numeroOperacion2;
    private javax.swing.JButton opcion1;
    private javax.swing.JButton opcion2;
    private javax.swing.JButton opcion3;
    private javax.swing.JLabel operacion;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables
}
