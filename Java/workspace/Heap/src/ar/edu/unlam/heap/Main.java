package ar.edu.unlam.heap;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MAX-HEAP ===");
        Heap<Integer> maxHeap = new Heap<Integer>(Comparator.naturalOrder());	// a - b

        maxHeap.agregar(50);
        maxHeap.agregar(30);
        maxHeap.agregar(20);
        maxHeap.agregar(10);
        maxHeap.agregar(15);
        maxHeap.agregar(5);
        maxHeap.agregar(8);

        System.out.println("\nHeap inicial:");
        maxHeap.mostrar();

        System.out.println("\nMáximo (método consultar): " + maxHeap.consultar());

        System.out.println("\nRemoviendo elementos...");
        while (maxHeap.consultar() != null) {
            System.out.println("\nSe removió: " + maxHeap.remover());
            maxHeap.mostrar();
        }

        System.out.println("\n=== MIN-HEAP ===");
        Heap<Integer> minHeap = new Heap<Integer>(Comparator.reverseOrder()); // b - a

        minHeap.agregar(50);
        minHeap.agregar(30);
        minHeap.agregar(20);
        minHeap.agregar(10);
        minHeap.agregar(15);
        minHeap.agregar(5);
        minHeap.agregar(8);

        System.out.println("\nHeap inicial:");
        minHeap.mostrar();

        System.out.println("\nMínimo (método consultar): " + minHeap.consultar());
        minHeap.cambiarAHeapComplemento(Comparator.naturalOrder());
        System.out.println("\nMáximo (convertí min a max): " + minHeap.consultar());
        minHeap.cambiarAHeapComplemento(Comparator.reverseOrder());
        
        System.out.println("\nRemoviendo elementos...");
        while (minHeap.consultar() != null) {
            System.out.println("\nSe removió: " + minHeap.remover());
            minHeap.mostrar();
        }
    }
}
