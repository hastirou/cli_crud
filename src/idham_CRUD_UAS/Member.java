package idham_CRUD_UAS;

public class Member {

	private String username;
	private int level;
	private String id;
	private String role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Member(String username, int level, String id, String role) {
		super();
		this.username = username;
		this.level = level;
		this.id = id;
		this.role = role;
	}

	// getter setter -- mengambil dan meng-set

}
