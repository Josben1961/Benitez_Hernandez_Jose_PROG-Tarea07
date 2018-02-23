/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehiculos.
 */
public class Vehiculos {

	/** The vehiculos. */
	private Vehiculo[] vehiculos;

	/** The max vehiculos. */
	private final int MAX_VEHICULOS = 100;

	/**
	 * Instantiates a new vehiculos.
	 */
	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}

	/**
	 * Gets the vehiculos.
	 *
	 * @return the vehiculos
	 */
	public Vehiculo[] getVehiculos() {
		return vehiculos.clone();
	}

	/**
	 * Anadir vehiculo.
	 *
	 * @param vehiculo
	 *            the vehiculo
	 * @param tipoVehiculo
	 *            the tipo vehiculo
	 */
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice)) {
			vehiculos[indice] = tipoVehiculo.getInstancia(vehiculo.getMatricula(), vehiculo.getMarca(),
					vehiculo.getModelo(), vehiculo.getDatosTecnicos());
			vehiculo.setDisponible(true);

		} else
			throw new ExcepcionAlquilerVehiculos("El array de veh�culos est� lleno.");
	}

	/**
	 * Buscar primer indice libre comprobando existencia.
	 *
	 * @param vehiculo
	 *            the vehiculo
	 * @return the int
	 */
	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] == null)
				vehiculoEncontrado = true;
			else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un veh�culo con esa matr�cula");
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
		return indice < vehiculos.length;
	}

	/**
	 * Borrar vehiculo.
	 *
	 * @param matricula
	 *            the matricula
	 */
	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El veh�culo a borrar no existe");
		}
	}

	/**
	 * Buscar indice vehiculo.
	 *
	 * @param matricula
	 *            the matricula
	 * @return the int
	 */
	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return vehiculoEncontrado ? indice : vehiculos.length;
	}

	/**
	 * Desplazar una posicion hacia izquierda.
	 *
	 * @param indice
	 *            the indice
	 */
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i + 1];
		}
	}

	/**
	 * Buscar vehiculo.
	 *
	 * @param matricula
	 *            the matricula
	 * @return the vehiculo
	 */
	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		Vehiculo vehiculo = null;
		if (indiceNoSuperaTamano(indice)) {
			return vehiculos[indice];

		} else
			return null;
	}
}
