package api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.resource.gson.GsonRestResource;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;
import web.FrontPage.IndexController;


public class PharAppRestResource  extends GsonRestResource {
	/*
	 * Paso 1: armar la clase que extiend GsonRestResource
	 * (lo de "Gson" es para que genere Json, hay otra que no s� c�mo se llama
	 *  para que genere XML)
	 */
	
	private static final long serialVersionUID = 2248095774654428282L;

		// a cada m�todo que quiero que escuche un pedido, 
		// le agrego la annotation @MethodMapping con el path como valor
		@MethodMapping("/farmacias")
		
		public List<PharmacyDataObject> pharmacyList() {
			return PharmApp.store().pharmacyList().stream()
					.sorted(Comparator.comparing(Pharmacy::getName))
					.map(pharmacy -> new PharmacyDataObject(pharmacy))
					.collect(Collectors.toList());
		}

		// si la URL tiene partes entre llaves, esas partes son variables.
		// el valor va a parar al par�metro del m�todo
		// p.ej. si pongo .../banda/Sumo, el par�metro nombre toma el valor "Sumo"
		@MethodMapping("/farmacia/{nombre}")	
		public PharmacyDataObject getBanda(String nombre) {
			return new PharmacyDataObject(PharmApp.store().getPharmacyCall(nombre));
		}
		
		
	
			@MethodMapping("/index/{offset}")	
			public IndexDataObject getIndex(int offset){
				IndexController indexController = new IndexController();
				indexController.setOffset(offset);
				
				List<PharmacyDataObject> shiftPharmacys = indexController.getListPharmacy().stream()
				.map(phar -> new PharmacyDataObject(phar))
				.collect(Collectors.toList());
				
				List<EventDataObject> eventData = indexController.getSpecialEventsDate().stream()
				.map(event -> new EventDataObject(event))
				.collect(Collectors.toList());
				
				return new IndexDataObject(indexController.getDate(),shiftPharmacys,eventData);
			}
			
		
			
		@MethodMapping("/socialWorks")	
		public List<SocialWorkDataObject> getSocialWorks(){
			List<SocialWork> socialWorks = PharmApp.store().getSocialWorks();
			
			List<SocialWorkDataObject> listSw = new ArrayList<>();
			
			for (SocialWork socialWork : socialWorks) {
				List<PharmacyDataObject> phars = PharmApp.store().pharmacyList().stream()
					.filter(phar -> phar.getSocialWorks().contains(socialWork))
					.sorted(Comparator.comparing(Pharmacy::getName))
					.map(pharmacy -> new PharmacyDataObject(pharmacy))
					.collect(Collectors.toList());
				
				listSw.add(new SocialWorkDataObject(socialWork, phars));
			}
			return listSw;
		}
	}