package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.ProductDao;
import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductDaoImpl
 * @Description: 商品数据层实现类
 * @author XHChen
 * @date 2018-9-27 下午8:22:03
 * 
 */
public class ProductDaoImpl implements ProductDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	/**
	 * 添加商品
	 */
	public int AddProduct(Product product) throws Exception {

		// 保存dao接口传过来的封装数据
		try {
			this.hibernateTemplate.saveOrUpdate(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * 更新商品
	 */
	public int UpdateProduct(Product product) throws Exception {

		// 保存dao接口传过来的封装数据
		try {
			this.hibernateTemplate.saveOrUpdate(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * 删除商品
	 */
	public int DeleteProduct(int ProductId) throws Exception {

		// 根据id删除数据
		try {
			// 根据id找到对象
			Product product = hibernateTemplate.get(Product.class, ProductId);
			// 删除对象
			hibernateTemplate.delete(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * 根据id查询商品
	 */
	public Product FindProductById(int ProductId) throws Exception {

		return this.hibernateTemplate.get(Product.class, ProductId);

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 查询所有商品
	 */
	public List<Product> FindAllProduct(String entityName) throws Exception {

		return (List<Product>) this.hibernateTemplate.find("from" + " "
				+ entityName);

	}

	@Override
	/**
	 * 模糊查询商品
	 */
	public List<Product> getLike(String likeName) throws Exception {

		@SuppressWarnings("unchecked")
		List<Product> list = this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%");

		return list;
	}

	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int realPage(String entityName) throws Exception {

		return this.hibernateTemplate.find("from" + " " + entityName).size();
	}

	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int realLikePage(String likeName) throws Exception {

		return this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%")
				.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 数据库所有数据分页
	 */
	public List<Product> getByPage(String entityName, int pageNo, int pageSize,
			int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug修改显示bug
		if (end > real) {
			end = real;
		}

		return (List<Product>) this.hibernateTemplate.find(
				"from" + " " + entityName).subList(begin, end);
	}

	/**
	 * 
	 * @Description: 模糊查询所有数据分页
	 * @param @param entityName
	 * @param @param pageNo
	 * @param @param pageSize
	 * @param @param real
	 * @param @return
	 * @return List<Product>
	 * @throws
	 * @author XHChen
	 * @date 2018年11月21日 下午6:28:12
	 */
	public List<Product> getLikeByPage(String likeName, int pageNo,
			int pageSize, int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug修改显示bug
		if (end > real) {
			end = real;
		}

		@SuppressWarnings("unchecked")
		List<Product> list = this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%")
				.subList(begin, end);

		return list;
	}

}
