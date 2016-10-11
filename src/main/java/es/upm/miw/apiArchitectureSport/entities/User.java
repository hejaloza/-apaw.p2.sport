package es.upm.miw.apiArchitectureSport.entities;

public class User {
	
	private int id;
    private String nick;
    private String email;

    private Sport sport;

    public User() {
    }

    public User(String nick, Sport sport) {
        this.nick = nick;
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

    public Sport getSport() {
        return sport;
    }

	@Override
	public String toString() {
		return "User [nick=" + nick + ", email=" + email + ", sport=" + sport + "]";
	}

}
