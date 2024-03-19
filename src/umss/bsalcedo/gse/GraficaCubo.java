package umss.bsalcedo.gse;

import javax.swing.*;

public class GraficaCubo {

    private static String imagen ;

    public static void graficar(){
        SwingUtilities.invokeLater(GraficaCubo::mostrarImagenEnFrame);
    }


    private static void mostrarImagenEnFrame(){

        JFrame frame = new JFrame("Grafo simple especial de tipo cubo ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("Imagenes\\" + imagen);

        JLabel label = new JLabel(imageIcon);

        frame.add(label);
        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void seleccionarImagen(int grado){
        imagen = "Q" + grado + ".png";
    }
}
