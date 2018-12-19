package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.AdminDao;
import cn.hnck.com.entity.Admin;
import cn.hnck.com.service.AdminService;

/**
 * 
 * ClassName: AdminImpl
 * 
 * @Description: 管理员服务实现
 * @author XHChen
 * @date 2018年11月21日 上午9:45:26
 */
public class AdminServiceImpl implements AdminService {

	// 注入dao
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	/**
	 * 查询管理员
	 */
	public List<Admin> findAdmin(Admin admin) throws Exception {

		return this.adminDao.findAdmin(admin);
	}

	@Override
	public void insertAdmin(Admin admin) throws Exception {
		
		this.adminDao.insertAdmin(admin);
	}

}
