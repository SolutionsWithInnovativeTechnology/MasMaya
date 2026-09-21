package JuegoMaya;

import Util.Botones;
import Util.Jugador;
import Util.ReproductorEfectos;
import Util.ReproductorSonido;

import javax.swing.*;

public class InformacionAnimales extends javax.swing.JFrame {
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    ReproductorEfectos efectos = new ReproductorEfectos();

    public InformacionAnimales(Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        Botones.transparenciaButton(btnImgAyuda);
        Botones.transparenciaButton(btnImgRegresar);
        Botones.transparenciaButton(btnImgInicio1);
        Botones.transparenciaButton(btnAnimal0);
        Botones.transparenciaButton(btnAnimal1);
        Botones.transparenciaButton(btnAnimal2);
        Botones.transparenciaButton(btnAnimal3);
        Botones.transparenciaButton(btnAnimal4);
        Botones.transparenciaButton(btnAnimal5);
        Botones.transparenciaButton(btnAnimal6);
        Botones.transparenciaButton(btnAnimal7);
        Botones.transparenciaButton(btnAnimal8);
        Botones.transparenciaButton(btnAnimal9);
        Botones.transparenciaButton(btnAnimal10);
        Botones.transparenciaButton(btnAnimal11);
        Botones.transparenciaButton(btnAnimal12);
        Botones.transparenciaButton(btnAnimal13);
        Botones.transparenciaButton(btnAnimal14);
        Botones.transparenciaButton(btnAnimal15);
        Botones.transparenciaButton(btnAnimal16);
        Botones.transparenciaButton(btnAnimal17);
        Botones.transparenciaButton(btnAnimal18);
        Botones.transparenciaButton(btnAnimal19);
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
        btnImgRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnAnimal0 = new javax.swing.JButton();
        btnAnimal1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblFruta = new javax.swing.JLabel();
        btnImgAyuda = new javax.swing.JButton();
        btnAnimal2 = new javax.swing.JButton();
        btnAnimal3 = new javax.swing.JButton();
        btnAnimal4 = new javax.swing.JButton();
        btnAnimal5 = new javax.swing.JButton();
        btnAnimal6 = new javax.swing.JButton();
        btnAnimal7 = new javax.swing.JButton();
        btnAnimal8 = new javax.swing.JButton();
        btnAnimal9 = new javax.swing.JButton();
        btnAnimal10 = new javax.swing.JButton();
        btnAnimal11 = new javax.swing.JButton();
        btnAnimal12 = new javax.swing.JButton();
        btnAnimal13 = new javax.swing.JButton();
        btnAnimal14 = new javax.swing.JButton();
        btnAnimal15 = new javax.swing.JButton();
        btnAnimal16 = new javax.swing.JButton();
        btnAnimal18 = new javax.swing.JButton();
        btnAnimal17 = new javax.swing.JButton();
        btnAnimal19 = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnImgInicio1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImgRegresar.setBackground(new java.awt.Color(255, 237, 213));
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Abeja");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gavilán");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 80, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lechuza");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Caballo");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 70, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cerdo");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Pájaro carpintero");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 130, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Conejo");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 70, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Puma");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 80, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Pez");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Jaguar");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 80, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Víbora");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 90, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Tortuga");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 80, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Mariposa");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 90, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Perro");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 70, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Cocodrilo");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Venado");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 70, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Murciélago");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 80, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Garrapata");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Libélula");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 80, 30));

        btnAnimal0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal0ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, 100));

        btnAnimal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 80, 100));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Gato");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 70, 30));

        lblFruta.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblFruta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFruta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblFruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 230, 30));

        btnImgAyuda.setBackground(new java.awt.Color(255, 237, 213));
        btnImgAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgAyuda.setBorder(null);
        btnImgAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImgAyuda.setMaximumSize(new java.awt.Dimension(40, 40));
        btnImgAyuda.setMinimumSize(new java.awt.Dimension(40, 40));
        btnImgAyuda.setPreferredSize(new java.awt.Dimension(40, 40));
        btnImgAyuda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 590, 34, 37));

        btnAnimal2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 100));

        btnAnimal3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 80, 100));

        btnAnimal4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 90));

        btnAnimal5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 80, 90));

        btnAnimal6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, 90));

        btnAnimal7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 80, 90));

        btnAnimal8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 70, 90));

        btnAnimal9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 80, 90));

        btnAnimal10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal10ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 90, 90));

        btnAnimal11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal11ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 100, 90));

        btnAnimal12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal12ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal12, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 400, 70, 90));

        btnAnimal13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal13ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 80, 90));

        btnAnimal14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal14ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 90, 90));

        btnAnimal15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal15ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 80, 90));

        btnAnimal16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal16ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 70, 100));

        btnAnimal18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal18ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 70, 90));

        btnAnimal17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal17ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 80, 90));

        btnAnimal19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnimal19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimal19ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimal19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 80, 90));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 34, 37));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info_Animales.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 590, 473));

        btnImgInicio1.setBackground(new java.awt.Color(219, 239, 254));
        btnImgInicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio1.setBorder(null);
        btnImgInicio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicio1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnImgInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reproducirAnimal(int i) {
        efectos.reproducirEfecto("/sonidos/animales/" + i + ".wav");
    }

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosAnimales regresar = new JuegosAnimales(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgAyudaActionPerformed
        JOptionPane.showMessageDialog(this, "Presiona cualquier animal para escuchar su pronunciación y ver su escritura.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgAyudaActionPerformed

    private void btnAnimal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal0ActionPerformed
        lblFruta.setText("Yik'el kaab");
        reproducirAnimal(0);
    }//GEN-LAST:event_btnAnimal0ActionPerformed

    private void btnAnimal6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal6ActionPerformed
        reproducirAnimal(6);
        lblFruta.setText("T'u'ul");
    }//GEN-LAST:event_btnAnimal6ActionPerformed

    private void btnAnimal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal1ActionPerformed
        lblFruta.setText("I'");
        reproducirAnimal(1);
    }//GEN-LAST:event_btnAnimal1ActionPerformed

    private void btnAnimal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal2ActionPerformed
        lblFruta.setText("Xooch'");
        reproducirAnimal(2);
    }//GEN-LAST:event_btnAnimal2ActionPerformed

    private void btnAnimal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal3ActionPerformed
        reproducirAnimal(3);
        lblFruta.setText("Tsíimin");
    }//GEN-LAST:event_btnAnimal3ActionPerformed

    private void btnAnimal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal4ActionPerformed
        reproducirAnimal(4);
        lblFruta.setText("K'éek'en");
    }//GEN-LAST:event_btnAnimal4ActionPerformed

    private void btnAnimal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal5ActionPerformed
        lblFruta.setText("Ch'ejun");
        reproducirAnimal(5);
    }//GEN-LAST:event_btnAnimal5ActionPerformed

    private void btnAnimal7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal7ActionPerformed
        lblFruta.setText("Koj");
        reproducirAnimal(7);
    }//GEN-LAST:event_btnAnimal7ActionPerformed

    private void btnAnimal8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal8ActionPerformed
        reproducirAnimal(8);
        lblFruta.setText("Miis");
    }//GEN-LAST:event_btnAnimal8ActionPerformed

    private void btnAnimal9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal9ActionPerformed
        reproducirAnimal(9);
        lblFruta.setText("Báalam");
    }//GEN-LAST:event_btnAnimal9ActionPerformed

    private void btnAnimal10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal10ActionPerformed
        reproducirAnimal(10);
        lblFruta.setText("Peépem");
    }//GEN-LAST:event_btnAnimal10ActionPerformed

    private void btnAnimal11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal11ActionPerformed
        lblFruta.setText("Áayin");
        reproducirAnimal(11);
    }//GEN-LAST:event_btnAnimal11ActionPerformed

    private void btnAnimal12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal12ActionPerformed
        reproducirAnimal(12);
        lblFruta.setText("Peek'");
    }//GEN-LAST:event_btnAnimal12ActionPerformed

    private void btnAnimal13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal13ActionPerformed
        reproducirAnimal(13);
        lblFruta.setText("Kay");
    }//GEN-LAST:event_btnAnimal13ActionPerformed

    private void btnAnimal14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal14ActionPerformed
        reproducirAnimal(14);
        lblFruta.setText("Kaan");
    }//GEN-LAST:event_btnAnimal14ActionPerformed

    private void btnAnimal15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal15ActionPerformed
        reproducirAnimal(15);
        lblFruta.setText("Àak");
    }//GEN-LAST:event_btnAnimal15ActionPerformed

    private void btnAnimal18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal18ActionPerformed
        lblFruta.setText("Peech");
        reproducirAnimal(18);
    }//GEN-LAST:event_btnAnimal18ActionPerformed

    private void btnAnimal17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal17ActionPerformed
        lblFruta.setText("Soots'");
        reproducirAnimal(17);
    }//GEN-LAST:event_btnAnimal17ActionPerformed

    private void btnAnimal19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal19ActionPerformed
        lblFruta.setText("Turix");
        reproducirAnimal(19);
    }//GEN-LAST:event_btnAnimal19ActionPerformed

    private void btnAnimal16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimal16ActionPerformed
        lblFruta.setText("Kéej");
        reproducirAnimal(16);
    }//GEN-LAST:event_btnAnimal16ActionPerformed

    private void btnImgInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicio1ActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicio1ActionPerformed

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
//            java.util.logging.Logger.getLogger(Información.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Información.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Información.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Información.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Jugador jugador = new Jugador("","");
//                jugador.offline();
//                new Información(jugador).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimal0;
    private javax.swing.JButton btnAnimal1;
    private javax.swing.JButton btnAnimal10;
    private javax.swing.JButton btnAnimal11;
    private javax.swing.JButton btnAnimal12;
    private javax.swing.JButton btnAnimal13;
    private javax.swing.JButton btnAnimal14;
    private javax.swing.JButton btnAnimal15;
    private javax.swing.JButton btnAnimal16;
    private javax.swing.JButton btnAnimal17;
    private javax.swing.JButton btnAnimal18;
    private javax.swing.JButton btnAnimal19;
    private javax.swing.JButton btnAnimal2;
    private javax.swing.JButton btnAnimal3;
    private javax.swing.JButton btnAnimal4;
    private javax.swing.JButton btnAnimal5;
    private javax.swing.JButton btnAnimal6;
    private javax.swing.JButton btnAnimal7;
    private javax.swing.JButton btnAnimal8;
    private javax.swing.JButton btnAnimal9;
    private javax.swing.JButton btnImgAyuda;
    private javax.swing.JButton btnImgInicio1;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFruta;
    // End of variables declaration//GEN-END:variables
}
