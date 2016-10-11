package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.daos.UserDao;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer,User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<Integer> findValueByThemeId(int themeId) {
		List<User> votes = this.findAll();
		List<Integer> votesValue = new ArrayList<>();
		for (User vote : votes) {
			if (vote.getSport().getId() == themeId) {
				votesValue.add(vote.getId());
			}
		}
		return votesValue;
	}

}