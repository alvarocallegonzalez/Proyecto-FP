package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		testConstructor1();

	}
	private static void testConstructor1(){
		System.out.println("Probando el primer constructor");
		Asignatura a1 = new AsignaturaImpl("Física", "0000230", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Asignatura a20 = new AsignaturaImpl("Programación", "0301230", 12.,
				TipoAsignatura.ANUAL, 1);
		
		mostrarAsignatura(a1);
		mostrarAsignatura(a20);
	}
	private  static void mostrarAsignatura(Asignatura a){
		System.out.println("Asignatura:"+ a);

		System.out.println("Nombre: <"+a.getNombre()+">");
		System.out.println("Acronimo: <"+a.getAcronimo()+">");
		System.out.println("Codigo: <"+a.getCodigo()+">");
		System.out.println("Creditos: <"+a.getCreditos()+">");
		System.out.println("Tipo: <"+a.getTipo()+">");
		System.out.println("Curso: <"+a.getCurso()+">");


	}
	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		//Creamos un objeto
		Asignatura a2 = new AsignaturaImpl("Física", "0000230", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		//Creamos un objeto igual al anterior
		Asignatura a3 = new AsignaturaImpl("Física", "0000230", 6., 
				TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		//Creamos un objeto distinto a los anteriores
		Asignatura a4 = new AsignaturaImpl("Dirección de Empresas", "00340234", 12., 
				TipoAsignatura.ANUAL, 1);
		System.out.println("Código hash del objeto a2("+a2+"): "+a2.hashCode());
		System.out.println("Código hash del objeto a3("+a3+"): "+a3.hashCode());
		System.out.println("Código hash del objeto a4("+a4+"): "+a4.hashCode());

		System.out.println("Comparamos a2 con a3"+a2.equals(a3));
		System.out.println("Comparamos a3 con a4"+a3.equals(a4));

	}

	private static void testOrden(){
		System.out.println("Probando orden natural ");
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Asignatura menor = new AsignaturaImpl("Fundamentos de Progamación",
				"2050001", 12., 
				TipoAsignatura.ANUAL, 1);
		Asignatura igual1 = new AsignaturaImpl("Estructura de Computadoras",
				"2050009", 6., 
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura igual2 = new AsignaturaImpl("Estructura de Computadoras",
				"2050009", 6., 
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura mayor = new AsignaturaImpl("Ingeniería de Requisitos",
				"2050020", 6., 
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3);

		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posición)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);

	}
	
	private static void compara(Asignatura a2, Asignatura a3){
		System.out.println(a2);
		if (a2.compareTo(a3)<0){
			System.out.println("Va antes que a3");
		}
		else  if(a2.compareTo(a3)>0){
			System.out.println("Va despues que a3");
		}
		else{
			System.out.println("Va en la misma posición que el objeto");
		}
		System.out.println(a3);

	}


}
