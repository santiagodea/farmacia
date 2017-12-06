package api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.resource.gson.GsonRestResource;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;


public class PharAppRestResource  extends GsonRestResource {
	/*
	 * Paso 1: armar la clase que extiend GsonRestResource
	 * (lo de "Gson" es para que genere Json, hay otra que no sé cómo se llama
	 *  para que genere XML)
	 */
	private static final long serialVersionUID = 2248095774654428282L;

		// a cada método que quiero que escuche un pedido, 
		// le agrego la annotation @MethodMapping con el path como valor
		@MethodMapping("/farmacias")
		
		public List<PharmacyDataObject> pharmacyList() {
			return PharmApp.store().pharmacyList().stream()
					.sorted(Comparator.comparing(Pharmacy::getName))
					.map(pharmacy -> new PharmacyDataObject(pharmacy))
					.collect(Collectors.toList());
		}

		// si la URL tiene partes entre llaves, esas partes son variables.
		// el valor va a parar al parámetro del método
		// p.ej. si pongo .../banda/Sumo, el parámetro nombre toma el valor "Sumo"
		@MethodMapping("/farmacia/{nombre}")	
		public PharmacyDataObject getBanda(String nombre) {
			return new PharmacyDataObject(PharmApp.store().getPharmacyCall(nombre));
		}

	}