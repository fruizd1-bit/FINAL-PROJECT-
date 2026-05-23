package Dominio;

import java.util.ArrayList;

public class Career {

    private String name;

    private ArrayList<Course> courses;

    // Constructor
    public Career(String name) {

        this.name = name;

        this.courses = new ArrayList<>();
    }

    // Getter nombre
    public String getName() {

        return name;
    }

    // Setter nombre
    public void setName(String name) {

        if (
                name == null ||
                name.trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                    "Nombre de carrera invalido"
            );
        }

        this.name = name;
    }

    // Agregar curso
    public void addCourse(Course course) {

        if (course == null) {

            throw new IllegalArgumentException(
                    "Curso invalido"
            );
        }

        courses.add(course);
    }

    // Obtener cursos
    public ArrayList<Course> getCourses() {

        return courses;
    }

    // Mostrar cursos
    public void showCourses() {

        if (courses.isEmpty()) {

            System.out.println(
                    "No hay cursos"
            );

            return;
        }

        for (Course course : courses) {

            System.out.println(
                    "- " +
                    course.getCourseName()
            );
        }
    }

    @Override
    public String toString() {

        return "Carrera: " + name;
    }
}