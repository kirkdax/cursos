package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
import com.jacaranda.cursos.Centro;


public class Menu {

	public static Scanner teclado = new Scanner(System.in);
//	public static Centro jaca = new Centro("Jacaranda");		// si no hay contenido creado previamente falla.
	public static Centro jaca;									// tuve que inicializarlo después de cargar el fichero, y después dejarlo como está ahora

	public static void main(String[] args) throws Exception {
		
		String nombreCentro = leerString("Introduce el nombre del centro/instituto:");
		jaca = new Centro(nombreCentro.toUpperCase());
		
		cargarFichero(nombreCentro.toUpperCase() + ".json");
//		jaca = new Centro("Jacaranda");
		
		int menu = 1;
		
		while (menu != 0) {
			System.out.println("0. Salir");
			System.out.println("1. Añadir curso");
			System.out.println("2. Añadir unidad");
			System.out.println("3. Añadir asignatura");
			System.out.println("4. Añadir alumno");
			System.out.println("5. Añadir nota a un alumno");
			System.out.println("6. Listar todas las unidades y alumnos del centro, por cursos");
			System.out.println("7. Listar todos los alumnos con todas sus notas de una unidad");
			System.out.println("8. Extra --> Mostrar cursos");
			System.out.println("9. Extra --> Eliminar curso");
			System.out.println("10. Extra --> Eliminar unidad");
			System.out.println("11. Extra --> Eliminar asignatura");
			System.out.println("12. Extra --> Eliminar alumno");
			System.out.println("13. Extra --> Eliminar nota de un alumno");


			menu = Integer.parseInt(teclado.nextLine());
			
			switch (menu) {
			case 0:
				guardarFichero(nombreCentro.toUpperCase() + ".json");
				System.out.println("Hasta luego!");
				break;
			case 1:		//Añadir curso
				String c1 = leerString("Introduce el curso");
				
				try {
					jaca.addCurso(c1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:		//Añadir unidad
				String c2 = leerString("Introduce el curso");
				String u1 = leerString("Introduce la unidad");

				try {
					jaca.addUnidadToCurso(c2, u1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:		//Añadir asignatura
				String c3 = leerString("Introduce el curso");
				String a1 = leerString("Introduce la asignatura");
				int h1 = leerEntero("Introduce las horas de la asignatura");
				
				try {
					jaca.addAsignaturaToCurso(c3, a1, h1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:		//Añadir alumno
				String c4 = leerString("Introduce el curso");
				String u2 = leerString("Introduce la unidad");
				String n1 = leerString("Introduce el nombre del alumno");
				String ap1 = leerString("Introduce los apellidos del alumno");

				try {
					jaca.addAlumnoToCurso(n1, ap1, u2, c4);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:		//Añadir nota a un alumno
				String n2 = leerString("Introduce el nombre del alumno");
				String ap2 = leerString("Introduce los apellidos del alumno");
				String c5 = leerString("Introduce el curso");
				String u3 = leerString("Introduce la unidad");
				double nota = leerDouble("Introduce la nota");
				String as = leerString("Introduce la asignatura");
							
				try {
	
					// si la nota no existe
					if (!jaca.AddNotaAlumnoToCurso(n2, ap2, u3, c5, nota, as)) {
						
						// preguntamos si se actualizará la nota o no
						System.out.println("El alumno " + n2 + " " + ap2 + " ya está calificado en la asignatura " + as);
						int actualizar = leerEntero("Quieres actualizar la nota? --> Introduce 0(NO) | 1(SI)");
						
						// hacer update de la nota
						if (actualizar == 1) {
							jaca.updateNotaAlumnoToCurso(n2, ap2, u3, c5, nota, as);
						}
						
					}
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:		//Listar todas las unidades y alumnos del centro, por cursos
				
				try {
					System.out.println(jaca.listarUnidadesC());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 7:		//Listar todos los alumnos con todas sus notas de una unidad
				String c6 = leerString("Introduce el curso");
				String u4 = leerString("Introduce la unidad");
				
				try {
					System.out.println(jaca.listarAlumnosNotas(c6, u4));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 8:		//Extra --> Mostrar cursos
				System.out.println(jaca.mostrarCursos());
				break;
			case 9:		//Extra --> Eliminar curso
				String c7 = leerString("Introduce el curso para ELIMINARLO");
				
				try {
					jaca.borrarCurso(c7);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 10:	//Extra --> Eliminar unidad
				String c8 = leerString("Introduce el curso correspondiente");
				String u5 = leerString("Introduce la unidad para ELIMINARLA");

				try {
					jaca.borrarUnidadDeCurso(c8, u5);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 11:	//Extra --> Eliminar asignatura
				String c9 = leerString("Introduce el curso correspondiente");
				String a3 = leerString("Introduce la asignatura para ELIMINARLA");

				try {
					jaca.borrarAsignaturaDeCurso(c9, a3);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 12:	//Extra --> Eliminar alumno
				String n3 = leerString("Introduce el nombre del alumno");
				String ap3 = leerString("Introduce los apellidos del alumno");
				String c10 = leerString("Introduce el curso");
				String u6 = leerString("Introduce la unidad");
							
				try {
					jaca.borrarAlumnoDeCurso(n3, ap3, u6, c10);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 13:	//Extra --> Eliminar nota de un alumno

				
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		}
		
	}

	
	public static String leerString(String m) {
		String aux;
		
		System.out.println(m);
		aux = teclado.nextLine();
		
		return aux;
	}
	
	public static int leerEntero(String msg) {
		int resultado;
		
		System.out.println(msg);
		resultado = Integer.parseInt(teclado.nextLine());
		return resultado;
	}
	
	public static double leerDouble(String msg) {
		double resultado;
		
		System.out.println(msg);
		resultado = Double.parseDouble(teclado.nextLine());
		
		return resultado;
	}
	
	
	
	public static void cargarFichero(String archivo) throws IOException {
		
		//utilizando try/catch, se comprueba si el fichero existe.
		//si no existe, 
		try {
			FileReader fichero = new FileReader(archivo);
			BufferedReader flujo = new BufferedReader(fichero);
			
			String linea;
			linea = flujo.readLine();
			StringBuilder aux = new StringBuilder();
			
			while (linea != null) {
				//proceso la linea
				aux.append(linea);
				
				//fin de proceso
				linea = flujo.readLine();
			}
			
			flujo.close();
			fichero.close();
			
			// objeto a mapear
			Gson gson = new Gson();

			// Lista donde se guardará todo el contenido
			jaca = gson.fromJson(aux.toString(), Centro.class);
		} catch (Exception e) {
//			System.out.println(e.getMessage());		//muestra mensaje de error si no existe el archivo
		}
		
		
	}
	
	public static void guardarFichero(String archivo) throws IOException {
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String representacionBonita = prettyGson.toJson(jaca);

		FileWriter file = new FileWriter(archivo);
		PrintWriter writer = new PrintWriter(file);
		
		writer.print(representacionBonita);
		
		writer.close();
		file.close();
	}

	
}
