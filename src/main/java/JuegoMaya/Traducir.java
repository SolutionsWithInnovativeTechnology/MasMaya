package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.text.Normalizer;
import java.util.Random;

public class Traducir extends javax.swing.JFrame {
    BD mBD;
    Jugador jugador;
    int frase = 0;
    String[] frasesMaya = {"Bet uts", "In yaakumech", "Mix ba'al", "Bix a beel", "Kanáantabaj", "Tu'ux yanech", "Ka'akate'", "Tu'ux ka bin",
            "In k'aaba'e", "Luba'an in wóol", "Sáamsamal", "Ba'ax ka beetik", "Ma'alob k'iin", "Ma'alob a'k'ab", "Ki'imak in wóol", "Biix a ka'aaba'",
            "Tak sáamal", "Bix u k'aaba' a na'", "Jach níib óolal", "Bix u k'aaba' a yuum"};
    String[] frases = {"Por favor", "Te amo", "De nada", "Como estas", "Cuidate", "Donde estas", "Mas tarde", "A donde vas",
            "Me llamo", "Estoy triste", "Todos los dias", "Que haces", "Buenos dias", "Buenas tardes", "Estoy feliz", "Como te llamas",
            "Hasta mañana", "Como se llama tu papa", "Muchas gracias", "Como se llama tu mama"};
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    ReproductorEfectos efectos = new ReproductorEfectos();

    public Traducir(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");
        initComponents();
        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }
        Botones.transparenciaButton(btnImgSoporte);
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }
        setResizable(false);
        asignarAudio();
        txtResultado.requestFocus();
    }

    private void asignarAudio() {
        Random v = new Random();
        frase = v.nextInt(frases.length);
        btnFrase.setText(frasesMaya[frase]);
        reproducirFrase(frase);
    }

    private String quitarAcentos(String frase) {
        // Utilizar Normalizer para quitar los acentos de la cadena de texto
        String fraseSinAcentos = Normalizer.normalize(frase, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return fraseSinAcentos;
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
        txtResultado = new javax.swing.JTextField();
        btnComprobar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        btnFrase = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRADUCIR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 58, 341, -1));

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
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 34, 37));

        txtResultado.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtResultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultadoActionPerformed(evt);
            }
        });
        txtResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtResultadoKeyReleased(evt);
            }
        });
        jPanel1.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 303, 189, 28));

        btnComprobar.setBackground(new java.awt.Color(255, 237, 213));
        btnComprobar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnComprobar.setText("Comprobar");
        btnComprobar.setBorder(null);
        btnComprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 359, 97, 29));

        btnReiniciar.setBackground(new java.awt.Color(255, 237, 213));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(null);
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        btnReiniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnReiniciarKeyReleased(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 359, 88, 29));

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
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 0, 188, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 49, 15));

        btnFrase.setBackground(new java.awt.Color(255, 237, 213));
        btnFrase.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnFrase.setText("Frase en maya");
        btnFrase.setBorder(null);
        btnFrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFraseActionPerformed(evt);
            }
        });
        jPanel1.add(btnFrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 214, 189, 29));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reproducirFrase(int i) {
        efectos.reproducirEfecto("/sonidos/frases/" + i + ".wav");
    }

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Escribe en español la frase que se muestra en pantalla \nNota: Si presiona el texto podrá escuchar la pronunciación"
                , "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void txtResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultadoActionPerformed

    }//GEN-LAST:event_txtResultadoActionPerformed

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
        if (txtResultado.getText().isEmpty()) {
            return;
        }

        String fraseRandom = frases[frase].toLowerCase();
        String respuesta = txtResultado.getText().toLowerCase();

        respuesta = respuesta.replaceAll("¿", "");
        respuesta = respuesta.replaceAll("\\?", "");
        respuesta = quitarAcentos(respuesta);

        if (respuesta.equals(fraseRandom)) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste 20 puntos.", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
            puntuacion(20);
            btnComprobar.setEnabled(false);
            asignarAudio();
            btnComprobar.setEnabled(true);
            txtResultado.setText("");
        } else if (jugador.getPuntuacion() > 0) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/error.wav");
            JOptionPane.showMessageDialog(this, "Vuelve a intentarlo\n -10 puntos", "Respuesta incorrecta", JOptionPane.INFORMATION_MESSAGE);
            puntuacion(-10);
        } else {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/lose.wav");
            JOptionPane.showMessageDialog(this, "Has perdido. Tu puntaje es: 0", "Perdiste :(", JOptionPane.INFORMATION_MESSAGE);
            btnComprobar.setEnabled(false);
        }
    }//GEN-LAST:event_btnComprobarActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrasesComunes regresar = new JuegosFrasesComunes(jugador);
        regresar.setVisible(true);
        efectos.cerrarRecurso();
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        asignarAudio();
        btnComprobar.setEnabled(true);
        txtResultado.setText("");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        efectos.cerrarRecurso();
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnFraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFraseActionPerformed
        reproducirFrase(frase);
    }//GEN-LAST:event_btnFraseActionPerformed

    private void txtResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoKeyReleased
        char c = (char) evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER && btnComprobar.isEnabled()) {
            btnComprobar.requestFocus();
            btnComprobar.doClick();
        }
    }//GEN-LAST:event_txtResultadoKeyReleased

    private void btnReiniciarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnReiniciarKeyReleased
        char c = (char) evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER) {
            btnReiniciar.doClick();
        }
    }//GEN-LAST:event_btnReiniciarKeyReleased

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
//            java.util.logging.Logger.getLogger(Tarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Jugador jugador = new Jugador("","");
//                jugador.offline();
//                new Tarjetas(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JButton btnFrase;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

    private boolean equals(char numero1, String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
