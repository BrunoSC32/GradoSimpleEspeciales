import umss.bsalcedo.gse.GraficaCubo;
import umss.bsalcedo.gse.GrafosSimplesEsp;

import java.util.Scanner;

public class EjemploGrafosSimplesEspeciales {
    public static void main(String[] args) throws IllegalAccessException {

        Scanner en = new Scanner(System.in);
        String confirmar;

        GrafosSimplesEsp completo = new GrafosSimplesEsp(3, 3, new int[]{2,2,2});

        GrafosSimplesEsp ciclo =  new GrafosSimplesEsp(4, 4, new int[]{2,2,2,2});

        GrafosSimplesEsp cubo = new GrafosSimplesEsp(8, 12, new int[]{3,3,3,3,3,3,3,3});

        GrafosSimplesEsp rueda = new GrafosSimplesEsp(4, 6, new int[]{3,3,3,3});
        

        GrafosSimplesEsp[] listaGrafos = {completo, ciclo, cubo, rueda};

        for(int i = 0; i < listaGrafos.length; i++){
            System.out.println(listaGrafos[i]);
            if(listaGrafos[i].esCubo()){
                System.out.println("Se detecto un grafo especial de tipo Cubo de grado " + listaGrafos[i].getGradoV()
                        + "\n Quiere graficar el grado?[Y/N]:");
                confirmar = en.nextLine();
                if("y".equalsIgnoreCase((String) confirmar.substring(0,1))){
                    GraficaCubo.seleccionarImagen(listaGrafos[i].getGradoV());
                    GraficaCubo.graficar();
                }
            }
        }



    }
}
