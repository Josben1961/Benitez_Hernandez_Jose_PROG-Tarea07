/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Class Clientes.
 */
public class Clientes {

	/** The max clientes. */
	private final int MAX_CLIENTES = 100;

	/** The clientes. */
	private Cliente[] clientes;

	/**
	 * Instantiates a new clientes.
	 */
	public Clientes() {
		clientes = new Cliente[MAX_CLIENTES];
	}

	/**
	 * Gets the clientes.
	 *
	 * @return the clientes
	 */
	public Cliente[] getClientes() {
		return clientes.clone();
	}

	/**
	 * Anadir cliente.
	 *
	 * @param cliente
	 *            the cliente
	 */
	public void anadirCliente(Cliente cliente) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
		if (indiceNoSuperaTamano(indice))
			clientes[indice] = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
	}

	/**
	 * Buscar primer indice libre comprobando existencia.
	 *
	 * @param cliente
	 *            the cliente
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
	 * Indice no supera tamano.
	 *
	 * @param indice
	 *            the indice
	 * @return true, if successful
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < clientes.length;
	}

	/**
	 * Borrar cliente.
	 *
	 * @param dni
	 *            the dni
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
	 * @param dni
	 *            the dni
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
	 * @param indice
	 *            the indice
	 */
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
			clientes[i] = clientes[i + 1];
		}
	}

	/**
	 * Buscar cliente.
	 *
	 * @param dni
	 *            the dni
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
