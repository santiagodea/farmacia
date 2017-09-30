package web.FrontPage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SpecialEvent;

public class IndexController implements Serializable {
	private static final long serialVersionUID = -2981381443054915529L;
	private PharmApp app = PharmApp.store();
	private long offset = 0L;
	
	public IndexController(){
		PharmApp.store().setDate(LocalDate.of(2017, 3, 15)); //para test
	}
	
	public LocalDate getDate(){
		return this.app.getDate().plusDays(this.offset);
	}
	
	public List<Pharmacy> getListPharmacy(){
		return this.app.getSectorList().stream()
				.map(s -> s.getShiftPharmacy(this.getDate()))
				.collect(Collectors.toList());
	}

	public List<SpecialEvent> getSpecialEventsDate(){
		return PharmApp.store().getSpecialEventListTo(this.getDate());
	}
	
	public boolean getIsToday(){
		return this.offset == 0;
	}
	
	public void minusDay() {
		this.offset-=1;
	}
	public void plusDay() {
		this.offset+=1;
	}
}
