package in.ibm.demo.service;

import java.util.List;

import in.ibm.demo.entity.InstructorDetail;

public interface InstructorDetailService {

	public List<InstructorDetail> getInstructorsDetail();

	public InstructorDetail createInstructorDetail(InstructorDetail instructorDetail);

	public InstructorDetail findInstructorDetailByID(int Id);

	public InstructorDetail updateInstructorDetail(InstructorDetail instructorDetail);

	public InstructorDetail deleteInstructorDetail(int id);

}
