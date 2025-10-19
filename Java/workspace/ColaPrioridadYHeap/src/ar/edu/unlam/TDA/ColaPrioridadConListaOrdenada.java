package ar.edu.unlam.TDA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ColaPrioridadConListaOrdenada<T> {
	private List<Queue<T>> colas;
	private Integer ultimaPrioridad;

	public ColaPrioridadConListaOrdenada() {
		colas = new ArrayList<Queue<T>>();
		ultimaPrioridad = null;
	}

	public void poner(T elemento, Integer prioridad) throws Exception {
		if (elemento == null) {
			throw new NullPointerException("Elemento es null.");
		}

		if (prioridad == null || prioridad < 0) {
			throw new Exception("Prioridad invalida (negativa o nula).");
		}

		// Primera insercion: solo se acepta prioridad 0
		if (ultimaPrioridad == null) {
			if (prioridad != 0) {
				throw new Exception("Debe iniciar con prioridad 0.");
			}
			Queue<T> nuevaCola = new LinkedList<>();
			nuevaCola.add(elemento);
			colas.add(nuevaCola);
			ultimaPrioridad = 0;
			return;
		}

		// Resto de inserciones
		if (prioridad > ultimaPrioridad + 1) {
			throw new Exception("Prioridad invalida (fuera de rango).");
		}

		if (prioridad == ultimaPrioridad + 1) {
			Queue<T> nuevaCola = new LinkedList<>();
			nuevaCola.add(elemento);
			colas.add(nuevaCola);
			ultimaPrioridad++;
		} else {
			colas.get(prioridad).add(elemento);
		}
	}

	public T sacar() {
		// Tomo la primera cola
		Queue<T> primeraCola = colas.get(0);

		// Saco el primer elemento
		T retorno = primeraCola.poll();

		// Si esa cola quedó vacía, la elimino de la lista
		if (primeraCola.isEmpty()) {
			colas.remove(0);
		}

		// Actualizo prioridad
		if (colas.isEmpty()) {
			ultimaPrioridad = null;
		} else {
			ultimaPrioridad--;
		}

		return retorno;
	}

	public void mostrar() {
		if (colas.size() == 0) {
			System.out.println("La cola de prioridad está vacia.");
			return;
		}
		int prioridad = 0;
		for (Queue<T> cola : colas) {
			System.out.println("========= PRIORIDAD " + prioridad + " =========");
			for (T e : cola) {
				System.out.println(e.toString());
			}
			if (cola.size() == 0) {
				System.out.println("Cola vacia");
			}
			
			prioridad++;
			System.out.println();
		}
	}
	
	public boolean estaVacia() {
		return colas.size() == 0;
	}
}
