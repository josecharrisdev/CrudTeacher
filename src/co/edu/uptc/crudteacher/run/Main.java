package co.edu.uptc.crudteacher.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import co.edu.uptc.crudteacher.logic.ManagementTeacher;

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
				
				switch(operacionTeacher) {
				case 1:
					System.out.println(" CREAR TEACHER");
					System.out.println("Ingrese el nombre del profesor: ");
					String nameTeacher = sc.nextLine();
					
					System.out.println("Ingrese el id del profesor: ");
					String idTeacher = sc.nextLine();
					
					System.out.println("Ingrese la carrera del profesor: ");
					String careerName = sc.nextLine();
					Date hireDate = null;
					
					try {
						System.out.println("Ingrese la fecha de ingreso (dd/mm/yyyy)");
						String strHireDate = sc.nextLine();
						SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
						hireDate = format.parse(strHireDate);
						
						if(managementTeacher.insertTeacher(nameTeacher, idTeacher, 
								careerName, hireDate)) {
							System.out.println(" El registro se agregó correctamente");
						}else {
							System.out.println(" No se agregó el registro");
						}
					} catch (ParseException e) {
						System.out.println("La fecha se ingresó en un formato erróneo.");
					}
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
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
