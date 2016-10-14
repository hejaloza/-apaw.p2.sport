package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.SportWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.SportListWrapper;

public class SportResource {

	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

	public void createSport(String sportName) throws InvalidThemeFieldException {
		this.validateField(sportName);
		this.validateSport(sportName);
		new SportController().createSport(sportName);
	}

	private void validateField(String field) throws InvalidThemeFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidThemeFieldException(field);
		}
	}

	public void validateSport(String sportName) throws InvalidThemeFieldException {
		SportWrapper sportWrapper = new SportController().findSport(sportName);
		if (!sportWrapper.getName().isEmpty()) {
			throw new InvalidThemeFieldException(sportName);
		}
	}

}
