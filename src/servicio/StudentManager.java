package servicio;

import java.util.ArrayList;

import Dominio.Student;

public class StudentManager {

    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {

        students = new ArrayList<>();
    }

    // Agregar estudiante
    public void addStudent(Student student) {
    	
    	   if (student == null) {

    	        throw new IllegalArgumentException(
    	                "El estudiante no puede ser null"
    	        );
    	    }

    	    if (searchStudent(student.getId()) != null) {

    	        throw new IllegalArgumentException(
    	                "El ID ya existe"
    	        );
    	    }

    	    students.add(student);

       
    }

    // Mostrar estudiantes
    public void showStudents() {

        if (students.isEmpty()) {

            System.out.println(
                    "No hay estudiantes registrados"
            );

            return;
        }

        for (Student student : students) {

            System.out.println(student);
        }
    }

    // Buscar estudiante por ID
    public Student searchStudent(String id) {

        for (Student student : students) {

            if (student.getId().equals(id)) {

                return student;
            }
        }

        return null;
    }

    // Eliminar estudiante
    public boolean removeStudent(String id) {

        Student student = searchStudent(id);

        if (student != null) {

            students.remove(student);

            return true;
        }

        return false;
    }

    // Obtener lista
    public ArrayList<Student> getStudents() {

        return students;
    }
}