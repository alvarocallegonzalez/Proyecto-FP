package fp.grados.tipos;

public interface Espacio extends Comparable <Espacio>{
	TipoEspacio getTipo();
	void setTipo(TipoEspacio tipo);
	String getNombre();
	void setNombre(String nombre);
	Integer getCapacidad();
	void setCapacidad(Integer capacidad);
	Integer getPlanta();
}
