package com.gpc.onlineshopping.dao;

import java.util.List;

import com.gpc.onlineshopping.dto.Category;

public interface CategoryDAO
{
	List<Category> list();

	Category get(int id);


}
