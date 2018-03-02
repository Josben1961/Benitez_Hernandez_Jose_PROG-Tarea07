
package alquilerVehiculos.mvc.modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * La Clase Alquileres para gestión de los alquileres
 */
public class Alquileres {

	private Alquiler[] alquileres;

	private final int MAX_ALQUILERES = 10;

	private final String FICHERO_ALQUILERES = "datos/alquileres.dat";
	
	/**
	 * Instancia de nuevos alquileres.
	 */
	public Alquileres() {
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	/**
	 * Gets the alquileres.
	 *
	 * @return the alquileres
	 */
	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}
	
	/**
	 * Leer alquileres.
	 */
	public void leerAlquileres() {
		File fichero = new File(FICHERO_ALQUILERES);
		ObjectInputStream entrada;
		try {
			entrada = new ObjectInputStream(new FileInputStream(fichero));
			try {
				alquileres = (Alquiler[])entrada.readObject();
				entrada.close();
				System.out.println(" Fichero alquileres leído correctamente.");
			} catch (ClassNotFoundException e) {
				System.out.println("No puedo encontrar la clase que tengo que leer.");
			} catch (IOException e) {
				System.out.println("Error inesperado de Entrada/Salida.");
			}
		} catch (IOException e) {
			System.out.println("Imposible abrir el fihero de alquileres.");
		}
	}
	
	/**
	 * Escribir alquileres.
	 */
	public void escribirAlquileres() {
		File fichero = new File(FICHERO_ALQUILERES);
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
			salida.writeObject((Alquiler[])alquileres);
			salida.close();
			System.out.println("Fichero alquileres escrito correctamente ");
		} catch (FileNotFoundException e) {
			System.out.println("Imposible crear el fichero de alquileres");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

	/**
	 * Abrir alquiler.
	 *
	 * @param cliente 
	 * @param vehiculo 
	 */
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice] = new Alquiler(cliente, vehiculo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehiculo) {
		int indice = 0;
		boolean encontrado = false;
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (alquileres[indice] == null)
				encontrado = true;
			else if (alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
					&& !alquileres[indice].getVehiculo().getDisponible())
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para este vehículo");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < alquileres.length;
	}

	/**
	 * Cerrar alquiler.
	 *
	 * @param cliente the cliente
	 * @param vehiculo the vehiculo
	 */
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		int indice = buscarAlquilerAbierto(cliente, vehiculo);
		if (indiceNoSuperaTamano(indice)) {
			alquileres[indice].cerrar();
			vehiculo.setDisponible(true);
		} else {
			throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese vehículo");
		}
	}

	/**
	 * Método para buscar alquiler abierto.
	 *
	 * @param cliente 
	 * @param vehiculo 
	 * @return indice
	 */
	private int buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
		int indice = 0;
		boolean alquilerEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !alquilerEncontrado) {
			if (alquileres[indice] != null
					&& alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
					&& alquileres[indice].getDias() == 0)
				alquilerEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

}
