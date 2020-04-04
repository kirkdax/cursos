package com.jacaranda.cursos;

import java.util.Comparator;

public class ComparatorCurso implements Comparator<Curso> {

	@Override
	public int compare(Curso c1, Curso c2) {
		
		if (c1.getNombreCurso().compareTo(c2.getNombreCurso()) < 1) {
			return -1;
		} else if (c1.getNombreCurso().compareTo(c2.getNombreCurso()) == 0) {
			return 0;
		} else {
			return 1;
		}
		
	}

}
