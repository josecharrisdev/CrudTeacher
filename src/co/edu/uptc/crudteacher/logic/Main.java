package co.edu.uptc.crudteacher.logic;

import java.util.Date;

import co.edu.uptc.crudteacher.model.Teacher;

public class Main {

	public static void main(String[] args) {
		Management<Teacher> managementTeacher = new Management<Teacher>();
		Management<Student> managementStudent = new Management<Student>();
		
		Teacher t = new Teacher("Jose", "1", "Sistenas", new Date());
		managementTeacher.insertObject(t);
		
		System.out.println(managementTeacher.findObjectById("1"));
		
		Student s = new Student();
		s.setId("1");
		s.setName("Jose");
		s.setCode("1234");
		
		managementStudent.insertObject(s);
		System.out.println(managementStudent.findObjectById("1"));
		

	}

}
