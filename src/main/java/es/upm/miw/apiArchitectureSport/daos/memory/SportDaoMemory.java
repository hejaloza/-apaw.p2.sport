package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.HashMap;

import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.daos.SportDao;

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

}