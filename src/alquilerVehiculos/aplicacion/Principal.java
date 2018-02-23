/*
 * 
 */
package alquilerVehiculos.aplicacion;

import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.ModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.vista.IUTextual;
import alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos;

// TODO: Auto-generated Javadoc
/**
 * The Class Principal.
 */
public class Principal {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		IModeloAlquilerVehiculos modelo = new ModeloAlquilerVehiculos();
		IVistaAlquilerVehiculos vista = new IUTextual();
		IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

		controlador.comenzar();
	}

}
