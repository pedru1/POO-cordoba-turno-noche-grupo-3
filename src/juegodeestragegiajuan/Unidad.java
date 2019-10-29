package juegodeestragegiajuan;
import java.util.ArrayList;
public class Unidad {
	

	
		
		private String nombre;
		private Integer salud;
		private Integer da�o;
		private Integer distanciaAtaque;
		private ArrayList<Item> inventario;
		
		public Unidad(String nombre, Integer salud, Integer da�o, Integer distanciaAtaque) {
			this.setNombre(nombre);
			this.setSalud(salud);
			this.setDa�o(da�o);
			this.setDistanciaAtaque(distanciaAtaque);
			this.setInventario(new ArrayList<Item>());
		}
		
		public Unidad(String nombre, Integer salud, Integer da�o, Integer distanciaAtaque, ArrayList<Item> inventario) {
			this(nombre, salud, da�o, distanciaAtaque);
			this.setInventario(inventario);
		}
		
		public void agregarItem(Item item) {
			this.getInventario().add(item);
		}
		
		private Integer getDistanciaAtaque() {
			return distanciaAtaque;
		}

		protected ArrayList<Item> getInventario() {
			return inventario;
		}

		private void setNombre(String nombre) {
			this.nombre = nombre;
		}

		private void setDa�o(Integer da�o) {
			this.da�o = da�o;
		}

		private void setDistanciaAtaque(Integer distanciaAtaque) {
			this.distanciaAtaque = distanciaAtaque;
		}

		private void setInventario(ArrayList<Item> inventario) {
			this.inventario = inventario;
		}


		public Integer atacar(Unidad unidad) throws NoSePuedeAtacarException  {
			unidad.setSalud(unidad.getSalud() - this.getDa�o());
			System.out.println(
					this.getNombre() +
					" ataco a " +
					unidad.getNombre() +
					" causandole " + this.getDa�o() +
					" puntos de da�o y dejandolo con " +
					unidad.getSalud() +
					" puntos de vida."
				);
			return unidad.getSalud();
		}
		
		public Integer getSalud() {
			return this.salud;
		}
		
		protected void setSalud(Integer salud) {
			this.salud = salud;
		}
		
		private Integer getDa�o() {
			return this.da�o;
		}
		
		protected String getNombre() {
			return this.nombre;
		}
		
		@Override
		public String toString() {
			return "Unidad [nombre=" + this.getNombre() + ", salud=" + this.getSalud() +  "]";
		}
			
	}

