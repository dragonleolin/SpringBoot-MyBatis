package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.pojo.Product;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	ProductMapper productMapper;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productMapper.queryAllProduct();
	}

	// 取得單一
	@GetMapping(value = "/{id}")
	public Product getOneProduct(@PathVariable int id) {
		return productMapper.queryProductByID(id);
	}
	// 模糊查詢
	@GetMapping(value = "key/{key}")
	public List<Product> searchProductByNameKey(@PathVariable String key) {
		return productMapper.searchProductByNameKey(key);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public String createProduct(@RequestBody Product product) {
		String name = product.getName();
		String location = product.getLocation();
		String descript = product.getDescript();
		int price = product.getPrice();
		String unit = product.getUnit();
		productMapper.insertProduct(name, location, descript, price, unit);
		return "新增成功";
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product) {
		String name = product.getName();
		String location = product.getLocation();
		String descript = product.getDescript();
		int price = product.getPrice();
		String unit = product.getUnit();
		productMapper.updateProductByMap(name, location, descript, price, unit, id);
		return "修改成功";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		productMapper.deleteProduct(id);
		return "刪除成功";
	}

}
