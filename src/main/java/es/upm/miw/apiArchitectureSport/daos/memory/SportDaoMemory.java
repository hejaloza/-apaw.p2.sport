package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.daos.SportDao;
import es.upm.miw.apiArchitectureSport.daos.UserDao;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer, Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);

	}
	
	
	public List<String> findBySport(String name) {
		List<Sport> sports = this.findAll();
		List<String> sportsName = new ArrayList<>();
		for (Sport sport : sports) {
			if (sport.getName() == name) {
				sportsName.add(sport.getName());
			}
		}
		return sportsName;
	}
	
	


	
	
	

	public List<Integer> findOneSport(String name) {
		List<Sport> sports = this.findAll();
		List<Integer> sportsName = new ArrayList<>();
		
		for (Sport sport : sports) {
			if (sport.getName().equalsIgnoreCase(name)) {
				
				sportsName.add(sport.getId());
			}
		}
		return sportsName;
	}
	
}