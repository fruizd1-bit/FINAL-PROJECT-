package servicio;

import Dominio.Course;
import Dominio.LabEvaluation;
import Dominio.ProjectEvaluation;
import Dominio.WrittenExam;

public class Main {

    public static void main(String[] args) {

        // Crear curso
        Course programming = new Course("Programacion 1");

        // Crear evaluaciones
        WrittenExam exam1 = new WrittenExam(
                "Parcial 1",
                30,
                85
        );

        LabEvaluation lab1 = new LabEvaluation(
                "Laboratorio 1",
                20,
                90
        );

        ProjectEvaluation project1 = new ProjectEvaluation(
                "Proyecto Final",
                50,
                95
        );

        // Agregar evaluaciones al curso
        programming.addEvaluation(exam1);
        programming.addEvaluation(lab1);
        programming.addEvaluation(project1);

        // Mostrar evaluaciones
        System.out.println("===== EVALUACIONES =====");

        programming.showEvaluations();

        // Mostrar nota final
        System.out.println("\n===== NOTA FINAL =====");

        System.out.println(
                "Nota Final: " +
                programming.calculateFinalGrade()
        );
    }
}