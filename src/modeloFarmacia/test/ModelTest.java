package modeloFarmacia.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import modeloFarmacia.Cycle;
import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;
import modeloFarmacia.SocialWork;

public class ModelTest {

	Sector norte = PharmApp.store().getSectorCall("norte");
	
//	//Ciclos - no usamos mas este tipo de creacion de ciclo se encarga Sector
//	Cycle ciclo1NORTE = new Cycle(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 6, 30));
//	Cycle ciclo2NORTE = new Cycle(LocalDate.of(2017, 6, 30), LocalDate.of(2017, 12, 31));
	
	
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

	}
	
	@Test
	public void testEqualsNamePharmacy() {

//		fail("Not yet implemented");
		Pharmacy farmacia3 = new Pharmacy("De Cicco", "Gues 399", 4522, 4523);
		
		assertTrue(farmacia1.equals(farmacia3));
		
	}
	
	@Test (expected = RuntimeException.class)
	public void testaddduplicatePharmacy() {
		
		//agrego la farmacia al sector
		PharmApp.store().addPharmacyToSector(farmacia1, "norte");
		PharmApp.store().addPharmacyToSector(farmacia2, "norte");
		
		
		
		Pharmacy farmacia3 = new Pharmacy("De Cicco", "Gues 399", 4522, 4523);
		PharmApp.store().addPharmacyToSector(farmacia3, "norte");

		
	}
	
	
	@Test (expected = RuntimeException.class)
	public void testaddduplicateSocialWork() {
		
		//agrego la farmacia al sector
		PharmApp.store().addPharmacyToSector(farmacia1, "norte");
		farmacia1.addSocialWork(obraS2);
		SocialWork obraS3 = new SocialWork("IOMA", "sara 1100", 455555);
		farmacia1.addSocialWork(obraS3);

		
	}
	
	@Test 
	public void testCreateCycles() {
		Sector norte = PharmApp.store().getSectorCall("norte");
		norte.createCycle(LocalDate.of(2017, 2, 20));
		norte.createCycle(LocalDate.of(2017, 4, 1));
		
		System.out.println("Ciclo 1 inicio " + norte.getCycles().get(0).getDateStart() + " fin " + norte.getCycles().get(0).getDateEnd());
		System.out.println("Ciclo 2 inicio " + norte.getCycles().get(1).getDateStart() + " fin " + norte.getCycles().get(1).getDateEnd());
		
		assertEquals(norte.getCycles().size(), 2);
	}
}
