package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loteria extends javax.swing.JFrame {
    BD mBD;
    Jugador jugador;
    private int puntuacion = 100;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    ReproductorEfectos efectos = new ReproductorEfectos();
    private static final int nCartas = 16;
    private List<Carta> cartas;
    private List<Carta> cartasCantadas;
    private List<JButton> cartonBtns;
    private Timer timer;
    int cartasHabilitadas = 9;
    private boolean juegoTerminado = false;

    public Loteria(Jugador jugador) {
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
        Botones.transparenciaButtonBorder(btn1);
        Botones.transparenciaButtonBorder(btn2);
        Botones.transparenciaButtonBorder(btn3);
        Botones.transparenciaButtonBorder(btn4);
        Botones.transparenciaButtonBorder(btn5);
        Botones.transparenciaButtonBorder(btn6);
        Botones.transparenciaButtonBorder(btn7);
        Botones.transparenciaButtonBorder(btn8);
        Botones.transparenciaButtonBorder(btn9);
        Botones.transparenciaButtonBorder(btnCartaCantada);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }
        setResizable(false);
        lblPuntuacion.setText(Integer.toString(puntuacion));

        iniciaJuego();
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    private void iniciaJuego() {
        // Inicializar las listas de cartas
        cartas = new ArrayList<>();
        cartasCantadas = new ArrayList<>();

        // Crear cartas únicas y agregarlas a la lista de cartas
        for (int i = 1; i <= nCartas; i++) {
            cartas.add(new Carta(i, i));
        }

        // Barajar las cartas
        Collections.shuffle(cartas);

        // Inicializar los botones del cartón
        cartonBtns = new ArrayList<>();
        cartonBtns.add(btn1);
        cartonBtns.add(btn2);
        cartonBtns.add(btn3);
        cartonBtns.add(btn4);
        cartonBtns.add(btn5);
        cartonBtns.add(btn6);
        cartonBtns.add(btn7);
        cartonBtns.add(btn8);
        cartonBtns.add(btn9);

        CartonGenerator cartonRand = new CartonGenerator();
        List<Carta> carton = cartonRand.generarCarton();
        List<ImageIcon> listaImagenes = cartonRand.cargarImagenes();
        cartonRand.establecerCarton(carton, listaImagenes, cartonBtns);

        // Inicializar el temporizador para generar nuevas cartas cantadas cada 3 segundos
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCartaCantada = cartasCantadas.get(cartasCantadas.size() - 1).getId();
                // Verificar si el idCartaCantada está en el cartón
                boolean cartaEnCarton = false;
                for (Carta carta : carton) {
                    if (carta.getId() == idCartaCantada) {
                        cartaEnCarton = true;
                        break;
                    }
                }
                // Restar puntos si la carta cantada está en el cartón
                if (cartaEnCarton) {
                    for (int i = 0; i < carton.size(); i++) {
                        if (carton.get(i).getId() == idCartaCantada) {
                            cartonBtns.get(i).setEnabled(false);
                            cartasHabilitadas--;
                            break;
                        }
                    }

                    puntuacion -= 10;
                    lblPuntuacion.setText(String.valueOf(puntuacion));
                }

                //Si el timer está activo y las cartas que quedan en el cartón están deshabilitadas
                if (cartasHabilitadas == 0) {
                    new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/draw.wav");
                    JOptionPane.showMessageDialog(null, "El juego ha terminado. Su puntaje es: " + puntuacion, "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                    puntuacion(puntuacion);
                    lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
                    timer.stop();
                    System.out.println("stop de timer");
                } else {
                    generarCartaCantada();
                }
            }
        });

        generarCartaCantada();

        //Acción al presionar los botones del cartón
        for (JButton boton : cartonBtns) {
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Validación del ID
                    int idBotonPresionado = (int) boton.getClientProperty("id");
                    int idCartaCantada = cartasCantadas.get(cartasCantadas.size() - 1).getId();

                    if (idBotonPresionado == idCartaCantada) {
                        boton.setEnabled(false);
                        boton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
                        efectos.cerrarRecurso();
                        timer.stop();
                        generarCartaCantada();

                        cartasHabilitadas--;

                        if (cartasHabilitadas == 0 && timer.isRunning()) {
                            timer.stop();
                            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
                            JOptionPane.showMessageDialog(null, "El juego ha terminado. Su puntaje es: " + puntuacion, "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                            puntuacion(puntuacion);
                            lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
                            System.out.println("stop de btn");
                        }
                    }
                }
            });
        }
    }

    private void generarCartaCantada() {
        if (!cartas.isEmpty()) {
            Carta cartaCantada = cartas.remove(0);
            cartasCantadas.add(cartaCantada);

            int numeroCartaCantada = cartaCantada.getNumero();

            cantaCarta(numeroCartaCantada);
            timer.start();

        } else if (!juegoTerminado) {
            juegoTerminado = true;
            System.out.println("stop de generar carta");
            efectos.cerrarRecurso();
            timer.stop();
            JOptionPane.showMessageDialog(this, "¡Se han cantado todas las cartas!");
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/draw.wav");
            JOptionPane.showMessageDialog(this, "Tu puntuación es de " + puntuacion);
            puntuacion(puntuacion);
            lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        }
    }

    private void cantaCarta(int nCartaCantada) {
        btnCartaCantada.setIcon(new ImageIcon(getClass().getResource("/imgLoteria/" + nCartaCantada + ".png")));
        ;
        reproducirCarta(nCartaCantada - 1);
    }

    private void reproducirCarta(int i) {
        efectos.reproducirEfecto("/sonidos/frutas/" + i + ".wav");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        hola = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        btnImgRegresar = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        btnImgSoporte = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        btnCartaCantada = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(572, 576));
        setSize(new java.awt.Dimension(572, 576));

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOTERÍA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 51, 411, -1));

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setBackground(new java.awt.Color(255, 237, 213));
        btn1.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        btn1.setForeground(new java.awt.Color(77, 52, 28));
        btn1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 110, 150));

        btn2.setBackground(new java.awt.Color(255, 237, 213));
        btn2.setForeground(new java.awt.Color(77, 52, 28));
        btn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 6, 110, 150));

        btn3.setBackground(new java.awt.Color(255, 237, 213));
        btn3.setForeground(new java.awt.Color(77, 52, 28));
        btn3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 6, 110, 150));

        btn4.setBackground(new java.awt.Color(255, 237, 213));
        btn4.setForeground(new java.awt.Color(77, 52, 28));
        btn4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 174, 110, 150));

        btn6.setBackground(new java.awt.Color(255, 237, 213));
        btn6.setForeground(new java.awt.Color(77, 52, 28));
        btn6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 174, 110, 150));

        btn5.setBackground(new java.awt.Color(255, 237, 213));
        btn5.setForeground(new java.awt.Color(77, 52, 28));
        btn5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 174, 110, 150));

        btn7.setBackground(new java.awt.Color(255, 237, 213));
        btn7.setForeground(new java.awt.Color(77, 52, 28));
        btn7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 342, 110, 150));

        btn8.setBackground(new java.awt.Color(255, 237, 213));
        btn8.setForeground(new java.awt.Color(77, 52, 28));
        btn8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 342, 110, 150));

        btn9.setBackground(new java.awt.Color(255, 237, 213));
        btn9.setForeground(new java.awt.Color(77, 52, 28));
        btn9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 342, 110, 150));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 113, -1, -1));

        hola.setBackground(new java.awt.Color(219, 239, 254));
        hola.setBorder(null);
        hola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holaActionPerformed(evt);
            }
        });
        jPanel2.add(hola, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 657, 37, -1));

        btnReiniciar.setBackground(new java.awt.Color(255, 237, 213));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 654, -1, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel2.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 34, 37));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 650, 34, 37));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntuación:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 658, 80, -1));
        jPanel2.add(lblPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 654, 37, 25));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 0, 250, 26));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));
        jPanel2.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 49, 15));

        btnCartaCantada.setBackground(new java.awt.Color(255, 237, 213));
        btnCartaCantada.setForeground(new java.awt.Color(77, 52, 28));
        btnCartaCantada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btnCartaCantada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(btnCartaCantada, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 286, 110, 150));

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
        jPanel2.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // Reiniciar la puntuación
        juegoTerminado = false;
        puntuacion = 100;
        lblPuntuacion.setText(String.valueOf(puntuacion));

        // Habilitar todos los botones del cartón
        for (JButton boton : cartonBtns) {
            boton.setEnabled(true);
            boton.setBorder(BorderFactory.createLineBorder(new Color(0, 168, 107), 4)); // Restaurar el borde
        }

        // Vaciar la lista de cartas cantadas
        cartasCantadas.clear();
        cartasHabilitadas = 9;

        // Reiniciar el temporizador
        if (timer != null) {
            timer.stop();
        }

        efectos.cerrarRecurso();

        // Volver a iniciar el juego
        iniciaJuego();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void holaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holaActionPerformed

    }//GEN-LAST:event_holaActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrutas regresar = new JuegosFrutas(jugador);
        regresar.setVisible(true);
        this.dispose();
        efectos.cerrarRecurso();
        timer.stop();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal regresar = new MenuPrincipal();
        regresar.setVisible(true);
        this.dispose();
        efectos.cerrarRecurso();
        timer.stop();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Presiona en tu cartón la tarjeta que salga en la \nderecha de la pantalla, si es que la tiene", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

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
//            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Jugador jugador = new Jugador("","");
//                jugador.offline();
//                new Memorama(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnCartaCantada;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JTextField hola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    // End of variables declaration//GEN-END:variables

}
