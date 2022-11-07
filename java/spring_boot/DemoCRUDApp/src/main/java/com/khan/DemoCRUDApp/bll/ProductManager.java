/**
 * 
 */
package com.khan.DemoCRUDApp.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khan.DemoCRUDApp.dal.ProductGateway;
import com.khan.DemoCRUDApp.models.ProductDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@RestController
public class ProductManager {
	
	@Autowired
	private ProductGateway aProductGateway;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductDAO product) {
		try {
			return aProductGateway.saveProduct(product)
					+ " has been SAVED successfully";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@PostMapping("/addProducts")
	public String addProducts(@RequestBody List<ProductDAO> productList) {
		try {
			return aProductGateway.saveProducts(productList)
					+ " have been SAVED successfully";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/products")
	public List<ProductDAO> findProducts() {
		return aProductGateway.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ProductDAO findProductById(@PathVariable int id) {
		return aProductGateway.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public ProductDAO findProductByName(@PathVariable String name) {
		return aProductGateway.getProductByName(name);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody ProductDAO product) {
		try {
			return aProductGateway.updateProduct(product)
					+ " has been UPDATED successfully .";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return aProductGateway.deleteProduct(id);
	}

	/**
	 * 
	 */
	public ProductManager() {
		// TODO Auto-generated constructor stub
	}

}
