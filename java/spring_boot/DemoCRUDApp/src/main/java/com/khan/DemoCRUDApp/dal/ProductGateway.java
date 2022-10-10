/**
 * 
 */
package com.khan.DemoCRUDApp.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.DemoCRUDApp.models.ProductDAO;
import com.khan.DemoCRUDApp.repository.IProductRepository;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Service
public class ProductGateway {
	
	@Autowired
	private IProductRepository productRepository;

	/**
	 * 
	 */
	public ProductGateway() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDAO saveProduct(ProductDAO product) {
		return productRepository.save(product);
	}
	
	public List<ProductDAO> saveProducts(List<ProductDAO> productList) {
		return productRepository.saveAll(productList);
	}
	
	public List<ProductDAO> getAllProducts() {
		return productRepository.findAll();
	}
	
	public ProductDAO getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public ProductDAO getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product [" + id + "] has been DELETED successfully";
	}
	
	public ProductDAO updateProduct(ProductDAO product) {
		ProductDAO existingProduct = productRepository.findById(product.getId()).orElse(null);
		if(existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
		}
		return productRepository.save(existingProduct);
	}
}
