
package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.vista.utilidades.Consola;

// TODO: Auto-generated Javadoc
/**
 * The Class IUTextual.
 */
public class IUTextual implements IVistaAlquilerVehiculos {

	/** The controlador. */
	IControladorAlquilerVehiculos controlador;

	/**
	 * Instantiates a new IU textual.
	 */
	public IUTextual() {
		Opcion.setVista(this);
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#setControlador(alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos)
	 */
	public void setControlador(IControladorAlquilerVehiculos controlador) {
		this.controlador = controlador;
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#comenzar()
	 */
	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#salir()
	 */
	public void salir() {
		System.out.println("Ha elegido salir de la aplicación");
		controlador.salir();
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#anadirCliente()
	 */
	public void anadirCliente() {
		Consola.mostrarCabecera("Añadir cliente");
		try {
			Cliente cliente = Consola.leerCliente();
			controlador.anadirCliente(cliente);
			System.out.println("Cliente añadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#borrarCliente()
	 */
	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		String dni = Consola.leerDni();
		try {
			controlador.borrarCliente(dni);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#buscarCliente()
	 */
	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#listarClientes()
	 */
	public void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		for (Cliente cliente : controlador.obtenerClientes()) {
			if (cliente != null)
				System.out.println(cliente);
		}
		System.out.println("");
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#anadirVehiculo()
	 */
	public void anadirVehiculo() {
		Consola.mostrarCabecera("Añadir vehículo");
		int ordinalTipo = Consola.elegirTipoVehiculo();
		try {
			Vehiculo vehiculo = Consola.leerVehiculo();
			controlador.anadirVehiculo(vehiculo, TipoVehiculo.getTipoVehiculoSegunOrdinal(ordinalTipo));
			;
			System.out.println("Vehículo añadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#borrarVehiculo()
	 */
	public void borrarVehiculo() {
		Consola.mostrarCabecera("Borrar vehículo");
		String matricula = Consola.leerMatricula();
		try {
			controlador.borrarVehiculo(matricula);
			System.out.println("Vehículo borrado satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#buscarVehiculo()
	 */
	public void buscarVehiculo() {
		Consola.mostrarCabecera("Buscar vehículo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculoBuscado = controlador.buscarVehiculo(matricula);
		String mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El vehículo no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#listarVehiculos()
	 */
	public void listarVehiculos() {
		Consola.mostrarCabecera("Listar vehículos");
		for (Vehiculo vehiculo : controlador.obtenerVehiculos()) {
			if (vehiculo != null)
				System.out.println(vehiculo);
		}
		System.out.println("");
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#abrirAlquiler()
	 */
	public void abrirAlquiler() {
		Consola.mostrarCabecera("Abrir alquiler");
		String matricula = Consola.leerMatricula();
		String dni = Consola.leerDni();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		Cliente cliente = controlador.buscarCliente(dni);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con esa matrícula\n");
		else {
			try {
				controlador.abrirAlquiler(cliente, vehiculo);
				System.out.println("Alquiler abierto satisfactoriamente\n");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#cerrarAlquiler()
	 */
	public void cerrarAlquiler() {
		Consola.mostrarCabecera("Cerrar alquiler");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			try {
				controlador.cerrarAlquiler(cliente, vehiculo);
				System.out.println("Alquiler cerrado satisfactoriamente\n");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos#listarAlquileres()
	 */
	public void listarAlquileres() {
		Consola.mostrarCabecera("Listar Alquileres");
		for (Alquiler alquiler : controlador.obtenerAlquileres()) {
			if (alquiler != null)
				System.out.println(alquiler);
		}
		System.out.println("");
	}
}
