package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.bean.Image;
import in.ibm.demo.repo.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image createImage(Image image) {
		
		return imageRepository.createImage(image);
	}

	@Override
	public List<Image> listAll() {
		return imageRepository.listAll();
	}

}
