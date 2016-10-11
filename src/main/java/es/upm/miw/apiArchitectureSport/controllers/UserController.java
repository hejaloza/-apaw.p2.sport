package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.VoteListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.VoteWrapper;

public class UserController {

	public boolean createVote(int themeId, String vote) {
		Sport theme = DaoFactory.getFactory().getThemeDao().read(themeId);
		if (theme != null) {
			DaoFactory.getFactory().getVoteDao().create(new User(vote, theme));
			return true;
		} else {
			return false;
		}
	}

	public VoteListWrapper voteList() {
		List<User> votes = DaoFactory.getFactory().getVoteDao().findAll();
		VoteListWrapper voteListWrapper = new VoteListWrapper();
		for (User vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteWrapper(vote.getSport().getName(),vote.getId()));
		}
		return voteListWrapper;
	}

}
