/*
 * 
 */
package alquilerVehiculos.mvc.modelo;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModeloAlquilerVehiculos.
 */
public interface IModeloAlquilerVehiculos {

	/**
	 * Anadir cliente.
	 *
	 * @param cliente the cliente
	 */
	void anadirCliente(Cliente cliente);

	/**
	 * Borrar cliente.
	 *
	 * @param dni the dni
	 */
	void borrarCliente(String dni);

	/**
	 * Buscar cliente.
	 *
	 * @param dni the dni
	 * @return the cliente
	 */
	Cliente buscarCliente(String dni);

	/**
	 * Obtener clientes.
	 *
	 * @return the cliente[]
	 */
	Cliente[] obtenerClientes();

	/**
	 * Anadir vehiculo.
	 *
	 * @param vehiculo the vehiculo
	 * @param tipoVehiculo the tipo vehiculo
	 */
	void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

	/**
	 * Borrar vehiculo.
	 *
	 * @param matricula the matricula
	 */
	void borrarVehiculo(String matricula);

	/**
	 * Buscar vehiculo.
	 *
	 * @param matricula the matricula
	 * @return the vehiculo
	 */
	Vehiculo buscarVehiculo(String matricula);

	/**
	 * Obtener vehiculos.
	 *
	 * @return the vehiculo[]
	 */
	Vehiculo[] obtenerVehiculos();

	/**
	 * Abrir alquiler.
	 *
	 * @param cliente the cliente
	 * @param vehiculo the vehiculo
	 */
	void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

	/**
	 * Cerrar alquiler.
	 *
	 * @param cliente the cliente
	 * @param vehiculo the vehiculo
	 */
	void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo);

	/**
	 * Obtener alquileres.
	 *
	 * @return the alquiler[]
	 */
	Alquiler[] obtenerAlquileres();
	
	/**
	 * Leer clientes.
	 */
	void leerClientes();
	
	/**
	 * Escribir clientes.
	 */
	void escribirClientes();
	
	/**
	 * Leer vehiculos.
	 */
	void leerVehiculos();
	
	/**
	 * Escribir vehiculos.
	 */
	void escribirVehiculos();
	
	/**
	 * Escribir alquileres.
	 */
	void escribirAlquileres();

	/**
	 * Leer alquileres.
	 */
	void leerAlquileres();

	
}