package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestTutoria {

	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();

	}
	private static void testConstructor1(){
		System.out.println("Probando el primer constructor");
		//DayOfWeek diaDeLaSemana, LocalTime horaDeComienzo, LocalTime horaDeFin
		Tutoria t1 = new TutoriaImpl(DayOfWeek.FRIDAY, LocalTime.of(11, 30), LocalTime.of(13, 35));
		mostrarTutoria(t1);
	}
	private static void testConstructor2(){
		System.out.println("Probando el segundo constructor");
		//DayOfWeek diaDeLaSemana, LocalTime horaDeComienzo
		Tutoria t1 = new TutoriaImpl(DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(10, 20));
		mostrarTutoria(t1);
			
	}
	private static void mostrarTutoria(Tutoria t){
		System.out.println("Tutoria --< >"+ t + ">");
		
		System.out.println("DiaDeLaSemana: <"+ t.getDiaSemana());
		System.out.println("HoraDeComienzo: <"+ t.getHoraComienzo());
		System.out.println("HoraDeFin: <"+ t.getHoraFin());
		System.out.println("Duracion: <"+ t.getDuracion());

		
	}
	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		//Creamos dos objetos identicos,es decir, mismo dia y hora de comienzo
		Tutoria t2 = new TutoriaImpl(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(10, 30));
		Tutoria t3 = new TutoriaImpl(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(10, 30));
		//Creamos un objeto distinto a los anteriores
		Tutoria t4 = new TutoriaImpl(DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(12, 30));
		System.out.println("Código hash del objeto t2("+t2+"): "+t2.hashCode());
		System.out.println("Código hash del objeto t3("+t3+"): "+t3.hashCode());
		System.out.println("Código hash del objeto t4("+t4+"): "+t4.hashCode());

		System.out.println("Comparamos t2 con t3"+t2.equals(t3));
		System.out.println("Comparamos t3 con t4"+t3.equals(t4));

	}
	private static void testOrden(){
		System.out.println("Probando orden natural ");
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Tutoria menor = new TutoriaImpl(DayOfWeek.MONDAY, LocalTime.of(12, 30), LocalTime.of(13, 35));
		Tutoria igual1 = new TutoriaImpl(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(10, 30));
		Tutoria igual2 = new TutoriaImpl(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(10, 30));
		Tutoria mayor = new TutoriaImpl(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(10, 30));

		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posición)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);

	}
	private static void compara(Tutoria t2, Tutoria t3){
		System.out.println(t2);
		if (t2.compareTo(t3)<0){
			System.out.println("Va antes que t3");
		}
		else  if(t2.compareTo(t3)>0){
			System.out.println("Va despues que t3");
		}
		else{
			System.out.println("Va en la misma posición que el objeto");
		}
		System.out.println(t3);

	}

}
