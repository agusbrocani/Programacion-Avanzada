package ar.edu.unlam.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
	private final List<T> heap;
    private Comparator<T> comparador;

    public Heap(Comparator<T> comparador) {
        if (comparador == null) {
            throw new IllegalArgumentException("El comparador no puede ser null.");
        }
        
        this.heap = new ArrayList<>();
        this.comparador = comparador;
    }
	
    public void agregar(T elemento) {
        heap.add(elemento);
        
        int i = heap.size() - 1;
        int indicePadreActual = (i - 1) / 2;
        while (i > 0 && comparador.compare(heap.get(i), heap.get(indicePadreActual)) > 0) {
            Collections.swap(heap, i, indicePadreActual);
            i = indicePadreActual;
            indicePadreActual = (i - 1) / 2;
        }
    }
	
    public T remover() {
        if (heap.isEmpty()) {
            return null;
        }

        // Intercambio raíz con el último
        Collections.swap(heap, 0, heap.size() - 1);
        T retorno = heap.remove(heap.size() - 1); // Quito la raíz original

        // Reordeno hacia abajo => veo si alguno de los hijos es mayor o menor para ponerlo de raiz
        int indiceRaiz = 0; // Arranco desde donde meti el último (inicio del heap)
        int cantidadDeElementosHeap = heap.size();

        while (true) {
            int indiceHijoIzquierdo = 2 * indiceRaiz + 1;
            int indiceHijoDerecho = 2 * indiceRaiz + 2;
            int mejor = indiceRaiz;

            // Comparo con el hijo izquierdo
            if (indiceHijoIzquierdo < cantidadDeElementosHeap && comparador.compare(heap.get(indiceHijoIzquierdo), heap.get(mejor)) > 0) {
                mejor = indiceHijoIzquierdo;
            }

            // Comparo con el hijo derecho
            if (indiceHijoDerecho < cantidadDeElementosHeap && comparador.compare(heap.get(indiceHijoDerecho), heap.get(mejor)) > 0) {
                mejor = indiceHijoDerecho;
            }

            // Si el padre ya es mejor que ambos hijos, termino
            if (mejor == indiceRaiz) {
                break;
            }

            // Intercambio y sigo bajando
            Collections.swap(heap, indiceRaiz, mejor);
            indiceRaiz = mejor;
        }

        return retorno;
    }

	
	public T consultar() {
	    return heap.isEmpty() ? null : heap.get(0);
	}
	
	public boolean heapVacio () {
		return heap.isEmpty();
	}
	
	public Integer heapSize() {
		return heap.size();
	}
	
	public void mostrar() {
	    if (heap.isEmpty()) {
	        System.out.println("Heap vacío.");
	        return;
	    }
	    mostrarNodo(0, "", true);
	}

	private void mostrarNodo(int indice, String prefijo, boolean esUltimo) {
	    if (indice >= heap.size()) return;

	    System.out.print(prefijo);
	    System.out.print(esUltimo ? "└── " : "├── ");
	    System.out.println(heap.get(indice));

	    int hijoIzquierdo = 2 * indice + 1;
	    int hijoDerecho = 2 * indice + 2;

	    if (hijoIzquierdo >= heap.size() && hijoDerecho >= heap.size()) {
	        return;
	    }

	    String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

	    // Primero el hijo derecho (queda arriba)
	    if (hijoDerecho < heap.size()) {
	        mostrarNodo(hijoDerecho, nuevoPrefijo, false);
	    }

	    // Luego el hijo izquierdo (queda abajo)
	    if (hijoIzquierdo < heap.size()) {
	        mostrarNodo(hijoIzquierdo, nuevoPrefijo, true);
	    }
	}
	
	public void cambiarAHeapComplemento(Comparator<T> nuevoComparador) {
	    if (nuevoComparador == null) {
	        throw new IllegalArgumentException("El comparador no puede ser null.");
	    }
	    
	    this.comparador = nuevoComparador;

	    int cantidadDeElementosHeap = heap.size();
	    for (int indicePadre = (cantidadDeElementosHeap / 2) - 1; indicePadre >= 0; indicePadre--) {
	        heapify(indicePadre, cantidadDeElementosHeap);
	    }
	}

	private void heapify(int indicePadre, int cantidadDeElementosHeap) {
	    int mejor = indicePadre;
	    int indiceHijoIzquierdo = 2 * indicePadre + 1;
	    int indiceHijoDerecho = 2 * indicePadre + 2;

	    if (indiceHijoIzquierdo < cantidadDeElementosHeap && comparador.compare(heap.get(indiceHijoIzquierdo), heap.get(mejor)) > 0) {
	        mejor = indiceHijoIzquierdo;
	    }

	    if (indiceHijoDerecho < cantidadDeElementosHeap && comparador.compare(heap.get(indiceHijoDerecho), heap.get(mejor)) > 0) {
	        mejor = indiceHijoDerecho;
	    }

	    if (mejor != indicePadre) {
	        Collections.swap(heap, indicePadre, mejor);
	        heapify(mejor, cantidadDeElementosHeap);
	    }
	}
}
