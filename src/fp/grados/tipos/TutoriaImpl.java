package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;

public class TutoriaImpl implements Tutoria {
	private DayOfWeek diaSemana;
	private LocalTime horaComienzo;
	private LocalTime horaFin;

	public TutoriaImpl(DayOfWeek diaSemana, LocalTime horaComienzo, LocalTime horaFin){
		checkHoras(horaComienzo,horaFin);
		checkDuracion(horaComienzo,horaFin);
		checkDiaSemana(diaSemana);
		checkHoraComienzo(horaComienzo);
		checkHoraFin(horaFin);

		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
	}
	public TutoriaImpl(DayOfWeek diaSemana, LocalTime horaComienzo, Integer duracion){
		checkHoras(horaComienzo,horaFin);
		checkDiaSemana(diaSemana);
		checkHoraComienzo(horaComienzo);
		checkDuracion(duracion);

		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaComienzo.plusMinutes(duracion);
	}
	private void checkDiaSemana(DayOfWeek diaSemana){
		if( diaSemana == diaSemana.SUNDAY || diaSemana == diaSemana.SATURDAY){
			throw new ExcepcionTutoriaNoValida("Las clases son de Lunes a Viernes");
		}
	}
	private void checkHoraComienzo(LocalTime horaComienzo){
		LocalTime f1 = LocalTime.of(8, 30);
		if(horaComienzo.isBefore(f1)){
			throw new ExcepcionTutoriaNoValida("Las clases comienzan a las 8:30,"
					+ " NO antes");
		}
	}
	private void checkHoraFin(LocalTime horaFin){
		LocalTime f2 = LocalTime.of(21, 30);
		if(horaFin.isAfter(f2)){
			throw new ExcepcionTutoriaNoValida("Las clase finalizan a las 21:30,"
					+ " NO más tarde");
		}
	}

	private void checkDuracion(Integer duracion){
		if(duracion < 30){
			throw new ExcepcionTutoriaNoValida("Las clases deben durar al menos"
					+ " 30 minutos");
		}
	}
	private void checkDuracion(LocalTime horaComienzo,LocalTime horaFin){
		int res = (int)horaComienzo.until(horaFin,ChronoUnit.MINUTES);
		if(res <30){
			throw new ExcepcionTutoriaNoValida("Las clases deben de durar al menos 30 minutos");
		}
	}
	private void checkHoras(LocalTime horaComienzo, LocalTime horaFin){
		if(horaComienzo.isAfter(horaFin)){
			throw new ExcepcionTutoriaNoValida("Error");
		}

	}

	@Override
	public DayOfWeek getDiaSemana() {

		return this.diaSemana;
	}

	@Override
	public LocalTime getHoraComienzo() {

		return this.horaComienzo;
	}

	@Override
	public LocalTime getHoraFin() {

		return this.horaFin;
	}

	@Override
	public Integer getDuracion() {


		return(int)horaComienzo.until(horaFin,ChronoUnit.MINUTES);
	}
	public String toString(){
		String diaString = null;
		switch(this.diaSemana){
		case MONDAY:
			diaString = "L";
			break;
		case TUESDAY:
			diaString = "M";
			break;
		case WEDNESDAY:
			diaString = "X";
			break;
		case THURSDAY:
			diaString = "J";
			break;
		case FRIDAY:
			diaString = "V";
			break;
		case SATURDAY:
			diaString = "S";
			break;
		case SUNDAY:
			diaString = "D";
			break;
		default:
			break;
		}
		String horaDeComienzo = this.horaComienzo.format(DateTimeFormatter.ofPattern("hh:mm"));
		String horaDeFin = this.horaFin.format(DateTimeFormatter.ofPattern("hh:mm"));
		return diaString + " " + horaDeComienzo + "-" + horaDeFin; 
	}
	public boolean equals(Object o){
		boolean res = false;

		if(o instanceof Tutoria){
			Tutoria t = (Tutoria) o;
			res = getDiaSemana().equals(t.getDiaSemana()) && 
					getHoraComienzo().equals(t.getHoraComienzo());
		}
		return res;
	}
	public int hashCode(){
		return getDiaSemana().hashCode() + getHoraComienzo().hashCode()*31;
	}

	public int compareTo(Tutoria t) {
		int res = getDiaSemana().compareTo(t.getDiaSemana());
		if(res == 0){
			res = getHoraComienzo().compareTo(t.getHoraComienzo());
		}
		return res;
	}

}
