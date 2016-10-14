package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureSport.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureSport.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeListWrapper;

public class SportResource {

	// GET **/themes
	public ThemeListWrapper themeList() {
		return new SportController().themeList();
	}

	// POST **/themes   body="themeName"
	public void createTheme(String themeName) throws InvalidThemeFieldException {
		this.validateField(themeName);
		this.validateSport(themeName);
		new SportController().createTheme(themeName);
	}
	


	private void validateField(String field) throws InvalidThemeFieldException {
	//	ThemeWrapper themeWrapper=new SportController().themeList(field);
		if (field == null || field.isEmpty()) {
			throw new InvalidThemeFieldException(field);
		}
	}

	// GET **themes/{id}/overage
	public OverageWrapper themeOverage(int themeId) throws NotFoundThemeIdException {
		OverageWrapper overageWrapper = new SportController().themeOverage(themeId);
		if (overageWrapper == null) {
			throw new NotFoundThemeIdException("" + themeId);
		} else {
			return overageWrapper;
		}
	}
	
	public void validateSport(String themeName) throws InvalidThemeFieldException {
		ThemeWrapper sportWrapper = new SportController().themeSport(themeName);
		if (!sportWrapper.getName().isEmpty() ) {
			throw new InvalidThemeFieldException(themeName);
		} 
	}


}
