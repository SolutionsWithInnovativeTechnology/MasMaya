package JuegoMaya;

import Util.Botones;
import Util.Jugador;
import Util.ReproductorSonido;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class DatosCuriosos extends javax.swing.JFrame {

    private ArrayList<String[]> datosCuriosos;
    private ArrayList<String[]> datosDisponibles;
    private ArrayList<String> rutasImg;
    private ArrayList<String> rutasImgDisponibles;

    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();

    public DatosCuriosos(Jugador jugador) {
        this.jugador = jugador;
        initDatos();
        initComponents();
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }
        Botones.transparenciaButtonBorder(btnImgRegresar);
        Botones.transparenciaButton(btnSonido);
        if (reproductor.isMusicPlaying()) {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_sonido.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_sonido1.png")));
        } else {
            btnSonido.setIcon(new ImageIcon(getClass().getResource("/img/icon_mute.png")));
            btnSonido.setRolloverIcon(new ImageIcon(getClass().getResource("/img/icon_mute1.png")));
        }

        setResizable(false);

        generarDatoAleatorio();
    }

    private void initDatos() {
        // Lista de datos curiosos
        datosCuriosos = new ArrayList<>();
        datosCuriosos.add(new String[]{"Eran grandes observadores del cielo", "Los mayas miraban las estrellas para hacer calendarios muy precisos. ¡Eran científicos del espacio antiguo!"});
        datosCuriosos.add(new String[]{"Inventaron el número cero", "Los mayas fueron de los primeros en usar el \"cero\" para hacer cálculos matemáticos."});
        datosCuriosos.add(new String[]{"Jugaban un deporte único", "Tenían un juego donde golpeaban una pelota sin usar manos ni pies. ¡Era difícil pero emocionante!"});
        datosCuriosos.add(new String[]{"Construyeron enormes pirámides", "Sus pirámides y templos eran tan grandes como impresionantes, y aún podemos visitarlos hoy."});
        datosCuriosos.add(new String[]{"Usaban chocolate como dinero", "Las semillas de cacao eran tan valiosas para ellos que las usaban para comprar cosas."});
        datosCuriosos.add(new String[]{"Hablaban muchos idiomas", "Aunque no hablaban español, tenían lenguas propias, y muchas personas aún las hablan hoy."});
        datosCuriosos.add(new String[]{"Creían en muchos dioses", "Tenían dioses para todo: desde la lluvia hasta el maíz, ¡cada aspecto de la vida estaba protegido!"});
        datosCuriosos.add(new String[]{"Eran artistas increíbles", "Los mayas dibujaban, esculpían y pintaban hermosos murales llenos de colores."});
        datosCuriosos.add(new String[]{"Vivían en la selva", "Sus ciudades estaban rodeadas de árboles, jaguares y monos. ¡La naturaleza era su hogar!"});
        datosCuriosos.add(new String[]{"El maíz era su comida favorita", "Hacían tortillas y tamales con maíz. ¡Era esencial para su vida diaria!"});
        datosCuriosos.add(new String[]{"Desarrollaron sistemas de escritura", "Usaban símbolos y jeroglíficos para contar historias y registrar hechos importantes."});
        datosCuriosos.add(new String[]{"Usaban cenotes para rituales sagrados", "Los mayas creían que los cenotes eran puertas al inframundo y los usaban en ceremonias."});
        datosCuriosos.add(new String[]{"Usaban jade en joyería", "El jade era una piedra preciosa para los mayas, y lo usaban para hacer collares, máscaras y ofrendas."});
        datosCuriosos.add(new String[]{"Practicaban sacrificios humanos", "Creían que esto complacía a los dioses y ayudaba a mantener el equilibrio del universo."});
        datosCuriosos.add(new String[]{"Desarrollaron sistemas de riego", "Para cultivar en la selva, los mayas construyeron sistemas que controlaban el agua de lluvia y cenotes."});
        datosCuriosos.add(new String[]{"Hacían bebidas de cacao", "Mezclaban cacao con agua, chile y especias para crear una bebida especial, ¡un precursor del chocolate caliente!"});
        datosCuriosos.add(new String[]{"Inventaron el calendario de 260 días", "Este calendario sagrado, llamado Tzolk'in, marcaba ceremonias y eventos religiosos."});
        datosCuriosos.add(new String[]{"Eran astrónomos expertos", "Podían predecir eclipses y entendían los ciclos de la luna, el sol y Venus."});
        datosCuriosos.add(new String[]{"Vivían en casas de palma", "Las casas comunes estaban hechas de madera y techos de palma, ideales para el clima tropical."});
        datosCuriosos.add(new String[]{"Tenían un dios del maíz", "El dios Yum Kaax era muy importante porque el maíz era su principal alimento."});
        datosCuriosos.add(new String[]{"El color rojo era sagrado", "Usaban un pigmento rojo llamado cinabrio en rituales y para decorar templos y ofrendas."});
        datosCuriosos.add(new String[]{"Inventaron el azul maya", "Crearon el pigmento azul maya, que era usado para pinturas y decoraciones importantes, y aún sorprende por su resistencia al paso del tiempo."});
        datosCuriosos.add(new String[]{"Los colores tenían significado", "Para los mayas, cada color representaba algo importante: el rojo simbolizaba la vida y la sangre; el azul, el agua y el cielo; el verde, la naturaleza; y el amarillo, el maíz y la riqueza."});

        //Lista de imagenes de datos 
        rutasImg = new ArrayList<>();
        rutasImg.add("cielo");
        rutasImg.add("cero_maya");
        rutasImg.add("juego_pelota");
        rutasImg.add("piramide");
        rutasImg.add("cacao");
        rutasImg.add("idiomas_mayas");
        rutasImg.add("dioses");
        rutasImg.add("pinturas");
        rutasImg.add("selva");
        rutasImg.add("maiz");
        rutasImg.add("escritura");
        rutasImg.add("cenotes");
        rutasImg.add("jade");
        rutasImg.add("sacrificio");
        rutasImg.add("riego");
        rutasImg.add("bebidas_cacao");
        rutasImg.add("calendario");
        rutasImg.add("eclipse");
        rutasImg.add("viviendas");
        rutasImg.add("dios_maiz");
        rutasImg.add("rojo");
        rutasImg.add("azul");
        rutasImg.add("colores");

        // Crear una copia de datos disponibles para controlar repetición
        datosDisponibles = new ArrayList<>(datosCuriosos);

        // Crear una copia de resources.img de datos disponibles
        rutasImgDisponibles = new ArrayList<>(rutasImg);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tituloDato = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        infoDato = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿Sabías qué?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 40, 436, -1));

        jPanel2.setBackground(new java.awt.Color(219, 239, 254));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 168, 107), 3, true));

        tituloDato.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        tituloDato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloDato.setText("Los mayas inventaron el cero");

        imagen.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgDatos/maya.png"))); // NOI18N

        infoDato.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        infoDato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoDato.setText("<html>Mientras otros no lo usaban, los mayas ya sabían que el \"cero\" era muy útil en matemáticas.</html>");
        infoDato.setAutoscrolls(true);
        infoDato.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(115, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(tituloDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tituloDato, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 102, -1, -1));

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
        jPanel1.add(btnImgRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 34, 37));

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 206, 34));

        btnGenerar.setBackground(new java.awt.Color(253, 223, 184));
        btnGenerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerar.setText("Dame otro dato");
        btnGenerar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 35, 29), 3));
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 431, 105, 33));

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
        jPanel1.add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 34, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        Categorias regresar = new Categorias(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        generarDatoAleatorio();
    }//GEN-LAST:event_btnGenerarActionPerformed

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

    private void generarDatoAleatorio() {
        if (datosDisponibles.isEmpty()) {
            // Si ya no hay datos disponibles, restablecemos la lista
            datosDisponibles = new ArrayList<>(datosCuriosos);
            rutasImgDisponibles = new ArrayList<>(rutasImg);
        }

        // Generar un dato aleatorio sin repetir
        Random random = new Random();
        int indice = random.nextInt(datosDisponibles.size());
        String imagenPath = "/imgDatos/" + rutasImgDisponibles.get(indice).toLowerCase() + ".png";
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenPath)));
        String[] dato = datosDisponibles.get(indice);

        // Configurar texto del título y descripción
        tituloDato.setText(dato[0]);
        infoDato.setText("<html>" + dato[1] + "</html>");

        // Eliminar el dato mostrado de la lista de disponibles
        datosDisponibles.remove(indice);
        rutasImgDisponibles.remove(indice);
    }

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
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel infoDato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblUsuario;
    private java.awt.TextArea textArea1;
    private javax.swing.JLabel tituloDato;
    // End of variables declaration//GEN-END:variables
}
