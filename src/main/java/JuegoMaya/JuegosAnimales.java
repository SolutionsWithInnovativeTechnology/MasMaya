package JuegoMaya;

import Util.Botones;
import Util.Jugador;
import Util.ReproductorSonido;

import javax.swing.*;

public class JuegosAnimales extends javax.swing.JFrame {
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();

    public JuegosAnimales(Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }
        Botones.transparenciaButtonBorder(btnImgCrucigrama);
        Botones.transparenciaButtonBorder(btnImgMemorama);
        Botones.transparenciaButtonBorder(btnImgRelacionar);
        Botones.transparenciaButtonBorder(btnImgPuzzle);
        Botones.transparenciaButton(btnImgInfo);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnImgCrucigrama = new javax.swing.JButton();
        btnImgMemorama = new javax.swing.JButton();
        btnImgPuzzle = new javax.swing.JButton();
        btnImgRelacionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnImgInfo = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        btnImgRegresar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JUEGOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 540, -1));

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));

        btnImgCrucigrama.setBackground(new java.awt.Color(219, 239, 254));
        btnImgCrucigrama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngClasificaciones.png"))); // NOI18N
        btnImgCrucigrama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        btnImgCrucigrama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgCrucigrama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgCrucigrama.setPreferredSize(new java.awt.Dimension(150, 120));
        btnImgCrucigrama.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngClasificaciones1.png"))); // NOI18N
        btnImgCrucigrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgCrucigramaActionPerformed(evt);
            }
        });

        btnImgMemorama.setBackground(new java.awt.Color(219, 239, 254));
        btnImgMemorama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngMemoramaAnimales.png"))); // NOI18N
        btnImgMemorama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        btnImgMemorama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgMemorama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgMemorama.setPreferredSize(new java.awt.Dimension(150, 120));
        btnImgMemorama.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngMemoramaAnimales1.png"))); // NOI18N
        btnImgMemorama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgMemoramaActionPerformed(evt);
            }
        });

        btnImgPuzzle.setBackground(new java.awt.Color(219, 239, 254));
        btnImgPuzzle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAdivinaElAnimal.png"))); // NOI18N
        btnImgPuzzle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        btnImgPuzzle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgPuzzle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgPuzzle.setPreferredSize(new java.awt.Dimension(150, 120));
        btnImgPuzzle.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAdivinaElAnimal1.png"))); // NOI18N
        btnImgPuzzle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgPuzzleActionPerformed(evt);
            }
        });

        btnImgRelacionar.setBackground(new java.awt.Color(219, 239, 254));
        btnImgRelacionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCategoria2/pngSopaDeLetras.png"))); // NOI18N
        btnImgRelacionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));
        btnImgRelacionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRelacionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgRelacionar.setPreferredSize(new java.awt.Dimension(150, 120));
        btnImgRelacionar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCategoria2/pngSopaDeLetras1.png"))); // NOI18N
        btnImgRelacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRelacionarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Adivina el animal");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Clasificaciones");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Relacionar Animales");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sopa de letras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnImgCrucigrama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnImgMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnImgPuzzle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnImgRelacionar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnImgMemorama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImgCrucigrama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnImgRelacionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnImgPuzzle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 160, -1, -1));

        btnImgInfo.setBackground(new java.awt.Color(219, 239, 254));
        btnImgInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgInfo.setBorder(null);
        btnImgInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgInfo.setMaximumSize(new java.awt.Dimension(40, 40));
        btnImgInfo.setMinimumSize(new java.awt.Dimension(40, 40));
        btnImgInfo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnImgInfo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInfoActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 34, 37));

        btnImgInicio.setBackground(new java.awt.Color(219, 239, 254));
        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setBorder(null);
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 34, 37));

        btnImgRegresar.setBackground(new java.awt.Color(219, 239, 254));
        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setBorder(null);
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 206, 34));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Puntuación global:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 137, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 49, 15));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInfoActionPerformed
        InformacionAnimales entrar = new InformacionAnimales(jugador);
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInfoActionPerformed

    private void btnImgMemoramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgMemoramaActionPerformed
        RelacionarAnimales entrar = new RelacionarAnimales(jugador);
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgMemoramaActionPerformed

    private void btnImgPuzzleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgPuzzleActionPerformed
        AdivinaElAnimal entrar = new AdivinaElAnimal(jugador);
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgPuzzleActionPerformed

    private void btnImgRelacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRelacionarActionPerformed
        SopaDeLetrasAnimales entrar = new SopaDeLetrasAnimales(jugador);
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRelacionarActionPerformed

    private void btnImgCrucigramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgCrucigramaActionPerformed
        ClasificacionesAnimales entrar = new ClasificacionesAnimales(jugador);
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgCrucigramaActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal regresar = new MenuPrincipal();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        Categorias regresar = new Categorias(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

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
            });
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
//            java.util.logging.Logger.getLogger(JuegosNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JuegosNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JuegosNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JuegosNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Jugador jugador = new Jugador("","");
//                new JuegosNumeros(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImgCrucigrama;
    private javax.swing.JButton btnImgInfo;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgMemorama;
    private javax.swing.JButton btnImgPuzzle;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgRelacionar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
