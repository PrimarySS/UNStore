package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductService
 * @Description: 商品服务层
 * @author XHChen
 * @date 2018-9-27 下午8:16:00
 * 
 */
public interface ProductService {

	// 添加商品
	public boolean AddProduct(Product product) throws Exception;

	// 更新商品
	public boolean UpdateProduct(Product product) throws Exception;

	// 删除商品
	public boolean DeleteProduct(int ProductId) throws Exception;

	// 根据id查询商品
	public Product FindProductById(int ProductID) throws Exception;

	// 查询所有商品
	public List<Product> FindAllProduct() throws Exception;
	
	// 模糊查询商品
	public List<Product> getLike(String likeName) throws Exception;
	
	// 获得数据库总数
	public int maxSize() throws Exception;
	
	// 获得数据库模糊信息总数
	public int maxLikeSize(String likeName) throws Exception;

	// 查询所有商品并分页
	public List<Product> getByPage(int pageNo, int pageSize) throws Exception;
	
	// 模糊查询所有商品并分页
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize) throws Exception;

}
