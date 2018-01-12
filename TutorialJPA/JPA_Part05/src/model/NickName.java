package model;

import javax.persistence.Embeddable;

@Embeddable
public class NickName {

	@Override
	public String toString() {
		return "NickName [nick=" + nick + "]";
	}



	private String nick;
	
	

	public NickName() {
		super();
	}



	public NickName(String nick) {
		super();
		this.nick = nick;
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}


}
