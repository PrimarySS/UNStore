package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.AdminDao;
import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminDaoImpl
 * 
 * @Description: 管理员数据操作实现
 * @author XHChen
 * @date 2018年11月21日 上午9:58:01
 */
public class AdminDaoImpl implements AdminDao {

	// 注入HibernateTemplate
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	/**
	 * 查询管理员
	 */
	public List<Admin> findAdmin(Admin admin) throws Exception {

		@SuppressWarnings("unchecked")
		List<Admin> list = this.hibernateTemplate.findByExample(admin);

		return list;
	}

	@Override
	public void insertAdmin(Admin admin) throws Exception {

		this.hibernateTemplate.save(admin);

	}

}
