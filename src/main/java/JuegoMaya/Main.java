package JuegoMaya;

import Util.ReproductorSonido;

/**
 *
 * @author SaulA
 */
public class Main {

    public static void main(String args[]) {
        ReproductorSonido reproductor = ReproductorSonido.getInstancia();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        reproductor.cargarSonido("/sonidos/bgMusic.wav");
        reproductor.fadeIn(0.3f, 1000);
        reproductor.reproducirEnBucle();
        reproductor.setPlaying(true);

        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}
