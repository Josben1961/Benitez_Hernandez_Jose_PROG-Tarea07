/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehiculo.
 */
public abstract class Vehiculo {

	/** The matricula. */
	private String matricula;

	/** The marca. */
	private String marca;

	/** The modelo. */
	private String modelo;

	/** The disponible. */
	private boolean disponible;

	/** The datos tecnicos. */
	protected DatosTecnicosVehiculo datosTecnicos;

	/** The factor cilindrada. */
	private final double FACTOR_CILINDRADA = 0;

	/** The factor numero plazas. */
	private final double FACTOR_NUMERO_PLAZAS = 0;

	/** The factor pma. */
	private final double FACTOR_PMA = 0;

	/**
	 * Instantiates a new vehiculo.
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
	// Constructor con cuatro parámetros
	public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {

		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setDatosTecnicos(datosTecnicos);

	}

	/**
	 * Constructor copia de la clase Vehiculo Instantiates a new vehiculo.
	 *
	 * @param vehiculo
	 *            the vehiculo
	 */
	public Vehiculo(Vehiculo vehiculo) {
		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		datosTecnicos = vehiculo.getDatosTecnicos();

	}

	/**
	 * Sets the datos tecnicos.
	 *
	 * @param datosTecnicos
	 *            the new datos tecnicos
	 */
	public void setDatosTecnicos(DatosTecnicosVehiculo datosTecnicos) {
		this.datosTecnicos = new DatosTecnicosVehiculo(datosTecnicos);

	}

	/**
	 * Gets the datos tecnicos.
	 *
	 * @return the datos tecnicos
	 */
	public DatosTecnicosVehiculo getDatosTecnicos() {

		return new DatosTecnicosVehiculo(datosTecnicos);
	}

	/**
	 * Gets the matricula.
	 *
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Gets the modelo.
	 *
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Gets the disponible.
	 *
	 * @return the disponible
	 */
	public boolean getDisponible() {
		return disponible;
	}

	/**
	 * Sets the matricula.
	 *
	 * @param matricula
	 *            the new matricula
	 */
	private void setMatricula(String matricula) {
		if (compruebaMatricula(matricula))
			this.matricula = matricula;
		else
			throw new ExcepcionAlquilerVehiculos("La matrícula no es correcta");
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca
	 *            the new marca
	 */
	private void setMarca(String marca) {
		if (marca != null && !marca.equals(""))
			this.marca = marca;
		else
			throw new ExcepcionAlquilerVehiculos("La marca no es válida");
	}

	/**
	 * Sets the modelo.
	 *
	 * @param modelo
	 *            the new modelo
	 */
	private void setModelo(String modelo) {
		if (modelo != null && !modelo.equals(""))
			this.modelo = modelo;
		else
			throw new ExcepcionAlquilerVehiculos("El modelo no es válido");
	}

	/**
	 * Sets the disponible.
	 *
	 * @param disponible
	 *            the new disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Gets the tipo vehiculo.
	 *
	 * @return the tipo vehiculo
	 */
	public abstract TipoVehiculo getTipoVehiculo();

	/**
	 * Precio especifico.
	 *
	 * @return the double
	 */
	public abstract double precioEspecifico();

	// Método para comprobar la matrícula introducida.
	// Matrícula correcta: Cuatro números, espacio y tres letras mayúsculas
	/**
	 * Comprueba matricula.
	 *
	 * @param matricula
	 *            the matricula
	 * @return true, if successful
	 * @throws ExcepcionAlquilerVehiculos
	 *             the excepcion alquiler vehiculos
	 */
	// (excluyendo vocales)
	private boolean compruebaMatricula(String matricula) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("([0-9]{4})+([BCDFGHJKLMNPQRSTVWXYZ]{3})");
		Matcher emparejador;
		emparejador = patron.matcher(matricula);
		return emparejador.matches();
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [TipoVehiculo = " + getTipoVehiculo() + ", Matricula = " + getMatricula() + ", Marca = " + getMarca()
				+ ", Modelo = " + getModelo() + "\n DatosTecnicos = " + getDatosTecnicos() + ", Disponible = "
				+ getDisponible() + ", precioEspecifico=" + precioEspecifico() + "]\n";
	}

}
