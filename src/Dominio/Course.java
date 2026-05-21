package Dominio;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private ArrayList<Evaluation> evaluations;

    public Course(String courseName) {
        this.courseName = courseName;
        this.evaluations = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Agregar evaluación
    public void addEvaluation(Evaluation evaluation) {

        if (evaluation == null) {
            throw new IllegalArgumentException("La evaluacion no puede ser null");
        }

        evaluations.add(evaluation);
    }

    // Mostrar evaluaciones
    public void showEvaluations() {

        if (evaluations.isEmpty()) {
            System.out.println("No hay evaluaciones registradas");
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
}