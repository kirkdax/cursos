package com.jacaranda.cursos;

import java.util.ArrayList;
import java.util.Iterator;

public class Unidad {

	// ATRIBUTOS -------------------------
	private String nombreUnidad;
	private ArrayList<Alumno> alumnos;


	
	// CONSTRUCTOR -----------------------
	public Unidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
		alumnos = new ArrayList<Alumno>();
	}
	
	
	
	// GET/SET ---------------------------
	public String getNombreUnidad() {
		return nombreUnidad;
	}



	// MÉTODOS BÁSICOS -------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnos == null) ? 0 : alumnos.hashCode());
		result = prime * result + ((nombreUnidad == null) ? 0 : nombreUnidad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidad other = (Unidad) obj;
		if (alumnos == null) {
			if (other.alumnos != null)
				return false;
		} else if (!alumnos.equals(other.alumnos))
			return false;
		if (nombreUnidad == null) {
			if (other.nombreUnidad != null)
				return false;
		} else if (!nombreUnidad.equals(other.nombreUnidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
//		return "Unidad= [nombreUnidad=" + nombreUnidad + ", alumnos=" + alumnos + "]";
		return nombreUnidad.toUpperCase() + ", alumnos=" + alumnos;

	}
	
	
	
	// MÉTODOS ---------------------------

	// ###################### ALUMNO ######################

	public void addAlumno(String nombreAlumno, String apellidosAlumno) throws Exception {

		if (alumnoExiste(nombreAlumno, apellidosAlumno)) {
			throw new Exception("El alumno " + nombreAlumno + " " + apellidosAlumno + " ya está registrado.");
		} else {
			Alumno a = new Alumno(nombreAlumno, apellidosAlumno);
			alumnos.add(a);
		}
	}

	private boolean alumnoExiste(String nombreAlumno, String apellidosAlumno) {
		boolean aux = false;

		Iterator<Alumno> a = alumnos.iterator();
		Alumno elemento;
		boolean encontrado = false;

		while (a.hasNext() && !encontrado) {
			elemento = a.next();

			if (elemento.getNombreAlumno().equalsIgnoreCase(nombreAlumno) && elemento.getApellidosAlumno().equalsIgnoreCase(apellidosAlumno)) {
				encontrado = true;
				aux = true;
			}
		}

		return aux;
	}
	
	public void borrarAlumno(String nombreAlumno, String apellidosAlumno) throws Exception {

		if (!alumnoExiste(nombreAlumno, apellidosAlumno)) {
			throw new Exception("El alumno " + nombreAlumno + " " + apellidosAlumno + " NO está registrado.");
		} 
		
		Iterator<Alumno> a = alumnos.iterator();
		Alumno elemento;
		boolean encontrado = false;

		while (a.hasNext() && !encontrado) {
			elemento = a.next();

			if (elemento.getNombreAlumno().equalsIgnoreCase(nombreAlumno) 
					&& elemento.getApellidosAlumno().equalsIgnoreCase(apellidosAlumno)) {
				encontrado = true;
				alumnos.remove(elemento);
			}
		}
		
	}

	// ###################### ALUMNO ######################
	

	// #################### NOTA_ALUMNO_UNIDAD ####################

	
	public boolean addNotaToAlumno(String nombreAlumno, String apellidosAlumno, double nota, String nombreAsignatura) throws Exception {
		boolean aux = false;
		
		if (alumnoExiste(nombreAlumno, apellidosAlumno)) {
			Iterator<Alumno> a = alumnos.iterator();
			Alumno elemento;
			boolean encontrado = false;

			while (a.hasNext() && !encontrado) {
				elemento = a.next();

				if (elemento.getNombreAlumno().equalsIgnoreCase(nombreAlumno) && elemento.getApellidosAlumno().equalsIgnoreCase(apellidosAlumno)) {
					encontrado = true;
					
					if (elemento.addNota(nota, nombreAsignatura)) {
						aux = true;
					}
					
				}
			}
		} else {
			throw new Exception("Error. El alumno " + nombreAlumno + " " + apellidosAlumno + " NO está registrado.");
		}

		return aux;
	}
	
	public void updateNotaToAlumno(String nombreAlumno, String apellidosAlumno, double nota, String nombreAsignatura) throws Exception {
		
		if (alumnoExiste(nombreAlumno, apellidosAlumno)) {
			Iterator<Alumno> a = alumnos.iterator();
			Alumno elemento;
			boolean encontrado = false;

			while (a.hasNext() && !encontrado) {
				elemento = a.next();

				if (elemento.getNombreAlumno().equalsIgnoreCase(nombreAlumno) && elemento.getApellidosAlumno().equalsIgnoreCase(apellidosAlumno)) {
					encontrado = true;
					
					elemento.updateNota(nota, nombreAsignatura);
					
				}
			}
		} else {
			throw new Exception("Error. El alumno " + nombreAlumno + " " + apellidosAlumno + " NO está registrado.");
		}

	}
	
	// #################### NOTA_ALUMNO_UNIDAD ####################


	// #################### Backups ####################	

//	public void addNotaToAlumno(String nombreAlumno, String apellidosAlumno, double nota, String nombreAsignatura) throws Exception {
//	
//	if (alumnoExiste(nombreAlumno, apellidosAlumno)) {
//		Iterator<Alumno> a = alumnos.iterator();
//		Alumno elemento;
//		boolean encontrado = false;
//
//		while (a.hasNext() && !encontrado) {
//			elemento = a.next();
//
//			if (elemento.getNombreAlumno().equalsIgnoreCase(nombreAlumno) && elemento.getApellidosAlumno().equalsIgnoreCase(apellidosAlumno)) {
//				encontrado = true;
//				elemento.addNota(nota, nombreAsignatura);
//			}
//		}
//	} else {
//		throw new Exception("Error. El alumno " + nombreAlumno + " " + apellidosAlumno + " NO está registrado.");
//	}
//	
//}

}
