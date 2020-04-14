package in.ibm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.ibm.demo.bean.Image;
import in.ibm.demo.repo.ImageDAO;

@Service
public class ImageServiceImpl implements ImageService {


	private ImageDAO imageDAO;
	
	@Autowired
	public ImageServiceImpl(ImageDAO imageDAO) {
		super();
		this.imageDAO = imageDAO;
	}


	@Override
	public Image createImage(Image image) {
	
		return imageDAO.createImage(image);
	}

}
