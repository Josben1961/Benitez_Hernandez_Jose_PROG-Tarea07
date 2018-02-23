/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class DeCarga.
 */
public class DeCarga extends Vehiculo {

	/** The factor de carga. */
	private double factorDeCarga = 0.0;

	/**
	 * Instantiates a new de carga.
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
	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	/**
	 * Instantiates a new de carga.
	 *
	 * @param deCarga
	 *            the de carga
	 */
	public DeCarga(Turismo deCarga) {
		super(deCarga);
	}

	/*
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	@Override
	public TipoVehiculo getTipoVehiculo() {
		// TODO Apéndice de método generado automáticamente
		return TipoVehiculo.DE_CARGA;
	}

	/*
	 * @see
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#precioEspecifico()
	 */
	@Override
	public double precioEspecifico() {
		factorDeCarga = datosTecnicos.getPma() / 20 + 1 * datosTecnicos.getNumeroPlazas();
		return factorDeCarga;
	}
}
