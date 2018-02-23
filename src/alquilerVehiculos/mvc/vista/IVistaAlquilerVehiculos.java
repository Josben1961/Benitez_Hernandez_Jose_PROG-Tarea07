/*
 * 
 */
package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVistaAlquilerVehiculos.
 */
public interface IVistaAlquilerVehiculos {

	/**
	 * Sets the controlador.
	 *
	 * @param controlador
	 *            the new controlador
	 */
	void setControlador(IControladorAlquilerVehiculos controlador);

	/**
	 * Comenzar.
	 */
	void comenzar();

	/**
	 * Salir.
	 */
	void salir();

	/**
	 * Anadir cliente.
	 */
	void anadirCliente();

	/**
	 * Borrar cliente.
	 */
	void borrarCliente();

	/**
	 * Buscar cliente.
	 */
	void buscarCliente();

	/**
	 * Listar clientes.
	 */
	void listarClientes();

	/**
	 * Anadir vehiculo.
	 */
	void anadirVehiculo();

	/**
	 * Borrar vehiculo.
	 */
	void borrarVehiculo();

	/**
	 * Buscar vehiculo.
	 */
	void buscarVehiculo();

	/**
	 * Listar vehiculos.
	 */
	void listarVehiculos();

	/**
	 * Abrir alquiler.
	 */
	void abrirAlquiler();

	/**
	 * Cerrar alquiler.
	 */
	void cerrarAlquiler();

	/**
	 * Listar alquileres.
	 */
	void listarAlquileres();

}