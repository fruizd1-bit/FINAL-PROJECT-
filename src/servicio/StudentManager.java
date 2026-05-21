package servicio;

import java.util.ArrayList;

import Dominio.Student;

public class StudentManager {

    // Lista donde se almacenarán los estudiantes
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Agregar estudiante
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("El estudiante no puede ser null");
        }

        students.add(student);
    }

    // Mostrar todos los estudiantes
    public void showStudents() {

        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Buscar estudiante por nombre
    public Student searchStudent(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }

    // Eliminar estudiante
    public boolean removeStudent(String name) {

        Student student = searchStudent(name);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Obtener lista completa
    public ArrayList<Student> getStudents() {
        return students;
    }
}