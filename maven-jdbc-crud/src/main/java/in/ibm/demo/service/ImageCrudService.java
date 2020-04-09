package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.model.Image;

public interface ImageCrudService {
	public void insertImage(Image objImage);

	public List<Image> imageList();

	public void deleteImage(String id);

	public void updateImage(Image objImage);
}
