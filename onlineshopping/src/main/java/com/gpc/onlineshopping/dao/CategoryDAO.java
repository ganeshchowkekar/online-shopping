package com.gpc.onlineshopping.dao;

import java.util.List;

import com.gpc.onlineshopping.dto.Category;

public interface CategoryDAO
{
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
