package Util;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ReproductorSonido {

    private static ReproductorSonido instancia;
    private Clip clip;
    HashMap<String, Float> volumenesPorVentana = new HashMap<>();
    private boolean cancionSonando = false;

    private ReproductorSonido() {
        volumenesPorVentana = new HashMap<>(); // Inicializar el mapa de volúmenes
        cargarVolumenesPorVentana();
        configurarGestorDeVentanas(); // Configurar la detección global de ventanas
    }

    public static ReproductorSonido getInstancia() {
        if (instancia == null) {
            instancia = new ReproductorSonido();
        }
        return instancia;
    }

    private void cargarVolumenesPorVentana() {
        volumenesPorVentana.put("MenuPrincipal", 0.5f);
        volumenesPorVentana.put("DatosCuriosos", 0.5f);
        volumenesPorVentana.put("InicioJuego", 0.5f);
        volumenesPorVentana.put("InformacionDelJuego", 0.5f);
        volumenesPorVentana.put("Ayuda", 0.5f);
        volumenesPorVentana.put("InformacionAnimales", 0.1f);
        volumenesPorVentana.put("InformacionFrasesComunes", 0.1f);
        volumenesPorVentana.put("InformacionFrutas", 0.1f);
        volumenesPorVentana.put("InformacionNumeros", 0.1f);
    }

    private void configurarGestorDeVentanas() {
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addPropertyChangeListener("activeWindow", evt -> {
            Window ventanaActiva = (Window) evt.getNewValue();
            if (ventanaActiva != null) {
                String ventanaNombre = ventanaActiva.getClass().getSimpleName();
                Float volumen = volumenesPorVentana.getOrDefault(ventanaNombre, 0.4f); // Volumen por defecto
                ajustarVolumen(volumen);
            } else {
                ajustarVolumen(0.0f); // Silenciar si no hay ventana activa
            }
        });
    }

    public void cargarSonido(String direccion) {
        try {
            InputStream aux = getClass().getResourceAsStream(direccion);

            if (aux != null) {
                BufferedInputStream path = new BufferedInputStream(aux);

                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(path));
                clip.start();
            } else {
                System.out.println("No se pudo cargar el recurso: " + direccion);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reproducirEnBucle() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void ajustarVolumen(float nivel) {
        if (clip != null) {
            try {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (20.0 * Math.log10(nivel <= 0.0f ? 0.0001f : nivel));
                gainControl.setValue(dB);
            } catch (IllegalArgumentException e) {
                System.out.println("El ajuste de volumen no está disponible para este clip.");
            }
        }
    }

    public void fadeIn(float nivelFinal, int duracionMs) {
        if (clip != null) {
            new Thread(() -> {
                try {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float nivelInicial = (float) Math.pow(10.0, gainControl.getValue() / 20.0);
                    int pasos = 50;
                    float incremento = (nivelFinal - nivelInicial) / pasos;
                    int tiempoPorPaso = duracionMs / pasos;

                    for (int i = 0; i <= pasos; i++) {
                        float nivelActual = nivelInicial + (incremento * i);
                        float dB = (float) (20.0 * Math.log10(nivelActual <= 0.0f ? 0.0001f : nivelActual));
                        gainControl.setValue(dB);
                        Thread.sleep(tiempoPorPaso);
                    }
                } catch (InterruptedException | IllegalArgumentException e) {
                    System.out.println("Error en fade in: " + e.getMessage());
                }
            }).start();
        }
    }

    public void fadeOut(int duracionMs) {
        if (clip != null) {
            new Thread(() -> {
                try {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float nivelInicial = (float) Math.pow(10.0, gainControl.getValue() / 20.0);
                    int pasos = 50;
                    float decremento = nivelInicial / pasos;
                    int tiempoPorPaso = duracionMs / pasos;

                    for (int i = 0; i <= pasos; i++) {
                        float nivelActual = nivelInicial - (decremento * i);
                        float dB = (float) (20.0 * Math.log10(nivelActual <= 0.0f ? 0.0001f : nivelActual));
                        gainControl.setValue(dB);
                        Thread.sleep(tiempoPorPaso);
                    }

                    clip.stop(); // Detener el clip al final del fade out
                } catch (InterruptedException | IllegalArgumentException e) {
                    System.out.println("Error en fade out: " + e.getMessage());
                }
            }).start();
        }
    }

    public void setPlaying(boolean estado) {
        this.cancionSonando = estado;
    }

    public boolean isMusicPlaying() {
        return this.cancionSonando;
    }
}
