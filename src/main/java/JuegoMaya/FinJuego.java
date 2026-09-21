package JuegoMaya;

import Util.Jugador;
import Util.ReproductorEfectos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinJuego extends javax.swing.JFrame {
    //Atributos
    private static int nIntentos;
    private static String palabra;
    private Jugador jugador;
    private Timer timer;
    private int posX;
    private final int velocidad = 5;

    public FinJuego(int nIntentos, String palabra, Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        this.nIntentos = nIntentos;
        this.palabra = palabra;

        // Temporizador para la animación del pez
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nIntentos > 0) { // Si el jugador ganó
                    if (posX > 105) { // Si el pez no ha llegado a la caña
                        label5.setIcon(new ImageIcon(getClass().getResource("/imgPescar/pez2.png")));
                        posX -= velocidad;
                        label5.setLocation(posX, label5.getY()); // Mover el pez hacia la izquierda hasta llegar a la posición 100
                    }
                } else { // Si el jugador perdió
                    if (label5.getX() > label5.getWidth()) { // Si el pez no ha salido completamente de la pantalla
                        posX += velocidad; // Mover el pez hacia la izquierda
                        label5.setLocation(posX, label5.getY());
                    } else { // Si el pez salió completamente de la pantalla
                        timer.stop(); // Detener la animación
                    }
                }
            }
        });
        timer.start(); // Iniciar el temporizador
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resultado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnSi1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        resultado1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSi2 = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resultado2 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        resultado.setEditable(false);
        resultado.setBackground(new java.awt.Color(255, 255, 255));
        resultado.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        resultado.setForeground(new java.awt.Color(0, 0, 255));
        resultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultado.setToolTipText("");
        resultado.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Desea jugar de nuevo?");

        btnSi.setBackground(new java.awt.Color(0, 0, 0));
        btnSi.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btnSi.setForeground(new java.awt.Color(255, 255, 255));
        btnSi.setText("Si");

        btnSi1.setBackground(new java.awt.Color(0, 0, 0));
        btnSi1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btnSi1.setForeground(new java.awt.Color(255, 255, 255));
        btnSi1.setText("Si");

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AHORCADO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(219, 239, 254));

        resultado1.setEditable(false);
        resultado1.setBackground(new java.awt.Color(219, 239, 254));
        resultado1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resultado1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultado1.setToolTipText("");
        resultado1.setBorder(null);
        resultado1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resultado1.setFocusable(false);
        resultado1.setSelectionColor(new java.awt.Color(255, 255, 255));
        resultado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultado1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 34, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Desea jugar de nuevo?");

        btnSi2.setBackground(new java.awt.Color(71, 34, 14));
        btnSi2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btnSi2.setForeground(new java.awt.Color(255, 255, 255));
        btnSi2.setText("Si");
        btnSi2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi2ActionPerformed(evt);
            }
        });

        btnNo.setBackground(new java.awt.Color(71, 34, 14));
        btnNo.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btnNo.setForeground(new java.awt.Color(255, 255, 255));
        btnNo.setText("No");
        btnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setBackground(new java.awt.Color(255, 255, 255));
        label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPescar/cana.png"))); // NOI18N
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 83));

        label5.setBackground(new java.awt.Color(255, 255, 255));
        label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPescar/pez.png"))); // NOI18N
        jPanel2.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 50, 40));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 80));

        resultado2.setEditable(false);
        resultado2.setBackground(new java.awt.Color(219, 239, 254));
        resultado2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resultado2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultado2.setToolTipText("");
        resultado2.setBorder(null);
        resultado2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resultado2.setFocusable(false);
        resultado2.setSelectionColor(new java.awt.Color(255, 255, 255));
        resultado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultado2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnSi2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNo)
                                .addGap(38, 38, 38))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(resultado1)
                                .addContainerGap())
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(resultado2)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(resultado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSi2)
                                        .addComponent(btnNo))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resultado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi2ActionPerformed
        Pescar inicio = new Pescar(jugador);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSi2ActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        JuegosFrutas regresar = new JuegosFrutas(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        daResultado();
    }//GEN-LAST:event_formWindowOpened

    private void resultado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultado1ActionPerformed

    private void resultado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultado2ActionPerformed

    public void daResultado() {
        String resul = "hola";
        String resul2 = "adios";
        if (nIntentos <= 0) {
            posX = 140;
            resul = "Perdiste, la palabra era " + palabra.toLowerCase();
            resul2 = "El pez escapó :(";
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/lose.wav");
        } else {
            posX = 160;
            resul = "Felicidades, ¡Ganaste!";
            resul2 = "Pescaste al pez :D";
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
        }
        resultado1.setText(resul);
        resultado2.setText(resul2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnSi1;
    private javax.swing.JButton btnSi2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JTextField resultado;
    private javax.swing.JTextField resultado1;
    private javax.swing.JTextField resultado2;
    // End of variables declaration//GEN-END:variables
}
