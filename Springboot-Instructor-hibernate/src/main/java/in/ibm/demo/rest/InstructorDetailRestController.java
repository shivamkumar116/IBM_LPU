package in.ibm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.entity.InstructorDetail;
import in.ibm.demo.service.InstructorDetailService;

@RestController
@RequestMapping("/api")
public class InstructorDetailRestController {

	@Autowired
	private InstructorDetailService instructorDetailService;

	@RequestMapping("/instructorsdetail")
	public List<InstructorDetail> getInstructors() {
		return instructorDetailService.getInstructorsDetail();
	}

	@RequestMapping("/instructorsdetail/{instructorDetailID}")
	public InstructorDetail getInstructorByID(@PathVariable int instructorDetailID) {
		return instructorDetailService.findInstructorDetailByID(instructorDetailID);
	}

	@PostMapping("/instructorsdetail")
	public InstructorDetail createInstructor(@RequestBody InstructorDetail instructorDetail) {
		instructorDetail.setId(0);
		
		return instructorDetailService.createInstructorDetail(instructorDetail);
	}

	@PutMapping("/instructorsdetail")
	public InstructorDetail updateInstructor(@RequestBody InstructorDetail instructorDetail) {
		return instructorDetailService.updateInstructorDetail(instructorDetail);
	}

	@DeleteMapping("/instructorsdetail/{instructorDetailID}")
	public InstructorDetail deleteInstructor(@PathVariable int instructorDetailID) {
		return instructorDetailService.deleteInstructorDetail(instructorDetailID);
	}

}
