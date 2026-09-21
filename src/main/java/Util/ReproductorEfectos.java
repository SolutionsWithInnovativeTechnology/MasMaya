package Util;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReproductorEfectos {
    private Clip clip;

    public void reproducirEfecto(String direccion) {
        new Thread(() -> {
            try {
                InputStream aux = getClass().getResourceAsStream(direccion);
                if (aux != null) {
                    BufferedInputStream path = new BufferedInputStream(aux);

                    // Crear un nuevo clip para reproducir este sonido
                    clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(path));

                    if (direccion.startsWith("/sonidos/efectos")) {
                        ajustarVolumen(clip, 0.3f);
                    } else {
                        ajustarVolumen(clip, 1.0f);
                    }

                    clip.start();
                } else {
                    System.out.println("No se pudo cargar el recurso: " + direccion);
                }
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.out.println("Error al reproducir efecto: " + e.getMessage());
            }
        }).start();
    }

    private void ajustarVolumen(Clip clip, float nivel) {
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

    public synchronized void cerrarRecurso() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); // Detener el clip si está en ejecución
            }
            clip.close(); // Liberar los recursos del clip
            clip = null; // Establecer como nulo para evitar referencias colgantes
        }
    }
}
