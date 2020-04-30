package in.ibm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.dao.StudentDAO;
import in.ibm.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;

	@Override
	public Student saveOrUpdate(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Iterable<Student> getAllStudent() {

		return studentDao.findAll();
	}

	@Override
	public Iterable<Student> findBySchoolName(String schoolName) {
		return studentDao.findBySchoolname(schoolName);
	}

}
