package com.jacaranda.cursos;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;



public class Centro {

	// Cursos que hay en el centro (Cursos, unidad)
		// Nombre + ArrayList de cursos?
	
	
	
	// ATRIBUTOS -------------------------
	private String nombreCentro;
	private ArrayList<Curso> cursos;
	

	
	// CONSTRUCTOR -----------------------
	public Centro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
		cursos = new ArrayList<Curso>();
	}

	
	
	// GET/SET ---------------------------
	public String getNombreCentro() {
		return nombreCentro;
	}
	
	
	
	
	// MÉTODOS BÁSICOS -------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((nombreCentro == null) ? 0 : nombreCentro.hashCode());
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
		Centro other = (Centro) obj;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (nombreCentro == null) {
			if (other.nombreCentro != null)
				return false;
		} else if (!nombreCentro.equals(other.nombreCentro))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Centro [nombreCentro=" + nombreCentro + ", cursos=" + cursos + "]";
	}



	// MÉTODOS --------------------------------------------------------------------------
	
	// ###################### CURSO ###################### 
	
	public void addCurso(String nombreCurso) throws Exception {
		
		if (cursoExiste(nombreCurso)) {
			throw new Exception("El curso " + nombreCurso + " ya está registrado.");
		} else {
			Curso c = new Curso(nombreCurso);
			cursos.add(c);
		}
		
	}
	
	private boolean cursoExiste(String nombreCurso) {
		boolean aux = false; 
		
		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();
			
			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				aux = true;
			}
		}
		
		return aux;		
	}
	
	public String mostrarCursos() {
		StringBuilder aux = new StringBuilder();
		
		if (cursos.size() == 0) {
			aux.append("No hay cursos registrados\n");
		} else {
			for (Curso curso : cursos) {
				aux.append(curso + "\n");
			}
		}
		
		return aux.toString();
	}
	
	public void borrarCurso(String nombreCurso) throws Exception {
		
		if (!cursoExiste(nombreCurso)) {												
			throw new Exception("El curso " + nombreCurso + " NO está registrado");
		}
		
		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();
			
			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				cursos.remove(elemento);
			}
		}
	}
	
	// ###################### CURSO ###################### 

	
	
	
	// ###################### UNIDAD ###################### 

	public void addUnidadToCurso(String nombreCurso, String nombreUnidad) throws Exception {
		
		if (!cursoExiste(nombreCurso)) {
			addCurso(nombreCurso);
		} 
			
		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.addUnidad(nombreUnidad);
			}
		}
	}
	
	public void borrarUnidadDeCurso(String nombreCurso, String nombreUnidad) throws Exception {

		if (!cursoExiste(nombreCurso)) {
			throw new Exception("El curso " + nombreCurso + " NO está registrado");
		}

		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.borrarUnidad(nombreUnidad);
			}
		}
	}
	
	// ###################### UNIDAD ###################### 


	
	// #################### ASIGNATURA #################### 

	public void addAsignaturaToCurso(String nombreCurso, String nombreAsignatura, int horasAsignatura) throws Exception {

		if (!cursoExiste(nombreCurso)) {
			addCurso(nombreCurso);
		}

		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.addAsignatura(nombreAsignatura, horasAsignatura);
			}
		}
	}
	
	
	public void borrarAsignaturaDeCurso(String nombreCurso, String nombreAsignatura) throws Exception {
		
		if (!cursoExiste(nombreCurso)) {
			throw new Exception("El curso " + nombreCurso + " NO está registrado");
		}

		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.borrarAsignatura(nombreAsignatura);
			}
		}
	}
	
	// #################### ASIGNATURA #################### 

	
	
	
	// #################### ALUMNO_UNIDAD_CURSO ####################

	public void addAlumnoToCurso(String nombreAlumno, String apellidosAlumno, 
			String nombreUnidad, String nombreCurso) throws Exception {

		if (!cursoExiste(nombreCurso)) {
			addCurso(nombreCurso);
		}

		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.addAlumnoToUnidad(nombreAlumno, apellidosAlumno, nombreUnidad);
			}
		}
	}
	
	public void borrarAlumnoDeCurso(String nombreAlumno, String apellidosAlumno, 
			String nombreUnidad, String nombreCurso) throws Exception {

		if (!cursoExiste(nombreCurso)) {
			throw new Exception("El curso " + nombreCurso + " NO está registrado");
		}

		Iterator<Curso> c = cursos.iterator();
		Curso elemento;
		boolean encontrado = false;

		while (c.hasNext() && !encontrado) {
			elemento = c.next();

			if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
				encontrado = true;
				elemento.borrarAlumnoDeUnidad(nombreAlumno, apellidosAlumno, nombreUnidad);
			}
		}
	}

	// #################### ALUMNO_UNIDAD_CURSO ####################	
	
	
	
	
	
	// ################## NOTA_ALUMNO_UNIDAD_CURSO_CENTRO ##################
	
	public boolean AddNotaAlumnoToCurso(String nombreAlumno, String apellidosAlumno, 
			String nombreUnidad, String nombreCurso, double nota, String nombreAsignatura) throws Exception {
		
		boolean aux = false;
		
		if (cursoExiste(nombreCurso)) {
			
			Iterator<Curso> c = cursos.iterator();
			Curso elemento;
			boolean encontrado = false;

			while (c.hasNext() && !encontrado) {
				elemento = c.next();

				if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
					encontrado = true;
					
					if (elemento.addNotaAlumnoToUnidad(nombreAlumno, apellidosAlumno, nombreUnidad, nota, nombreAsignatura)) {
						aux = true;
					}
					
				}
			}
		} else {
			throw new Exception("Error. El curso " + nombreCurso + " NO está registrado.");
		}
		
		return aux;
	}
	
	public void updateNotaAlumnoToCurso(String nombreAlumno, String apellidosAlumno, 
			String nombreUnidad, String nombreCurso, double nota, String nombreAsignatura) throws Exception {
				
		if (cursoExiste(nombreCurso)) {
			
			Iterator<Curso> c = cursos.iterator();
			Curso elemento;
			boolean encontrado = false;

			while (c.hasNext() && !encontrado) {
				elemento = c.next();

				if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
					encontrado = true;
					
					elemento.updateNotaAlumnoToUnidad(nombreAlumno, apellidosAlumno, nombreUnidad, nota, nombreAsignatura);
					
				}
			}
		} else {
			throw new Exception("Error. El curso " + nombreCurso + " NO está registrado.");
		}
		
	}
	
	// ################## NOTA_ALUMNO_UNIDAD_CURSO_CENTRO ##################

	public String listarUnidadesC() {
		StringBuilder aux = new StringBuilder();
		
		cursos.sort(new ComparatorCurso());
		
		for (Curso curso : cursos) {
			aux.append(curso.listarUnidades());
		}
		
		return aux.toString();
	}
	
	
	public String listarAlumnosNotas(String nombreCurso, String nombreUnidad) throws Exception {
		StringBuilder aux = new StringBuilder();
		
		if (cursoExiste(nombreCurso)) {

			Iterator<Curso> c = cursos.iterator();
			Curso elemento;
			boolean encontrado = false;

			while (c.hasNext() && !encontrado) {
				elemento = c.next();

				if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
					
					aux.append(nombreCurso.toUpperCase() + " ");
					aux.append(elemento.listarUnidad(nombreUnidad)); 
					
					encontrado = true;
				}
			}
		} else {
			throw new Exception("Error. El curso " + nombreCurso + " NO está registrado.");
		}
		
		return aux.toString();
	}

	
	// #################### Backups ####################	
	
//	public void AddNotaAlumnoToCurso(String nombreAlumno, String apellidosAlumno, 
//	String nombreUnidad, String nombreCurso, double nota, String nombreAsignatura) throws Exception {
//
//if (cursoExiste(nombreCurso)) {
//	
//	Iterator<Curso> c = cursos.iterator();
//	Curso elemento;
//	boolean encontrado = false;
//
//	while (c.hasNext() && !encontrado) {
//		elemento = c.next();
//
//		if (elemento.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
//			elemento.addNotaAlumnoToUnidad(nombreAlumno, apellidosAlumno, nombreUnidad, nota, nombreAsignatura);
//			encontrado = true;
//		}
//	}
//} else {
//	throw new Exception("Error. El curso " + nombreCurso + " NO está registrado.");
//}
//}
	
}
