package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
		testConstructor1();

	}
	private static void testConstructor1(){
		System.out.println("Probando el nuevo constructor");
		//TipoEspacio tipo, String nombre, int capacidad, int planta
		Espacio e1 = new EspacioImpl(TipoEspacio.EXAMEN, "A0.12", 10, 1);
		mostrarEspacio(e1);
	}
	private static void mostrarEspacio(Espacio e){
		System.out.println("Espacio --< >"+ e + ">");
		
		System.out.println("Tipo: --< >"+ e.getTipo() + ">");
		System.out.println("Nombre: --< >"+ e.getNombre() + ">");
		System.out.println("Capacidad: --< >"+ e.getCapacidad() + ">");
		System.out.println("Planta: --< >"+ e.getPlanta() + ">");
	}
	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		//Creamos dos objetos iguales,es decir, mismo nombre y planta
		Espacio e2 = new EspacioImpl(TipoEspacio.TEORIA, "A0.12", 50, 1);
		Espacio e3 = new EspacioImpl(TipoEspacio.EXAMEN, "A0.12", 100, 1);
		//Creamos un objeto distinto a los anteriores
		Espacio e4 = new EspacioImpl(TipoEspacio.EXAMEN, "A3.22", 200, 3);
		System.out.println("Código hash del objeto e2("+e2+"): "+e2.hashCode());
		System.out.println("Código hash del objeto e3("+e3+"): "+e3.hashCode());
		System.out.println("Código hash del objeto e4("+e4+"): "+e4.hashCode());

		System.out.println("Comparamos e2 con a3"+e2.equals(e3));
		System.out.println("Comparamos e3 con a4"+e3.equals(e4));

	}
	private static void testOrden(){
		System.out.println("Probando orden natural ");
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Espacio menor = new EspacioImpl(TipoEspacio.LABORATORIO, "A0.12", 50, 1);
		Espacio igual1 = new EspacioImpl(TipoEspacio.TEORIA, "A1.23", 50, 2);
		Espacio igual2 = new EspacioImpl(TipoEspacio.TEORIA, "A1.23", 50, 2);
		Espacio mayor = new EspacioImpl(TipoEspacio.OTRO, "A3.20", 100, 4);

		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posición)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);

	}
	private static void compara(Espacio e2, Espacio e3){
		System.out.println(e2);
		if (e2.compareTo(e3)<0){
			System.out.println("Va antes que e3");
		}
		else  if(e2.compareTo(e3)>0){
			System.out.println("Va despues que e3");
		}
		else{
			System.out.println("Va en la misma posición que el objeto");
		}
		System.out.println(e3);

	}

}
