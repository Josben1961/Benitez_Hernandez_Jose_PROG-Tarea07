/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Autobus.
 */
public class Autobus extends Vehiculo {

	/** The factor autobus. */
	private double factorAutobus = 0.0;

	/**
	 * Instantiates a new autobus.
	 *
	 * @param matricula
	 *            the matricula
	 * @param marca
	 *            the marca
	 * @param modelo
	 *            the modelo
	 * @param datosTecnicos
	 *            the datos tecnicos
	 */
	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	/**
	 * Instantiates a new autobus.
	 *
	 * @param autobus
	 *            the autobus
	 */
	public Autobus(Turismo autobus) {
		super(autobus);
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return TipoVehiculo.AUTOBUS;
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#precioEspecifico()
	 */
	@Override
	public double precioEspecifico() {
		factorAutobus = datosTecnicos.getCilindrada() / 50 + 1 * datosTecnicos.getNumeroPlazas();
		return factorAutobus;
	}

}
