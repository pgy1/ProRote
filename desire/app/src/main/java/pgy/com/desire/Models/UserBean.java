package pgy.com.desire.Models;

/**
 * �û��������Զ���
 * 
 * @author pgy
 * 
 */
public class UserBean {

	private int id;

	private String email;
	private String sex;
	private String nick;

	public UserBean(String email, String sex, String nick) {
		this.email = email;
		this.sex = sex;
		this.nick = nick;
	}

	public UserBean(int id, String email, String sex, String nick) {
		this.id = id;
		this.email = email;
		this.sex = sex;
		this.nick = nick;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
