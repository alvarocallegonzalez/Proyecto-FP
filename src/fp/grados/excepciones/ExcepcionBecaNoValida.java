package fp.grados.excepciones;

public class ExcepcionBecaNoValida extends RuntimeException {
	public ExcepcionBecaNoValida(){
		super();
	}
	public ExcepcionBecaNoValida(String s){
		super(s);
	}

}
