package fp.grados.excepciones;

public class ExcepcionTutoriaNoValida extends RuntimeException {
	
	public ExcepcionTutoriaNoValida(){
		super();
	}
	public ExcepcionTutoriaNoValida(String s){
		super(s);
	}

}
