package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminDao
 * 
 * @Description: 管理员数据操作
 * @author XHChen
 * @date 2018年11月21日 上午9:49:24
 */
public interface AdminDao {

	// 查询管理员
	public List<Admin> findAdmin(Admin admin) throws Exception;

	// 注册
	public void insertAdmin(Admin admin) throws Exception;

}
