
package alquilerVehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Alquiler.
 */
public class Alquiler implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cliente. */
	private Cliente cliente;
	
	/** The vehiculo. */
	private Vehiculo vehiculo;
	
	/** The fecha. */
	private Date fecha;
	
	/** The dias. */
	private int dias;
	
	/** The formato fecha. */
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	/** The ms dia. */
	private final int MS_DIA = 1000 * 60 * 60 * 24;
	
	/** The precio dia. */
	private final double PRECIO_DIA = 30.0;

	/**
	 * Instantiates a new alquiler.
	 *
	 * @param cliente the cliente
	 * @param vehiculo the vehiculo
	 */
	// Constructor con dos parámetros
	public Alquiler(Cliente cliente, Vehiculo vehiculo) {
		setCliente(cliente);
		setVehiculo(vehiculo);
		fecha = new Date();
		dias = 0;
		vehiculo.setDisponible(false);
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	private void setCliente(Cliente cliente) {
		if (cliente != null)
			this.cliente = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El alquiler debe tener un cliente identificado");
	}

	/**
	 * Sets the vehiculo.
	 *
	 * @param vehiculo the new vehiculo
	 */
	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo != null)
			this.vehiculo = vehiculo;
		else
			throw new ExcepcionAlquilerVehiculos("El alquiler debe tener un veh�culo identificado");
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	// Métodos getters
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Gets the vehiculo.
	 *
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Gets the dias.
	 *
	 * @return the dias
	 */
	public int getDias() {
		return dias;
	}

	/**
	 * Gets the precio fijo.
	 *
	 * @return the precio fijo
	 */
	public double getPrecioFijo() {
		return PRECIO_DIA;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public double getPrecio() {

		return PRECIO_DIA * getDias() + vehiculo.precioEspecifico();
	}

	/**
	 * Cerrar.
	 */
	public void cerrar() {
		Date entrega = new Date();
		dias = difDias(entrega, fecha);
		if (entrega == fecha) {
			dias = 1;
		}
		vehiculo.setDisponible(true);
	}

	/**
	 * Dif dias.
	 *
	 * @param fechaFin the fecha fin
	 * @param fechaInicio the fecha inicio
	 * @return the int
	 */
	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
		long dias = milisegundos / MS_DIA;
		return (int) dias + 1;
	}

	/* (sin Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alquiler [Cliente = " + getCliente() + " Vehiculo = " + getVehiculo() + " Fecha = "
				+ FORMATO_FECHA.format(fecha) + ", Dias = " + getDias() + ", Precio = " + getPrecio() + "]\n\n";
	}

}
