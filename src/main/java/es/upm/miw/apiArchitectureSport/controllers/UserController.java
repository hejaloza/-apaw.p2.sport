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
		List<User> votes = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper voteListWrapper = new UserListWrapper();
		// Sport sport=new Sport("null");
		for (User vote : votes) {
			voteListWrapper
					.addUserWrapper(new UserWrapper(vote.getId(), vote.getNick(), vote.getEmail(), vote.getSport()));
		}
		return voteListWrapper;
	}

	public UserListWrapper usersBySport(String sport) {
		List<User> votes = DaoFactory.getFactory().getUserDao().findUserBySport(sport);
		System.out.println(votes + "sss");
		UserListWrapper voteListWrapper = new UserListWrapper();

		for (User vote : votes) {
			voteListWrapper
					.addUserWrapper(new UserWrapper(vote.getId(), vote.getNick(), vote.getEmail(), vote.getSport()));
		}
		return voteListWrapper;
	}

	public UserWrapper voteUser(String themeId) {

		List<String> voteWrapper = DaoFactory.getFactory().getUserDao().findByUser(themeId);
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
