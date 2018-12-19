package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.AddressDao;
import cn.hnck.com.entity.ShippingAddress;
import cn.hnck.com.service.AddressService;

public class AddressServiceImpl implements AddressService {

	// 导入dao接口对象
	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	/**
	 * 添加地址
	 */
	public boolean AddAddress(ShippingAddress address) throws Exception {

		int flag = this.addressDao.AddAddress(address);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 更新地址
	 */
	public boolean UpdateAddress(ShippingAddress address) throws Exception {

		int flag = this.addressDao.UpdateAddress(address);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 删除地址
	 */
	public boolean DeleteAddress(int id) throws Exception {

		int flag = this.addressDao.DeleteAddress(id);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 根据id查询地址
	 */
	public ShippingAddress FindAddressById(int addressID) throws Exception {

		return this.addressDao.FindAddressById(addressID);
	}

	@Override
	/**
	 * 查询地址
	 */
	public List<ShippingAddress> FindAllAddress() throws Exception {

		return addressDao.FindAllAddress("ShippingAddress");

	}
	
	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int maxSize() throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.addressDao.realPage("ShippingAddress");

		maxPage = (count + 4) / 5;

		return maxPage;
	}

	@Override
	/**
	 * 分页
	 */
	public List<ShippingAddress> getByPage(int pageNo, int pageSize) {

		int real = this.addressDao.realPage("ShippingAddress");

		return this.addressDao.getByPage("ShippingAddress", pageNo, pageSize, real);
	}

}
