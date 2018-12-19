package cn.hnck.com.dto;

/**
 * 
 * ClassName: AdminDTO
 * 
 * @Description: 封装驱动
 * @author XHChen
 * @date 2018年11月21日 上午9:16:50
 */
public class AdminDTO {

	private int id; // 管理员主键

	private String AdminName; // 管理员名称

	private String AdminPassword; // 密码

	private String SurePassword; // 确认密码

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

	public String getSurePassword() {
		return SurePassword;
	}

	public void setSurePassword(String surePassword) {
		SurePassword = surePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
