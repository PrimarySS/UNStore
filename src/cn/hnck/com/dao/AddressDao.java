package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.ShippingAddress;

/**
 * 
 * @ClassName: AddressDao
 * @Description: 数据层接口,给serviceImpl调用，传入数据
 * @author XHChen
 * @date 2018-9-21 下午3:46:52
 * 
 */
public interface AddressDao {

	// 添加地址
	public int AddAddress(ShippingAddress address) throws Exception;

	// 更新地址
	public int UpdateAddress(ShippingAddress address) throws Exception;

	// 删除地址
	public int DeleteAddress(int id) throws Exception;

	// 根据id查询地址
	public ShippingAddress FindAddressById(int addressID) throws Exception;

	// 查询所有地址
	public List<ShippingAddress> FindAllAddress(String entityName) throws Exception;

	// 获得数据库信息总数
	public int realPage(String entityName);

	// 分页
	public List<ShippingAddress> getByPage(String entityName, int pageNo, int pageSize, int real);

}
