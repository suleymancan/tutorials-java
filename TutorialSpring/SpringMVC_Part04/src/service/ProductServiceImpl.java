/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDAO;
import model.Product;

/**
 * @author suleymancan Mar 7, 2018
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ProductService#getProductById(java.lang.String)
	 */
	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(productId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ProductService#getProductsByCategory(java.lang.String)
	 */
	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		return productDAO.getProductsByCategory(categoryName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ProductService#getProductsByBrands(java.util.List)
	 */
	@Override
	public List<Product> getProductsByBrands(List<String> brands) {
		// TODO Auto-generated method stub
		return productDAO.getProductsByBrands(brands);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ProductService#addProduct(model.Product)
	 */
	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

}
