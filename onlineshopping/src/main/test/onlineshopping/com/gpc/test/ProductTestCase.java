package onlineshopping.com.gpc.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gpc.onlineshopping.dao.ProductDAO;
import com.gpc.onlineshopping.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;
	
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.gpc.onlineshopping");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	@Test
	public void testAddProduct() {
		product = new Product();

		product.setName("Mobile");
		product.setBrand("iPhone 8 plus");
		product.setDescription("This is some discription for mobile iPhone 8 plus");
		product.setUnitPrice(85000.50);
		product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);

		assertEquals("added", true, productDAO.add(product));
		
		product = new Product();

		product.setName("TV");
		product.setBrand("Videocon");
		product.setDescription("This is some discription for TV Videocon");
		product.setUnitPrice(15000.50);
		product.setQuantity(3);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);

		assertEquals("added", true, productDAO.add(product));
	}

	/*
	 * @Test public void testGetProduct() {
	 * 
	 * product = productDAO.get(3); // category=categoryDAO.get(1);
	 * 
	 * assertEquals("fetched", "apple", product.getBrand()); }
	 */
}
