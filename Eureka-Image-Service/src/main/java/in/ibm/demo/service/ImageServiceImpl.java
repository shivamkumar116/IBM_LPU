package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.ImageDAO;
import in.ibm.demo.entity.Image;

@Service
public class ImageServiceImpl implements ImageService {

	private ImageDAO imageDAO;

	@Autowired
	public ImageServiceImpl(ImageDAO imageDAO) {
		super();
		this.imageDAO = imageDAO;
	}

	@Override
	public List<Image> getAllImages() {

		return (List<Image>) imageDAO.findAll();
	}

}
