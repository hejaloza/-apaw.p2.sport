package es.upm.miw.apiArchitectureSport.api;

import java.util.List;
import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidVoteException;
import es.upm.miw.apiArchitectureSport.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

	public void createUser(String nick, String email) throws InvalidVoteException, NotFoundThemeIdException {
		this.validateUser(nick);
		new UserController().createUser(nick, email);
	}

	// Put Sport in User **/themes body="themeName"
	public void updateUser(String nick, String SportName) throws InvalidVoteException {
		this.validateSport(SportName);
		new UserController().updateVote(nick, SportName);
	}

	public UserListWrapper userList() {
		return new UserController().userList();
	}

	public UserListWrapper usersBySport(String sportName) {
		return new UserController().usersBySport(sportName);
	}

	public void validateUser(String nick) throws InvalidVoteException {
		UserWrapper userWrapper = new UserController().voteUser(nick);
		if (!userWrapper.getNick().isEmpty()) {
			throw new InvalidVoteException(nick);
		}
	}

	public void validateSport(String sportName) throws InvalidVoteException {
		List<String> listSport = DaoFactory.getFactory().getSportDao().findSportBySportName(sportName);
		if (listSport.isEmpty()) {
			throw new InvalidVoteException(sportName);
		}
	}

}
