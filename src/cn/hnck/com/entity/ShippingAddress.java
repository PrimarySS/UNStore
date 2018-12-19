package cn.hnck.com.entity;

/**
 * 
 * @ClassName: ShippingAddress
 * @Description: 新增收货地址
 * @author XHChen
 * @date 2018-9-19 下午10:34:38
 * 
 */
public class ShippingAddress {

	private int id; // 地址id

	private String recipient; // 收件人

	private String mobilePhone; // 手机号

	private String address; // 收货地址(省/市/县（区）)

	private String detailedAddress; // 详细地址

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

}
