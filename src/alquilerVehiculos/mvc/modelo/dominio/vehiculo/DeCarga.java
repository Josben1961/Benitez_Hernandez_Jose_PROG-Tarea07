
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class DeCarga.
 */
public class DeCarga extends Vehiculo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The factor de carga. */
	private double factorDeCarga = 0.0;

	/**
	 * Instantiates a new de carga.
	 *
	 * @param matricula the matricula
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param datosTecnicos the datos tecnicos
	 */
	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	/**
	 * Instantiates a new de carga.
	 *
	 * @param deCarga the de carga
	 */
	public DeCarga(Turismo deCarga) {
		super(deCarga);
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.DE_CARGA;
	}

	/* (sin Javadoc)
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#precioEspecifico()
	 */
	@Override
	public double precioEspecifico() {
		factorDeCarga = datosTecnicos.getPma() / 20 + 1 * datosTecnicos.getNumeroPlazas();
		return factorDeCarga;
	}
}
