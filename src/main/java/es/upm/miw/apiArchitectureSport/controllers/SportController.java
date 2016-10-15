package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.SportWrapper;

public class SportController {

	public SportListWrapper sportList() {
		List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper sportListWrapper = new SportListWrapper();
		for (Sport sport : sportList) {
			sportListWrapper.addSportWrapper(new SportWrapper(sport.getId(), sport.getName()));
		}
		return sportListWrapper;
	}

	public void createSport(String sportName) {

		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}

	public SportWrapper findSport(String sportName) {
		List<String> sportWrapper = DaoFactory.getFactory().getSportDao().findSportBySportName(sportName);
		String name = "";
		int id = 0;
		for (String value : sportWrapper) {
			name = value;
			id++;
		}

		return new SportWrapper(id, name);

	}

}
