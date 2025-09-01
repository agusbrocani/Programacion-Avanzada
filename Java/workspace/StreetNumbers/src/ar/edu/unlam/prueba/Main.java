package ar.edu.unlam.prueba;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<Integer, Integer> casasSimetricas = new LinkedHashMap<>();

//        casasSimetricas.put(5, -1);
		casasSimetricas.put(6, 8);
		casasSimetricas.put(35, 49);
		casasSimetricas.put(204, 288);
		casasSimetricas.put(1189, 1681);
		casasSimetricas.put(6930, 9800);
		casasSimetricas.put(40391, 57121);
		casasSimetricas.put(235416, 332928);
		casasSimetricas.put(1372105, 1940449);
		casasSimetricas.put(7997214, 11309768);
		casasSimetricas.put(46611179, 65918161);

		for (Map.Entry<Integer, Integer> par : casasSimetricas.entrySet()) {
			int esperado = par.getKey();
			int calculado = StreetNumbers.metodo1(par.getValue());

			System.out.println("Casa: " + par.getKey() + ", Esperado: " + esperado + ", Calculado: " + calculado);

			if (esperado != calculado) {
				System.out.println("Esperado " + esperado);
				System.out.println("Calculado " + calculado);
				System.out.println("❌ ERROR: El valor calculado no coincide con el esperado.");
				return;
			}
		}
		System.out.println("✅ TODO BIEN: La función StreetNumbers.constante() está correcta.");
	}
}
