package modeloFarmacia.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import modeloFarmacia.Cycle;
import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;
import modeloFarmacia.SocialWork;

public class ModelTest {

	Sector norte = PharmApp.store().getSectorCall("norte");
	
	//Ciclos
	Cycle ciclo1NORTE = new Cycle(LocalDateTime.of(2017, 1, 1, 00, 00), LocalDateTime.of(2017, 6, 30, 00, 00));
	Cycle ciclo2NORTE = new Cycle(LocalDateTime.of(2017, 6, 30, 00, 01), LocalDateTime.of(2017, 12, 31, 00, 00));
	
	
	//creo las farmacias
	Pharmacy farmacia1 = new Pharmacy("De Cicco", "Guemes 399", 452222, 452223);
	Pharmacy farmacia2 = new Pharmacy("Pasteur", "Calle 18 Nª300", 452254, 453333);

	//creo las obras sociales
	SocialWork obraS1 = new SocialWork("OSDE", "sarasa 1000", 456666);
	SocialWork obraS2 = new SocialWork("IOMA", "sarasa 1100", 455555);
	

	
	@Before
	public void init(){
		//Agrego las obras sociales a las farmacias
		farmacia1.addSocialWork(obraS1);
		farmacia1.addSocialWork(obraS2);
		farmacia2.addSocialWork(obraS2);
		
		//agrego la farmacia al sector
		PharmApp.store().addPharmacyToSector(farmacia1, "norte");
		norte.addPharmacy(farmacia2);
		
		//agrego los ciclos al sector
		norte.addCycle(ciclo1NORTE);
		norte.addCycle(ciclo2NORTE);
		
	}
	
	@Test
	public void testEquals() {
//		fail("Not yet implemented");
		Pharmacy farmacia3 = new Pharmacy("De Cicco", "Gues 399", 4522, 4523);
		
		assertTrue(farmacia1.equals(farmacia3));
	}


	
}
