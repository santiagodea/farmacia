package web.FrontPage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SpecialEvent;
import web.LoadCycle.mainAdmin.Controller;

public class IndexController extends Controller implements Serializable {
	private static final long serialVersionUID = -2981381443054915529L;
	
//Variables
	
	private long offset = 0L;
	
//Methods
	
	public LocalDate getDate(){
		LocalDate nowDate = LocalDate.now();
		return ( this.getIsToday() && LocalDateTime.now().getHour() < 8) ? nowDate.minusDays(1) : nowDate.plusDays(this.offset);
	}
	
	public List<Pharmacy> getListPharmacy(){
		try {
			this.controllerErrorMsg = "";
			return PharmApp.store().getSectorList().stream()
					.map(s -> s.getShiftPharmacy(this.getDate()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			this.controllerErrorMsg= e.getMessage();
			return new ArrayList<Pharmacy>();
		}
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
	public void setOffset(int n){
		this.offset= n;
	}
}
