package com.jacaranda.cursos;

import java.util.ArrayList;
import java.util.Iterator;

public class Alumno {

	/*
	 * Para cada alumno (el nombre, apellidos y un id) nos interesa saber en qué unidades está, 
	 * y las notas que saca en cada una de las asignaturas que tiene en las asignaturas del curso en que está matriculado.
	 */
	
	
	
	// ATRIBUTOS -------------------------
	private String nombreAlumno;
	private String apellidosAlumno;
	private int idAlumnoSiguiente = 1;
	private int idAlumno;
	private ArrayList<Nota> notas;
	
	
	
	// CONSTRUCTOR -----------------------
	public Alumno(String nombreAlumno, String apellidosAlumno) {
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.idAlumno = idAlumnoSiguiente++;
		notas = new ArrayList<Nota>();
	}


	
	// GET/SET ---------------------------
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public String getApellidosAlumno() {
		return apellidosAlumno;
	}

	public int getIdAlumno() {
		return idAlumno;
	}



	// MÉTODOS BÁSICOS -------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidosAlumno == null) ? 0 : apellidosAlumno.hashCode());
		result = prime * result + idAlumno;
		result = prime * result + ((nombreAlumno == null) ? 0 : nombreAlumno.hashCode());
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellidosAlumno == null) {
			if (other.apellidosAlumno != null)
				return false;
		} else if (!apellidosAlumno.equals(other.apellidosAlumno))
			return false;
		if (idAlumno != other.idAlumno)
			return false;
		if (nombreAlumno == null) {
			if (other.nombreAlumno != null)
				return false;
		} else if (!nombreAlumno.equals(other.nombreAlumno))
			return false;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [nombreAlumno=" + nombreAlumno + ", apellidosAlumno=" + apellidosAlumno + ", idAlumno="
				+ idAlumno + ", notas=" + notas + "]";
	}
	
	
	
	// MÉTODOS ---------------------------

	
	// ###################### NOTA_ALUMNO ######################
		//		esta nota compara solo el nombre, la calificacion no la tiene en cuenta
		
		public boolean addNota(double nota, String nombreAsignatura) throws Exception {
			
			if (!notaExiste(nombreAsignatura)) {
				Nota a = new Nota(nombreAsignatura, nota);
				notas.add(a);
				return true;
			} else {
				return false;
			}

		}

		
		private boolean notaExiste(String nombreAsignatura) {
			boolean aux = false;

			Iterator<Nota> n = notas.iterator();
			Nota elemento;
			boolean encontrado = false;

			while (n.hasNext() && !encontrado) {
				elemento = n.next();

				if (elemento.getNombreAsignatura().equalsIgnoreCase(nombreAsignatura)) {
					encontrado = true;
					aux = true;
				}
			}

			return aux;
		}
		
		
		public void updateNota(double nota, String nombreAsignatura) throws Exception {
			
			Iterator<Nota> n = notas.iterator();
			Nota elemento;
			boolean encontrado = false;

			while (n.hasNext() && !encontrado) {
				elemento = n.next();

				if (elemento.getNombreAsignatura().equalsIgnoreCase(nombreAsignatura)) {	//si encuentra el elemento
					encontrado = true;														//encontrado -> true, para que no siga buscando
					
					notas.remove(elemento);				// eliminamos la nota antigua
					addNota(nota, nombreAsignatura);	// añadimos la nota nueva.
				}
			}
			
		}
		

		// ###################### NOTA_ALUMNO ######################

		
		
		// #################### Backups ####################	

//		// ###################### NOTA_ALUMNO ######################
//		//		esta nota compara tanto el nombre como la calificacion
	//	
//		public void addNota(double nota, String nombreAsignatura) throws Exception {
	//
//			if (notaExiste(nota, nombreAsignatura)) {
//				throw new Exception("Nota: " + nota + ", Asignatura: " + nombreAsignatura + " ya está registrada.");
//			} else {
//				Nota a = new Nota(nombreAsignatura, nota);
//				notas.add(a);
//			}
//		}
	//
//		private boolean notaExiste(double nota, String nombreAsignatura) {
//			boolean aux = false;
	//
//			Iterator<Nota> n = notas.iterator();
//			Nota elemento;
//			boolean encontrado = false;
	//
//			while (n.hasNext() && !encontrado) {
//				elemento = n.next();
	//
//				if (elemento.getNombreAsignatura().equalsIgnoreCase(nombreAsignatura) 
//						&& elemento.getNota() == nota) {
//					encontrado = true;
//					aux = true;
//				}
//			}
	//
//			return aux;
//		}
	//
//		// ###################### NOTA_ALUMNO ######################

}
