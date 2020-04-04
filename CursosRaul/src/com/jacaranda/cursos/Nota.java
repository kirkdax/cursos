package com.jacaranda.cursos;

public class Nota {

	//revisar cómo se guarda la nota de cada asignatura
	private String nombreAsignatura;
	private double nota;

	
	
	// CONSTRUCTOR -----------------------
	public Nota(String nombreAsignatura, double nota) {
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
	}


	
	// GET/SET ---------------------------
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public double getNota() {
		return nota;
	}


	
	// MÉTODOS BÁSICOS -------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreAsignatura == null) ? 0 : nombreAsignatura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Nota other = (Nota) obj;
		if (nombreAsignatura == null) {
			if (other.nombreAsignatura != null)
				return false;
		} else if (!nombreAsignatura.equals(other.nombreAsignatura))
			return false;
		if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [nombreAsignatura=" + nombreAsignatura + ", nota=" + nota + "]";
	}

	

	// MÉTODOS ---------------------------

	
}
