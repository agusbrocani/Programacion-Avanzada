package ar.edu.unlam.practica;

public class Ordenamiento {
	public static void bubbleSort(Integer coleccion[]) {
		for (int i = 0; i < coleccion.length - 1; i++) {			// [asignación => 1, comparación => 1, resta => 1, incremento hasta n en el peor de los casos siendo n = i => N] 	=> N		) => por la regla del producto N * N = N^2
			for (int j = 0; j < coleccion.length - 1 - i; j++) {	// [asignación => 1, comparación => 1, resta => 1, incremento hasta n/2 siendo n = i => N] 							=> N		)
                if (coleccion[j] > coleccion[j + 1]) {	// [acceso a vector => 1 , suma => 1, comparación => 1] => 1
                    int tmp = coleccion[j];				// [acceso a vector => 1, asignación => 1] 				=> 1
                    coleccion[j] = coleccion[j + 1];	// [acceso a vector => 1 , suma => 1, asignación => 1] 	=> 1
                    coleccion[j + 1] = tmp;				// [acceso a vector => 1 , suma => 1, asignación => 1] 	=> 1
                }
            }
		}
	}
}
