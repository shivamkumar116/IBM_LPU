package in.ibm.demo.rest;

import java.lang.System.Logger.Level;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.Image;
import in.ibm.demo.service.ImageService;

@RestController
public class ImageRestController {

	private ImageService imageService;
	private Logger logger;

	@Autowired
	public ImageRestController(ImageService imageService) {
		super();
		logger = Logger.getLogger("imageRestController");
		this.imageService = imageService;
	}

	@Value("${server.port}")
	String port;
	
	@GetMapping("/images")
	public List<Image> getImages() {
		logger.info("****************port is: "+ port);
		return imageService.getAllImages();
	}

}
