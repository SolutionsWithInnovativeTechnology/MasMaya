package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Memorama extends javax.swing.JFrame {
    Timer timer = new Timer(1500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cartaVolteada && primerc) {
                if (im1.compareTo(im2) != 0) {
                    pbtn[0].setEnabled(true);
                    pbtn[1].setEnabled(true);
                } else {
                    if (click <= 5) {
                        puntuacion(30);
                        puntuacion += 30;
                        lblPuntuacion.setText(Integer.toString(puntuacion));
                    } else if (click <= 10) {
                        puntuacion(25);
                        puntuacion += 25;
                        lblPuntuacion.setText(Integer.toString(puntuacion));
                    } else if (click <= 15) {
                        puntuacion(20);
                        puntuacion += 20;
                        lblPuntuacion.setText(Integer.toString(puntuacion));
                    } else if (click <= 20) {
                        puntuacion(15);
                        puntuacion += 15;
                        lblPuntuacion.setText(Integer.toString(puntuacion));
                    } else if (click <= 25) {
                        puntuacion(10);
                        puntuacion += 10;
                        lblPuntuacion.setText(Integer.toString(puntuacion));
                    }
                }
                cartaVolteada = false;
            }
        }
    });
    BD mBD;
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    int click = 0;

    private Revolver log = new Revolver();
    private boolean cartaVolteada = false;
    private String im1;
    private String im2;
    private JButton[] pbtn = new JButton[2];
    private boolean primerc = false;
    private int puntuacion = 0;

    public Memorama(Jugador jugador) {
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
        Botones.transparenciaButtonBorder(btn10);
        Botones.transparenciaButtonBorder(btn11);
        Botones.transparenciaButtonBorder(btn12);
        Botones.transparenciaButtonBorder(btn13);
        Botones.transparenciaButtonBorder(btn14);
        Botones.transparenciaButtonBorder(btn15);
        Botones.transparenciaButtonBorder(btn16);
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
        cartasAl();
        timer.start();
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    private String asignarTexto(int numero) {
        String text = "numero ";
        switch (numero) {
            case 1:
                text += "0";
                break;
            case 9:
                text += "0";
                break;
            case 2:
                text += "1";
                break;
            case 10:
                text += "1";
                break;
            case 3:
                text += "2";
                break;
            case 11:
                text += "2";
                break;
            case 4:
                text += "3";
                break;
            case 12:
                text += "3";
                break;
            case 5:
                text += "4";
                break;
            case 13:
                text += "4";
                break;
            case 6:
                text += "5";
                break;
            case 14:
                text += "5";
                break;
            case 7:
                text += "6";
                break;
            case 15:
                text += "6";
                break;
            case 8:
                text += "7";
                break;
            case 16:
                text += "7";
                break;
        }
        return text;
    }

    private void cartasAl() {
        int[] numeros = log.NumerosAl();
        btn1.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[0] + ".jpg")));
        btn1.setName(asignarTexto(numeros[0]));
        btn2.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[1] + ".jpg")));
        btn2.setName(asignarTexto(numeros[1]));
        btn3.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[2] + ".jpg")));
        btn3.setName(asignarTexto(numeros[2]));
        btn4.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[3] + ".jpg")));
        btn4.setName(asignarTexto(numeros[3]));
        btn5.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[4] + ".jpg")));
        btn5.setName(asignarTexto(numeros[4]));
        btn6.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[5] + ".jpg")));
        btn6.setName(asignarTexto(numeros[5]));
        btn7.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[6] + ".jpg")));
        btn7.setName(asignarTexto(numeros[6]));
        btn8.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[7] + ".jpg")));
        btn8.setName(asignarTexto(numeros[7]));
        btn9.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[8] + ".jpg")));
        btn9.setName(asignarTexto(numeros[8]));
        btn10.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[9] + ".jpg")));
        btn10.setName(asignarTexto(numeros[9]));
        btn11.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[10] + ".jpg")));
        btn11.setName(asignarTexto(numeros[10]));
        btn12.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[11] + ".jpg")));
        btn12.setName(asignarTexto(numeros[11]));
        btn13.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[12] + ".jpg")));
        btn13.setName(asignarTexto(numeros[12]));
        btn14.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[13] + ".jpg")));
        btn14.setName(asignarTexto(numeros[13]));
        btn15.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[14] + ".jpg")));
        btn15.setName(asignarTexto(numeros[14]));
        btn16.setDisabledIcon(new ImageIcon(getClass().getResource("/img/c" + numeros[15] + ".jpg")));
        btn16.setName(asignarTexto(numeros[15]));
    }

    private void btnEnabled(JButton btn) {
        if (!cartaVolteada) {
            btn.setEnabled(false);
            im1 = btn.getName();
            pbtn[0] = btn;
            cartaVolteada = true;
            primerc = false;
        } else {
            btn.setEnabled(false);
            im2 = btn.getName();
            pbtn[1] = btn;
            primerc = true;
            click++;
            hola.setText(Integer.toString(click));
            if (click < 26) {
                pregwin();
            }
        }
        if (click > 25) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/lose.wav");
            JOptionPane.showMessageDialog(this, "Vuelve a intentarlo. Su puntaje es: " + puntuacion, "Perdiste :(", JOptionPane.INFORMATION_MESSAGE);
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
            btn12.setEnabled(false);
            btn13.setEnabled(false);
            btn14.setEnabled(false);
            btn15.setEnabled(false);
            btn16.setEnabled(false);
            primerc = false;
            cartaVolteada = false;
        }
    }

    private void compare() {
        if (cartaVolteada && primerc) {
            if (im1.compareTo(im2) != 0) {
                pbtn[0].setEnabled(true);
                pbtn[1].setEnabled(true);
            } else {
                if (click <= 5) {
                    puntuacion(30);
                    puntuacion += 30;
                    lblPuntuacion.setText(Integer.toString(puntuacion));
                } else if (click <= 10) {
                    puntuacion(25);
                    puntuacion += 25;
                    lblPuntuacion.setText(Integer.toString(puntuacion));
                } else if (click <= 15) {
                    puntuacion(20);
                    puntuacion += 20;
                    lblPuntuacion.setText(Integer.toString(puntuacion));
                } else if (click <= 20) {
                    puntuacion(15);
                    puntuacion += 15;
                    lblPuntuacion.setText(Integer.toString(puntuacion));
                } else if (click <= 25) {
                    puntuacion(10);
                    puntuacion += 10;
                    lblPuntuacion.setText(Integer.toString(puntuacion));
                }
            }
            cartaVolteada = false;
        }
    }

    private void reiniciar() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn12.setEnabled(true);
        btn13.setEnabled(true);
        btn14.setEnabled(true);
        btn15.setEnabled(true);
        btn16.setEnabled(true);

        primerc = false;
        cartaVolteada = false;
        puntuacion = 0;
        lblPuntuacion.setText(Integer.toString(puntuacion));
        click = 0;
        hola.setText(Integer.toString(click));
        this.cartasAl();
    }

    private void pregwin() {
        if (!btn1.isEnabled() && !btn2.isEnabled() && !btn3.isEnabled() && !btn4.isEnabled() && !btn5.isEnabled() && !btn6.isEnabled() &&
                !btn7.isEnabled() && !btn8.isEnabled() && !btn9.isEnabled() && !btn10.isEnabled() && !btn11.isEnabled() &&
                !btn12.isEnabled() && !btn13.isEnabled() && !btn14.isEnabled() && !btn15.isEnabled() && !btn16.isEnabled()) {
            new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
            JOptionPane.showMessageDialog(this, "Felicidades, usted ha ganado. Su puntaje es: " + puntuacion, "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
        }
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
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        hola = new javax.swing.JTextField();
        reiniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        btnImgSoporte = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
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
        jLabel1.setText("MEMORAMA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 51, 411, -1));

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));

        btn1.setBackground(new java.awt.Color(77, 52, 28));
        btn1.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        btn1.setForeground(new java.awt.Color(77, 52, 28));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(77, 52, 28));
        btn2.setForeground(new java.awt.Color(77, 52, 28));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(77, 52, 28));
        btn3.setForeground(new java.awt.Color(77, 52, 28));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(77, 52, 28));
        btn5.setForeground(new java.awt.Color(77, 52, 28));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(77, 52, 28));
        btn7.setForeground(new java.awt.Color(77, 52, 28));
        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(77, 52, 28));
        btn6.setForeground(new java.awt.Color(77, 52, 28));
        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn12.setBackground(new java.awt.Color(77, 52, 28));
        btn12.setForeground(new java.awt.Color(77, 52, 28));
        btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(77, 52, 28));
        btn9.setForeground(new java.awt.Color(77, 52, 28));
        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn10.setBackground(new java.awt.Color(77, 52, 28));
        btn10.setForeground(new java.awt.Color(77, 52, 28));
        btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn11.setBackground(new java.awt.Color(77, 52, 28));
        btn11.setForeground(new java.awt.Color(77, 52, 28));
        btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn16.setBackground(new java.awt.Color(77, 52, 28));
        btn16.setForeground(new java.awt.Color(77, 52, 28));
        btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });

        btn13.setBackground(new java.awt.Color(77, 52, 28));
        btn13.setForeground(new java.awt.Color(77, 52, 28));
        btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });

        btn14.setBackground(new java.awt.Color(77, 52, 28));
        btn14.setForeground(new java.awt.Color(77, 52, 28));
        btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });

        btn15.setBackground(new java.awt.Color(77, 52, 28));
        btn15.setForeground(new java.awt.Color(77, 52, 28));
        btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(77, 52, 28));
        btn8.setForeground(new java.awt.Color(77, 52, 28));
        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(77, 52, 28));
        btn4.setForeground(new java.awt.Color(77, 52, 28));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama1.png"))); // NOI18N
        btn4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 4, true));
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reversoMemorama2.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn8)
                                                        .addComponent(btn4)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btn10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn15)
                                                        .addComponent(btn11))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn12)
                                                        .addComponent(btn16))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn2)
                                        .addComponent(btn3)
                                        .addComponent(btn1)
                                        .addComponent(btn4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn6)
                                        .addComponent(btn7)
                                        .addComponent(btn5)
                                        .addComponent(btn8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn10)
                                        .addComponent(btn11)
                                        .addComponent(btn12)
                                        .addComponent(btn9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn14)
                                        .addComponent(btn15)
                                        .addComponent(btn16)
                                        .addComponent(btn13))
                                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 113, -1, -1));

        hola.setBackground(new java.awt.Color(219, 239, 254));
        hola.setBorder(null);
        hola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holaActionPerformed(evt);
            }
        });
        jPanel2.add(hola, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 618, 37, -1));

        reiniciar.setBackground(new java.awt.Color(255, 237, 213));
        reiniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel2.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Intentos:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 619, 66, -1));

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
        jPanel2.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 34, 37));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 34, 37));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntuación:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 619, 80, -1));
        jPanel2.add(lblPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 615, 37, 25));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 0, 250, 26));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Puntuación global:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 32, -1, -1));
        jPanel2.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 32, 49, 15));

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
        jPanel2.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn11);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn5);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn6);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn7);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn8);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn9);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn10);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn12);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn13);
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn14);
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn15);
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        if (!(cartaVolteada && primerc)) btnEnabled(btn16);
    }//GEN-LAST:event_btn16ActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        reiniciar();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void holaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holaActionPerformed

    }//GEN-LAST:event_holaActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosNumeros regresar = new JuegosNumeros(jugador);
        regresar.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal regresar = new MenuPrincipal();
        regresar.setVisible(true);
        timer.stop();
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Encuentra todos los pares, número en digito con número maya", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);

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
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
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
    private javax.swing.JTextField hola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JButton reiniciar;
    // End of variables declaration//GEN-END:variables

}
