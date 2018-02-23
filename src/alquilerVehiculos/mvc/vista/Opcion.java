/*
 * 
 */
package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Enum Opcion.
 */
public enum Opcion {

	/** The salir. */
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},

	/** The anadir cliente. */
	ANADIR_CLIENTE("Añadir cliente") {
		public void ejecutar() {
			vista.anadirCliente();
		}
	},

	/** The borrar cliente. */
	BORRAR_CLIENTE("Borrar cliente") {
		public void ejecutar() {
			vista.borrarCliente();
		}
	},

	/** The buscar cliente. */
	BUSCAR_CLIENTE("Buscar cliente") {
		public void ejecutar() {
			vista.buscarCliente();
		}
	},

	/** The listar clientes. */
	LISTAR_CLIENTES("Listar clientes") {
		public void ejecutar() {
			vista.listarClientes();
		}
	},

	/** The anadir vehiculo. */
	ANADIR_VEHICULO("Añadir vehículo") {
		public void ejecutar() {
			vista.anadirVehiculo();
		}
	},

	/** The borrar vehiculo. */
	BORRAR_VEHICULO("Borrar vehículo") {
		public void ejecutar() {
			vista.borrarVehiculo();
		}
	},

	/** The buscar vehiculo. */
	BUSCAR_VEHICULO("Buscar vehículo") {
		public void ejecutar() {
			vista.buscarVehiculo();
		}
	},

	/** The listar vehiculos. */
	LISTAR_VEHICULOS("Listar vehículos") {
		public void ejecutar() {
			vista.listarVehiculos();
		}
	},

	/** The abrir alquileres. */
	ABRIR_ALQUILERES("Abrir alquiler") {
		public void ejecutar() {
			vista.abrirAlquiler();
		}
	},

	/** The cerrar alquiler. */
	CERRAR_ALQUILER("Cerrar Alquiler") {
		public void ejecutar() {
			vista.cerrarAlquiler();
		}
	},

	/** The listar alquileres. */
	LISTAR_ALQUILERES("Listar Alquileres") {
		public void ejecutar() {
			vista.listarAlquileres();
		}
	};

	/** The mensaje. */
	private String mensaje;

	/** The vista. */
	private static IVistaAlquilerVehiculos vista;

	/**
	 * Instantiates a new opcion.
	 *
	 * @param mensaje
	 *            the mensaje
	 */
	private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Ejecutar.
	 */
	public abstract void ejecutar();

	/**
	 * Gets the mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Sets the vista.
	 *
	 * @param vista
	 *            the new vista
	 */
	public static void setVista(IVistaAlquilerVehiculos vista) {
		Opcion.vista = vista;
	}

	/*
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}

	/**
	 * Gets the opcion segun oridnal.
	 *
	 * @param ordinal
	 *            the ordinal
	 * @return the opcion segun oridnal
	 */
	public static Opcion getOpcionSegunOridnal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Opción no válida");
	}

	/**
	 * Es ordinal valido.
	 *
	 * @param ordinal
	 *            the ordinal
	 * @return true, if successful
	 */
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}
}
