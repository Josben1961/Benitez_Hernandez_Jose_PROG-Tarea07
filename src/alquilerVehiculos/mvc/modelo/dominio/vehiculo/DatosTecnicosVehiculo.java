/*
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Class DatosTecnicosVehiculo.
 */
public class DatosTecnicosVehiculo {
	
	/** The cilindrada. */
	private int cilindrada;
	
	/** The numero plazas. */
	private int numeroPlazas;
	
	/** The pma. */
	private int pma;
	
	/**
	 * Instantiates a new datos tecnicos vehiculo.
	 *
	 * @param datosTecnicos the datos tecnicos
	 */
	public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {
		cilindrada= datosTecnicos.getCilindrada();
		numeroPlazas=datosTecnicos.getNumeroPlazas();
		pma= datosTecnicos.getPma();
	}
	
	/**
	 * Instantiates a new datos tecnicos vehiculo.
	 *
	 * @param cilindrada the cilindrada
	 * @param numeroPlazas the numero plazas
	 * @param pma the pma
	 */
	public DatosTecnicosVehiculo(int cilindrada, int numeroPlazas, int pma) {
		
		setCilindrada(cilindrada);
		setNumeroPlazas(numeroPlazas);
		setPma(pma);				
	}

	/**
	 * Gets the cilindrada.
	 *
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * Sets the cilindrada.
	 *
	 * @param cilindrada the new cilindrada
	 */
	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
	}

	/**
	 * Gets the numero plazas.
	 *
	 * @return the numero plazas
	 */
	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	/**
	 * Sets the numero plazas.
	 *
	 * @param numeroPlazas the new numero plazas
	 */
	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	/**
	 * Gets the pma.
	 *
	 * @return the pma
	 */
	public int getPma() {
		return pma;
	}

	/**
	 * Sets the pma.
	 *
	 * @param pma the new pma
	 */
	public void setPma(int pma) {
		this.pma = pma;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [Cilindrada = " + getCilindrada() + ", NumeroPlazas = " + getNumeroPlazas()
				+ ", Pma = " + getPma() + "]";
	}

	
	
	

}
