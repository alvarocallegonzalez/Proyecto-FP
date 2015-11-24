package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Convocatoria;


public class TestNota {

	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();




	}
	private static void testConstructor1(){
		System.out.println("Probando el primer constructor");
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n","0000235",
				6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		//Asignatura asignatura, String cursoAcademico, String convocatoria, double valor, boolean mencionDeHonor)
		Nota n1 = new NotaImpl( a1 , 2015, Convocatoria.PRIMERA, 10., true);
		mostrarNota(n1);
	}
	private static void testConstructor2(){
		System.out.println("Probando el segundo constructor");
		Asignatura a1 = new AsignaturaImpl("F�sica", "0000230",
				6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		//Asignatura asignatura, String cursoAcademico, String convocatoria, double valor)
		Nota n2 = new NotaImpl(a1, 2120, Convocatoria.SEGUNDA, 10.0);
		mostrarNota(n2);
	}



	private static void mostrarNota(Nota n){
		System.out.println("Nota --< >"+ n + ">");

		System.out.println("Asignatura: --< >"+ n.getAsignatura());
		System.out.println("CursoAcademico: --< >"+ n.getCursoAcademico());
		System.out.println("Convocatoria: --< >"+ n.getConvocatoria());
		System.out.println("Valor: --< >"+ n.getValor());
		System.out.println("Calificacion: --< >"+ n.getCalificacion());
		System.out.println("MencionDeHonor: --< >"+ n.getMencionHonor());
	}
	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		Asignatura a2 = new AsignaturaImpl("F�sica", "0000230", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		Asignatura a3 = new AsignaturaImpl("Estad�stica", "0000245", 6., 
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura a4 = new AsignaturaImpl("Direcci�n de Empresas", "00340234", 12., 
				TipoAsignatura.ANUAL, 1);
		//Creamos un objeto
		Nota n2 = new NotaImpl( a2 , 2015-16, Convocatoria.PRIMERA, 6.0);
		//Creamos un objeto igual al anterior
		Nota n3 = new NotaImpl( a2 , 2015-16, Convocatoria.PRIMERA, 12.0);
		//Creamos un objeto distinto a los anteriores
		Nota n4 = new NotaImpl( a4 , 2015-16, Convocatoria.PRIMERA, 6.0);
		System.out.println("C�digo hash del objeto n2("+n2+"): "+n2.hashCode());
		System.out.println("C�digo hash del objeto a3("+n3+"): "+n3.hashCode());
		System.out.println("C�digo hash del objeto a4("+n4+"): "+n4.hashCode());

		System.out.println("Comparamos n2 con n3"+n2.equals(n3));
		System.out.println("Comparamos a3 con a4"+n3.equals(n4));

	}
	private static void testOrden(){
		System.out.println("Probando orden natural ");
		Asignatura a2 = new AsignaturaImpl("F�sica", "0000230", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		Asignatura a3 = new AsignaturaImpl("Estad�stica", "0000245", 6., 
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura a4 = new AsignaturaImpl("Direcci�n de Empresas", "00340234", 12., 
				TipoAsignatura.ANUAL, 1);
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Nota menor = new NotaImpl( a3 , 2011-12, Convocatoria.PRIMERA, 6.0);
		Nota igual1 = new NotaImpl( a4 , 2013-14, Convocatoria.SEGUNDA, 12.0);
		Nota igual2 = new NotaImpl( a4 , 2013-14, Convocatoria.SEGUNDA, 12.0);
		Nota mayor = new NotaImpl( a4 , 2016-17, Convocatoria.PRIMERA, 12.0);

		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posici�n)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);

	}
	private static void compara(Nota n2, Nota n3){
		System.out.println(n2);
		if (n2.compareTo(n3)<0){
			System.out.println("Va antes que n3");
		}
		else  if(n2.compareTo(n3)>0){
			System.out.println("Va despues que n3");
		}
		else{
			System.out.println("Va en la misma posici�n que el objeto");
		}
		System.out.println(n3);

	}



}
