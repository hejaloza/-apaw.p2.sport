package es.upm.miw.apiArchitectureSport.wrappers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;

public class VoteWrapper {
	private int id;
	private String themeName;
	private String voteValue;
    private List<Sport> sport;

	public VoteWrapper() {
	}

	public VoteWrapper(int id,String themeName, String voteValue,List<Sport> sport) {
	//	this.id=id;
	//	this.themeName = themeName;
	//	this.voteValue = voteValue;
		//this.sport=sport;
		
		this.setId(id);
		this.setThemeName(themeName);
		this.setVoteValue(voteValue);
		this.setSport(sport);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(String voteValue) {
		this.voteValue = voteValue;
	}
	
	public List<Sport> getSport(){
		
		return sport;
		
	}
	
	public void setSport(List<Sport> sport){
		this.sport=sport;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + ",\"themeName\":\"" + themeName + ",\"voteValue\":" + voteValue + ",\"sport\":" + sport + "}";
	}
	
	public String toString2() {
		return "{\"themeName\":\"" + themeName + "}";
	}

}
