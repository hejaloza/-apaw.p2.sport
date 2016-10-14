package es.upm.miw.apiArchitectureSport.daos;

import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	List<Integer> findValueBySportId(int sportId);
	List<String> findByUser(String themeId);
	// findOneUser(String nickUser);
	List<Integer> findOneUser(String themeId);
	List<Sport> findSport(Integer idUser);
	List<User> findUserBySport(String sportName);
}
