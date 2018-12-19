package cn.hnck.com.action;

import java.util.List;

import cn.hnck.com.dto.AdminDTO;
import cn.hnck.com.entity.Admin;
import cn.hnck.com.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport implements
		ModelDriven<AdminDTO> {

	private static final long serialVersionUID = 1L;
	// 获得页面封装的数据
	private AdminDTO adminDTO = new AdminDTO();
	// 创建实体类
	private Admin admin;

	// 注入service ioc
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public AdminDTO getModel() {
		return adminDTO;
	}

	/**
	 * 
	 * @Description: 管理员登陆
	 * @param
	 * @return void
	 * @throws Exception
	 * @throws
	 * @author XHChen
	 * @date 2018年11月21日 上午10:10:52
	 */
	public String admin() throws Exception {

		// 创建admin对象
		admin = new Admin();

		// 设置页面封装的值
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminPassword(adminDTO.getAdminPassword());

		// 查询数据库
		List<Admin> list = this.adminService.findAdmin(admin);

		int size = list.size();

		if (size > 0) {
			// 管理员存在,进入主页面
			ActionContext.getContext().put("AdminName", admin.getAdminName());

			return "success";
		} else {
			// 管理员不存在,返回提示信息
			String msg = "管理员不存在!";
			ActionContext.getContext().put("msg", msg);

			// 返回登陆页面
			return "msg";
		}
	}

	/**
	 * 
	 * @Description: 退出登陆
	 * @param @return
	 * @return String
	 * @throws
	 * @author XHChen
	 * @date 2018年11月21日 上午11:51:22
	 */
	public String out() throws Exception {

		return "out";
	}

	/**
	 * 
	 * @Description: 管理员注册
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 * @author XHChen
	 * @date 2018年12月17日 下午1:36:40
	 */
	public String registered() throws Exception {

		// 创建admin对象
		admin = new Admin();

		// 密码匹配
		if (adminDTO.getAdminName().equals("")){
			ActionContext.getContext().put("error", "昵称不能为空！");

		} else if (adminDTO.getAdminPassword().equals("")) {
			ActionContext.getContext().put("error", "密码不能为空！");

		} else if (adminDTO.getSurePassword().equals("")) {
			ActionContext.getContext().put("error", "确认密码不能为空！");

		} else if (adminDTO.getEmail().equals("")) {
			ActionContext.getContext().put("error", "邮箱不能为空！");

		}else if (!adminDTO.getAdminPassword().equals(adminDTO.getSurePassword())) {
			ActionContext.getContext().put("error", "密码不匹配！");

		} else {
			admin.setAdminName(adminDTO.getAdminName());
			admin.setAdminPassword(adminDTO.getAdminPassword());
			admin.setEmail(adminDTO.getEmail());
	
			// 添加管理员
			adminService.insertAdmin(admin);
	
			// 响应信息
			ActionContext.getContext().put("msg", "注册成功！");
	
			return "msg";
		}
			
		return "error";
	}
}
