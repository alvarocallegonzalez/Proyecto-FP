package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestPersona {

	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();
		
	}
	private static void testConstructor1(){
		System.out.println("Probando el constructor 1");
		//String dni, String nombre, String apellidos, LocalDate fechaDeNacimiento, String email
		Persona p1 = new PersonaImpl("12345678Z", "Pepe", "Chincho M�rquez",
				LocalDate.of(1997, 03, 21),"pepitopintor@yaho.com");
		mostrarPersona(p1);
	}
	private static void testConstructor2(){
		System.out.println("Probando el constructor 2");
		//(String dni, String nombre, String apellidos, LocalDate fechaDeNacimiento)
		Persona p1 = new PersonaImpl("12345678Z", "Alfonso","Matute Canales",
				LocalDate.of(1990, 02, 10));
		mostrarPersona(p1);
	}
	private static void mostrarPersona(Persona p){
		System.out.println("Persona --< >" + p + ">");
		
		System.out.println("Nombre: --< >" + p.getNombre() + ">");
		System.out.println("DNI: --< >" + p.getDNI() + ">");
		System.out.println("Apellidos: --< >" + p.getApellidos() + ">");
		System.out.println("FechaDeNacimiento: --< >" +
		p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("Edad: --< >" + p.getEdad() + ">");
		System.out.println("Email: --< >" + p.getEmail() + ">");
		
		
	}
	private static void testIgualdad(){
		System.out.println("Proband orden igualdad");
		//Creamos dos objetos iguales(mismo dni, nombre y apellidos
		Persona p2 = new PersonaImpl("47426147D", "Pepe", "Chincho M�rquez",
				LocalDate.of(1950, 03, 21)," pepitopintor@yaho.com");
		Persona p3 = new PersonaImpl("47426147D", "Pepe", "Chincho M�rquez",
				LocalDate.of(1950, 03, 21)," pepitopintor@yaho.com");
		//Creamos varios objetos distintos
		Persona p4 = new PersonaImpl("57424187E", "Fernado", "Rioja Rojo",
				LocalDate.of(1907, 11, 23)," albertocalleglez@yaho.com");
		Persona p5 = new PersonaImpl("57424187F", "Fernado", "Rioja Rojo",
				LocalDate.of(1907, 11, 23)," albertomotocros@yaho.com");
		Persona p6 = new PersonaImpl("50425290Z", "Daniel", "Calle Macia",
				LocalDate.of(1988, 05, 03)," alvcalgon@yaho.com");
		System.out.println("C�digo hash del objeto p2("+p2+"): "+p2.hashCode());
		System.out.println("C�digo hash del objeto p3("+p3+"): "+p3.hashCode());
		System.out.println("C�digo hash del objeto p4("+p4+"): "+p4.hashCode());
		System.out.println("C�digo hash del objeto p5("+p5+"): "+p5.hashCode());
		System.out.println("C�digo hash del objeto p6("+p6+"): "+p6.hashCode());

		System.out.println("Comparamos p2 con p3"+  p2.equals(p3));
		System.out.println("Comparamos p2 con p4(es falso, pero al estar negado,es True)"+ !p2.equals(p4));
		System.out.println("Comparamos p2 con p5(es falso, pero al estar negado,es True)"+ !p2.equals(p5));
		System.out.println("Comparamos p2 con p6(es falso, pero al estar negado,es True)"+ !p2.equals(p6));

	}
	private static void testOrden(){
		System.out.println("Probando orden natural ");
		//Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Persona menor = new PersonaImpl("47426147D", "Alvaro", "Calle Gonz�lez",
				LocalDate.of(1997, 03, 10)," pepitopintor@yaho.com");
		Persona igual1 = new PersonaImpl("47426147D", "Pepe", "Chincho M�rquez",
				LocalDate.of(1997, 03, 21)," pepitopintor@yaho.com");
		Persona igual2 = new PersonaImpl("47426147D", "Pepe", "Chincho M�rquez",
				LocalDate.of(1950, 03, 21)," pepitopintor@yaho.com");
		Persona mayor = new PersonaImpl("47426149H", "Dani", "Arcos Rodr�guez",
				LocalDate.of(1996, 01, 14)," pepitopintor@yaho.com");

		System.out.println("(Debe ser: antes)");
		compara(menor,igual1);
		System.out.println("(Debe ser: misma posici�n)");
		compara(igual1,igual2);
		System.out.println("(Debe ser: antes)");
		compara(igual2,mayor);

	}
	private static void compara(Persona p2, Persona p3){
		System.out.println(p2);
		if (p2.compareTo(p3)<0){
			System.out.println("Va antes que p3");
		}
		else  if(p2.compareTo(p3)>0){
			System.out.println("Va despues que p3");
		}
		else{
			System.out.println("Va en la misma posici�n que el objeto");
		}
		System.out.println(p3);

	}

}
