package in.ibm.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.demo.bean.Image;
import in.ibm.demo.repo.ImageRepository;
import in.ibm.demo.repo.ImageRepositoryImpl;
import in.ibm.demo.service.ImageService;
import in.ibm.demo.service.ImageServiceImpl;

public class App

{

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*
		 * WITHOUT IMPLEMENTING SERVICE LAYER ImageRepositoryImpl imageRepositoryImpl =
		 * context.getBean("imageRepositoryImpl",ImageRepositoryImpl.class);
		 * 
		 * Image image = imageRepositoryImpl.createImage(new
		 * Image(UUID.randomUUID().toString(),"myImage")); System.out.println(image);
		 */
		
		ImageService imageService = context.getBean("imageServiceImpl", ImageServiceImpl.class);
		Image image = context.getBean("image", Image.class);
		image = imageService.createImage(new Image(UUID.randomUUID().toString(), "Sample"));
		System.out.println(image);

		// List all the images in the database
		List<Image> images = imageService.listAll();
		System.out.println("Images in the database are ...........");
		for (Image im : images) {
			System.out.println(im);
		}

	}
}
