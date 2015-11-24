package fp.grados.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionPersonaNoValida;

public class PersonaImpl implements Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;

	public PersonaImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email){
		
		System.out.println("hola");
		
		checkDni(dni);
		checkEmail(email);
		checkFechaNacimiento(fechaNacimiento);
		
		System.out.println("adios");
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public PersonaImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento){
		this(dni, nombre, apellidos, fechaNacimiento, "");
		checkDni(dni);
		checkFechaNacimiento(fechaNacimiento);
	}

	private void checkDni(String dni){
		boolean esCorrecto = checkDni1(dni) && checkDni2(dni);
		if(!esCorrecto){
			throw new ExcepcionPersonaNoValida("DNI incorrecto");
		}
	}
	private boolean checkDni1(String dni){
		boolean res = (dni.length()==9) &&
				Character.isDigit(dni.charAt(0)) &&
				Character.isDigit(dni.charAt(1)) &&
				Character.isDigit(dni.charAt(2)) &&
				Character.isDigit(dni.charAt(3)) &&
				Character.isDigit(dni.charAt(4)) &&
				Character.isDigit(dni.charAt(5)) &&
				Character.isDigit(dni.charAt(6)) &&
				Character.isDigit(dni.charAt(7)) &&
				Character.isLetter(dni.charAt(8));

		return res;
	}
	private boolean checkDni2(String dni){
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Integer numeroDni = new Integer(dni.substring(0, 8));
		return dni.charAt(8) == letras.charAt(numeroDni%23);
//		Integer numDni = new Integer (dni.substring(0,7));
//		int numReferencia = numDni%23;
//		boolean res = tabla.charAt(numReferencia) == dni.charAt(8);
//		return res;
		

	}
	private void checkEmail(String email){
		boolean esCorrecto = email.contains("@") || email.isEmpty();
		if(!esCorrecto){
			throw new ExcepcionPersonaNoValida("El email debe contener"
					+ " el usurario, el arroba y el servidor");
		}
	}
	private void checkFechaNacimiento(LocalDate fechaNacimiento){
		boolean esCorrecto = fechaNacimiento.isBefore(LocalDate.now());
		if(!esCorrecto){
			throw new ExcepcionPersonaNoValida("La fecha de nacimiento de"
					+ " una persona debe ser anterior a"
					+ " la actual fecha");
		}
	}


	@Override
	public String getDNI() {

		return this.dni;
	}

	@Override
	public void setDNI(String dni) {
		checkDni(dni);
		this.dni = dni;
	}

	@Override
	public String getNombre() {

		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	@Override
	public String getApellidos() {

		return this.apellidos;
	}

	@Override
	public void setApellidos(String apellido) {

		this.apellidos = apellidos;


	}

	@Override
	public LocalDate getFechaNacimiento() {

		return this.fechaNacimiento;
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		checkFechaNacimiento(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String getEmail() {

		return this.email;
	}

	@Override
	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}

	@Override
	public Integer getEdad() {
		return (int)getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
	}
	public String toString(){
		return  getDNI() + "-" + getApellidos() + "," + getNombre() + "-" +
				getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	} 
	public boolean equals(Object o){
		boolean res = false;

		if(o instanceof Persona){
			Persona p = (Persona) o;
			res = getDNI().equals(p.getDNI()) 
					&& getNombre().equals(p.getNombre())
					&& getApellidos().equals(p.getApellidos());

		}
		return res;
	}
	public int hashCode(){
		return getDNI().hashCode() + getNombre().hashCode()*31 + 
				getApellidos().hashCode()*37;
	}

	@Override
	public int compareTo(Persona p) {
		int res = getApellidos().compareTo(p.getApellidos());
		if(res == 0){
			res = getNombre().compareTo(p.getNombre());
		}
		if(res == 0){
			res = getDNI().compareTo(p.getDNI());

		}
		return res;


	}




}
