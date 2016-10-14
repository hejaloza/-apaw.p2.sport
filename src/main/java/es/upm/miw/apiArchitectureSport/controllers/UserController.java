package es.upm.miw.apiArchitectureSport.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserController {

	public void createUser(String nick, String email) {
		List<Sport> listSport = new ArrayList<Sport>();
		DaoFactory.getFactory().getUserDao().create(new User(nick, email, listSport));

	}

	public void updateVote(String nickUser, String SportUser) {
		List<Integer> ListIdSport = DaoFactory.getFactory().getSportDao().findOneSport(SportUser);
		Integer idSport = ListIdSport.get(0);
		Sport sport1 = DaoFactory.getFactory().getSportDao().read(idSport);
		
		List<Integer> idUser = DaoFactory.getFactory().getUserDao().findOneUser(nickUser);
		Integer id = idUser.get(0);
		User user1 = DaoFactory.getFactory().getUserDao().read(id);
		
		List<Sport> ListSports = DaoFactory.getFactory().getUserDao().findSport(id);
		ListSports.add(sport1);
		user1.setSport(ListSports);
		DaoFactory.getFactory().getUserDao().update(user1);

	}

	public UserListWrapper userList() {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper voteListWrapper = new UserListWrapper();
		for (User user : users) {
			voteListWrapper
					.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), user.getSport()));
		}
		return voteListWrapper;
	}

	public UserListWrapper usersBySport(String sport) {
		List<User> users = DaoFactory.getFactory().getUserDao().findUserBySport(sport);
		UserListWrapper voteListWrapper = new UserListWrapper();
		for (User user : users) {
			voteListWrapper
					.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), user.getSport()));
		}
		return voteListWrapper;
	}

	public UserWrapper findUser(String nick) {

		List<String> voteWrapper = DaoFactory.getFactory().getUserDao().findByUser(nick);
		String name = "";
		int id=0;
		List<Sport> listSport = new ArrayList<Sport>();

		for (String value : voteWrapper) {
			name = value;
			id++;
		}

		return new UserWrapper(id, name, name, listSport);

	}

}
