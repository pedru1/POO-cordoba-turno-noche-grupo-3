package juegoEstrategia;

import java.util.ArrayList;

public class Batalla {
	
	private ArrayList<Unidad> campo;
	private static final Integer CANTIDAD_CASILLEROS = 10;
	private Unidad unidad1;
	private Unidad unidad2;
	
	Batalla(Unidad unidad1, Unidad unidad2) {
		this.setUnidad1(unidad1);
		this.setUnidad2(unidad2);
	}
	
	private Unidad getUnidad1() {
		return unidad1;
	}

	private Unidad getUnidad2() {
		return unidad2;
	}

	private void setUnidad1(Unidad unidad1) {
		this.unidad1 = unidad1;
	}

	private void setUnidad2(Unidad unidad2) {
		this.unidad2 = unidad2;
	}

	
	
	private void setCasilleros() {
		this.campo = new ArrayList<Unidad>(CANTIDAD_CASILLEROS);
	}
	
	public void agregarUnidades(Unidad unidad1, Unidad unidad2) {
		this.campo.add(0, unidad1);
		this.campo.add(CANTIDAD_CASILLEROS - 1, unidad2);
	}
	
	public Unidad simular() {
		Unidad ganador = null;
		Unidad unidadActiva = this.getUnidad1();
		Unidad unidadInactiva = this.getUnidad2();

		while(ganador == null) {
			try {
				unidadActiva.atacar(unidadInactiva);
				if(unidadInactiva.getSalud() <= 0) {
					ganador = unidadActiva;
				}
			} 
			catch(SinEnergiaException e) {
				if (unidadActiva instanceof Soldado) 
					((Soldado) unidadActiva).consumirPocion();
			}
			catch(SinFlechasException e) {
				if (unidadActiva instanceof Arquero) 
					((Arquero) unidadActiva).recargarFlechas();
			}
			catch (NoSePuedeAtacarException e) {
				System.out.println("La unidad " + unidadActiva.getNombre() + " no pudo atacar porque: " + e.getMessage());
			} finally {
				if(unidadActiva == this.getUnidad1()) {
					unidadActiva = this.getUnidad2();
					unidadInactiva = this.getUnidad1();
				} else {
					unidadActiva = this.getUnidad1();
					unidadInactiva = this.getUnidad2();
				}
			}
		}
		return ganador;
	}
	
	
}
