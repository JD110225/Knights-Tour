public class Tablero {
    private int[][] matriz;  
    Interfaz interfaz;
    public static final int[] SUMA_F = { 2, 1, -1, -2, -2, -1, 1, 2 };
    public static final int[] SUMA_C = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public Tablero() {
        matriz = new int[8][8];
        interfaz=new Interfaz();
        for (int f = 0; f < matriz.length; ++f) {
            for (int c = 0; c < matriz[0].length; ++c) {
                matriz[f][c] = 0;
            }
        }
    }

    public boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length
                && matriz[fila][columna] == 0;
    }

    public boolean recorridoCaballo(int fila, int columna, int contador) {
        boolean recorridoCompleto = false;
        if (contador == 65) {
            recorridoCompleto = true;
        } else {
            for (int i = 0; i < SUMA_F.length && !recorridoCompleto; i++) {
                int nuevaFila = fila + SUMA_F[i];
                int nuevaColumna = columna + SUMA_C[i];
                if (esValida(nuevaFila, nuevaColumna)) {
                    matriz[nuevaFila][nuevaColumna] = contador;
                    recorridoCompleto = recorridoCaballo(nuevaFila, nuevaColumna, contador + 1);
                    if (!recorridoCompleto) {
                        matriz[nuevaFila][nuevaColumna] = 0;
                    }                     
                }

            }
        }
        return recorridoCompleto;
    }
    public int[] posicionNumero(int numero){  //devuelve [x,y] de la posicion de un numero especifico en la matriz
        int[] coordenadas=new int[2];  
        for(int f=0;f<matriz.length; ++f){
            for(int c=0;c< matriz[0].length; ++c){
                if(matriz[f][c]==numero){
                    coordenadas[0]=f;
                    coordenadas[1]=c;
                }
            }
        }
        return coordenadas;
    }
    public void ponerCaballos(){
        matriz[0][0]=1;
        recorridoCaballo(0,0,2);
        for(int i=1;i<=64;++i){
            int[] coordenadas=posicionNumero(i);
            int fila=coordenadas[0];
            int columna=coordenadas[1];
            try{
                interfaz.ponerNumero(fila,columna,i);
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.err.println("Error");
            }
        }
    }
    public String toString() {
        String tira = "";
        for (int f = 0; f < matriz.length; ++f) {
            for (int c = 0; c < matriz[0].length; ++c) {
                tira += matriz[f][c] + " ";
            }
            tira += "\n";
        }
        return tira;
    }
}