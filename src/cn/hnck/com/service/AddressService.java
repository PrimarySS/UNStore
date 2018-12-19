package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.ShippingAddress;

/**
 * 
 * @ClassName: AddressService
 * @Description: dao的service处理,给Action调用，传入数据
 * @author XHChen
 * @date 2018-9-21 下午4:04:00
 * 
 */
public interface AddressService {

	// 添加地址
	public boolean AddAddress(ShippingAddress address) throws Exception;

	// 更新地址
	public boolean UpdateAddress(ShippingAddress address) throws Exception;

	// 删除地址
	public boolean DeleteAddress(int id) throws Exception;

	// 根据id查询地址
	public ShippingAddress FindAddressById(int addressID) throws Exception;

	// 查询所有地址
	public List<ShippingAddress> FindAllAddress() throws Exception;

	// 获得数据库总数
	public int maxSize() throws Exception;

	// 分页
	public List<ShippingAddress> getByPage(int pageNo, int pageSize);
}
