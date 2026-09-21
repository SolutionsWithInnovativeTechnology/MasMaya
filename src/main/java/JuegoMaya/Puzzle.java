package JuegoMaya;

import Util.BD;
import Util.Botones;
import Util.Jugador;
import Util.ReproductorSonido;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Puzzle extends javax.swing.JFrame {
    BD mBD;
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    int cont = 0, puntaje = 0;

    public Puzzle(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");
        initComponents();
        puntaje = 400;
        lblPuntuacionInicial.setText(Integer.toString(puntaje));
        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio);
        Botones.transparenciaButton(btnImgSoporte);
        Botones.transparenciaButtonBorder(btn1);
        Botones.transparenciaButtonBorder(btn2);
        Botones.transparenciaButtonBorder(btn3);
        Botones.transparenciaButtonBorder(btn4);
        Botones.transparenciaButtonBorder(btn5);
        Botones.transparenciaButtonBorder(btn6);
        Botones.transparenciaButtonBorder(btn7);
        Botones.transparenciaButtonBorder(btn8);
        Botones.transparenciaButtonBorder(btn9);
        Botones.transparenciaButtonBorder(btn10);
        Botones.transparenciaButtonBorder(btn11);
        Botones.transparenciaButtonBorder(btn12);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }
        EnumerarBotones();
        btn12.setVisible(false);
        setResizable(false);
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    private void EnumerarBotones() {
        Stack<Integer> numeros = new Stack<>();
        Random rnd = new Random();
        int aleatorio;
        int numBoton[] = new int[12];
        int inversiones = 0;
        do {
            numeros.clear();
            for (int i = 1; i < 12; i++) {
                aleatorio = (int) (rnd.nextDouble() * 11 + 1);
                while (numeros.contains(aleatorio)) {
                    aleatorio = (int) (rnd.nextDouble() * 11 + 1);
                }
                numeros.push(aleatorio);
                numBoton[i] = aleatorio;
            }
            inversiones = 0;
            for (int i = 1; i < numBoton.length; i++) {
                for (int j = i + 1; j < numBoton.length; j++) {
                    if (numBoton[i] > numBoton[j]) {
                        inversiones++;
                    }
                }
            }
        } while (inversiones % 2 == 1);
        //Coloca los nombres de los botones de acuerdo al vector
        btn1.setText(Integer.toString(numBoton[1]));
        btn1.setIcon(new ImageIcon(setFiguraEscalada(numBoton[1])));
        btn2.setIcon(new ImageIcon(setFiguraEscalada(numBoton[2])));
        btn2.setText(Integer.toString(numBoton[2]));
        btn3.setIcon(new ImageIcon(setFiguraEscalada(numBoton[3])));
        btn3.setText(Integer.toString(numBoton[3]));
        btn4.setIcon(new ImageIcon(setFiguraEscalada(numBoton[4])));
        btn4.setText(Integer.toString(numBoton[4]));
        btn5.setIcon(new ImageIcon(setFiguraEscalada(numBoton[5])));
        btn5.setText(Integer.toString(numBoton[5]));
        btn6.setIcon(new ImageIcon(setFiguraEscalada(numBoton[6])));
        btn6.setText(Integer.toString(numBoton[6]));
        btn7.setIcon(new ImageIcon(setFiguraEscalada(numBoton[7])));
        btn7.setText(Integer.toString(numBoton[7]));
        btn8.setIcon(new ImageIcon(setFiguraEscalada(numBoton[8])));
        btn8.setText(Integer.toString(numBoton[8]));
        btn9.setIcon(new ImageIcon(setFiguraEscalada(numBoton[9])));
        btn9.setText(Integer.toString(numBoton[9]));
        btn10.setIcon(new ImageIcon(setFiguraEscalada(numBoton[10])));
        btn10.setText(Integer.toString(numBoton[10]));
        btn11.setIcon(new ImageIcon(setFiguraEscalada(numBoton[11])));
        btn11.setText(Integer.toString(numBoton[11]));
        btn12.setText("12");

    }

    void IntercambiaBotton(JButton btn1, JButton btn2) {
        //recuperamos el valor del boton 2
        String valorBoton = btn2.getText();
        //validamos el valor del boton2
        if (valorBoton == "12") {
            //Intercambiamos con el valor del boton1
            btn2.setText(btn1.getText());
            btn2.setIcon(btn1.getIcon());
            btn2.setVisible(true);
            btn1.setText("12");
            btn1.setVisible(false);
            contador();
        }
    }

    private void resolver() {
        int[] resuelto = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        btn1.setText(Integer.toString(resuelto[1]));
        btn1.setIcon(new ImageIcon(setFiguraEscalada(resuelto[1])));
        btn2.setIcon(new ImageIcon(setFiguraEscalada(resuelto[2])));
        btn2.setText(Integer.toString(resuelto[2]));
        btn3.setIcon(new ImageIcon(setFiguraEscalada(resuelto[3])));
        btn3.setText(Integer.toString(resuelto[3]));
        btn4.setIcon(new ImageIcon(setFiguraEscalada(resuelto[4])));
        btn4.setText(Integer.toString(resuelto[4]));
        btn5.setIcon(new ImageIcon(setFiguraEscalada(resuelto[5])));
        btn5.setText(Integer.toString(resuelto[5]));
        btn6.setIcon(new ImageIcon(setFiguraEscalada(resuelto[6])));
        btn6.setText(Integer.toString(resuelto[6]));
        btn7.setIcon(new ImageIcon(setFiguraEscalada(resuelto[7])));
        btn7.setText(Integer.toString(resuelto[7]));
        btn8.setIcon(new ImageIcon(setFiguraEscalada(resuelto[8])));
        btn8.setText(Integer.toString(resuelto[8]));
        btn9.setIcon(new ImageIcon(setFiguraEscalada(resuelto[9])));
        btn9.setText(Integer.toString(resuelto[9]));
        btn10.setIcon(new ImageIcon(setFiguraEscalada(resuelto[10])));
        btn10.setText(Integer.toString(resuelto[10]));
        btn11.setIcon(new ImageIcon(setFiguraEscalada(resuelto[11])));
        btn11.setText(Integer.toString(resuelto[11]));
        btn12.setText("12");
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn5.setVisible(true);
        btn6.setVisible(true);
        btn7.setVisible(true);
        btn8.setVisible(true);
        btn9.setVisible(true);
        btn10.setVisible(true);
        btn11.setVisible(true);
        btn12.setVisible(false);
    }

    private void contador() {
        cont++;
        jClicks.setText(Integer.toString(cont));
        int[] lugares = {Integer.parseInt(btn1.getText()),
                Integer.parseInt(btn2.getText()),
                Integer.parseInt(btn3.getText()),
                Integer.parseInt(btn4.getText()),
                Integer.parseInt(btn5.getText()),
                Integer.parseInt(btn6.getText()),
                Integer.parseInt(btn7.getText()),
                Integer.parseInt(btn8.getText()),
                Integer.parseInt(btn9.getText()),
                Integer.parseInt(btn10.getText()),
                Integer.parseInt(btn11.getText())};
        int[] aux = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        if (Arrays.equals(lugares, aux)) {
            puntaje = puntaje - cont;
            puntuacion(puntaje);
            JOptionPane.showMessageDialog(this, "Felicidades, ha completado la figura en " + cont + " movimientos.\n Su puntaje es de: " + puntaje, "GANASTE!!", JOptionPane.INFORMATION_MESSAGE);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
            btn11.setEnabled(false);
            cont = 0;
        }
    }

    private Image setFiguraEscalada(int n) {
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("/PuzzleImg" + "/ola" + n + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
        }
        img = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
        return img;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jClicks = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        btnImgSoporte = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPuntuacionInicial = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 237, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 5));
        jPanel2.setLayout(new java.awt.GridLayout(3, 4));

        btn1.setBackground(new java.awt.Color(255, 237, 213));
        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1);

        btn2.setBackground(new java.awt.Color(255, 237, 213));
        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2);

        btn3.setBackground(new java.awt.Color(255, 237, 213));
        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3);

        btn4.setBackground(new java.awt.Color(255, 237, 213));
        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4);

        btn5.setBackground(new java.awt.Color(255, 237, 213));
        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5);

        btn6.setBackground(new java.awt.Color(255, 237, 213));
        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6);

        btn7.setBackground(new java.awt.Color(255, 237, 213));
        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7);

        btn8.setBackground(new java.awt.Color(255, 237, 213));
        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8);

        btn9.setBackground(new java.awt.Color(255, 237, 213));
        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9);

        btn10.setBackground(new java.awt.Color(255, 237, 213));
        btn10.setText("10");
        btn10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel2.add(btn10);

        btn11.setBackground(new java.awt.Color(255, 237, 213));
        btn11.setText("11");
        btn11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel2.add(btn11);

        btn12.setBackground(new java.awt.Color(255, 237, 213));
        btn12.setText("12");
        btn12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 4));
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel2.add(btn12);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 139, 476, 379));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ROMPECABEZAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 33, 529, -1));

        jPanel3.setBackground(new java.awt.Color(255, 237, 213));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 3));

        jButton1.setBackground(new java.awt.Color(246, 185, 183));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 237, 213));

        jClicks.setBackground(new java.awt.Color(255, 237, 213));
        jClicks.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jClicks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jClicks.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CLICKS:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jClicks, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jClicks, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(70, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 297, -1, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setText("jButton2");
        btnImgRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgRegresar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setText("jButton2");
        btnImgInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 34, 37));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 0, 208, 42));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntuación inicial:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, -1, 42));

        lblPuntuacionInicial.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblPuntuacionInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblPuntuacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 82, 42));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Puntuación global:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 48, -1, -1));
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 48, 49, 15));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        IntercambiaBotton(btn3, btn4);
        IntercambiaBotton(btn3, btn2);
        IntercambiaBotton(btn3, btn7);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        IntercambiaBotton(btn2, btn1);
        IntercambiaBotton(btn2, btn3);
        IntercambiaBotton(btn2, btn6);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        IntercambiaBotton(btn1, btn2);
        IntercambiaBotton(btn1, btn5);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        IntercambiaBotton(btn4, btn8);
        IntercambiaBotton(btn4, btn3);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        IntercambiaBotton(btn5, btn6);
        IntercambiaBotton(btn5, btn1);
        IntercambiaBotton(btn5, btn9);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        IntercambiaBotton(btn6, btn7);
        IntercambiaBotton(btn6, btn5);
        IntercambiaBotton(btn6, btn2);
        IntercambiaBotton(btn6, btn10);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        IntercambiaBotton(btn7, btn6);
        IntercambiaBotton(btn7, btn8);
        IntercambiaBotton(btn7, btn3);
        IntercambiaBotton(btn7, btn11);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        IntercambiaBotton(btn8, btn12);
        IntercambiaBotton(btn8, btn7);
        IntercambiaBotton(btn8, btn4);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        IntercambiaBotton(btn9, btn5);
        IntercambiaBotton(btn9, btn10);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        IntercambiaBotton(btn10, btn9);
        IntercambiaBotton(btn10, btn11);
        IntercambiaBotton(btn10, btn6);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        IntercambiaBotton(btn11, btn12);
        IntercambiaBotton(btn11, btn7);
        IntercambiaBotton(btn11, btn10);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        IntercambiaBotton(btn12, btn11);
        IntercambiaBotton(btn12, btn8);
    }//GEN-LAST:event_btn12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cont = 0;
        puntaje = 0;
        jClicks.setText(Integer.toString(cont));
        btn1.setEnabled(true);
        btn1.setVisible(true);
        btn2.setEnabled(true);
        btn2.setVisible(true);
        btn3.setEnabled(true);
        btn3.setVisible(true);
        btn4.setEnabled(true);
        btn4.setVisible(true);
        btn5.setEnabled(true);
        btn5.setVisible(true);
        btn6.setEnabled(true);
        btn6.setVisible(true);
        btn7.setEnabled(true);
        btn7.setVisible(true);
        btn8.setEnabled(true);
        btn8.setVisible(true);
        btn9.setEnabled(true);
        btn9.setVisible(true);
        btn10.setEnabled(true);
        btn10.setVisible(true);
        btn11.setEnabled(true);
        btn11.setVisible(true);
        btn12.setEnabled(true);
        btn12.setVisible(false);
        EnumerarBotones();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosNumeros regresar = new JuegosNumeros(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal regresar = new MenuPrincipal();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Acomoda las piezas en orden numerico", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
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
//            java.util.logging.Logger.getLogger(Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Jugador jugador = new Jugador("","");
//                jugador.offline();
//                new Puzzle(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnSonido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jClicks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblPuntuacionInicial;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    // End of variables declaration//GEN-END:variables
}
