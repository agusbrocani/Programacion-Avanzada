package ar.edu.unlam.TDA;

public class ClasePrueba {
	private String nombre;
	private Integer dni;
	
	public ClasePrueba(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " - " + "DNI: " + dni;
	}
}
