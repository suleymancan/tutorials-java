/**
 * 
 */
package service.beanParam;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * @author suleymancan Jun 15, 2018
 */
public class Product {

	@QueryParam("id")
	private int id;
	@MatrixParam("brand")
	private String brand;
	@MatrixParam("price")
	private Double price;
	@PathParam("category")
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", price=" + price + ", category=" + category + "]";
	}

}
