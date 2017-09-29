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

//	Sector norte = PharmApp.store().getSectorCall("norte");
	Sector norte = new Sector("norte", LocalDate.of(2016, 12, 31));
	
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
		
		//assertEquals("suer",PharmApp.store().getSectorList().get(0).getName());		
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
	

	@Test
	public void testIncludeDate(){
		Cycle c = new Cycle(LocalDate.of(2017,2, 10), LocalDate.of(2017,2, 15));
		Cycle c1 = new Cycle(LocalDate.of(2017,2, 10), LocalDate.of(2017,5, 15));

		assertTrue(c.includeDate(LocalDate.of(2017,2, 10)));
		assertTrue(c.includeDate(LocalDate.of(2017,2, 13)));
		assertTrue(c.includeDate(LocalDate.of(2017,2, 14)));
		
		assertTrue(c1.includeDate(LocalDate.of(2017,2, 10)));
		assertTrue(c1.includeDate(LocalDate.of(2017,3, 13)));
		assertTrue(c1.includeDate(LocalDate.of(2017,5, 14)));
		
	}
	
	@Test
	public void testShiftPharmacy(){
		Pharmacy s = new Pharmacy("Soloeta", "20 n210", 453131, 453132);
		
		norte.addPharmacy(farmacia1);
		norte.addPharmacy(farmacia2);
		norte.addPharmacy(s);
		
		norte.createCycle(LocalDate.of(2017, 1, 20));
		
		assertEquals(farmacia1, norte.getShiftPharmacy(LocalDate.of(2017, 1, 1)));
		
		assertEquals(s, norte.getShiftPharmacy(LocalDate.of(2017, 1, 3)));
		assertEquals(s, norte.getShiftPharmacy(LocalDate.of(2017, 1, 6)));
		
		assertEquals(farmacia1, norte.getShiftPharmacy(LocalDate.of(2017, 1, 19)));
		
	}
}
