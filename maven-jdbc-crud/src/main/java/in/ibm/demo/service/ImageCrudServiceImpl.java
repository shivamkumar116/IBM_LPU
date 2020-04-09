package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.dao.ImageCrudDao;
import in.ibm.demo.dao.ImageCrudDaoImpl;
import in.ibm.demo.model.Image;

public class ImageCrudServiceImpl implements ImageCrudService {

	private ImageCrudDao refImageCrudDao;
	
	{
		refImageCrudDao= new ImageCrudDaoImpl();	
	}
	
	

	@Override
	public void insertImage(Image objImage) {
		refImageCrudDao.insertImage(objImage);	
	}

	@Override
	public List<Image> imageList() {
		
		return refImageCrudDao.imageList();
	}

	@Override
	public void deleteImage(String id) {
		refImageCrudDao.deleteImage(id);
		
	}

	@Override
	public void updateImage(Image objImage) {
		refImageCrudDao.updateImage(objImage);
		
	}

}
