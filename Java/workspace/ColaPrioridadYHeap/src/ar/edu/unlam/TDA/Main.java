package ar.edu.unlam.TDA;

public class Main {

	public static void main(String[] args) {
		ColaPrioridadConListaOrdenada<ClasePrueba> colaDePrioridad = new ColaPrioridadConListaOrdenada<ClasePrueba>();
		
		ClasePrueba lotePrioridad0[] = {
			    new ClasePrueba("Agustin Brocani", 40931870),
			    new ClasePrueba("Federico Martinez", 45128433),
			    new ClasePrueba("Sofia Ramirez", 43219025),
			    new ClasePrueba("Lautaro Gimenez", 40122819)
			};

			ClasePrueba lotePrioridad1[] = {
			    new ClasePrueba("Camila Perez", 42256789),
			    new ClasePrueba("Mariano Lopez", 45890211),
			    new ClasePrueba("Lucia Fernandez", 43800677),
			    new ClasePrueba("Tomas Herrera", 41679003),
			    new ClasePrueba("Micaela Torres", 45100642)
			};

			ClasePrueba lotePrioridad2[] = {
			    new ClasePrueba("Julian Alvarez", 41123745),
			    new ClasePrueba("Nicolas Cabrera", 42678190),
			    new ClasePrueba("Florencia Diaz", 44980123)
			};

			ClasePrueba lotePrioridad3[] = {
			    new ClasePrueba("Valentina Suarez", 43329087),
			    new ClasePrueba("Bruno Castro", 42003156),
			    new ClasePrueba("Milagros Romero", 45100922),
			    new ClasePrueba("Facundo Molina", 43827014),
			    new ClasePrueba("Celeste Navarro", 46019234),
			    new ClasePrueba("Santiago Ruiz", 42778003)
			};
			
			ClasePrueba lotes[][] = {
				    lotePrioridad0,
				    lotePrioridad1,
				    lotePrioridad2,
				    lotePrioridad3,
				};
		
		try {
			int prioridad = 0;
			for (ClasePrueba lote[] : lotes) {
				for (ClasePrueba o : lote) {
					colaDePrioridad.poner(o, prioridad);
				}
				prioridad++;
			}
			
			colaDePrioridad.mostrar();
			
			while(!colaDePrioridad.estaVacia()) {
				colaDePrioridad.sacar();
			}

			colaDePrioridad.mostrar();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
