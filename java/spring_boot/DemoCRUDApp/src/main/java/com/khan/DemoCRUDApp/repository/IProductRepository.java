/**
 * 
 */
package com.khan.DemoCRUDApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.DemoCRUDApp.models.ProductDAO;

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
public interface IProductRepository extends JpaRepository<ProductDAO, Integer> {

	ProductDAO findByName(String name);

}
