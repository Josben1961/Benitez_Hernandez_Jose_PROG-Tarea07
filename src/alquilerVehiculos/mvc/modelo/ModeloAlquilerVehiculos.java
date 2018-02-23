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

	/** The clientes. */
	private Clientes clientes;

	/** The vehiculos. */
	private Vehiculos vehiculos;

	/** The alquileres. */
	private Alquileres alquileres;

	/**
	 * Instantiates a new modelo alquiler vehiculos.
	 */
	public ModeloAlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#anadirCliente(
	 * alquilerVehiculos.mvc.modelo.dominio.Cliente)
	 */
	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#borrarCliente(java.lang
	 * .String)
	 */
	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#buscarCliente(java.lang
	 * .String)
	 */
	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#obtenerClientes()
	 */
	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#anadirVehiculo(
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo)
	 */
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#borrarVehiculo(java.
	 * lang.String)
	 */
	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#buscarVehiculo(java.
	 * lang.String)
	 */
	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#obtenerVehiculos()
	 */
	public Vehiculo[] obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#abrirAlquiler(
	 * alquilerVehiculos.mvc.modelo.dominio.Cliente,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#cerrarAlquiler(
	 * alquilerVehiculos.mvc.modelo.dominio.Cliente,
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {

		alquileres.cerrarAlquiler(cliente, vehiculo);
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#obtenerAlquileres()
	 */
	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos#anadirDatosPrueba()
	 */
	public void anadirDatosPrueba() {
		Cliente cliente1 = new Cliente("Antonio", "11111111A", new DireccionPostal("Mota", "Almería", "04001"));
		Cliente cliente2 = new Cliente("Luis", "22222222B", new DireccionPostal("Tinaja", "Almería", "04002"));
		Cliente cliente3 = new Cliente("José", "12345678C", new DireccionPostal("Pasaje", "Granada", "28345"));
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		anadirCliente(cliente3);
		Vehiculo vehiculo1 = new Turismo("1234BBB", "Renault", "Clio", new DatosTecnicosVehiculo(1600, 5, 1000));
		Vehiculo vehiculo2 = new Turismo("2345BBB", "Citröen", "C4", new DatosTecnicosVehiculo(1500, 5, 800));
		Vehiculo vehiculo3 = new DeCarga("3456BBB", "Man", "3700", new DatosTecnicosVehiculo(2500, 5, 3000));
		Vehiculo vehiculo4 = new Autobus("4567BBB", "Volvo", "8100", new DatosTecnicosVehiculo(2900, 60, 2000));
		anadirVehiculo(vehiculo1, TipoVehiculo.TURISMO);
		anadirVehiculo(vehiculo2, TipoVehiculo.TURISMO);
		anadirVehiculo(vehiculo3, TipoVehiculo.DE_CARGA);
		anadirVehiculo(vehiculo4, TipoVehiculo.AUTOBUS);
		abrirAlquiler(cliente1, vehiculo1);
		abrirAlquiler(cliente2, vehiculo2);
		abrirAlquiler(cliente3, vehiculo3);
		cerrarAlquiler(cliente1, vehiculo1);
		cerrarAlquiler(cliente2, vehiculo2);
		cerrarAlquiler(cliente3, vehiculo3);
	}

}
