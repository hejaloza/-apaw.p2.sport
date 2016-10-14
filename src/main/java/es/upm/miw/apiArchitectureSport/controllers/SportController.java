package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeWrapper;

public class SportController {

	public ThemeListWrapper themeList() {
		List<Sport> themeList = DaoFactory.getFactory().getSportDao().findAll();
		ThemeListWrapper themeListWrapper = new ThemeListWrapper();
		for (Sport theme : themeList) {
			themeListWrapper.addThemeWrapper(new ThemeWrapper(theme.getId(), theme.getName()));
		}
		return themeListWrapper;
	}

	public void createTheme(String themeName) {
		
		DaoFactory.getFactory().getSportDao().create(new Sport(themeName));
	}

	public OverageWrapper themeOverage(int sportId) {
		if (DaoFactory.getFactory().getSportDao().read(sportId) == null) {
			return null;
		}
		List<Integer> voteValues = DaoFactory.getFactory().getUserDao().findValueBySportId(sportId);
		double total = 0;
		for (Integer value : voteValues) {
			total += value;
		}
		return new OverageWrapper(total / voteValues.size());
	
	
	}
	
	
	public ThemeWrapper themeSport(String themeName) {
		
		List<String> themeWrapper = DaoFactory.getFactory().getSportDao().findBySport(themeName);
		  String name="";
		for (String value : themeWrapper) {
			 name= value;
		}
	    
		return new ThemeWrapper(1,name);
	
	}
	

}
