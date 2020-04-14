package in.ibm.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ibm.demo.bean.Image;
import in.ibm.demo.config.MyAppConfig;
import in.ibm.demo.service.ImageServiceImpl;

public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
		Image image = context.getBean("image", Image.class);
		ImageServiceImpl service = context.getBean("imageServiceImpl", ImageServiceImpl.class);

		/*
		 * image.setImageID(UUID.randomUUID().toString()); image.setImageURL("demo");
		 * service.createImage(image);
		 */

		List<Image> images =service.listAll();
		for(Image im:images)
			System.out.println(im);

	}
}
