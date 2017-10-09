package com.gpc.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gpc.onlineshopping.dao.ProductDAO;
import com.gpc.onlineshopping.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// retriving single product by productID
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// listing active product list
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	// adding single product
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// updating single product
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// deleting single product
	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Business methods
	 */
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "FROM Product WHERE active=:active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProduct, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategoryId = "FROM Product WHERE active=:active AND categoryId=:categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductByCategoryId, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active=:active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
