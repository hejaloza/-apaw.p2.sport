package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidVoteException;
import es.upm.miw.apiArchitectureSport.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureSport.wrappers.VoteListWrapper;

public class UserResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, String vote) throws InvalidVoteException, NotFoundThemeIdException {
	/*	if (vote < 0 || vote > 10) {
			throw new InvalidVoteException("" + vote);
		}
		if (!new UserController().createVote(themeId, vote)) {
			throw new NotFoundThemeIdException("" + themeId);
		}*/
	}

	// GET **/votes
	public VoteListWrapper voteList() {
		return new UserController().voteList();
	}
}
