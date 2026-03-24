package co.edu.uptc.crudteacher.run;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import co.edu.uptc.crudteacher.logic.ManagementTeacher;
import co.edu.uptc.crudteacher.model.Teacher;

public class Main {

	public static void main(String[] args) {
		String menuPrincipal = """
				----- EJERCICIO CRUDS -----
				[1] CRUD TEACHER 
				[2] CRUD STUDENT
				[3] SALIR
				""";
		
		String menuTeacher = """
				----- EJERCICIO CRUDS -----
				[1] CREAR TEACHER
				[2] BUSCAR TEACHER
				[3] ACTUALIZAR TEACHER
				[4] ELIMINAR TEACHER
				[5] LISTAR TEACHER
				[6] SALIR
				""";
		
		String menuStudent = """
				----- EJERCICIO CRUDS -----
				[1] CREAR STUDENT
				[2] BUSCAR STUDENT
				[3] ACTUALIZAR STUDENT
				[4] ELIMINAR STUDENT
				""";
		
		ManagementTeacher managementTeacher = new ManagementTeacher();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println(menuPrincipal);
			int operacion = Integer.parseInt(sc.nextLine());
			
			switch(operacion) {
			case 1:
				System.out.println(menuTeacher);
				int operacionTeacher = Integer.parseInt(sc.nextLine());
				managementTeacher.insertTeacher("name", "1", "aa", new Date());
				
				
				switch(operacionTeacher) {
				case 1:
					
					System.out.println(" CREAR TEACHER");
					System.out.println("Ingrese el nombre del profesor: ");
					String nameTeacher = sc.nextLine();
					
					System.out.println("Ingrese el id del profesor: ");
					String idTeacher = sc.nextLine();
					
					System.out.println("Ingrese la carrera del profesor: ");
					String careerName = sc.nextLine();
					
					System.out.println("Ingrese la fecha de ingreso (dd/mm/yyyy)");
					String strHireDate = sc.nextLine();
					
					//Solución con split
					String fechaArray [] = strHireDate.split("/");
					Calendar calendar = Calendar.getInstance();
					calendar.set(Integer.parseInt(fechaArray[2]), 
							Integer.parseInt(fechaArray[1]) - 1, 
							Integer.parseInt(fechaArray[0]));
					
					/* Si ocurre un error, nunca llegará a esta línea */
					if(managementTeacher.insertTeacher(nameTeacher, idTeacher, 
							careerName, calendar.getTime())) {
						System.out.println(" El registro se agregó correctamente");
					}else {
						System.out.println(" No se agregó el registro");
					}
					break;
				case 2:
					System.out.println("Digite el identificador del TEACHER: ");
					String id = sc.nextLine();
					Teacher teacher = managementTeacher.findTeacherById(id);
					if(!Objects.isNull(teacher)) {
						System.out.println(teacher.getHireDate());
						System.out.println(teacher);
					}else {
						System.out.println("La persona no fue encontrada.");
					}
					break;
				case 3:
					System.out.println(" Actualizar Teacher ");
					System.out.println("Ingrese el identificador del TEACHER: ");
					String idUpdateTeacher = sc.nextLine();
					
					System.out.println("Ingrese el nombre del TEACHER: ");
					String nameUpdateTeacher = sc.nextLine();
					
					System.out.println("Ingrese la carrera del TEACHER: ");
					String careerUpdateTeacher = sc.nextLine();
					
					Teacher teacherUpdate = new Teacher();
					teacherUpdate.setId(idUpdateTeacher);
					teacherUpdate.setName(nameUpdateTeacher);
					teacherUpdate.setCareer(careerUpdateTeacher);
					teacherUpdate.setHireDate(null);
					
					if(managementTeacher.updateTeacher(teacherUpdate)) {
						System.out.println("Se realizó la actualización");
					}else {
						System.out.println("No se realizó la actualización");
					}
					break;
				case 4:
					System.out.println("ELIMINAR TEACHER");
					System.out.println("Digite el identificador del TEACHER a eliminar: ");
					String idDeleteTeacher = sc.nextLine();
					if(managementTeacher.deleteTeacher(idDeleteTeacher)) {
						System.out.println("Se eliminó el registro.");
					}else {
						System.out.println("No se eliminó el registro.");
					}
					break;
				case 5:
					System.out.println("   LISTAR TEACHER   ");
					managementTeacher.getListTeacher()
						.forEach(t -> System.out.println(t));
					break;
				case 6:
					flag = false;
					break;
				}
				
				break;
			case 2:
				System.out.println(menuStudent);
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}

}
