package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.ProductDao;
import cn.hnck.com.entity.Product;
import cn.hnck.com.service.ProductService;

/**
 * 
 * @ClassName: ProductServiceImpl
 * @Description: 商品服务层实现类
 * @author XHChen
 * @date 2018-9-27 下午8:20:30
 * 
 */
public class ProductServiceImpl implements ProductService {

	// 导入dao接口对象
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	/**
	 * 添加商品
	 */
	public boolean AddProduct(Product product) throws Exception {

		int flag = this.productDao.AddProduct(product);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 更新商品
	 */
	public boolean UpdateProduct(Product product) throws Exception {

		int flag = this.productDao.UpdateProduct(product);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 刪除商品
	 */
	public boolean DeleteProduct(int ProductId) throws Exception {

		int flag = this.productDao.DeleteProduct(ProductId);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 通过id查询商品
	 */
	public Product FindProductById(int ProductID) throws Exception {

		return this.productDao.FindProductById(ProductID);
	}

	@Override
	/**
	 * 查询所以商品
	 */
	public List<Product> FindAllProduct() throws Exception {

		return this.productDao.FindAllProduct("Product");
	}

	@Override
	/**
	 * 模糊查询商品
	 */
	public List<Product> getLike(String likeName) throws Exception {

		return this.productDao.getLike(likeName);
	}

	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int maxSize() throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.productDao.realPage("Product");

		maxPage = (count + 4) / 5;

		return maxPage;
	}
	
	@Override
	/**
	 * 获得数据库模糊信息总数
	 */
	public int maxLikeSize(String likeName) throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.productDao.realLikePage(likeName);

		maxPage = (count + 4) / 5;

		return maxPage;
	}

	@Override
	/**
	 * 查询所有商品并分页
	 */
	public List<Product> getByPage(int pageNo, int pageSize) throws Exception {

		int real = this.productDao.realPage("Product");

		return this.productDao.getByPage("Product", pageNo, pageSize, real);
	}

	@Override
	/**
	 * 模糊查询所有商品并分页
	 */
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize)
			throws Exception {

		int real = this.productDao.realLikePage(likeName);
		
		return this.productDao.getLikeByPage(likeName, pageNo, pageSize, real);
	}

}
