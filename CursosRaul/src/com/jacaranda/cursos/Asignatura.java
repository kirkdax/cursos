package com.jacaranda.cursos;

public class Asignatura {

	//De las asignaturas guardaremos el nombre y el númeo de horas que tiene a la semana.
	
		// 6 horas al día, durante 5 días = 30 horas
		/*
		 * Matemáticas
		 * Lengua
		 * Biología
		 * Geografía
		 * Historia
		 * Música
		 */
	private String nombreAsig;
	private int numHoras;


	
	// CONSTRUCTOR -----------------------
	public Asignatura(String nombreAsig, int numHoras) {
		super();
		this.nombreAsig = nombreAsig;
		this.numHoras = numHoras;
	}
	
	
	
	// GET/SET ---------------------------
	public String getNombreAsig() {
		return nombreAsig;
	}
	
	public int getNumHoras() {
		return numHoras;
	}
	
	
	
	// MÉTODOS BÁSICOS -------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreAsig == null) ? 0 : nombreAsig.hashCode());
		result = prime * result + numHoras;
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
		Asignatura other = (Asignatura) obj;
		if (nombreAsig == null) {
			if (other.nombreAsig != null)
				return false;
		} else if (!nombreAsig.equals(other.nombreAsig))
			return false;
		if (numHoras != other.numHoras)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Asignatura [nombreAsig=" + nombreAsig + ", numHoras=" + numHoras + "]";
	}
	
	
	
	// MÉTODOS ---------------------------

	
	
}
