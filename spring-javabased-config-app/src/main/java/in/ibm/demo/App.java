package in.ibm.demo;

import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ibm.demo.bean.Image;
import in.ibm.demo.config.MyAppConfig;

public class App 
{
    public static void main( String[] args )
    {
       
    	AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(MyAppConfig.class);
    	Image image = context.getBean("image",Image.class);
    	image.setImageID(UUID.randomUUID().toString());
    	image.setImageURL("demo");
    	System.out.println(image);
    	
    }
}
