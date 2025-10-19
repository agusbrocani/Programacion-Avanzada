package ar.edu.unlam.heapsort;

public class Main {

	public class HeapSort {

	    public static <T extends Comparable<T>> void heapSort(T[] array) {
	        int n = array.length;	// 1
	        int i;	// 1

	        // Construir el heap máximo
	        for (i = n / 2 - 1; i >= 0; i--) {	// N
	            reacomodar(array, i, n);
	        }

	        // Extraer los elementos del heap uno por uno
	        for (i = n - 1; i > 0; i--) {	// N
	            intercambiar(array, 0, i);
	            reacomodar(array, 0, i);
	        }
	    }

	    private static <T extends Comparable<T>> void reacomodar(T[] array, int i, int n) {
	        int mayor = i;
	        int hijoIzq = 2 * i + 1;
	        int hijoDer = 2 * i + 2;

	        if (hijoIzq < n && array[hijoIzq].compareTo(array[mayor]) > 0) {
	            mayor = hijoIzq;											
	        }

	        if (hijoDer < n && array[hijoDer].compareTo(array[mayor]) > 0) {
	            mayor = hijoDer;											
	        }

	        if (mayor != i) {												
	            intercambiar(array, i, mayor);								
	            reacomodar(array, mayor, n);
	        }
	    }

	    private static <T> void intercambiar(T[] array, int i, int j) {
	        T aux = array[i];												
	        array[i] = array[j];											
	        array[j] = aux;													
	    }

	    // Método main de prueba
	    public static void main(String[] args) {
	        Integer[] numeros = {4, 10, 3, 5, 1};
	        System.out.println("Antes de ordenar:");
	        for (int n : numeros) {
	            System.out.print(n + " ");
	        }

	        heapSort(numeros);

	        System.out.println("\nDespués de ordenar:");
	        for (int n : numeros) {
	            System.out.print(n + " ");
	        }
	    }
	}	
}
