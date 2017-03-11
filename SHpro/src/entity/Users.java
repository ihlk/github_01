package entity;
//用户类
public class Users {
	
	private int uid;//用户ID
	
	private String username;//用户名
	private String password;//用户密码
	
	public Users() {
		
	}
	public Users(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	
	public int getUid() {
		return uid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


	
}
