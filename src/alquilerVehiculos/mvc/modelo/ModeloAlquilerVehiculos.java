/*
 * 
 */
package alquilerVehiculos.mvc.modelo;

import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Autobus;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DeCarga;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeloAlquilerVehiculos.
 */
public class ModeloAlquilerVehiculos implements IModeloAlquilerVehiculos {

	private Clientes clientes;

	private Vehiculos vehiculos;

	private Alquileres alquileres;

	public ModeloAlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}

	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}

	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}

	public Vehiculo[] obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}

	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {

		alquileres.cerrarAlquiler(cliente, vehiculo);
	}

	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}
	@Override
	public void leerClientes() {
		clientes.leerClientes();
	}

	@Override
	public void escribirClientes() {
		clientes.escribirClientes();		
	}

	@Override
	public void leerVehiculos() {
		vehiculos.leerVehiculos();
	}

	@Override
	public void escribirVehiculos() {
		vehiculos.escribirVehiculos();
	}

	@Override
	public void leerAlquileres() {
		alquileres.leerAlquileres();
	}

	@Override
	public void escribirAlquileres() {
		alquileres.escribirTrabajos();
	}

}


