package es.upm.miw.apiArchitectureSport.wrappers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.Sport;

public class UserWrapper {
	private int id;
	private String nick;
	private String email;
	private List<Sport> sport;

	public UserWrapper() {
	}

	public UserWrapper(int id, String nick, String email, List<Sport> sport) {
		this.setId(id);
		this.setNick(nick);
		this.setEmail(email);
		this.setSport(sport);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Sport> getSport() {

		return sport;

	}

	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "{\"Nick\":\"" + nick + ",\"Email\":" + email + ",\"Sport\":" + sport + "}";
	}

	public String returnNick() {
		return "{\"Nick\":\"" + nick + "}";
	}

}
