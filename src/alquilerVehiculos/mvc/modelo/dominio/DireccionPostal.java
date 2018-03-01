/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class DireccionPostal.
 */
public class DireccionPostal implements Serializable{

	private static final long serialVersionUID = 1L;

	/** The calle. */
	private String calle;

	/** The localidad. */
	private String localidad;

	/** The codigo postal. */
	private String codigoPostal;

	/**
	 * Instantiates a new direccion postal.
	 *
	 * @param direccionPostal
	 *            the direccion postal
	 */
	public DireccionPostal(DireccionPostal direccionPostal) {
		calle = direccionPostal.getCalle();
		localidad = direccionPostal.getLocalidad();
		codigoPostal = direccionPostal.getCodigoPostal();
	}

	/**
	 * Instantiates a new direccion postal.
	 *
	 * @param calle
	 *            the calle
	 * @param localidad
	 *            the localidad
	 * @param codigoPostal
	 *            the codigo postal
	 */
	public DireccionPostal(String calle, String localidad, String codigoPostal) {
		setCalle(calle);
		setLocalidad(localidad);
		setCodigoPostal(codigoPostal);
	}

	/**
	 * Gets the calle.
	 *
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Sets the calle.
	 *
	 * @param calle
	 *            the new calle
	 */
	public void setCalle(String calle) {
		if (calle != null && !calle.equals(""))
			this.calle = calle;
		else
			throw new ExcepcionAlquilerVehiculos("La calle no es correcta");
	}

	/**
	 * Gets the localidad.
	 *
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Sets the localidad.
	 *
	 * @param localidad
	 *            the new localidad
	 */
	public void setLocalidad(String localidad) {
		if (localidad != null && !localidad.equals(""))
			this.localidad = localidad;
		else
			throw new ExcepcionAlquilerVehiculos("Localidad no v�lida");
	}

	/**
	 * Gets the codigo postal.
	 *
	 * @return the codigo postal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Sets the codigo postal.
	 *
	 * @param codigoPostal
	 *            the new codigo postal
	 */
	public void setCodigoPostal(String codigoPostal) {
		if (compruebaCodigoPostal(codigoPostal))
			this.codigoPostal = codigoPostal;
		else
			throw new ExcepcionAlquilerVehiculos("El formato del c�digo no es v�lido");
	}

	/**
	 * Comprueba codigo postal.
	 *
	 * @param codigoPostal
	 *            the codigo postal
	 * @return true, if successful
	 * @throws ExcepcionAlquilerVehiculos
	 *             the excepcion alquiler vehiculos
	 */
	boolean compruebaCodigoPostal(String codigoPostal) throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
		Matcher emparejador;
		emparejador = patron.matcher(codigoPostal);
		return emparejador.matches();
	}

	/* (sin Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("Calle: %s Localidad: %s C�digo Postal: %s", calle, localidad, codigoPostal);
	}
}