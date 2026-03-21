package co.edu.uptc.crudteacher.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.uptc.crudteacher.model.Teacher;

public class ManagementTeacher {
	
	private List<Teacher> listTeacher;
	
	private ManagementTeacher() {
		this.listTeacher = new ArrayList<>();
	}
	
	public boolean insertTeacher(String name, String id, String career,
			Date hireDate) {
		if(this.findTeacherById(id) == null) {
			this.listTeacher.add(new Teacher(name, id, career, hireDate));
			return true;
		}
		
		return false;
	}
	
	public Teacher findTeacherById(String id) {
	    return this.listTeacher.stream()
	            .filter(t -> t.getId().equals(id))
	            .findAny()
	            .orElse(null);
	}
	
	public int findIndexTeacherById(String id) {
		for(int i=0; i < this.listTeacher.size(); i++) {
			if(this.listTeacher.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean updateTeacher(Teacher newTeacher) {
		/* Identificar el registro actual */
		Teacher teacher = this.findTeacherById(newTeacher.getId());	
		if(teacher == null) {
			return false;
		}
		
		/* Realizar las asignaciones de la información */
		if(newTeacher.getName() != null && !newTeacher.getName().isEmpty()) {
			teacher.setName(newTeacher.getName());
		}
		
		if(newTeacher.getCareer() != null && !newTeacher.getCareer().isEmpty()) {
			teacher.setCareer(newTeacher.getCareer());
		}
		
		if(newTeacher.getHireDate() != null) {
			teacher.setCareer(newTeacher.getCareer());
		}
		/* Actualizarlo en la lista */
		this.listTeacher.set(this.findIndexTeacherById(newTeacher.getId()), 
				teacher);
		return true;
	}
	
	public boolean deleteTeacher(String id) {
		int index = this.findIndexTeacherById(id);
		if(index != -1) {
			this.listTeacher.remove(index);
			return true;
		}
		return false;	
	}

	public List<Teacher> getListTeacher() {
		return listTeacher;
	}

	public void setListTeacher(List<Teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}
	
	
}
