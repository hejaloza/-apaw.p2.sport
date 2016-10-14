package es.upm.miw.apiArchitectureSport.api;

import java.util.List;
import java.util.Map;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidThemeFieldException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidVoteException;
import es.upm.miw.apiArchitectureSport.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureSport.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.VoteWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.VoteListWrapper;

public class UserResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(String themeId, String vote) throws InvalidVoteException, NotFoundThemeIdException {
	//	if (vote < 0 || vote > 10) {
	//		throw new InvalidVoteException("" + vote);
	//	}
		this.validateUser(themeId);
		new UserController().createVote(themeId, vote);
			
		
	}
	
	
	// Put Sport in User **/themes   body="themeName"
	public void updateUser(String nickUser,String SportUser) throws InvalidVoteException {
		
	//	List<String> themeWrapper = DaoFactory.getFactory().getSportDao().findBySport(themeName);
		
	///	new SportController().createTheme(themeName);
	//	String name="name";
		this.validateSport(SportUser);
		new UserController().updateVote(nickUser,SportUser);
		
	//	List<String> voteWrapper = DaoFactory.getFactory().getUserDao().findByUser(name);
		//User usuario= voteWrapper.get(0).;
	//	DaoFactory.getFactory().getUserDao().
	}
	

	

	// GET **/votes
	public VoteListWrapper voteList() {
		return new UserController().voteList();
	}
	
	
	// GET **/usersBySport
		public VoteListWrapper usersBySport(String sport) {
			
			return new UserController().usersBySport(sport);
		}
	
	
	
	public void validateUser(String themeId) throws InvalidVoteException {
		VoteWrapper voteWrapper = new UserController().voteUser(themeId);
		if (!voteWrapper.getThemeName().isEmpty() ) {
			throw new InvalidVoteException(themeId);
		} 
	}

	
	public void validateSport(String vote)throws InvalidVoteException {
		
		List<String> listSport = DaoFactory.getFactory().getSportDao().findBySport(vote);
		if (listSport.isEmpty() ) {
			throw new InvalidVoteException(vote);
		} 
	}

	
}
