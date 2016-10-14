package es.upm.miw.apiArchitectureSport.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.ThemeWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.VoteListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.VoteWrapper;

public class UserController {

	public void createVote(String themeId, String vote) {
	//	Sport theme = DaoFactory.getFactory().getSportDao().read(themeId);
	//	if (theme != null) {
				
	//	Sport sport=new Sport("null");
		List<Sport> listSport = new ArrayList<Sport>();
	//	listSport.add(sport);
			DaoFactory.getFactory().getUserDao().create(new User(themeId,vote,listSport));
			//return true;
	//	} else {
	//		return false;
	//	}
	}
	
	
	public void updateVote(String nickUser,String SportUser) {
		List<Integer> ListIdSport = DaoFactory.getFactory().getSportDao().findOneSport(SportUser);
		Integer idSport=ListIdSport.get(0);
		Sport sport1 = DaoFactory.getFactory().getSportDao().read(idSport);
	//	----------------------------------------------------------------------
		List<Integer> idUser = DaoFactory.getFactory().getUserDao().findOneUser(nickUser);
		System.out.println(idUser.get(0)+"Envio a dao id");
		Integer id= idUser.get(0);
		User user1=DaoFactory.getFactory().getUserDao().read(id);
		
		System.out.println(user1+"Usuarioretornado");
		
		List<Sport> ListSports = DaoFactory.getFactory().getUserDao().findSport(id);
		
		//System.out.println(ListSports+"kkk");
		
	//	Sport sport2=new Sport("sport3");
	//	Sport sport3=new Sport("sport4");
	//	List<Sport> listSport = new ArrayList<Sport>();
	//	listSport.add(sport2);
		ListSports.add(sport1);
		user1.setSport(ListSports);
	//	user1.
	//	if (theme != null) {
	//	Sport sport=new Sport("null");
			DaoFactory.getFactory().getUserDao().update(user1);
			//return true;
	//	} else {
	//		return false;
	//	}
	}
	
	

	public VoteListWrapper voteList() {
		List<User> votes = DaoFactory.getFactory().getUserDao().findAll();
		VoteListWrapper voteListWrapper = new VoteListWrapper();
		//Sport sport=new Sport("null");
		for (User vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteWrapper(vote.getId(),vote.getNick(),vote.getEmail(),vote.getSport()));
		}
		return voteListWrapper;
	}
	
	
	public VoteListWrapper usersBySport(String sport) {
		List<User> votes = DaoFactory.getFactory().getUserDao().findUserBySport(sport);
		System.out.println(votes+"sss");
		VoteListWrapper voteListWrapper = new VoteListWrapper();
		
		for (User vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteWrapper(vote.getId(),vote.getNick(),vote.getEmail(),vote.getSport()));
		}
		return voteListWrapper;
	}
	
	
	
	
	
	public VoteWrapper voteUser(String themeId) {
		
		List<String> voteWrapper = DaoFactory.getFactory().getUserDao().findByUser(themeId);
		String name="";
		Sport sport=new Sport("null");
		List<Sport> listSport = new ArrayList<Sport>();
		
		for (String value : voteWrapper) {
			 name= value;
		}
	    
		return new VoteWrapper(1,name,name,listSport);
	
	}
	
	
	
	

}
