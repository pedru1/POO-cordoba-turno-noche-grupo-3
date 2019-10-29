package juegoEstrategia;

public class Main {

	public static void main(String[] args) {
		Unidad soldado = new Soldado("Juan el tremendo");
		soldado.agregarItem(new PocionAgua());
		soldado.agregarItem(new PocionAgua());
		Arquero arquero = new Arquero("Pepe el veloz");
		arquero.setFlechasRepuesto(100);
		Batalla batalla = new Batalla(soldado, arquero);
		Unidad unidadGanadora = batalla.simular();
		System.out.println("La unidad ganadora es " + unidadGanadora.getNombre());	
	}

}
