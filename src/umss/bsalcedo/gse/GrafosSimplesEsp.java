package umss.bsalcedo.gse;

import java.util.Arrays;

public class GrafosSimplesEsp {
    private int nVertices;
    private int nAristas;
    private int[] gradoVertice;
    private int gradoV ;

    public GrafosSimplesEsp(int nVertices, int nAristas, int[] gradoVertice) throws IllegalAccessException {
        this.nVertices = nVertices;
        this.nAristas = nAristas;

        if(gradoVertice.length != nVertices){
            throw new IllegalAccessException("Error, el número de vertices  no coincide con el tamaño del array gradoVertice.");
        }
        this.gradoVertice = gradoVertice;

        if(!valoresMenosDeDosDistintos()){
            throw new IllegalAccessException("Error, la lista de grados de vértices tiene más de un valor repetido, " +
                    "o cual no es válido para grafos completos, ciclos, o cubos.");
        }
        this.gradoV = gradoVertice[0];
    }

    public int getGradoV(){
        return gradoV;
    }
    public boolean esCompleto(){
        return gradoV == nVertices - 1 && nAristas== (Math.pow(nVertices, 2) - nVertices)/2;
    }

    public boolean esCiclo(){
        return nVertices == nAristas && gradoV == 2;
    }

    public boolean esCubo(){
        return nVertices == Math.pow(2, gradoV) && nAristas == Math.pow(2,gradoV - 1) * gradoV;
    }

    public boolean esRueda(){
        int gradoW = 0;
        for(int i = 1; i < gradoVertice.length; i++){
            gradoW = Math.max(gradoW, gradoVertice[i]);
        }
        return nVertices == gradoW + 1 && nAristas == 2 * gradoW;
    }

    // Para los grafos simples especiales completo, ciclo y cubo para sus listas de grado de vertices todos sus
    //elementos comparten un valor y para el grafo rueda dos valores, lo usaremos el metodo valoresRepetidos para comprobarlo
    private boolean valoresMenosDeDosDistintos() {
        if (gradoVertice.length <= 1) {
            return true;
        }

        int primerValorDistinto = gradoVertice[0];
        Integer segundoValorDistinto = null;

        for (int i = 1; i < gradoVertice.length; i++) {
            if (gradoVertice[i] != primerValorDistinto) {
                if (segundoValorDistinto == null) {
                    segundoValorDistinto = gradoVertice[i];
                } else if (gradoVertice[i] != segundoValorDistinto) {
                    return false;
                }
            }
        }
        return true;
    }


    public String queGrafoEs(){
        StringBuilder categoria = new StringBuilder();
        if(esCompleto()){
            categoria.append("Es un grafo simple especial de tipo completo\n");
        }
        if(esCiclo()){
            categoria.append("Es un grafo simple especial de tipo ciclo\n");
        }
        if(esCubo()){
            categoria.append("Es un grafo simple especial de tipo cubo\n");
        }
        if(esRueda()){
            categoria.append("Es un grafo simple especial de tipo rueda\n");
        }
        if(categoria.isEmpty()){
            categoria.append("No es un grado simple especial");
        }

        return categoria.toString();
    }



    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder("El grafo:\n|v| = " + nVertices + "\n|A| = " + nAristas + "\nG(v) = {");
        for(int i = 0; i < gradoVertice.length; i++) {
            if (i == gradoVertice.length - 1) {
                descripcion.append(gradoVertice[i]).append("}");
                break;
            }
            descripcion.append(gradoVertice[i]).append(",");
        }

        descripcion.append("\n").append(queGrafoEs());
        return descripcion.toString();
    }
}
