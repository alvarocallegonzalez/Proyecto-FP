package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {
	//Atributos (uno por cada get basico)
	private String nombre;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;
	//TODO: private Departamento departamento;

	//Constructores
	public AsignaturaImpl(String nombre, String codigo,
			Double creditos, TipoAsignatura tipo, Integer curso){

		checkCreditos(creditos);
		checkCurso(curso);
		checkCodigo(codigo);

		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;	
		//TODO: Inicializar el atributo departamento.
	}
	private void checkCodigo(String codigo){
		boolean esCorrecto = (codigo.length()==7) &&
				Character.isDigit(codigo.charAt(0)) &&
				Character.isDigit(codigo.charAt(1)) &&
				Character.isDigit(codigo.charAt(2)) &&
				Character.isDigit(codigo.charAt(3)) &&
				Character.isDigit(codigo.charAt(4)) &&
				Character.isDigit(codigo.charAt(5)) &&
				Character.isDigit(codigo.charAt(6));
		if(!esCorrecto){
			throw new ExcepcionAsignaturaNoValida("Error");

		}
	}


	private void checkCurso(Integer curso){
		if(curso<1 || curso>4){
			throw new ExcepcionAsignaturaNoValida("El curso debe estar"
					+ " comprendido entre 1 y 4");

		}
	}

	private void checkCreditos(Double creditos){
		if(creditos <= 0){
			throw new ExcepcionAsignaturaNoValida("Los créditos deben ser"
					+ " un número mayor que cero");
		}
	}
	//Métodos de la intefaz
	@Override
	public String getNombre() {

		return this.nombre;
	}

	@Override
	public String getAcronimo() {
		//TODO: implementar esta propiedad derivada
		return null;
	}

	@Override
	public String getCodigo() {

		return this.codigo;
	}

	@Override
	public Double getCreditos() {

		return this.creditos;
	}

	@Override
	public TipoAsignatura getTipo() {

		return this.tipo;
	}

	@Override
	public Integer getCurso() {

		return this.curso;
	}
	//Métodos adicionales
	public String toString(){
		String res = "(" + getCodigo() + ") " + getNombre();
		return res;
	}

	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Asignatura){
			Asignatura a = (Asignatura) o;
			res = getCodigo().equals(a.getCodigo());
		}
		return res;
	}
	public int hashCode(){
		return getCodigo().hashCode();
	}
	public int compareTo(Asignatura a){
		return getCodigo().compareTo(a.getCodigo());
	}
}
