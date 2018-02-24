
package alquilerVehiculos.mvc.modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Vehiculos {

	private Vehiculo[] vehiculos;

	private final int MAX_VEHICULOS = 100;
	private final String FICHERO_VEHICULOS = "datos/vehiculos.dat";
	
	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}

	public Vehiculo[] getVehiculos() {
		return vehiculos.clone();
	}
	
	public void leerVehiculos() {
		File fichero = new File(FICHERO_VEHICULOS);
		ObjectInputStream entrada;
		try {
			entrada = new ObjectInputStream(new FileInputStream(fichero));
			try {
				vehiculos = (Vehiculo[])entrada.readObject();
				entrada.close();
				System.out.println("Leido fichero vehiculos correctamente.");
			} catch (ClassNotFoundException e) {
				System.out.println("No puedo encontrar la clase que tengo que leer.");
			} catch (IOException e) {
				System.out.println("Error inesperado de Entrada/Salida.");
			}
		} catch (IOException e) {
			System.out.println("Imposible abrir el fihero de vehículos.");
		}
	}
	public void escribirVehiculos() {
		File fichero = new File(FICHERO_VEHICULOS);
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
			salida.writeObject((Vehiculo[])vehiculos);
			salida.close();
			System.out.println("Escrito fichero vehiculos correctamente");
		} catch (FileNotFoundException e) {
			System.out.println("Imposible crear el fichero de vehículos");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice)) {
			vehiculos[indice] = tipoVehiculo.getInstancia(vehiculo.getMatricula(), vehiculo.getMarca(),
					vehiculo.getModelo(), vehiculo.getDatosTecnicos());
			vehiculo.setDisponible(true);

		} else
			throw new ExcepcionAlquilerVehiculos("El array de vehículos está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] == null)
				vehiculoEncontrado = true;
			else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un vehículo con esa matrícula");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}

	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El vehículo a borrar no existe");
		}
	}

	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return vehiculoEncontrado ? indice : vehiculos.length;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i + 1];
		}
	}

	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		Vehiculo vehiculo = null;
		if (indiceNoSuperaTamano(indice)) {
			return vehiculos[indice];

		} else
			return null;
	}
}
