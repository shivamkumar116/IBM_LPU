package in.ibm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Object> getStudents(String schoolName) {

		Iterable<Object> students = (Iterable<Object>) restTemplate
				.getForObject("http://Student-Service/students/{schoolName}", Object.class, schoolName);
		return students;
	}

}
