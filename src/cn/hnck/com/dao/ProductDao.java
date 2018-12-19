package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductDao
 * @Description: 商品数据层接口
 * @author XHChen
 * @date 2018-9-27 下午7:44:32
 * 
 */
public interface ProductDao {

	// 添加商品
	public int AddProduct(Product product) throws Exception;

	// 修改商品
	public int UpdateProduct(Product product) throws Exception;

	// 删除商品
	public int DeleteProduct(int ProductId) throws Exception;

	// 根据id查询商品
	public Product FindProductById(int ProductId) throws Exception;

	// 查询所有商品
	public List<Product> FindAllProduct(String entityName) throws Exception;
	
	// 模糊查询商品
	public List<Product> getLike(String likeName) throws Exception;

	// 获得数据库信息总数
	public int realPage(String entityName) throws Exception;
	
	// 模糊信息总数
	public int realLikePage(String likeName) throws Exception;

	// 查询所有商品并分页
	public List<Product> getByPage(String entityName, int pageNo, int pageSize, int real) throws Exception;
	
	// 模糊查询所有商品并分页
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize, int real) throws Exception;

}
