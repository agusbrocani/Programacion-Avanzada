package pa.matrix;

public class Main {
    public static void main(String[] args) {
        Neo neo = new Neo();
        int[][]  matriz = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int[] resultado = neo.buscarAgenteSmith(matriz, 5);
        System.out.println("Resultado: [" + resultado[0] + ", " + resultado[1] + "]");
    }
}
