package es.upm.miw.apiArchitectureSport.api;

import java.util.List;
import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.exceptions.ExistsUserException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

	public void createUser(String nick, String email) throws ExistsUserException, InvalidUserFieldException {
		this.validateField(nick, email);
		this.validateUser(nick);
		new UserController().createUser(nick, email);
	}

	// Put Sport in User **/ body="sportName"
	public void updateUser(String nick, String SportName) throws InvalidSportException {
		this.validateSport(SportName);
		new UserController().updateVote(nick, SportName);
	}

	public UserListWrapper userList() {
		return new UserController().userList();
	}

	public UserListWrapper usersBySport(String sportName) {
		return new UserController().usersBySport(sportName);
	}

	public void validateUser(String nick) throws ExistsUserException {
		UserWrapper userWrapper = new UserController().findUser(nick);
		if (!userWrapper.getNick().isEmpty()) {
			throw new ExistsUserException(nick);
		}
	}

	public void validateSport(String sportName) throws InvalidSportException {
		List<String> listSport = DaoFactory.getFactory().getSportDao().findSportBySportName(sportName);
		if (listSport.isEmpty()) {
			throw new InvalidSportException(sportName);
		}
	}

	private void validateField(String nick, String email) throws InvalidUserFieldException {
		if (nick.isEmpty() || email.isEmpty()) {
			throw new InvalidUserFieldException();
		}
	}

}
