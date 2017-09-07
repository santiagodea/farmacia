package modeloFarmacia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PharmApp {
	private List<Cycle> CycleList = new ArrayList<>();
	private List<Sector> SectorList = new ArrayList<>();
	
	private LocalDateTime date;
	
	public PharmApp() {
		
	}
	
	
	
	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}
	
}
