package pa.matrix;

/**
 * Neo debe localizar al Agente Smith en los registros de la Matrix. Los datos
 * están organizados en una matriz de enteros sin elementos repetidos, donde
 * cada fila está ordenada de menor a mayor, y cada columna también está
 * ordenada de menor a mayor.
 * 
 * Esta clase implementa un algoritmo de división y conquista recursivo para
 * buscar un valor objetivo en una matriz N×N ordenada por filas y columnas en
 * tiempo menor a O(n^2).
 * 
 * @author AGUSTIN BROCANI
 * @version 1.0
 */
public class Neo {
    public int[] buscarAgenteSmith(int[][] matrizDatos, int codigoSmith) {
        if (matrizDatos == null || matrizDatos.length == 0) {
            return new int[]{-1, -1};
        }
        return buscarRecursivo(matrizDatos, codigoSmith, 0, matrizDatos.length - 1, 0, matrizDatos[0].length - 1);
    }

    private int[] buscarRecursivo(int[][] matriz, int objetivo, int filaInicio, int filaFin, int colInicio, int colFin) {
        // Caso base: no hay rango válido
        if (filaInicio > filaFin || colInicio > colFin) {
            return new int[]{-1, -1};
        }

        // Punto medio de la submatriz
        int filaMid = (filaInicio + filaFin) / 2;
        int colMid = (colInicio + colFin) / 2;
        int valor = matriz[filaMid][colMid];

        if (valor == objetivo) {
            return new int[]{filaMid, colMid};
        }

        if (valor > objetivo) {
            int[] res = buscarRecursivo(matriz, objetivo, filaInicio, filaMid - 1, colInicio, colFin);
            if (res[0] != -1) return res;
            return buscarRecursivo(matriz, objetivo, filaMid, filaFin, colInicio, colMid - 1);
        } else {
            int[] res = buscarRecursivo(matriz, objetivo, filaMid + 1, filaFin, colInicio, colFin);
            if (res[0] != -1) return res;
            return buscarRecursivo(matriz, objetivo, filaInicio, filaMid, colMid + 1, colFin);
        }
    }
}
