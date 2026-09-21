package JuegoMaya;


import Util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public final class SopaDeLetras extends javax.swing.JFrame {
    BD mBD;
    Jugador jugador;
    ReproductorSonido reproductor = ReproductorSonido.getInstancia();
    ReproductorEfectos efectos = new ReproductorEfectos();
    int puntuacion = 0;


    private JPanel panel;
    private int rows = 10;
    private int cols = 14;
    private JLabel firstClickedLabel;
    private boolean selecting = false;
    private String[] frutas = {"PLATANO", "AGUACATE", "NANCE", "GUAYABA", "UVA", "SANDIA", "CIRUELA", "NARANJA", "MAMEY", "MANGO"};
    String abc[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    List<JLabel> correctLabels = new ArrayList<>();
    List<String> palabrasEncontradas = new ArrayList<>();
    String colorFondo = "#FFEDD5";
    Color color = Color.decode(colorFondo);
    private boolean juegoTerminado = false; //Bandera para indicar que el juego ha terminado

    public SopaDeLetras(Jugador jugador) {
        this.jugador = jugador;
        mBD = new BD("BD_maya?useSSL=false", "root", "");

        initComponents();
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

        lblpuntuacionGlobal.setText(jugador.getPuntuacion() + "");
        if (!jugador.isOffline()) {
            lblUsuario.setText(this.jugador.getUsuario());
        }

        panel = new JPanel(new GridLayout(rows, cols));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel1.add(panel);
        panel.setBackground(Color.WHITE);
        panel.setBounds(37, 84, 454, 431);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel("0");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setBackground(null);
                panel.add(label);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (juegoTerminado) {

                            return; //No permitir selección si el juego ha terminado
                        }

                        JLabel clickedLabel = (JLabel) e.getSource();
                        if (!selecting) {
                            firstClickedLabel = clickedLabel;
                            firstClickedLabel.setBackground(Color.ORANGE);
                            selecting = true;
                        } else {
                            // Seleccionar todas las letras entre la primera celda clicada y la segunda celda clicada
                            selectLettersBetween(firstClickedLabel, clickedLabel);

                            selecting = false;
                        }
                    }
                });
            }
        }

        setVisible(true);
        // Agregar palabras
        for (String word : frutas) {
            colocarPalabra(word);
        }
        Random random = new Random();
        for (int i = 0; i < 140; i++) {
            JLabel label = (JLabel) panel.getComponent(i);
            if (label.getText().equals("0"))
                label.setText(abc[(int) (random.nextDouble() * abc.length - 1)]);
        }
        setResizable(false);
    }

    private SopaDeLetras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                                                         


    private void selectLettersBetween(JLabel startLabel, JLabel endLabel) {
        int startId = panel.getComponentZOrder(startLabel);
        int endIx = panel.getComponentZOrder(endLabel);

        int startRow = panel.getComponentZOrder(startLabel) / cols;
        int startCol = panel.getComponentZOrder(startLabel) % cols;
        int endRow = panel.getComponentZOrder(endLabel) / cols;
        int endCol = panel.getComponentZOrder(endLabel) % cols;

        if (startRow == endRow || startCol == endCol && juegoTerminado == false) {
            int rowDelta = Integer.compare(endRow, startRow);
            int colDelta = Integer.compare(endCol, startCol);

            JLabel currentLabel = startLabel;
            while (currentLabel != endLabel) {
                currentLabel.setBackground(Color.ORANGE);
                int currentRow = panel.getComponentZOrder(currentLabel) / cols;
                int currentCol = panel.getComponentZOrder(currentLabel) % cols;

                currentLabel = (JLabel) panel.getComponent((currentRow + rowDelta) * cols + currentCol + colDelta);
            }
            endLabel.setBackground(Color.ORANGE);

            panel.repaint(); // Para actualizar los colores en la pantalla

            StringBuilder selectedWord = new StringBuilder();
            currentLabel = startLabel;
            while (currentLabel != endLabel) {
                selectedWord.append(currentLabel.getText());
                int currentIdx = panel.getComponentZOrder(currentLabel);
                currentLabel = (JLabel) panel.getComponent(currentIdx + rowDelta * cols + colDelta);
            }
            selectedWord.append(endLabel.getText());
            String word = selectedWord.toString();
            String reverseWord = new StringBuilder(word).reverse().toString();

            int cont = 0;
            boolean found = false;
            for (String palabra : frutas) {
                cont++;
                if (word.equals(palabra) || reverseWord.equals(palabra)) {
                    //System.out.println("Palabra encontrada: " + palabra);

                    boolean encontrada = false;
                    for (String encontrada1 : palabrasEncontradas) {
                        if (encontrada1.equals(word) || encontrada1.equals(reverseWord)) {
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        // Sumar 10 puntos si la palabra no se encontró en palabrasEncontradas
                        puntuacion += 10;
                        point.setText(Integer.toString(puntuacion));
                    }

                    palabrasEncontradas.add(palabra); //Agrega la palabra encontrada a una lista vacia

                    found = true;

                    //Agregar las etiquetas a correctLabels
                    correctLabels.add(startLabel);
                    currentLabel = startLabel;
                    while (currentLabel != endLabel) {
                        correctLabels.add(currentLabel);
                        int currentRow = panel.getComponentZOrder(currentLabel) / cols;
                        int currentCol = panel.getComponentZOrder(currentLabel) % cols;
                        currentLabel = (JLabel) panel.getComponent((currentRow + rowDelta) * cols + currentCol + colDelta);
                    }
                    correctLabels.add(endLabel);

                    point.setText(Integer.toString(puntuacion));
                    switch (cont) {
                        case 1:
                            a1.setBackground(Color.DARK_GRAY);
                            break;
                        case 2:
                            a2.setBackground(Color.DARK_GRAY);
                            break;
                        case 3:
                            a3.setBackground(Color.DARK_GRAY);
                            break;
                        case 4:
                            a4.setBackground(Color.DARK_GRAY);
                            break;
                        case 5:
                            a5.setBackground(Color.DARK_GRAY);
                            break;
                        case 6:
                            a6.setBackground(Color.DARK_GRAY);
                            break;
                        case 7:
                            a7.setBackground(Color.DARK_GRAY);
                            break;
                        case 8:
                            a8.setBackground(Color.DARK_GRAY);
                            break;
                        case 9:
                            a9.setBackground(Color.DARK_GRAY);
                            break;
                        case 10:
                            a10.setBackground(Color.DARK_GRAY);
                            break;
                    }
                    if (puntuacion == 100) {
                        juegoTerminado = true;
                        cambiarColorCeldas(Color.GRAY);
                        new ReproductorEfectos().reproducirEfecto("/sonidos/efectos/win.wav");
                        JOptionPane.showMessageDialog(this, "Has ganado. Tu puntaje es: " + puntuacion, "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                        puntuacion(puntuacion);
                    }
                    break;
                }

            }
            if (!found) {
                final JLabel finalCurrentLabel = currentLabel;
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel label = startLabel;
                        while (label != endLabel) {
                            if (!correctLabels.contains(label)) {
                                label.setBackground(null); // Restaurar color original
                            }
                            int currentRow = panel.getComponentZOrder(label) / cols;
                            int currentCol = panel.getComponentZOrder(label) % cols;

                            label = (JLabel) panel.getComponent((currentRow + rowDelta) * cols + currentCol + colDelta);
                        }
                        if (!correctLabels.contains(label)) {
                            label.setBackground(null); // Restaurar color original
                        } // Restaurar color original
                    }
                });
                timer.setRepeats(false); // Solo se ejecuta una vez
                timer.start();
            }
        } else {
            JLabel label = startLabel;

            // Pintar la celda inicial de naranja
            label.setBackground(Color.ORANGE);

            // Usar un Timer para restaurar el color original de la celda inicial
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Restaurar color original de la celda inicial
                    if (!correctLabels.contains(label)) {
                        label.setBackground(null); // Restaurar color original
                    }
                    panel.repaint();  // Actualizar la interfaz
                }
            });
            timer.setRepeats(false); // Solo se ejecuta una vez
            timer.start();

            // Si se ha seleccionado una segunda celda, pintarla también de naranja y restaurarla después de un tiempo
            if (startLabel != endLabel) {
                endLabel.setBackground(Color.ORANGE);

                // Timer para restaurar el color de la celda final después de un segundo
                Timer timerEnd = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!correctLabels.contains(endLabel)) {
                            endLabel.setBackground(null); // Restaurar color original
                        }
                        panel.repaint();  // Actualizar la interfaz
                    }
                });
                timerEnd.setRepeats(false); // Solo se ejecuta una vez
                timerEnd.start();
            }
        }
    }


    private void colocarPalabra(String palabra) {
        Random random = new Random();

        boolean colocada = false;
        while (!colocada) {
            int fila = random.nextInt(rows);
            int columna = random.nextInt(cols);

            boolean horizontal = random.nextBoolean();
            boolean vertical = !horizontal;
            boolean reversa = random.nextBoolean(); //Determina si la palabra se coloca al revés

            if (horizontal && columna + palabra.length() <= cols) {
                boolean colision = false;
                for (int i = 0; i < palabra.length(); i++) {
                    JLabel label;
                    if (reversa) {
                        label = (JLabel) panel.getComponent(fila * cols + columna + palabra.length() - 1 - i);
                    } else {
                        label = (JLabel) panel.getComponent(fila * cols + columna + i);
                    }
                    if (!label.getText().equals("0")) {
                        colision = true;
                        break;
                    }
                }
                if (!colision) {
                    colocada = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        JLabel label;
                        if (reversa) {
                            label = (JLabel) panel.getComponent(fila * cols + columna + palabra.length() - 1 - i);
                        } else {
                            label = (JLabel) panel.getComponent(fila * cols + columna + i);
                        }
                        label.setText(Character.toString(palabra.charAt(i)));
                    }
                }
            } else if (vertical && fila + palabra.length() <= rows) {
                boolean colision = false;
                for (int i = 0; i < palabra.length(); i++) {
                    JLabel label;
                    if (reversa) {
                        label = (JLabel) panel.getComponent((fila + palabra.length() - 1 - i) * cols + columna);
                    } else {
                        label = (JLabel) panel.getComponent((fila + i) * cols + columna);
                    }
                    if (!label.getText().equals("0")) {
                        colision = true;
                        break;
                    }
                }
                if (!colision) {
                    colocada = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        JLabel label;
                        if (reversa) {
                            label = (JLabel) panel.getComponent((fila + palabra.length() - 1 - i) * cols + columna);
                        } else {
                            label = (JLabel) panel.getComponent((fila + i) * cols + columna);
                        }
                        label.setText(Character.toString(palabra.charAt(i)));
                    }
                }
            }
        }
    }

    private void puntuacion(int puntos) {
        jugador.actualizarPuntuacion(puntos);
        if (!jugador.isOffline() && mBD.conectar()) {
            mBD.actualizarPuntuacion(jugador);
        }
    }

    private void reproducirFruta(int i) {
        efectos.reproducirEfecto("/sonidos/frutas/" + i + ".wav");
    }

    private void cambiarColorCeldas(Color color) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setBackground(color);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnImgInicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        a7 = new javax.swing.JLabel();
        a8 = new javax.swing.JLabel();
        a9 = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        point = new javax.swing.JLabel();
        btnImgRegresar = new javax.swing.JButton();
        btnImgSoporte = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblpuntuacionGlobal = new javax.swing.JLabel();
        btnSonido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("+Maya");

        jPanel1.setBackground(new java.awt.Color(219, 239, 254));
        jPanel1.setForeground(new java.awt.Color(207, 169, 132));

        btnImgInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio.png"))); // NOI18N
        btnImgInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngInicio1.png"))); // NOI18N
        btnImgInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgInicioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(162, 35, 29));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOPA DE LETRAS");

        btnReiniciar.setBackground(new java.awt.Color(255, 237, 213));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(null);
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(162, 35, 29));

        jPanel2.setBackground(new java.awt.Color(248, 190, 110));

        a1.setBackground(new java.awt.Color(255, 237, 213));
        a1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1.setText("JA'AS");
        a1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a1.setOpaque(true);
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });

        a2.setBackground(new java.awt.Color(255, 237, 213));
        a2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a2.setText("OON");
        a2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a2.setOpaque(true);
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });

        a3.setBackground(new java.awt.Color(255, 237, 213));
        a3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a3.setText("CHI'");
        a3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a3.setOpaque(true);
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });

        a4.setBackground(new java.awt.Color(255, 237, 213));
        a4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a4.setText("PICHI'");
        a4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a4.setOpaque(true);
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });

        a5.setBackground(new java.awt.Color(255, 237, 213));
        a5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a5.setText("ABA");
        a5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a5.setOpaque(true);
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
        });

        a6.setBackground(new java.awt.Color(255, 237, 213));
        a6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a6.setText("CHAK BOJONJA'");
        a6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a6.setOpaque(true);
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6MouseClicked(evt);
            }
        });

        a7.setBackground(new java.awt.Color(255, 237, 213));
        a7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a7.setText("ABAL");
        a7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a7.setOpaque(true);
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7MouseClicked(evt);
            }
        });

        a8.setBackground(new java.awt.Color(255, 237, 213));
        a8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a8.setText("CH'UJUK PAK'ÁAL");
        a8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a8.setOpaque(true);
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a8MouseClicked(evt);
            }
        });

        a9.setBackground(new java.awt.Color(255, 237, 213));
        a9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a9.setText("CHAKAL JA'AS");
        a9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a9.setOpaque(true);
        a9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a9MouseClicked(evt);
            }
        });

        a10.setBackground(new java.awt.Color(255, 237, 213));
        a10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a10.setText("OOK");
        a10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a10.setOpaque(true);
        a10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(a1)
                                .addGap(15, 15, 15)
                                .addComponent(a2)
                                .addGap(15, 15, 15)
                                .addComponent(a3)
                                .addGap(15, 15, 15)
                                .addComponent(a4)
                                .addGap(15, 15, 15)
                                .addComponent(a5)
                                .addGap(15, 15, 15)
                                .addComponent(a6)
                                .addGap(10, 10, 10)
                                .addComponent(a7)
                                .addGap(10, 10, 10)
                                .addComponent(a8)
                                .addGap(10, 10, 10)
                                .addComponent(a9)
                                .addGap(10, 10, 10)
                                .addComponent(a10)
                                .addGap(29, 29, 29))
        );

        jPanel4.setBackground(new java.awt.Color(255, 237, 213));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 50, 23)));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FRUTAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("Puntuación: ");

        btnImgRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar.png"))); // NOI18N
        btnImgRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngRegresar1.png"))); // NOI18N
        btnImgRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgRegresarActionPerformed(evt);
            }
        });

        btnImgSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda.png"))); // NOI18N
        btnImgSoporte.setBorder(null);
        btnImgSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImgSoporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngAyuda1.png"))); // NOI18N
        btnImgSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSoporteActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Puntuación global:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblpuntuacionGlobal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(btnImgRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(308, 308, 308)
                                                                .addComponent(jLabel21)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(btnSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblpuntuacionGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(517, 517, 517)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(btnImgInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(116, 116, 116)
                                                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)
                                                .addComponent(jLabel2)
                                                .addGap(11, 11, 11)
                                                .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(203, 203, 203)
                                                .addComponent(btnImgSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(btnImgRegresar))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblpuntuacionGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel21))))))
                                .addGap(13, 13, 13)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnImgInicio)
                                        .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImgSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // Reiniciar la puntuación
        puntuacion = 0;
        point.setText(Integer.toString(puntuacion));
        palabrasEncontradas = new ArrayList<>();
        a1.setBackground(color);
        a2.setBackground(color);
        a3.setBackground(color);
        a4.setBackground(color);
        a5.setBackground(color);
        a6.setBackground(color);
        a7.setBackground(color);
        a8.setBackground(color);
        a9.setBackground(color);
        a10.setBackground(color);
        panel.removeAll();
        panel.revalidate();
        panel.repaint();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel("0"); // Puedes usar un JLabel para representar cada celda
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setBackground(null);
                panel.add(label);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel clickedLabel = (JLabel) e.getSource();
                        if (!selecting) {
                            firstClickedLabel = clickedLabel;
                            firstClickedLabel.setBackground(Color.ORANGE);
                            selecting = true;
                        } else {
                            // Seleccionar todas las letras entre la primera celda clicada y la segunda celda clicada
                            selectLettersBetween(firstClickedLabel, clickedLabel);

                            selecting = false;
                        }
                    }
                });
            }
        }
        for (String word : frutas) {
            colocarPalabra(word);
        }

        Random random = new Random();
        for (int i = 0; i < 140; i++) {
            JLabel label = (JLabel) panel.getComponent(i);
            if (label.getText().equals("0"))
                label.setText(abc[(int) (random.nextDouble() * abc.length - 1)]);
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnImgInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgInicioActionPerformed
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgInicioActionPerformed

    private void btnImgRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgRegresarActionPerformed
        JuegosFrutas regresar = new JuegosFrutas(jugador);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnImgRegresarActionPerformed

    private void btnImgSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSoporteActionPerformed
        JOptionPane.showMessageDialog(this, "Busca en la sopa de letras las frutas que se te indican en las pistas\nNota:"
                        + " al presionar sobre las pistas, podrás escuchar su pronunciación."
                , "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImgSoporteActionPerformed

    private void a10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a10MouseClicked
        reproducirFruta(9);
    }//GEN-LAST:event_a10MouseClicked

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
        reproducirFruta(3);
    }//GEN-LAST:event_a4MouseClicked

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        reproducirFruta(0);
    }//GEN-LAST:event_a1MouseClicked

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        reproducirFruta(1);
    }//GEN-LAST:event_a2MouseClicked

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
        reproducirFruta(2);
    }//GEN-LAST:event_a3MouseClicked

    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked
        reproducirFruta(4);
    }//GEN-LAST:event_a5MouseClicked

    private void a6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseClicked
        reproducirFruta(5);
    }//GEN-LAST:event_a6MouseClicked

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked
        reproducirFruta(6);
    }//GEN-LAST:event_a7MouseClicked

    private void a8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseClicked
        reproducirFruta(7);
    }//GEN-LAST:event_a8MouseClicked

    private void a9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseClicked
        reproducirFruta(8);
    }//GEN-LAST:event_a9MouseClicked

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


    //public static void main(String args[]) {
    //  
    //    java.awt.EventQueue.invokeLater(new Runnable() {
    //        public void run() {
    //          new SopaDeLetras().setVisible(true);
    //        }
    //    });
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JButton btnImgInicio;
    private javax.swing.JButton btnImgRegresar;
    private javax.swing.JButton btnImgSoporte;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblpuntuacionGlobal;
    private javax.swing.JLabel point;
    // End of variables declaration//GEN-END:variables
}
