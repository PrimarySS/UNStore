package cn.hnck.com.entity;

/**
 * 
 * @ClassName: Product
 * @Description: 商品实体类
 * @author XHChen
 * @date 2018-9-27 下午3:43:03
 * 
 */
public class Product {

	private int id; // 商品id主键

	private String name; // 商品名称

	private String description; // 商品描述

	private String imageSrc; // 照片地址

	private double price; // 商品价格

	// 无参构造函数
	public Product() {
		super();
	}

	// 传递商品名称
	public Product(String name) {
		super();

		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
