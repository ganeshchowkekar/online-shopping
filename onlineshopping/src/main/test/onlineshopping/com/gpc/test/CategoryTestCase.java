package onlineshopping.com.gpc.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gpc.onlineshopping.dao.CategoryDAO;
import com.gpc.onlineshopping.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context =new AnnotationConfigApplicationContext();
		context.scan("com.gpc.onlineshopping");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		category=new Category();
		
		//category.setId(3);
		category.setName("Tv");
		category.setDescription("This is some discription for TV");
		category.setImageURL("cat_3.png");
		category.setActive(true);
		
		assertEquals("added",true, categoryDAO.add(category));
	}*/
	
	@Test
	public void testGetCategory() {
		
		category=categoryDAO.get(3);
		
		assertEquals("fetched","Laptop", category.getName());
	}
	
/*	
	@Test
	public void testUpdateCategory() {
		
		category=categoryDAO.get(1);
		category.setName("RadioPhilip");
		
		assertEquals("updated",true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		
		category=categoryDAO.get(2);
		category.setActive(false);;
		
		assertEquals("deactivated",true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched result ", 2,categoryDAO.list().size());
	}*/
	
}
