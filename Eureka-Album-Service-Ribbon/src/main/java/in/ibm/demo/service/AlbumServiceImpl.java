package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getImages() {
	
		return (List<Object>) restTemplate.getForObject("http://IMAGE-SERVICE/images",Object.class);
	}

}
