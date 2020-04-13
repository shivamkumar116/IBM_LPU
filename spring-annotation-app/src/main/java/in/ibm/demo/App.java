package in.ibm.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.demo.bean.Image;
import in.ibm.demo.repo.ImageRepository;
import in.ibm.demo.repo.ImageRepositoryImpl;


public class App 

{
	
	
    public static void main( String[] args )
    {	
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       ImageRepositoryImpl imageRepositoryImpl =  context.getBean("imageRepositoryImpl",ImageRepositoryImpl.class);
       
       Image image  = imageRepositoryImpl.createImage(new Image(UUID.randomUUID().toString(),"myImage"));
       System.out.println(image);
       
    }
}
