package fp.grados.tipos;

public interface Beca extends Comparable <Beca> {
	String getCodigo();
	Double getCuantiaTotal();
	void setCuantiaTotal(Double cuantia);
	Integer getDuracion();
	void setDuracion(Integer duracion);
	TipoBeca getTipo();
	Double getCuantiaMensual(); // derivable
}