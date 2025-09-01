package ar.edu.unlam.practica;

public class Main {
	public static void mostrar(Integer coleccion[]) {
		for (int i = 0; i < coleccion.length; i++) {
			System.out.print(coleccion[i] + (i == coleccion.length - 1 ? "" : " - "));
		}
	}
	
	public static void main(String args[]) {
		Integer coleccion[] = {5,4,1,3,2};
		
		Ordenamiento.bubbleSort(coleccion);
		mostrar(coleccion);
	}
}
