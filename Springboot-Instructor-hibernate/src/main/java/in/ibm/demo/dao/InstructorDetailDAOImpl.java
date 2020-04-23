package in.ibm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.demo.entity.Instructor;
import in.ibm.demo.entity.InstructorDetail;

@Repository
public class InstructorDetailDAOImpl implements InstructorDetailDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<InstructorDetail> getInstructorsDetail() {
		Session session = entityManager.unwrap(Session.class);
		List<InstructorDetail> instructors = session.createQuery("from InstructorDetail", InstructorDetail.class)
				.getResultList();
		return instructors;
	}

	@Override
	public InstructorDetail createInstructorDetail(InstructorDetail instructorDetail) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = instructorDetail.getInstructor();
		session.getTransaction().begin();

		instructor.setInstructorDetail(instructorDetail);
		session.saveOrUpdate(instructor);

		session.getTransaction().commit();
		return instructorDetail;
	}

	@Override
	public InstructorDetail findInstructorDetailByID(int Id) {
		Session session = entityManager.unwrap(Session.class);
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, Id);
		return instructorDetail;
	}

	@Override
	public InstructorDetail updateInstructorDetail(InstructorDetail instructorDetail) {

		Session session = entityManager.unwrap(Session.class);

		session.getTransaction().begin();
		Instructor in = instructorDetail.getInstructor();
		in.setInstructorDetail(instructorDetail);
		session.update(in);		
		session.getTransaction().commit();
		return instructorDetail;

	}

	@Override
	public InstructorDetail deleteInstructorDetail(int id) {

		Session session = entityManager.unwrap(Session.class);
		session.getTransaction().begin();
		InstructorDetail instructorDetail = findInstructorDetailByID(id);
		Instructor in = instructorDetail.getInstructor();

		session.remove(in);
		;
		session.getTransaction().commit();
		return instructorDetail;

	}

}
