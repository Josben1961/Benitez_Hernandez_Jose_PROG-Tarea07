
package alquilerVehiculos.mvc.modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;


// TODO: Auto-generated Javadoc
/**
 *Clase Clientes para gestión de clientes
 */
public class Clientes {

	private Cliente[] clientes;
	private final int MAX_CLIENTES = 10;
	private final String FICHERO_CLIENTES = "datos/clientes.dat";
	
	/**
	 * Instancia de nuevos clientes.
	 */
	public Clientes() {
		clientes = new Cliente[MAX_CLIENTES];
	}

	/**
	 * Gets de  clientes.
	 *
	 * @return  clientes
	 */
	public Cliente[] getClientes() {
		return clientes.clone();
	}
	
	/**
	 * Leer clientes.
	 */
	public void leerClientes() {
		File fichero = new File(FICHERO_CLIENTES);
		ObjectInputStream entrada;
		try {
			entrada = new ObjectInputStream(new FileInputStream(fichero));
			try {
				clientes = (Cliente[])entrada.readObject();
				entrada.close();
				System.out.println("Fichero clientes leído satisfactoriamente.");
				Cliente.aumentarUltimoIdentificador(calcularUltimoIdentificador());
			} catch (ClassNotFoundException e) {
				System.out.println("No puedo encontrar la clase que tengo que leer.");
			} catch (IOException e) {
				System.out.println("Error inesperado de Entrada/Salida.");
			}
		} catch (IOException e) {
			System.out.println("Imposible abrir el fihero de clientes.");
		}
	}
	
	/**
	 * Método para calcular el último identificador.
	 *
	 * @return  int ultimoIdentificador
	 */
	private int calcularUltimoIdentificador() {
		int ultimoIdentificador = 0;
		int i = 0;
		while (clientes[i] != null) {
			if (clientes[i].getIdentificador() > ultimoIdentificador)
				ultimoIdentificador = clientes[i].getIdentificador();
			i++;
		}
		return ultimoIdentificador;
	}
	
	/**
	 * Escribir clientes.
	 */
	public void escribirClientes() {
		File fichero = new File(FICHERO_CLIENTES);
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
			salida.writeObject((Cliente[])clientes);
			salida.close();
			System.out.println("Fichero clientes escrito satisfactoriamente.");
		} catch (FileNotFoundException e) {
			System.out.println("Imposible crear el fichero de clientes");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

	/**
	 * Anadir cliente.
	 *
	 * @param cliente 
	 */
	public void anadirCliente(Cliente cliente) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
		if (indiceNoSuperaTamano(indice))
			clientes[indice] = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
	}

	/**
	 * Buscar el primer indice libre para comprobar su existencia.
	 *
	 * @param cliente 
	 * @return the int
	 */
	private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] == null)
				clienteEncontrado = true;
			else if (clientes[indice].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("El cliente ya existe");
			else
				indice++;
		}
		return indice;
	}

	/**
	 * Comprobamos que el índice no supera tamaño.
	 *
	 * @param indice the indice
	 * @return true, si no lo supera
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < clientes.length;
	}

	/**
	 * Borrar cliente.
	 *
	 * @param dni the dni
	 */
	public void borrarCliente(String dni) {
		int indice = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
		}
	}

	/**
	 * Buscar indice cliente.
	 *
	 * @param dni the dni
	 * @return the int
	 */
	private int buscarIndiceCliente(String dni) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] != null && clientes[indice].getDni().equals(dni))
				clienteEncontrado = true;
			else
				indice++;
		}
		return indice;
	}

	/**
	 * Desplazar una posicion hacia izquierda.
	 *
	 * @param indice the indice
	 */
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
			clientes[i] = clientes[i + 1];
		}
	}

	/**
	 * Buscar cliente.
	 *
	 * @param dni the dni
	 * @return the cliente
	 */
	public Cliente buscarCliente(String dni) {
		int posicion = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(posicion))
			return new Cliente(clientes[posicion]);
		else
			return null;
	}
}
