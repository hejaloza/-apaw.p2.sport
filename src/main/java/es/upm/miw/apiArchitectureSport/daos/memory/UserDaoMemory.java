package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.daos.UserDao;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}


	public List<String> findByUser(String nick) {
		List<User> users = this.findAll();
		List<String> usersName = new ArrayList<>();
		for (User user : users) {
			if (user.getNick().equalsIgnoreCase(nick)) {
				usersName.add(user.getNick());
			}
		}
		return usersName;
	}

	public List<User> findUserBySport(String sportName) {
		List<User> users = this.findAll();
		List<User> usersName = new ArrayList<>();
		for (User user : users) {
			for (int i = 0; i < user.getSport().size(); i++) {
				if (user.getSport().get(i).getName().equals(sportName)) {
					usersName.add(user);
				}

			}

		}
		return usersName;
	}

	public List<Sport> findSport(Integer idUser) {
		System.out.println("Id Usuario a buscar" + idUser);
		List<User> users = this.findAll();
		List<Sport> sportsList = new ArrayList<>();

		for (User user : users) {
			if (user.getId() == idUser) {
				for (int i = 0; i < user.getSport().size(); i++) {
					sportsList.add(user.getSport().get(i));

				}

			}
		}
		System.out.println("Lista de los usuarios" + users);

		System.out.println("Lista de los Deportes" + sportsList);
		return sportsList;
	}

	public List<Integer> findOneUser(String nickUser) {
		List<User> users = this.findAll();
		List<Integer> userId = new ArrayList<>();
		for (User user : users) {
			if (user.getNick().equalsIgnoreCase(nickUser)) {
				userId.add(user.getId());
			}

		}

		System.out.println(nickUser + "nickk");
		System.out.println(userId + "idNick");

		return userId;
	}

}