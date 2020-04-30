package in.ibm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getStudents(String schoolName) {
		return restTemplate.getForObject("http://Student-Service/students/{schoolName}", List.class, schoolName);

	}

}
