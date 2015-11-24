package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {
	//Atributos
	private static final Double CUANTIA_MINIMA = 1500.0;
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;

	//Constructores
	public BecaImpl(String codigo, TipoBeca tipo){
		checkCodigo(codigo);

		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = CUANTIA_MINIMA;
		this.duracion = 1;
		
	}

	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion,
			TipoBeca tipo){
		checkCodigo(codigo);
		checkDuracion(duracion);
		checkCuantiaTotal(cuantiaTotal);

		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = cuantiaTotal;
		this.duracion = duracion;
			
	}

	private void checkCodigo(String codigo){
		boolean esCorrecto = codigo.length()==7 &&
				Character.isLetter(codigo.charAt(0)) &&
				Character.isLetter(codigo.charAt(1)) &&
				Character.isLetter(codigo.charAt(2)) &&
				Character.isDigit(codigo.charAt(3)) &&
				Character.isDigit(codigo.charAt(4)) &&
				Character.isDigit(codigo.charAt(5)) &&
				Character.isDigit(codigo.charAt(6));
		if(!esCorrecto){
			throw new ExcepcionBecaNoValida("El c�digo debe estar compuesto"
					+ " por 3 letras y 4 digitos");
		}

	}
	private void checkDuracion(Integer duracion){
		if(duracion <1){
			throw new ExcepcionBecaNoValida("La duraci�n debe ser de al menos un mes");
		}
	}
	private void checkCuantiaTotal(Double cuantiaTotal){
		if(cuantiaTotal < CUANTIA_MINIMA){
			throw new ExcepcionBecaNoValida("La cuant�a total no puede ser"
					+ " menos que:"+ CUANTIA_MINIMA);
		}
	}

	//M�todos de la interfaz

	@Override
	public String getCodigo() {

		return this.codigo;
	}

	@Override
	public Double getCuantiaTotal() {

		return this.cuantiaTotal;
	}

	@Override
	public void setCuantiaTotal(Double cuantia) {
		checkCuantiaTotal(cuantia);
		this.cuantiaTotal = cuantia;

	}

	@Override
	public Integer getDuracion() {

		return this.duracion;
	}

	@Override
	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;

	}

	@Override
	public TipoBeca getTipo() {

		return this.tipo;
	}

	@Override
	public Double getCuantiaMensual() {

		return this.cuantiaTotal/this.duracion;
	}
	//Metodos adicionales
	public String toString(){
		
		return "[" + getCodigo() + "," + getTipo() + "]";

	}
	public boolean equals(Object o){
		boolean res = false;

		if(o instanceof Beca){
			Beca b = (Beca) o;
			res = getCodigo().equals(b.getCodigo()) && getTipo().equals(b.getTipo());
		}
		return res;
	}
	public int hashCode(){
		return getCodigo().hashCode() + getTipo().hashCode()*31;
	}
	public int compareTo(Beca b){
		int res = getCodigo().compareTo(b.getCodigo());
		if(res == 0){
			res = getTipo().compareTo(b.getTipo());
		}
		return res;
	}

}
