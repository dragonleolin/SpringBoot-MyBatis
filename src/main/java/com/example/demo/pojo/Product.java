package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
//这里使用了lombok快速创建了Product的 setter, getter, constructor 等方法
public class Product {
	private Integer id;
	private String name;
	private String location;
	private String descript;
	private Integer price;
	private String unit;
	private String imgPath;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", location=" + location + ", descript=" + descript + ", price="
				+ price + ", unit=" + unit + ", imgPath=" + imgPath + "]";
	}
	
	
}
