package co.edu.uptc.crudteacher.model;

import java.util.Date;
import java.util.List;

public class Teacher {
	private String name;
	private String id;
	private String career;
	private Date hireDate;
	private List<Student> listStudent;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String id, String career, Date hireDate) {
		super();
		this.name = name;
		this.id = id;
		this.career = career;
		this.hireDate = hireDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public List<Student> getListStudent() {
		return listStudent;
	}
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", id=" + id + ", career=" + career + ", hireDate=" + hireDate
				+ ", listStudent=" + listStudent + "]";
	}
	
	
}
