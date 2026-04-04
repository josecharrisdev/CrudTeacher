package co.edu.uptc.crudteacher.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Management <T extends BaseClass> {
	private List<T> listObject;
	
	public Management() {
		this.listObject = new ArrayList<>();
	}
	
	public boolean insertObject(T object) {
		System.out.println("Ingreso");
		if(this.findObjectById(object.getId()) == null) {
			System.out.println("Agregó");
			this.listObject.add(object);
			return true;
		}
		
		return false;
	}
	
	/** <b>Description:</b> Realiza el proceso búsqueda de registro */
	public T findObjectById(String id) {
	    return this.listObject.stream()
	            .filter(t -> t.getId().equals(id))
	            .findAny()
	            .orElse(null);
	}
	
	/** <b>Description:</b> Realiza el proceso búsqueda del indice del registro*/
	public int findIndexObjectById(String id) {
		for(int i=0; i < this.listObject.size(); i++) {
			if(this.listObject.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	/** <b>Description:</b> Realiza el proceso de actualización de registro */
	public boolean updateTeacher(T newRecord) {
		/* Identificar el registro actual */
		T object = this.findObjectById(newRecord.getId());	
		if(object == null) {
			return false;
		}
		/* Actualizarlo en la lista */
		this.listObject.set(this.findIndexObjectById(newRecord.getId()), 
				newRecord);
		return true;
	}
	
	/** <b>Description:</b> Realiza el proceso de eliminación de registro */
	public boolean deleteObject(String id) {
		int index = this.findIndexObjectById(id);
		if(index != -1) {
			this.listObject.remove(index);
			return true;
		}
		return false;	
	}
}
