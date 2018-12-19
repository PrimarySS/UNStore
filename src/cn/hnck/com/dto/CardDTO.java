package cn.hnck.com.dto;

/**
 * 
 * ClassName: CardDTO
 * 
 * @Description: 名片页面封装
 * @author XHChen
 * @date 2018年11月28日 上午10:06:21
 */
public class CardDTO {

	private int id; // 名片id

	private String name; // 姓名

	private String sex; // 性别

	private String department; // 单位

	private String mobile; // 手机

	private String phone; // 电话

	private String email; // 邮箱

	private String address; // 通讯地址

	private String flag; // 标记

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", department=" + department + ", mobile=" + mobile
				+ ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", flag=" + flag + "]";
	}

}
