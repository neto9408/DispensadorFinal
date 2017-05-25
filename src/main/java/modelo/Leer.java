package modelo;

/*Clase: Leer
	Lee datos de cualquier tipo primitivo y String 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leer {
	public static String dato() {
		String sdato = "";
		try {
			// Definir un flujo de caracteres de entrada: flujoE
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader leer = new BufferedReader(isr);
			// Leer. La entrada finaliza al pulsar la tecla Entrar
			sdato = leer.readLine();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato; // devolver el dato tecleado
	}

	public static short datoShort() {
		try {
			return Short.parseShort(dato());
		} catch (NumberFormatException e) {
			return Short.MIN_VALUE; // valor mas pequeño
		}
	}

	public static int datoInt() {
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			System.out.println("Error Entrar un Dato Entero no un Caracter? ");
			return -1;
		}
	}

	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch (NumberFormatException e) {
			System.out.println("Error Entrar un Dato Entero no un cararter? ");
			return -1;
		}
	}

	public static float datoFloat() {
		try {
			Float f = new Float(dato());
			return f.floatValue();
		} catch (NumberFormatException e) {
			System.out.println("Error Entrar un Dato Entero no un Caracter? ");
			return Float.NaN; // No es un Número; valor float.
		}
	}

	public static double datoDouble() {
		try {
			Double d = new Double(dato());
			return d.doubleValue();
		} catch (NumberFormatException e) {
			return Double.NaN; // No es un Número; valor double.
		}
	}
	
	public static boolean datoBoolean() {
		try {
			Boolean b = new Boolean(dato());
			return b.booleanValue();
		} catch (NumberFormatException e) {
			return false;// No es un boleano; valor boolean.
		}
	}
	
	public static Date datoDate (String fecha) {
	    Date date;
		try {
	            DateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
	            formatter.setLenient(false);
	            date = (Date)formatter.parse(fecha);
	            return date;
	        } catch (ParseException e) {
	        	return null;
	        } 
	    }
	
	
}