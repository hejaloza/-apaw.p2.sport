package es.upm.miw.apiArchitectureSport.daos;

import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {
	List<String> findBySport(String name);
	List<Integer> findOneSport(String name);
	
}
