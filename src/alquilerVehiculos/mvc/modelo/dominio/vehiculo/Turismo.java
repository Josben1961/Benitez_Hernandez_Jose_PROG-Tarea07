/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Turismo.
 */
public class Turismo extends Vehiculo {
	
	/** The factor turismo. */
	private double factorTurismo = 0.0;

	/**
	 * Instantiates a new turismo.
	 *
	 * @param matricula the matricula
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param datosTecnicos the datos tecnicos
	 */
	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	/**
	 * Instantiates a new turismo.
	 *
	 * @param turismo the turismo
	 */
	public Turismo(Turismo turismo) {
		super(turismo);
	}

	/* 
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	public TipoVehiculo getTipoVehiculo() {
		// TODO Apéndice de método generado automáticamente
		return TipoVehiculo.TURISMO;
	}

	/* 
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#precioEspecifico()
	 */
	public double precioEspecifico() {
		factorTurismo= datosTecnicos.getCilindrada()/50;
		return factorTurismo;
	}
}