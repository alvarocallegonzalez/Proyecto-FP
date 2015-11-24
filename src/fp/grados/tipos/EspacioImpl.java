package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionEspacioNoValido;

public class EspacioImpl implements Espacio {
	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad;
	private Integer planta;

	public EspacioImpl(TipoEspacio tipo, String nombre, Integer capacidad,
			Integer planta){
		checkCapacidad(capacidad);
		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
	}
	private void checkCapacidad(Integer capacidad){
		if(capacidad <0){
			throw new ExcepcionEspacioNoValido("Error");
		}
	}

	@Override
	public TipoEspacio getTipo() {

		return this.tipo;
	}

	@Override
	public void setTipo(TipoEspacio tipo) {

		this.tipo = tipo;

	}

	@Override
	public String getNombre() {

		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {

		this.nombre = nombre;


	}

	@Override
	public Integer getCapacidad() {

		return this.capacidad;
	}

	@Override
	public void setCapacidad(Integer capacidad) {
		checkCapacidad(capacidad);
		this.capacidad = capacidad;


	}

	@Override
	public Integer getPlanta() {

		return this.planta;
	}
	public String toString(){
		return getNombre() + "(" + getPlanta() + ")";
	}
	public boolean equals(Object o){
		boolean res = false;

		if(o instanceof Espacio){
			Espacio e = (Espacio) o;
			res = getNombre().equals(e.getNombre()) && getPlanta().equals(e.getPlanta());

		}
		return res;
	}
	public int hashCode(){
		return getNombre().hashCode() + getPlanta().hashCode()*31;

	}

	public int compareTo(Espacio e) {
		int res = getPlanta().compareTo(e.getPlanta());
		if(res==0){
			res = getNombre().compareTo(e.getNombre());
		}
		return res;
	}
}
