package cn.gzsxt.po;

public class User {
	private int id;
	private String name;
	private String pwd;
	private String age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String pwd, String age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
