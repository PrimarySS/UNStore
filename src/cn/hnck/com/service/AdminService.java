package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminService
 * 
 * @Description: 管理员服务接口
 * @author XHChen
 * @date 2018年11月21日 上午9:42:00
 */
public interface AdminService {

	// 查询管理员
	public List<Admin> findAdmin(Admin admin) throws Exception;

	// 注册
	public void insertAdmin(Admin admin) throws Exception;

}
