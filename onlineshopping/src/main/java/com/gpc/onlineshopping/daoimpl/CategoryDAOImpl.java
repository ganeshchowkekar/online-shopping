package com.gpc.onlineshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gpc.onlineshopping.dao.CategoryDAO;
import com.gpc.onlineshopping.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// Adding 1st category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some discription for television");
		category.setImageURL("cat_1.png");

		categories.add(category);

		// Adding 2nd category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some discription for Mobile");
		category.setImageURL("cat_2.png");

		categories.add(category);

		// Adding 3rd category
		category = new Category();
		category.setId(3);
		category.setName("laptop");
		category.setDescription("This is some discription for laptop");
		category.setImageURL("cat_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//enhanced foreach loop
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		
		return null;
	}

}
