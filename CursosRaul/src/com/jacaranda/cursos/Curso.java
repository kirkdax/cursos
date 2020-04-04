package com.jacaranda.cursos;

import java.util.ArrayList;
import java.util.Iterator;

public class Curso {

	// para cada Curso las asignaturas que tiene
	
	
	// ATRIBUTOS -----------------------------------------------------------------------
	private String nombreCurso;
	private ArrayList<Unidad> unidades;
	private ArrayList<Asignatura> asignaturas;
	
	
	// CONSTRUCTOR ----------------------------------------------------------------------
	public Curso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
		asignaturas = new ArrayList<Asignatura>();
		unidades = new ArrayList<Unidad>();
	}


	
	// GET/SET --------------------------------------------------------------------------
	public String getNombreCurso() {
		return nombreCurso;
	}
	
	
	
	// MÉTODOS BÁSICOS ------------------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((nombreCurso == null) ? 0 : nombreCurso.hashCode());
		result = prime * result + ((unidades == null) ? 0 : unidades.hashCode());
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
		Curso other = (Curso) obj;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (nombreCurso == null) {
			if (other.nombreCurso != null)
				return false;
		} else if (!nombreCurso.equals(other.nombreCurso))
			return false;
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso\t[nombreCurso=" + nombreCurso + "\n" +
				"\t asignaturas=" + asignaturas + "\n" +
				"\t unidades=" + unidades + "]";
	}
	
	
	
	// MÉTODOS --------------------------------------------------------------------------
	
	// ###################### UNIDAD ###################### 

	public void addUnidad (String nombreUnidad) throws Exception {
		
		if (unidadExiste(nombreUnidad)) {
			throw new Exception("La unidad " + nombreUnidad + " ya está registrada.");
		} else {
			Unidad u = new Unidad(nombreUnidad);
			unidades.add(u);
			
		}
	}
	
	private boolean unidadExiste(String nombreUnidad) {
		boolean aux = false; 
		
		Iterator<Unidad> u = unidades.iterator();
		Unidad elemento;
		boolean encontrado = false;

		while (u.hasNext() && !encontrado) {
			elemento = u.next();
			
			if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
				encontrado = true;
				aux = true;
			}
		}
		
		return aux;		
	}
	
	public String listarUnidad(String nombreUnidad) throws Exception {
		StringBuilder aux = new StringBuilder();
		
		if (!unidadExiste(nombreUnidad)) {
			throw new Exception("La unidad " + nombreUnidad + " NO está registrada.");
		} else {
			
			Iterator<Unidad> u = unidades.iterator();
			Unidad elemento;
			boolean encontrado = false;

			while (u.hasNext() && !encontrado) {
				elemento = u.next();
				
				if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
					encontrado = true;
					aux.append(elemento);
				}
			}
			
		}
		
		return aux.toString();
	}
	
	// ###################### UNIDAD ###################### 

	
	
	// #################### ASIGNATURA #################### 

	public void addAsignatura(String nombreAsignatura, int numHoras) throws Exception {

		if (asignaturaExiste(nombreAsignatura)) {
			throw new Exception("La asignatura " + nombreAsignatura + " ya está registrada.");
		} else {
			Asignatura a = new Asignatura(nombreAsignatura, numHoras);
			asignaturas.add(a);
		}
	}
	
	private boolean asignaturaExiste(String nombreAsignatura) {
		boolean aux = false; 
		
		Iterator<Asignatura> a = asignaturas.iterator();
		Asignatura elemento;
		boolean encontrado = false;

		while (a.hasNext() && !encontrado) {
			elemento = a.next();
			
			if (elemento.getNombreAsig().equalsIgnoreCase(nombreAsignatura)) {
				encontrado = true;
				aux = true;
			}
		}
		
		return aux;		
	}
	
	// #################### ASIGNATURA #################### 

	
	
	
	
	// ################## ALUMNO_UNIDAD ##################

	public boolean addAlumnoToUnidad(String nombreAlumno, String apellidosAlumno, String nombreUnidad) throws Exception {
		boolean aux = false;

		if (!unidadExiste(nombreUnidad)) {
			throw new Exception("La unidad " + nombreUnidad + " NO está registrada.");
		}
		
		Iterator<Unidad> u = unidades.iterator();
		Unidad elemento;
		boolean encontrado = false;

		while (u.hasNext() && !encontrado) {
			elemento = u.next();

			if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
				encontrado = true;
				
				elemento.addAlumno(nombreAlumno, apellidosAlumno);
				
				aux = true;
			}
		}

		return aux;
	}
	
	public void borrarAlumnoDeUnidad(String nombreAlumno, String apellidosAlumno, String nombreUnidad) throws Exception {

		if (!unidadExiste(nombreUnidad)) {
			throw new Exception("La unidad " + nombreUnidad + " NO está registrada.");
		}
		
		Iterator<Unidad> u = unidades.iterator();
		Unidad elemento;
		boolean encontrado = false;

		while (u.hasNext() && !encontrado) {
			elemento = u.next();

			if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
				encontrado = true;
				
				elemento.borrarAlumno(nombreAlumno, apellidosAlumno);
				
			}
		}

	}

	// ################## ALUMNO_UNIDAD ##################
	
	
	
	
	
	// ################## NOTA_ALUMNO_UNIDAD_CURSO ##################
	
	public boolean addNotaAlumnoToUnidad(String nombreAlumno, String apellidosAlumno, String nombreUnidad, 
			double nota, String nombreAsignatura) throws Exception {
		
		boolean aux = false;
		
		if (asignaturaExiste(nombreAsignatura) && unidadExiste(nombreUnidad)) {
			
			Iterator<Unidad> u = unidades.iterator();
			Unidad elemento;
			boolean encontrado = false;

			while (u.hasNext() && !encontrado) {
				elemento = u.next();

				if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
					encontrado = true;
					
					if (elemento.addNotaToAlumno(nombreAlumno, apellidosAlumno, nota, nombreAsignatura)) {
						aux = true;
					}
					
				}
			}
		} else {
			throw new Exception("Error. La asignatura " + nombreAsignatura + " NO está registrada.");
		}
		
		return aux;
	}
	
	public void updateNotaAlumnoToUnidad(String nombreAlumno, String apellidosAlumno, String nombreUnidad, 
			double nota, String nombreAsignatura) throws Exception {
				
		if (asignaturaExiste(nombreAsignatura) && unidadExiste(nombreUnidad)) {
			
			Iterator<Unidad> u = unidades.iterator();
			Unidad elemento;
			boolean encontrado = false;

			while (u.hasNext() && !encontrado) {
				elemento = u.next();

				if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
					encontrado = true;
					
					elemento.updateNotaToAlumno(nombreAlumno, apellidosAlumno, nota, nombreAsignatura);
					
				}
			}
		} else {
			throw new Exception("Error. La asignatura " + nombreAsignatura + " NO está registrada.");
		}
		
	}
	
	// ################## NOTA_ALUMNO_UNIDAD_CURSO ##################

	
	
	
	
	public String listarUnidades() {
		StringBuilder aux = new StringBuilder();
		
		aux.append(nombreCurso.toUpperCase() + " ");
		
		for (Unidad u: unidades) {
			aux.append(u + "\n");
		}
		
		return aux.toString();
	}

	
	
	
	public void borrarUnidad(String nombreUnidad) throws Exception {
		
		if (!unidadExiste(nombreUnidad)) {
			throw new Exception("La unidad " + nombreUnidad + " NO está registrada.");
		}
		
		Iterator<Unidad> u = unidades.iterator();
		Unidad elemento;
		boolean encontrado = false;

		while (u.hasNext() && !encontrado) {
			elemento = u.next();
			
			if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
				encontrado = true;
				unidades.remove(elemento);
			}
		}
	}
	
	public void borrarAsignatura(String nombreAsignatura) throws Exception {
		
		if (!asignaturaExiste(nombreAsignatura)) {
			throw new Exception("La asignatura " + nombreAsignatura + " NO está registrada.");
		}
		
		Iterator<Asignatura> a = asignaturas.iterator();
		Asignatura elemento;
		boolean encontrado = false;

		while (a.hasNext() && !encontrado) {
			elemento = a.next();
			
			if (elemento.getNombreAsig().equalsIgnoreCase(nombreAsignatura)) {
				encontrado = true;
				asignaturas.remove(elemento);
			}
		}
	}
	
	
	
	
	// #################### Backups ####################	

//	public void addNotaAlumnoToUnidad(String nombreAlumno, String apellidosAlumno, String nombreUnidad, 
//	double nota, String nombreAsignatura) throws Exception {
//
//if (asignaturaExiste(nombreAsignatura) && unidadExiste(nombreUnidad)) {
//	
//	Iterator<Unidad> u = unidades.iterator();
//	Unidad elemento;
//	boolean encontrado = false;
//
//	while (u.hasNext() && !encontrado) {
//		elemento = u.next();
//
//		if (elemento.getNombreUnidad().equalsIgnoreCase(nombreUnidad)) {
//			encontrado = true;
//			
//			elemento.addNotaToAlumno(nombreAlumno, apellidosAlumno, nota, nombreAsignatura);
//		}
//	}
//} else {
//	throw new Exception("Error. La asignatura " + nombreAsignatura + " NO está registrada.");
//}
//}

}
