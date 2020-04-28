package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.service.AlbumService;

@RestController
public class AlbumRestController {

	private AlbumService albumService;

	@Autowired
	public AlbumRestController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	
	@RequestMapping("/albums")
	public List<Object> getAllImages(){
		return albumService.getImages();
	}

}
