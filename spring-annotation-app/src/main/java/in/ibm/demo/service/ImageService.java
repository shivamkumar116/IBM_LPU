package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.bean.Image;

public interface ImageService {

	
	public Image createImage(Image image);
	
	public List<Image> listAll();
}
