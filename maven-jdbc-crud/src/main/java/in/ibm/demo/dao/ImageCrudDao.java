package in.ibm.demo.dao;

import java.util.List;

import in.ibm.demo.model.Image;

public interface ImageCrudDao {
	
	public void insertImage(Image objImage);
	
	public List<Image> imageList();
	
	public void deleteImage(String id);
	
	public void updateImage(Image objImage);
	
}
