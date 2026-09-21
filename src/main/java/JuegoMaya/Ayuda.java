package JuegoMaya;

import Util.Botones;
import Util.ReproductorSonido;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 *
 * @author fernando
 */
public class Ayuda extends javax.swing.JFrame {
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();

    public Ayuda() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        btnSonido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 34, 37));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 482, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Haz click");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 411, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(162, 35, 29));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("aquí");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 411, 44, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("para descargar el manual de usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 411, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Para cualquier duda, aclaración o comentario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 186, 427, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Correo: masmaya2007@gmail.com ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 217, 427, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Número: 983 130 0264 ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 248, 427, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Hecho por: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 279, 427, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("- Torres Guerrero María José");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 307, 427, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("- Nolasco Cen Saúl Gabriel");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 335, 427, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("- Loria Torres Alonso Del Angel");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 363, 427, -1));

        btnImgRegresar.setBackground(new java.awt.Color(219, 239, 254));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("https://drive.google.com/file/d/1kIsvUTWJYZzJZKZTqqeNVEUn7fsWYurx/view?usp=sharing"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        MenuPrincipal regresar = new MenuPrincipal();
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
            }).start();
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
            reproductor.setPlaying(false);
        }
    }//GEN-LAST:event_btnSonidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
