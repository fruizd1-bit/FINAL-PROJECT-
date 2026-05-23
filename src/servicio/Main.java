package servicio;


import ui.MainFrame;
import java.util.Scanner;

import Dominio.Course;
import Dominio.Evaluation;
import Dominio.LabEvaluation;
import Dominio.ProjectEvaluation;
import Dominio.Student;
import Dominio.WrittenExam;

public class Main {
	
	
    public static void main(String[] args) {
    	
    	

        Scanner input = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        
        FileManager.loadStudents(manager);
        	
        
        Student selectedStudent = null;
        Course selectedCourse = null;

        int option = 0;

        while (option != 14) {

            System.out.println("\n========== MENU ==========");

            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Seleccionar estudiante por ID");

            System.out.println("\n===== CURSOS =====");

            System.out.println("4. Crear curso");
            System.out.println("5. Mostrar cursos");
            System.out.println("6. Seleccionar curso");

            System.out.println("\n===== EVALUACIONES =====");

            System.out.println("7. Agregar evaluacion");
            System.out.println("8. Mostrar evaluaciones");
            System.out.println("9. Buscar evaluacion");
            System.out.println("10. Eliminar evaluacion");
            System.out.println("11. Editar porcentaje evaluacion");
            System.out.println("12. Editar nombre evaluacion");

            System.out.println("\n===== NOTAS =====");

            System.out.println("13. Calcular nota final");

            System.out.println("\n14. Salir");

            System.out.print("\nSeleccione una opcion: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

            // REGISTRAR ESTUDIANTE
            case 1:

                try {

                    System.out.println("Ingrese ID:");
                    String id = input.nextLine();

                    System.out.println("Ingrese nombre:");
                    String name = input.nextLine();

                    System.out.println("Ingrese email:");
                    String email = input.nextLine();

                    Student student = new Student(id, name, email);

                    manager.addStudent(student);

                    System.out.println(
                            "Estudiante registrado correctamente"
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: " + e.getMessage()
                    );
                }

                break;

            // MOSTRAR ESTUDIANTES
            case 2:

                System.out.println(
                        "\n===== ESTUDIANTES ====="
                );

                manager.showStudents();

                break;

            // SELECCIONAR ESTUDIANTE
            case 3:

                System.out.println(
                        "Ingrese ID del estudiante:"
                );

                String searchId = input.nextLine();

                selectedStudent =
                        manager.searchStudent(searchId);

                // Limpiar curso seleccionado
                selectedCourse = null;

                if (selectedStudent != null) {

                    System.out.println(
                            "Estudiante seleccionado:"
                    );

                    System.out.println(selectedStudent);

                } else {

                    System.out.println(
                            "Estudiante no encontrado"
                    );
                }

                break;

            // CREAR CURSO
            case 4:

                if (selectedStudent == null) {

                    System.out.println(
                            "Seleccione un estudiante primero"
                    );

                    break;
                }

                try {

                    System.out.println(
                            "Ingrese nombre del curso:"
                    );

                    String courseName =
                            input.nextLine();

                    Course course =
                            new Course(courseName);

                    selectedStudent.addCourse(course);

                    System.out.println(
                            "Curso agregado correctamente"
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: " + e.getMessage()
                    );
                }

                break;

            // MOSTRAR CURSOS
            case 5:

                if (selectedStudent == null) {

                    System.out.println(
                            "Seleccione un estudiante primero"
                    );

                    break;
                }

                System.out.println(
                        "\n===== CURSOS ====="
                );

                if (selectedStudent.getCourses().isEmpty()) {

                    System.out.println(
                            "No hay cursos registrados"
                    );

                } else {

                    for (Course course :
                            selectedStudent.getCourses()) {

                        System.out.println(course);
                    }
                }

                break;

            // SELECCIONAR CURSO
            case 6:

                if (selectedStudent == null) {

                    System.out.println(
                            "Seleccione un estudiante primero"
                    );

                    break;
                }

                if (selectedStudent.getCourses().isEmpty()) {

                    System.out.println(
                            "El estudiante no tiene cursos"
                    );

                    break;
                }

                System.out.println(
                        "\n===== CURSOS ====="
                );

                for (Course course :
                        selectedStudent.getCourses()) {

                    System.out.println(
                            course.getCourseName()
                    );
                }

                System.out.println(
                        "Ingrese nombre del curso:"
                );

                String courseNameSearch =
                        input.nextLine();

                selectedCourse = null;

                for (Course course :
                        selectedStudent.getCourses()) {

                    if (course.getCourseName()
                            .equalsIgnoreCase(
                                    courseNameSearch
                            )) {

                        selectedCourse = course;
                    }
                }

                if (selectedCourse != null) {

                    System.out.println(
                            "Curso seleccionado:"
                    );

                    System.out.println(selectedCourse);

                } else {

                    System.out.println(
                            "Curso no encontrado"
                    );
                }

                break;

            // AGREGAR EVALUACION
            case 7:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                try {

                    System.out.println(
                            "\nTipos de evaluacion:"
                    );

                    System.out.println(
                            "1. Examen escrito"
                    );

                    System.out.println(
                            "2. Laboratorio"
                    );

                    System.out.println(
                            "3. Proyecto"
                    );

                    int type = input.nextInt();
                    input.nextLine();

                    System.out.println(
                            "Ingrese nombre de la evaluacion:"
                    );

                    String evalName =
                            input.nextLine();

                    System.out.println(
                            "Ingrese porcentaje:"
                    );

                    double percentage =
                            input.nextDouble();

                    System.out.println(
                            "Ingrese nota:"
                    );

                    double score =
                            input.nextDouble();

                    input.nextLine();

                    Evaluation evaluation = null;

                    switch (type) {

                    case 1:

                        evaluation =
                                new WrittenExam(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;

                    case 2:

                        evaluation =
                                new LabEvaluation(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;

                    case 3:

                        evaluation =
                                new ProjectEvaluation(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;

                    default:

                        System.out.println(
                                "Tipo invalido"
                        );

                        break;
                    }

                    if (evaluation != null) {

                        selectedCourse.addEvaluation(
                                evaluation
                        );

                        System.out.println(
                                "Evaluacion agregada correctamente"
                        );
                    }

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: " + e.getMessage()
                    );
                }

                break;

            // MOSTRAR EVALUACIONES
            case 8:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                System.out.println(
                        "\n===== EVALUACIONES ====="
                );

                selectedCourse.showEvaluations();

                break;

            // BUSCAR EVALUACION
            case 9:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                System.out.println(
                        "Ingrese nombre de la evaluacion:"
                );

                String searchEvaluation =
                        input.nextLine();

                Evaluation found =
                        selectedCourse.searchEvaluation(
                                searchEvaluation
                        );

                if (found != null) {

                    System.out.println(
                            "Evaluacion encontrada:"
                    );

                    System.out.println(found);

                } else {

                    System.out.println(
                            "Evaluacion no encontrada"
                    );
                }

                break;

            // ELIMINAR EVALUACION
            case 10:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                System.out.println(
                        "Ingrese evaluacion a eliminar:"
                );

                String removeName =
                        input.nextLine();

                boolean removed =
                        selectedCourse.removeEvaluation(
                                removeName
                        );

                if (removed) {

                    System.out.println(
                            "Evaluacion eliminada"
                    );

                } else {

                    System.out.println(
                            "Evaluacion no encontrada"
                    );
                }

                break;

            // EDITAR PORCENTAJE
            case 11:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                try {

                    System.out.println(
                            "Ingrese evaluacion:"
                    );

                    String evaluationName =
                            input.nextLine();

                    System.out.println(
                            "Ingrese nuevo porcentaje:"
                    );

                    double newPercentage =
                            input.nextDouble();

                    input.nextLine();

                    selectedCourse.editEvaluationPercentage(
                            evaluationName,
                            newPercentage
                    );

                    System.out.println(
                            "Porcentaje actualizado"
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: "
                            + e.getMessage()
                    );
                }

                break;

            // EDITAR NOMBRE
            case 12:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                try {

                    System.out.println(
                            "Ingrese nombre actual:"
                    );

                    String currentName =
                            input.nextLine();

                    System.out.println(
                            "Ingrese nuevo nombre:"
                    );

                    String newName =
                            input.nextLine();

                    selectedCourse.editEvaluationName(
                            currentName,
                            newName
                    );

                    System.out.println(
                            "Nombre actualizado"
                    );

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Error: "
                            + e.getMessage()
                    );
                }

                break;

            // CALCULAR NOTA FINAL
            case 13:

                if (selectedCourse == null) {

                    System.out.println(
                            "Seleccione un curso primero"
                    );

                    break;
                }

                double finalGrade =
                        selectedCourse
                                .calculateFinalGrade();

                System.out.println(
                        "\n===== NOTA FINAL ====="
                );

                System.out.println(
                        "Curso: "
                        + selectedCourse
                                .getCourseName()
                );

                System.out.println(
                        "Nota Final: "
                        + finalGrade
                );

                if (finalGrade >= 61) {

                    System.out.println(
                            "Estado: APROBADO"
                    );

                } else {

                    System.out.println(
                            "Estado: REPROBADO"
                    );
                }

                break;

            // SALIR
            case 14:

                System.out.println(
                        "Saliendo del sistema..."
                );
               
                FileManager.saveStudents(manager);
                		

                break;

            default:

                System.out.println(
                        "Opcion invalida"
                );
            }
        }

        input.close();
    }
}