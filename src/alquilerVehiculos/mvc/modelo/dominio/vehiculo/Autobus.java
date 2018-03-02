
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Autobus.
 */
public class Autobus extends Vehiculo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The factor autobus. */
	private double factorAutobus = 0.0;

	/**
	 * Instantiates a new autobus.
	 *
	 * @param matricula the matricula
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param datosTecnicos the datos tecnicos
	 */
	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	/**
	 * Instantiates a new autobus.
	 *
	 * @param autobus the autobus
	 */
	public Autobus(Turismo autobus) {
		super(autobus);
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.AUTOBUS;
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#precioEspecifico()
	 */
	@Override
	public double precioEspecifico() {
		factorAutobus = datosTecnicos.getCilindrada() / 50 + 1 * datosTecnicos.getNumeroPlazas();
		return factorAutobus;
	}

}
