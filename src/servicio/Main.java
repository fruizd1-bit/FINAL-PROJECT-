package servicio;

import java.util.Scanner;

import Dominio.Course;
import Dominio.LabEvaluation;
import Dominio.ProjectEvaluation;
import Dominio.Student;
import Dominio.WrittenExam;
import Dominio.Evaluation;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student student1 = null;
        Course programming = null;

        int option = 0;

        while (option != 8) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiante");
            System.out.println("3. Crear curso");
            System.out.println("4. Mostrar cursos");
            System.out.println("5. Agregar evaluacion");
            System.out.println("6. Mostrar evaluaciones");
            System.out.println("7. Calcular nota final");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

            case 1:

                try {

                    System.out.println("\n===== REGISTRAR ESTUDIANTE =====");

                    System.out.print("Ingrese ID: ");
                    String id = input.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String name = input.nextLine();

                    System.out.print("Ingrese email: ");
                    String email = input.nextLine();

                    student1 = new Student(id, name, email);

                    System.out.println("Estudiante registrado correctamente");

                } catch (IllegalArgumentException e) {

                    System.out.println("Error: " + e.getMessage());

                }

                break;

            case 2:

                System.out.println("\n===== ESTUDIANTE =====");

                if (student1 == null) {

                    System.out.println("No hay estudiante registrado");

                } else {

                    System.out.println(student1);
                }

                break;

            case 3:

                try {

                    if (student1 == null) {

                        System.out.println(
                                "Primero debe registrar un estudiante"
                        );

                        break;
                    }

                    System.out.println("\n===== CREAR CURSO =====");

                    System.out.print("Ingrese nombre del curso: ");
                    String courseName = input.nextLine();

                    programming = new Course(courseName);

                    student1.addCourse(programming);

                    System.out.println("Curso agregado correctamente");

                } catch (IllegalArgumentException e) {

                    System.out.println("Error: " + e.getMessage());

                }

                break;

            case 4:

                System.out.println("\n===== CURSOS DEL ESTUDIANTE =====");

                if (student1 == null) {

                    System.out.println("No hay estudiante registrado");

                } else if (student1.getCourses().isEmpty()) {

                    System.out.println("El estudiante no tiene cursos");

                } else {

                    for (Course course : student1.getCourses()) {
                        System.out.println(course);
                    }
                }

                break;

            case 5:

                try {

                    if (programming == null) {

                        System.out.println(
                                "Primero debe crear un curso"
                        );

                        break;
                    }

                    System.out.println("\n===== AGREGAR EVALUACION =====");

                    System.out.println("1. Written Exam");
                    System.out.println("2. Lab Evaluation");
                    System.out.println("3. Project Evaluation");

                    int type = input.nextInt();
                    input.nextLine();

                    System.out.print("Ingrese nombre de la evaluacion: ");
                    String evalName = input.nextLine();

                    System.out.print("Ingrese porcentaje: ");
                    double percentage = input.nextDouble();

                    System.out.print("Ingrese nota: ");
                    double score = input.nextDouble();
                    input.nextLine();

                    Evaluation evaluation = null;

                    switch (type) {

                    case 1:

                        evaluation = new WrittenExam(
                                evalName,
                                percentage,
                                score
                        );

                        break;

                    case 2:

                        evaluation = new LabEvaluation(
                                evalName,
                                percentage,
                                score
                        );

                        break;

                    case 3:

                        evaluation = new ProjectEvaluation(
                                evalName,
                                percentage,
                                score
                        );

                        break;

                    default:

                        System.out.println("Tipo invalido");
                        break;
                    }

                    if (evaluation != null) {

                        programming.addEvaluation(evaluation);

                        System.out.println(
                                "Evaluacion agregada correctamente"
                        );
                    }

                } catch (IllegalArgumentException e) {

                    System.out.println("Error: " + e.getMessage());

                }

                break;

            case 6:

                System.out.println("\n===== EVALUACIONES =====");

                if (programming == null) {

                    System.out.println("No hay curso registrado");

                } else {

                    programming.showEvaluations();
                }

                break;

            case 7:

                System.out.println("\n===== NOTA FINAL =====");

                if (programming == null) {

                    System.out.println("No hay curso registrado");

                } else {

                    System.out.println(
                            "Nota Final: "
                            + programming.calculateFinalGrade()
                    );
                }

                break;

            case 8:

                System.out.println("Saliendo del sistema...");

                break;

            default:

                System.out.println("Opcion invalida");
            }
        }

        input.close();
    }
}