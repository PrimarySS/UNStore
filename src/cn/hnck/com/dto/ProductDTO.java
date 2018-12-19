package cn.hnck.com.dto;

import java.io.File;

/**
 * 
 * @ClassName: ProductDTO
 * @Description: 商品封装驱动
 * @author XHChen
 * @date 2018-9-27 下午8:32:22
 * 
 */
public class ProductDTO {

	private int id; // 商品id主键

	private String name; // 商品名称

	private double price; // 商品价格

	private String description; // 商品描述

	private File file; // 照片地址

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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
