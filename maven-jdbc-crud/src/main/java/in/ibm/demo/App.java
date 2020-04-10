package in.ibm.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.ibm.demo.model.Image;
import in.ibm.demo.service.ImageCrudService;
import in.ibm.demo.service.ImageCrudServiceImpl;

public class App 
{
	private ImageCrudService refImageCrudService;
	private static Scanner sc = new Scanner(System.in);
	
	{
		refImageCrudService= new ImageCrudServiceImpl();
	}
    public static void main( String[] args )
    {
    	int choice=0;
    	String imageUrl=null;
    	int availableChoice=0;
    	boolean isAvailable=false;
    	
    	App app = new App();
    	
    	
    	do {
    		
    		System.out.println("************Image App**********");
    		System.out.println("1. Insert Image\n2. List All\n3. Delete By id\n4.Update Image ");
    		choice=sc.nextInt();
    		sc.nextLine();
    		switch(choice) {
    		case 1:
    			System.out.println("Enter the image Url");
    			imageUrl=sc.nextLine();
    			System.out.println("Is image Available?");
    			System.out.println("1. Yes\n2. No");
    			availableChoice= sc.nextInt();
    			sc.nextLine();
    			if(availableChoice==1)
    				isAvailable=true;
    			else
    				isAvailable=false;
    			app.refImageCrudService.insertImage(new Image(imageUrl, isAvailable));
    			break;
    		case 2:
    			List<Image> images = app.refImageCrudService.imageList();
    			for(Image im:images) {
    				System.out.println(im);
    			}
    			break;
    		case 3:
    			System.out.println("Enter the image id : ");
    			String deleteID =sc.nextLine();
    			app.refImageCrudService.deleteImage(deleteID);
    			break;
    		case 4:
    			Image img= new Image();
    			System.out.println("Enter the image id :");
    			img.setImageID(sc.nextLine());
    			System.out.println("Enter the image url");
    			img.setImageUrl(sc.nextLine());
    			System.out.println("Enter the status : ");
    			img.setAvailable(sc.nextBoolean());
    			app.refImageCrudService.updateImage(img);
    			break;
    		case 0:
				System.out.println("bye.!!!!!");
				System.exit(0);
				break;
			default:
				break;
    		
    		}
    		
    	}
    	while(choice!=0);
    	
        
    	
    }
}
