package edu.CECAR.logicanegocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta clase llamada Operaciones se encarga de realizar las diferentes opciones
 * que tiene el editor de texto toda la parte logica del proyecto.
 * 
 * @author Grupo de trabajo cuello, rios, rodrigez, sierra
 * @version 2.0
 * Fecha 27/05/2015
 */


public class Operacion {
	
	private static FileReader lector; //variable para lectura del fichero
	private static BufferedReader bfReader; // 
        
        /**
         * El metodo abrir se encarga de abrir un documento especificado
         * y retorna su contenido.
         * 
         * @param ruta varible que recibe el metodo y que contiene la ruta del
         * fichero abrir
         * @return El metodo retorna el contenido del archivo si ocurre un error
         * este retorna null
         */
	
	public static final String abrir(String ruta){
		lector = null;

		try {
			lector = new FileReader(new File(ruta));
			bfReader = new BufferedReader(lector);
			String lineaFichero;
			StringBuilder contenidoFichero = new StringBuilder();

			while ((lineaFichero = bfReader.readLine()) != null) { //ciclo para leer la diferntes lineas del
				contenidoFichero.append(lineaFichero);         //del documento
			        contenidoFichero.append("\n");
			}
			return contenidoFichero.toString();                   //retorna el contenido del fichero

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
        /**
         * El metodo guardar de la clase Operaciones permite guardar las 
         * nuevas modificaciones  de algun fichero, como tambien nos crear
         * ficheros nuevos.
         * @param ruta donde se desea guardar el nuevo documento
         * @param contenido el parametro contiene el contenido que se guardara 
         * dentro del fichero
         * @return retorna una valor de tipo booleano, si el documento se guarda 
         * con exito devuelve un valor true, de lo contrario false
         */
	
	public static final boolean guardar(String ruta, String contenido){
		try {
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
				out.write( contenido); 
				out.close();
				return true;
		} catch (Exception ex) { 
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	
	
	


}
