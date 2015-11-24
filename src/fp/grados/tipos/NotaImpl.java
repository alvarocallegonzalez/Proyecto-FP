package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public class NotaImpl implements Nota {
	private Asignatura asignatura;
	private Integer cursoAcademico;
	private Convocatoria convocatoria;
	private double valor;
	private boolean mencionHonor;


	public NotaImpl(Asignatura asignatura, Integer cursoAcademico,
			Convocatoria convocatoria,
			Double valor, Boolean mencionHonor){
		checkValor(valor);
		checkMencionHonor(valor, mencionHonor);

		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = mencionHonor;


	}
	public NotaImpl(Asignatura asignatura, Integer cursoAcademico,
			Convocatoria convocatoria,Double valor){
		checkValor(valor);

		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;

	}

	private void checkValor(Double valor){
		if(valor <0 || valor > 10){
			throw new ExcepcionNotaNoValida("Valor no comprendido entre 0 y 10");

		}
	}
	
	private void checkMencionHonor(Double valor, Boolean mencionHonor) {
		if (valor < 9 && mencionHonor) {
			throw new ExcepcionNotaNoValida("La menci�n de honor "
					+ "solo es posible si el valor es mayor o igual que 9");
		}
	}

	@Override
	public Asignatura getAsignatura() {

		return this.asignatura;
	}

	@Override
	public Integer getCursoAcademico() {

		return this.cursoAcademico;
	}

	@Override
	public Convocatoria getConvocatoria() {

		return this.convocatoria;
	}

	@Override
	public Double getValor() {

		return this.valor;
	}

	@Override
	public Boolean getMencionHonor() {
		return this.mencionHonor;

	}

	@Override
	public Calificacion getCalificacion() {
		if (valor < 5){
			return Calificacion.SUSPENSO;
		}else if ( valor >= 5 && valor < 7){
			return Calificacion.APROBADO;
		}else if ( valor >= 7 && valor < 9){
			return Calificacion.NOTABLE;
		}else if (valor >= 9 && !this.mencionHonor){
			return Calificacion.SOBRESALIENTE;
		}else if (valor >= 9 && this.mencionHonor){
			return Calificacion.MATRICULA_DE_HONOR;
		}else{

			return null;
		}

	}
	public String toString(){
		Integer cursoInicio = getCursoAcademico();
		// Integer cursoFinal = cursoInicio+1-2000;
		
		Integer cursoFinal = cursoInicio+1;
		String cursoFinalString = cursoFinal.toString();
		String cursoFinalSubstring = cursoFinalString.substring(cursoFinalString.length()-2);
		String cursoAcademico = cursoInicio.toString() + "-" + cursoFinalSubstring;
		
		return getAsignatura() +","+ cursoAcademico +","+ getConvocatoria()
		+","+ getValor() +","+ getCalificacion();
	}
	public boolean equals(Object o){
		boolean res = false;

		if(o instanceof Nota){
			Nota n = (Nota) o;
			res = getCursoAcademico().equals(n.getCursoAcademico()) &&
					getAsignatura().equals(n.getAsignatura()) &&
					getConvocatoria().equals(n.getConvocatoria());
		}
		return res;
	}
	public int hashCode(){
		return getCursoAcademico().hashCode() + getAsignatura().hashCode()*31 + 
				getConvocatoria().hashCode()*37;
	}
	public int compareTo(Nota n){
		int res = getCursoAcademico().compareTo(n.getCursoAcademico());
		if(res==0){
			res = getAsignatura().compareTo(n.getAsignatura());	
		}
		if(res == 0){
			res = getConvocatoria().compareTo(n.getConvocatoria());
		}
		return res;
	}

}
