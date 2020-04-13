package in.ibm.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ibm.demo.bean.Image;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Image image = context.getBean("image",Image.class);
       System.out.println(image);
       
    }
}
