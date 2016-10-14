package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.exceptions.ExistsSportException;
import es.upm.miw.apiArchitectureSport.wrappers.SportWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.SportListWrapper;

public class SportResource {

	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

	public void createSport(String sportName) throws ExistsSportException {
		// this.validateField(sportName);
		this.validateSport(sportName);
		new SportController().createSport(sportName);
	}

	public void validateSport(String sportName) throws ExistsSportException {
		SportWrapper sportWrapper = new SportController().findSport(sportName);
		if (!sportWrapper.getName().isEmpty()) {
			throw new ExistsSportException(sportName);
		}
	}

}
