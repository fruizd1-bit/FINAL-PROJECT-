package Dominio;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private ArrayList<Evaluation> evaluations;

    // Constructor
    public Course(String courseName) {

        setCourseName(courseName);

        this.evaluations = new ArrayList<>();
    }

    // Getter nombre del curso
    public String getCourseName() {
        return courseName;
    }

    // Getter evaluaciones
    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }

    // Setter nombre del curso
    public void setCourseName(String courseName) {

        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nombre del curso invalido"
            );
        }

        this.courseName = courseName;
    }

    // Obtener porcentaje total acumulado
    public double getTotalPercentage() {

        double total = 0;

        for (Evaluation evaluation : evaluations) {
            total += evaluation.getPercentage();
        }

        return total;
    }

    // Agregar evaluación
    public void addEvaluation(Evaluation evaluation) {

        if (evaluation == null) {
            throw new IllegalArgumentException(
                    "La evaluacion no puede ser null"
            );
        }

        // Validar que no pase de 100%
        if (getTotalPercentage() + evaluation.getPercentage() > 100) {

            throw new IllegalArgumentException(
                    "El porcentaje total no puede superar 100%"
            );
        }

        evaluations.add(evaluation);
    }

    // Mostrar evaluaciones
    public void showEvaluations() {

        if (evaluations.isEmpty()) {

            System.out.println(
                    "No hay evaluaciones registradas"
            );

            return;
        }

        for (Evaluation evaluation : evaluations) {
            System.out.println(evaluation);
        }
    }

    // Calcular nota final
    public double calculateFinalGrade() {

        double finalGrade = 0;

        for (Evaluation evaluation : evaluations) {
            finalGrade += evaluation.calculateContribution();
        }

        return finalGrade;
    }

    @Override
    public String toString() {
        return "Curso: " + courseName;
    }
}