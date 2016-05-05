package com.spring.properities.tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("Hello World! of Annotations");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/java/com/spring/properities/tutorial/beans/beans.xml");
		Point point = (Point) context.getBean("point");
		System.out.println(point.toString());

		try {
			OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
			
			Offers off1= new Offers("poi","txt1","email111");
			Offers off2= new Offers("mno","txt2","email22");

			if(offersDao.create(off1)){
				System.out.println("OBJ 1 CREATED");
			}
			
			if(offersDao.create(off2)){
				System.out.println("OBJ 2 CREATED");
			}
			
			List<Offers> offers = offersDao.getOfferss();
			for (Offers offer : offers) {
				System.out.println(offer.toString());
			}
		} catch (Exception ex) {
			System.out.println("excption " + ex);
		}
	}

}
