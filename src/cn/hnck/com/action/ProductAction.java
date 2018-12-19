package cn.hnck.com.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.ProductDTO;
import cn.hnck.com.entity.Product;
import cn.hnck.com.service.ProductService;
import cn.hnck.com.utils.UpLoadUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @ClassName: ProductAction
 * @Description: 模型驱动封装数据
 * @author XHChen
 * @date 2018-9-27 下午8:34:19
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<ProductDTO> {

	private static final long serialVersionUID = 1L;
	// 单例模式
	private ProductDTO productDTO = new ProductDTO();
	private Product product;

	private List<Product> list;
	private Product updateProduct;

	// service IOC
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public ProductDTO getModel() {
		return productDTO;
	}

	// 请求，响应页面
	private HttpServletRequest request;

	// 图片上传
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;

	// 分页
	private int page;
	private int maxPage;

	// 存储用户的历史行为数据
	private ArrayList<String> arrayList = new ArrayList<String>();

	// 商品推荐
	public String recommended() throws Exception {
		
		for (String proName : arrayList) {
			// 分页操作
			this.request = ServletActionContext.getRequest();

			int maxPage = this.productService.maxLikeSize(proName);

			int pageNo = 1;

			int pageSize = 5;

			if (page > 0) {
				pageNo = page;
			}

			list = this.productService.getLikeByPage(proName, pageNo, pageSize);

			// 把返回的实体setAttribute到页面
			ActionContext.getContext().put("list", list);

			request.setAttribute("page", pageNo);

			request.setAttribute("maxPage", maxPage);
		}

		return "recommendpro";
	}

	// 添加商品
	public String save() throws Exception {

		product = new Product();

		String imagePath = UpLoadUtils.upload(headImg, headImgFileName);

		product.setImageSrc(imagePath);
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		this.productService.AddProduct(product);

		return "findpro";
	}

	// 修改商品
	public String update() throws Exception {

		product = new Product();

		String imagePath = UpLoadUtils.upload(headImg, headImgFileName);

		product.setId(productDTO.getId());
		product.setImageSrc(imagePath);
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		this.productService.UpdateProduct(product);

		return "findpro";
	}

	// 删除商品
	public String delete() throws Exception {

		this.productService.DeleteProduct(productDTO.getId());

		return "findpro";
	}

	// 根据id查询用户
	public String FindProductById() throws Exception {

		updateProduct = this.productService.FindProductById(productDTO.getId());

		// 把返回的实体setAttribute到页面
		ActionContext.getContext().put("updateProduct", updateProduct);

		return "updatepro";
	}

	// 模糊查询商品
	public String query() throws Exception {

		product = new Product();

		// 获取提交的搜索名称
		product.setName(productDTO.getName());

		if (product.getName() != null) {
			list = this.productService.getLike(product.getName());

			// 把返回的实体setAttribute到页面
			ActionContext.getContext().put("list", list);

			return "prolist";
		} else {
			return "findpro";
		}
	}

	// 模糊查询
	public String queryPage() throws Exception {

		// 存储用户行为数据
		if (!arrayList.contains(productDTO.getName())&& !productDTO.getName().equals("")) {
			arrayList.clear();
			arrayList.add(productDTO.getName());
		}

		product = new Product();

		// 获取提交的搜索名称
		product.setName(productDTO.getName());

		// 分页操作
		this.request = ServletActionContext.getRequest();

		int maxPage = this.productService.maxLikeSize(product.getName());

		int pageNo = 1;

		int pageSize = 5;

		if (page > 0) {
			pageNo = page;
		}

		list = this.productService.getLikeByPage(product.getName(), pageNo,
				pageSize);
		
		

		// 把返回的实体setAttribute到页面
		ActionContext.getContext().put("list", list);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "prolist";
	}

	// 分页显示
	public String list() throws Exception {

		this.request = ServletActionContext.getRequest();

		int maxPage = this.productService.maxSize();

		int pageNo = 1;

		int pageSize = 5;

		if (page > 0) {
			pageNo = page;
		}

		list = this.productService.getByPage(pageNo, pageSize);

		// 把返回的实体setAttribute到页面
		ActionContext.getContext().put("list", list);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "prolist";
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public Product getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(Product updateProduct) {
		this.updateProduct = updateProduct;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
