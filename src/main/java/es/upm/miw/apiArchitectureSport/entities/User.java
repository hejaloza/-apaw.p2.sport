package es.upm.miw.apiArchitectureSport.entities;

import java.util.List;

public class User {

	private int id;

	private String nick;

	private String email;

	private List<Sport> sport;

	public User() {
	}

	public User(String nick, String email, List<Sport> sport) {
		this.nick = nick;
		this.email = email;
		this.sport = sport;
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
		return "User [id=" + id + ",nick=" + nick + ", email=" + email + "]";
	}

}
