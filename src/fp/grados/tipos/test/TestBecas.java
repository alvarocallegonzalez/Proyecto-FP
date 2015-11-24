package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;

public class TestBecas {

	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();

	}
	private  static void testConstructor1(){
		//public BecaImpl(String codigo, TipoBeca tipo)
		System.out.println("Trying the first builder");
		Beca b1 = new BecaImpl("FTG2345", TipoBeca.ORDINARIA);
		mostrarBeca(b1);

	}
	private  static void testConstructor2(){
		/*public BecaImpl(String codigo, double cuantiaTotal, 
		int duracion, TipoBeca tipo)*/
		System.out.println("Try the second builder");
		Beca b1 = new BecaImpl("ABC1234", 1600.0, 1, TipoBeca.MOVILIDAD);
		mostrarBeca(b1);

	}
	private static void mostrarBeca(Beca b){
		System.out.println("Beca --< >" + b + ">" );

		System.out.println("Codigo: --< >" + b.getCodigo() + ">" );
		System.out.println("CuantiaTotal: --< >" + b.getCuantiaTotal() + ">" );
		System.out.println("Duracion: --< >" + b.getDuracion() + ">" );
		System.out.println("Tipo: --< >" + b.getTipo() + ">" );
		System.out.println("CuantiaMensual: --< >" + b.getCuantiaMensual() + ">" );


	}

	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		//Creamos dos objetos idénticos(mismo código y tipo, el resto diferente)
		Beca b2 = new BecaImpl("ABC1234", 2000., 12, TipoBeca.MOVILIDAD);
		Beca b3 = new BecaImpl("ABC1234", 2000., 12, TipoBeca.MOVILIDAD);
		//Creamos dos objetos distintos(diferente codigo y tipo)
		Beca b4 = new BecaImpl("ZWF9877", 2000., 12, TipoBeca.MOVILIDAD);
		Beca b5 = new BecaImpl("ABC1234", 3000., 6, TipoBeca.EMPRESA);
		System.out.println("Código hash del objeto b2("+b2+"): "+b2.hashCode());
		System.out.println("Código hash del objeto b3("+b3+"): "+b3.hashCode());
		System.out.println("Código hash del objeto b4("+b4+"): "+b4.hashCode());
		System.out.println("Código hash del objeto b4("+b4+"): "+b5.hashCode());

		System.out.println("Comparamos b2 con b3"+b2.equals(b3));
		System.out.println("Comparamos b3 con b4"+b3.equals(b4));
		System.out.println("Comparamos b4 con b5"+b4.equals(b5));

	}
	private static void testOrden(){
		System.out.println("Probando orden natural ");
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Beca menor = new BecaImpl("ABC1234", 10000., 6, TipoBeca.ORDINARIA);
		Beca igual1 = new BecaImpl("ABC1235", 10000., 6, TipoBeca.ORDINARIA);
		Beca igual2 = new BecaImpl("ABC1235", 10000., 6, TipoBeca.ORDINARIA);
		Beca mayor = new BecaImpl("ABC1235", 10000., 6, TipoBeca.EMPRESA);
		
		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posición)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);
		
	}
	private static void compara(Beca b2, Beca b3){
		System.out.println(b2);
		if (b2.compareTo(b3)<0){
			System.out.println("Va antes que b3");
		}
		else  if(b2.compareTo(b3)>0){
			System.out.println("Va despues que b3");
		}
		else{
			System.out.println("Va en la misma posición que el objeto");
		}
		System.out.println(b3);
			
	}

}

