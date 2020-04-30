package in.ibm.demo.service;

import in.ibm.demo.model.Student;

public interface StudentService {

	public Student saveOrUpdate(Student student);
	
	public Iterable<Student> getAllStudent();
	
	public Iterable<Student> findBySchoolName(String schoolName);
	
}
