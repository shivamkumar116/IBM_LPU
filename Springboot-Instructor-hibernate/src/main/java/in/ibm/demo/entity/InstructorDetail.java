package in.ibm.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "instructorDetail")
public class InstructorDetail  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtube_channel;

	@Column(name = "hobby")
	private String hobby;

	@JsonManagedReference
	@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * public InstructorDetail(String youtube_channel, String hobby) { super();
	 * this.youtube_channel = youtube_channel; this.hobby = hobby; }
	 */

	public InstructorDetail(String youtube_channel, String hobby, Instructor instructor) {
		super();
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@JsonManagedReference
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
