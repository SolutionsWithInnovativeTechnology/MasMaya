package JuegoMaya;

import Util.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pescar extends javax.swing.JFrame {
    BD mBD;
    Jugador jugador;
    int nIntentos = 5;
    private String palabra;
    int puntaje = 100;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    ReproductorEfectos efectos = new ReproductorEfectos();

    // Palabras a adivinar
    String[] pistas = {
            "JA'AS", "OON", "CHI'", "PICHI'", "ABA", "CHAK BOJONJA'", "ABAL", "CH'UJUK PAK'ÁAL", "CHAKAL JA'AS", "OOK", "CHI'IKMA", "P'AAK", "YA'", "PUUT", "SU'UTS' MULIIX", "K'uúm"
    };
    String[] palabras = {
            "PLATANO", "AGUACATE", "NANCE", "GUAYABA", "UVA", "SANDIA", "CIRUELA", "NARANJA", "MAMEY", "MANGO", "JICAMA", "TOMATE", "ZAPOTE", "PAPAYA", "LIMON", "CALABAZA"
    };

    public Pescar(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");
        initComponents();

        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }

        Botones.transparenciaButton(btnImgSoporte);
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
        puntuacion.setText("Puntuación: " + puntaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ahorcado = new javax.swing.JLabel();
        intentos = new javax.swing.JTextField();
        intento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        q = new javax.swing.JButton();
        w = new javax.swing.JButton();
        e = new javax.swing.JButton();
        a = new javax.swing.JButton();
        p = new javax.swing.JButton();
        r = new javax.swing.JButton();
        t = new javax.swing.JButton();
        y = new javax.swing.JButton();
        u = new javax.swing.JButton();
        i = new javax.swing.JButton();
        o = new javax.swing.JButton();
        s = new javax.swing.JButton();
        d = new javax.swing.JButton();
        f = new javax.swing.JButton();
        g = new javax.swing.JButton();
        h = new javax.swing.JButton();
        j = new javax.swing.JButton();
        k = new javax.swing.JButton();
        l = new javax.swing.JButton();
        x = new javax.swing.JButton();
        c = new javax.swing.JButton();
        v = new javax.swing.JButton();
        b = new javax.swing.JButton();
        n = new javax.swing.JButton();
        m = new javax.swing.JButton();
        z = new javax.swing.JButton();
        btnImgRegresar = new javax.swing.JButton();
        btnImgInicio = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        puntuacion = new javax.swing.JLabel();
        btnImgSoporte = new javax.swing.JButton();
        txtPista = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PESCAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 18, 306, 45));

        ahorcado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ahorcado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPescar/peces.png"))); // NOI18N
        jPanel1.add(ahorcado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 167, 415, -1));

        intentos.setEditable(false);
        intentos.setBackground(new java.awt.Color(219, 239, 254));
        intentos.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        intentos.setForeground(new java.awt.Color(71, 34, 14));
        intentos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        intentos.setText("Te quedan 5 intentos");
        intentos.setBorder(null);
        intentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        intentos.setFocusable(false);
        jPanel1.add(intentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 267, 409, -1));

        intento.setEditable(false);
        intento.setBackground(new java.awt.Color(219, 239, 254));
        intento.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        intento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        intento.setBorder(null);
        intento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        intento.setFocusable(false);
        jPanel1.add(intento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 308, 421, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 34, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese una letra");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 349, 421, -1));

        q.setBackground(new java.awt.Color(71, 34, 14));
        q.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        q.setForeground(new java.awt.Color(255, 255, 255));
        q.setText("Q");
        q.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qActionPerformed(evt);
            }
        });
        jPanel1.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 390, -1, -1));

        w.setBackground(new java.awt.Color(71, 34, 14));
        w.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        w.setForeground(new java.awt.Color(255, 255, 255));
        w.setText("W");
        w.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        w.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wActionPerformed(evt);
            }
        });
        jPanel1.add(w, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 390, -1, -1));

        e.setBackground(new java.awt.Color(71, 34, 14));
        e.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        e.setForeground(new java.awt.Color(255, 255, 255));
        e.setText("E");
        e.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eActionPerformed(evt);
            }
        });
        jPanel1.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 390, -1, -1));

        a.setBackground(new java.awt.Color(71, 34, 14));
        a.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        a.setForeground(new java.awt.Color(255, 255, 255));
        a.setText("A");
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 428, -1, -1));

        p.setBackground(new java.awt.Color(71, 34, 14));
        p.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("P");
        p.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        jPanel1.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 390, -1, -1));

        r.setBackground(new java.awt.Color(71, 34, 14));
        r.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        r.setForeground(new java.awt.Color(255, 255, 255));
        r.setText("R");
        r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });
        jPanel1.add(r, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 390, -1, -1));

        t.setBackground(new java.awt.Color(71, 34, 14));
        t.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        t.setForeground(new java.awt.Color(255, 255, 255));
        t.setText("T");
        t.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });
        jPanel1.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 390, -1, -1));

        y.setBackground(new java.awt.Color(71, 34, 14));
        y.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        y.setForeground(new java.awt.Color(255, 255, 255));
        y.setText("Y");
        y.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yActionPerformed(evt);
            }
        });
        jPanel1.add(y, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 390, -1, -1));

        u.setBackground(new java.awt.Color(71, 34, 14));
        u.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        u.setForeground(new java.awt.Color(255, 255, 255));
        u.setText("U");
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uActionPerformed(evt);
            }
        });
        jPanel1.add(u, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 390, -1, -1));

        i.setBackground(new java.awt.Color(71, 34, 14));
        i.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        i.setForeground(new java.awt.Color(255, 255, 255));
        i.setText("I");
        i.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iActionPerformed(evt);
            }
        });
        jPanel1.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 390, -1, -1));

        o.setBackground(new java.awt.Color(71, 34, 14));
        o.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        o.setForeground(new java.awt.Color(255, 255, 255));
        o.setText("O");
        o.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oActionPerformed(evt);
            }
        });
        jPanel1.add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 390, -1, -1));

        s.setBackground(new java.awt.Color(71, 34, 14));
        s.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        s.setForeground(new java.awt.Color(255, 255, 255));
        s.setText("S");
        s.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });
        jPanel1.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 428, -1, -1));

        d.setBackground(new java.awt.Color(71, 34, 14));
        d.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        d.setForeground(new java.awt.Color(255, 255, 255));
        d.setText("D");
        d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 428, -1, -1));

        f.setBackground(new java.awt.Color(71, 34, 14));
        f.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        f.setForeground(new java.awt.Color(255, 255, 255));
        f.setText("F");
        f.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });
        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 428, -1, -1));

        g.setBackground(new java.awt.Color(71, 34, 14));
        g.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        g.setForeground(new java.awt.Color(255, 255, 255));
        g.setText("G");
        g.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gActionPerformed(evt);
            }
        });
        jPanel1.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 428, -1, -1));

        h.setBackground(new java.awt.Color(71, 34, 14));
        h.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        h.setForeground(new java.awt.Color(255, 255, 255));
        h.setText("H");
        h.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });
        jPanel1.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 428, -1, -1));

        j.setBackground(new java.awt.Color(71, 34, 14));
        j.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        j.setForeground(new java.awt.Color(255, 255, 255));
        j.setText("J");
        j.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActionPerformed(evt);
            }
        });
        jPanel1.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 428, -1, -1));

        k.setBackground(new java.awt.Color(71, 34, 14));
        k.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        k.setForeground(new java.awt.Color(255, 255, 255));
        k.setText("K");
        k.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kActionPerformed(evt);
            }
        });
        jPanel1.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 428, -1, -1));

        l.setBackground(new java.awt.Color(71, 34, 14));
        l.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("L");
        l.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lActionPerformed(evt);
            }
        });
        jPanel1.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 428, -1, -1));

        x.setBackground(new java.awt.Color(71, 34, 14));
        x.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        x.setForeground(new java.awt.Color(255, 255, 255));
        x.setText("X");
        x.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        jPanel1.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 466, -1, -1));

        c.setBackground(new java.awt.Color(71, 34, 14));
        c.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        c.setForeground(new java.awt.Color(255, 255, 255));
        c.setText("C");
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 466, -1, -1));

        v.setBackground(new java.awt.Color(71, 34, 14));
        v.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        v.setForeground(new java.awt.Color(255, 255, 255));
        v.setText("V");
        v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vActionPerformed(evt);
            }
        });
        jPanel1.add(v, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 466, -1, -1));

        b.setBackground(new java.awt.Color(71, 34, 14));
        b.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setText("B");
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 466, -1, -1));

        n.setBackground(new java.awt.Color(71, 34, 14));
        n.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        n.setForeground(new java.awt.Color(255, 255, 255));
        n.setText("N");
        n.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });
        jPanel1.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 466, -1, -1));

        m.setBackground(new java.awt.Color(71, 34, 14));
        m.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        m.setForeground(new java.awt.Color(255, 255, 255));
        m.setText("M");
        m.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });
        jPanel1.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 466, -1, -1));

        z.setBackground(new java.awt.Color(71, 34, 14));
        z.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        z.setForeground(new java.awt.Color(255, 255, 255));
        z.setText("Z");
        z.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zActionPerformed(evt);
            }
        });
        jPanel1.add(z, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 466, -1, -1));

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 37));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 34, 37));

        btnReiniciar.setBackground(new java.awt.Color(255, 237, 213));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 168, 107), 3));
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 88, 25));

        puntuacion.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        puntuacion.setText("Puntuación: ");
        jPanel1.add(puntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setBorder(null);
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 34, 37));

        txtPista.setEditable(false);
        txtPista.setBackground(new java.awt.Color(219, 239, 254));
        txtPista.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        txtPista.setForeground(new java.awt.Color(71, 34, 14));
        txtPista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPista.setText("Palabra a adivinar");
        txtPista.setBorder(null);
        txtPista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPista.setFocusable(false);
        jPanel1.add(txtPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 121, 421, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Puntuación global:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 78, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 69, 200, 46));

        lblpuntuacionGlobal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblpuntuacionGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 78, 23, 15));

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 390, 14, 26));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reproducirFruta(int i) {
        efectos.reproducirEfecto("/sonidos/frutas/" + i + ".wav");
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    /*
        Intenta letra
    */
    private void kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kActionPerformed
        tryLetra(k);
    }//GEN-LAST:event_kActionPerformed

    private void lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lActionPerformed
        tryLetra(l);
    }//GEN-LAST:event_lActionPerformed

    private void qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qActionPerformed
        tryLetra(q);
    }//GEN-LAST:event_qActionPerformed

    private void wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wActionPerformed
        tryLetra(w);
    }//GEN-LAST:event_wActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        tryLetra(a);
    }//GEN-LAST:event_aActionPerformed

    private void eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eActionPerformed
        tryLetra(e);
    }//GEN-LAST:event_eActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        tryLetra(r);
    }//GEN-LAST:event_rActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        tryLetra(t);
    }//GEN-LAST:event_tActionPerformed

    private void yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yActionPerformed
        tryLetra(y);
    }//GEN-LAST:event_yActionPerformed

    private void uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uActionPerformed
        tryLetra(u);
    }//GEN-LAST:event_uActionPerformed

    private void iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iActionPerformed
        tryLetra(i);
    }//GEN-LAST:event_iActionPerformed

    private void oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oActionPerformed
        tryLetra(o);
    }//GEN-LAST:event_oActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        tryLetra(p);
    }//GEN-LAST:event_pActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        tryLetra(s);
    }//GEN-LAST:event_sActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        tryLetra(d);
    }//GEN-LAST:event_dActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        tryLetra(f);
    }//GEN-LAST:event_fActionPerformed

    private void gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gActionPerformed
        tryLetra(g);
    }//GEN-LAST:event_gActionPerformed

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed
        tryLetra(h);
    }//GEN-LAST:event_hActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        tryLetra(x);
    }//GEN-LAST:event_xActionPerformed

    private void zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zActionPerformed
        tryLetra(z);
    }//GEN-LAST:event_zActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        tryLetra(c);
    }//GEN-LAST:event_cActionPerformed

    private void vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vActionPerformed
        tryLetra(v);
    }//GEN-LAST:event_vActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        tryLetra(b);
    }//GEN-LAST:event_bActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        tryLetra(n);
    }//GEN-LAST:event_nActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        tryLetra(m);
    }//GEN-LAST:event_mActionPerformed

    private void jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActionPerformed
        tryLetra(j);
    }//GEN-LAST:event_jActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Random rand = new Random();

        // Genera un índice aleatorio de las palabras
        int indicePalabra = rand.nextInt(palabras.length);
        // Asigna la palabra aleatoria que corresponde al índice
        palabra = palabras[indicePalabra];

        StringBuilder palabraSecreta = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            palabraSecreta.append("_  ");
        }
        //Asigna los espacios de la palabra en español
        intento.setText(palabraSecreta.toString());
        //Asigna la pista en maya
        txtPista.setText(pistas[indicePalabra]);
        reproducirFruta(indicePalabra);
    }//GEN-LAST:event_formWindowOpened

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        efectos.cerrarRecurso();
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrutas regresar = new JuegosFrutas(jugador);
        regresar.setVisible(true);
        efectos.cerrarRecurso();
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        Pescar nuevoJuego = new Pescar(jugador);
        nuevoJuego.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Adivine la fruta escrita en español a partir de la pista escrita en maya."
                , "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
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

    //Método que comprueba si la letra se encuentra en la palabra
    public void tryLetra(JButton btnLetra) {
        String letra = btnLetra.getText();
        Color colorBtn = btnLetra.getBackground();
        if (tieneLetra(letra)) {
            //Evalúa si ya se ha presionado ese botón 
            if (colorBtn.equals(Color.GREEN)) {
                new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/error.wav");
                JOptionPane.showMessageDialog(rootPane, "Ya ha presionado este botón", "Error", JOptionPane.ERROR_MESSAGE);
            } else { //Si no se ha presionado, cambia las letras y lo marca como presionado
                reemplazaLetras(letra);
                btnLetra.setBackground(Color.GREEN);
            }
        } else {
            if (colorBtn.equals(Color.RED)) { //Evalúa si ya se ha presionado ese botón
                new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/error.wav");
                JOptionPane.showMessageDialog(rootPane, "Ya ha presionado este botón", "Error", JOptionPane.ERROR_MESSAGE);
            } else { //Si no se ha presionado, te quita un intento y lo marca como presionado
                btnLetra.setBackground(Color.RED);
                nIntentos--;
                puntaje -= 20;
                puntuacion.setText("Puntuación: " + puntaje);
                if (nIntentos > 0)
                    intentos.setText("Te quedan " + nIntentos + " intentos.");
            }
        }
        comprueba();
    }

    //Método que pone la letra donde corresponde si es correcta
    public void reemplazaLetras(String letra) {
        int length = palabra.length();
        String contenido = intento.getText();
        StringBuilder newPalabra = new StringBuilder(intento.getText()); //Crea un objeto de una clase para modificar Strings

        for (int i = 0; i < length; i++) {
            char letraActual = palabra.charAt(i); //letra de la palabra oculta

            for (int j = 0; j < contenido.length(); j++) { //recorre el intento
                char lActualIntento = intento.getText().charAt(j); // caracter actual del intento
                //Evalúa si el caracter actual del intento es un espacio y la letra de la palabra oculta es la letra seleccionada
                if (lActualIntento == '_' && letraActual == letra.charAt(0)) {
                    if (i == 0)
                        newPalabra.setCharAt(i, letra.charAt(0));
                    else//si no es el primer espacio, lo multiplica por 3 debido a los espacios en blanco
                        newPalabra.setCharAt(i * 3, letra.charAt(0));
                }
            }
        }
        intento.setText(newPalabra.toString());
    }


    //Método que comprueba si acertaste
    public void comprueba() {
        String contenido = intento.getText().replaceAll(" ", "");

        if (contenido.equalsIgnoreCase(palabra)) {
            puntuacion(puntaje);
            FinJuego fin = new FinJuego(nIntentos, palabra, jugador);
            fin.setVisible(true);
            this.dispose();
        } else {
            switch (nIntentos) {
                case 4:
                    ahorcado.setIcon(new ImageIcon(getClass().getResource("/imgPescar/peces2.png")));
                    break;
                case 3:
                    ahorcado.setIcon(new ImageIcon(getClass().getResource("/imgPescar/peces3.png")));
                    break;
                case 2:
                    ahorcado.setIcon(new ImageIcon(getClass().getResource("/imgPescar/peces4.png")));
                    break;
                case 1:
                    ahorcado.setIcon(new ImageIcon(getClass().getResource("/imgPescar/peces5.png")));
                    break;
                case 0:
                    ahorcado.setIcon(new ImageIcon(getClass().getResource("/imgPescar/peces6.png")));
                    break;
            }
            if (nIntentos <= 0) {
                intentos.setText("Te quedan " + nIntentos + " intentos.");
                FinJuego fin = new FinJuego(nIntentos, palabra, jugador);
                fin.setVisible(true);
                intento.setText("");
                this.dispose();
            }
        }
    }

    //Método que comprueba si la palabra contiene una letra
    public boolean tieneLetra(String letra) {
        int length = palabra.length();
        for (int i = 0; i < length; i++) {
            char letraActual = palabra.charAt(i);
            if (letraActual == letra.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JLabel ahorcado;
    private javax.swing.JButton b;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JButton c;
    private javax.swing.JButton d;
    private javax.swing.JButton e;
    private javax.swing.JButton f;
    private javax.swing.JButton g;
    private javax.swing.JButton h;
    private javax.swing.JButton i;
    public javax.swing.JTextField intento;
    private javax.swing.JTextField intentos;
    private javax.swing.JButton j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton k;
    private javax.swing.JButton l;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JButton m;
    private javax.swing.JButton n;
    private javax.swing.JButton o;
    private javax.swing.JButton p;
    private javax.swing.JLabel puntuacion;
    private javax.swing.JButton q;
    private javax.swing.JButton r;
    private javax.swing.JButton s;
    private javax.swing.JButton t;
    private javax.swing.JTextField txtPista;
    private javax.swing.JButton u;
    private javax.swing.JButton v;
    private javax.swing.JButton w;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    private javax.swing.JButton z;
    // End of variables declaration//GEN-END:variables
}