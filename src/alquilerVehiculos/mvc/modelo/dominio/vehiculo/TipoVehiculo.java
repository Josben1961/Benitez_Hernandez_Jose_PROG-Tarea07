
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Enum TipoVehiculo.
 */
public enum TipoVehiculo {

	/** The turismo. */
	TURISMO("Turismo") {

		public Turismo getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new Turismo(matricula, marca, modelo, datosTecnicos);
		}

	},

	/** The de carga. */
	DE_CARGA("DeCarga") {

		public DeCarga getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new DeCarga(matricula, marca, modelo, datosTecnicos);
		}

	},

	/** The autobus. */
	AUTOBUS("Autobús") {

		public Autobus getInstancia(String matricula, String marca, String modelo,
				DatosTecnicosVehiculo datosTecnicos) {
			return new Autobus(matricula, marca, modelo, datosTecnicos);
		}

	};

	/** The tipo. */
	private String tipo;

	/**
	 * Instantiates a new tipo vehiculo.
	 *
	 * @param tipo the tipo
	 */
	private TipoVehiculo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the instancia.
	 *
	 * @param matricula the matricula
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param datosTecnicos the datos tecnicos
	 * @return the instancia
	 */
	public abstract Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos);

	/**
	 * Gets the tipo vehiculo segun ordinal.
	 *
	 * @param ordinal the ordinal
	 * @return the tipo vehiculo segun ordinal
	 */
	public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
	}

	/**
	 * Es ordinal valido.
	 *
	 * @param ordinal the ordinal
	 * @return true, if successful
	 */
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}

	/* (sin Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return tipo;
	}

}
