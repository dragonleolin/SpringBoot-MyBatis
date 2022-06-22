package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.Product;

@Mapper // 這個註解表示了這個類是一個mybatis的mapper介面類
@Repository
public interface ProductMapper {
	@Transactional
	int insertProduct(String name, String location, String descript, int price, String unit);

	int Product(Integer id);

	int deleteProduct(Integer id);

	int updateProduct(Product product);

	@Transactional
	int updateProductByMap(String name, String location, String descript, int price, String unit, int id);

	Product queryProductByID(int id);

	List<Product> queryAllProduct();

	// 模糊查询
	Product searchProductByNameKey(String key);
}
