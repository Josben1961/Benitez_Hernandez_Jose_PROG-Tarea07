/*
 * 
 */
package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;

// TODO: Auto-generated Javadoc
/**
 * The Class ControladorAlquilerVehiculos.
 */
public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos {

	/** The modelo. */
	private IModeloAlquilerVehiculos modelo;

	/** The vista. */
	private IVistaAlquilerVehiculos vista;

	/**
	 * Instantiates a new controlador alquiler vehiculos.
	 *
	 * @param vista
	 *            the vista
	 * @param modelo
	 *            the modelo
	 */
	public ControladorAlquilerVehiculos(IVistaAlquilerVehiculos vista, IModeloAlquilerVehiculos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}

	/*
	 * (sin Javadoc)
	 * 
	 * @see
	 * alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#comenzar()
	 */
	public void comenzar() {
		modelo.anadirDatosPrueba();
		vista.comenzar();
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#anadirCliente
	 * (alquilerVehiculos.mvc.modelo.dominio.Cliente)
	 */
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#borrarCliente
	 * (java.lang.String)
	 */
	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#buscarCliente
	 * (java.lang.String)
	 */
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * obtenerClientes()
	 */
	public Cliente[] obtenerClientes() {
		return modelo.obtenerClientes();
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * anadirVehiculo(alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo)
	 */
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		modelo.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * borrarVehiculo(java.lang.String)
	 */
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * buscarVehiculo(java.lang.String)
	 */
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * obtenerVehiculos()
	 */
	public Vehiculo[] obtenerVehiculos() {
		return modelo.obtenerVehiculos();
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#abrirAlquiler
	 * (alquilerVehiculos.mvc.modelo.dominio.Cliente,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * cerrarAlquiler(alquilerVehiculos.mvc.modelo.dominio.Cliente,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.cerrarAlquiler(cliente, vehiculo);

	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * obtenerAlquileres()
	 */
	public Alquiler[] obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}

	/*
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#
	 * anadirDatosPrueba()
	 */
	public void anadirDatosPrueba() {

	}

}
