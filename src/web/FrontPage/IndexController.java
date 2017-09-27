package web.FrontPage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;

public class IndexController implements Serializable {
	private static final long serialVersionUID = -2981381443054915529L;
	private PharmApp app = PharmApp.store();
	
	public IndexController(){
		PharmApp.store().setDate(LocalDate.of(2017, 3, 15));
	}
	
	public LocalDate getDate(){
		return this.app.getDate();
	}
	
	public List<Pharmacy> getListPharmacy(){
		return this.app.getSectorList().stream()
				.map(s -> s.getShiftPharmacy(this.getDate()))
				.collect(Collectors.toList());
	}
	
}
