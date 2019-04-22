package com.java.so;

import java.util.List;

import org.junit.Test;

import com.java.te.JPAUnitTest;

public class ProductTest extends JPAUnitTest {
	
	
	@Test
	public void testProductStringStringInt() {
		Product p = new Product("Huawei","Huawei P10",5, 200.5);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	@Test
	public void testGetProducts() {
		List<Product> resultList = em.createQuery("Select a From Product a", Product.class).getResultList();
		   System.out.println("num of products:" + resultList.size());
		   for (Product next : resultList) {
		      System.out.println("next product: " + next.getNameProduct());
		   }
		//fail("Not yet implemented");
	}

}
