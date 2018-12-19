package cn.hnck.com.entity;

/**
 * 
 * ClassName: Admin
 * 
 * @Description: 管理员
 * @author XHChen
 * @date 2018年11月20日 下午9:46:28
 */
public class Admin {

	private int id; // 管理员主键

	private String AdminName; // 管理员名称

	private String AdminPassword; // 密码

	private String email; // 注册邮箱

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
