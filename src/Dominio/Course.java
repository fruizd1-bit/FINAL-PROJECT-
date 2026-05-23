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

    // Getter nombre curso
    public String getCourseName() {

        return courseName;
    }

    // Getter evaluaciones
    public ArrayList<Evaluation> getEvaluations() {

        return evaluations;
    }

    // Setter nombre curso
    public void setCourseName(String courseName) {

        if (courseName == null ||
            courseName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Nombre del curso invalido"
            );
        }

        this.courseName = courseName;
    }

    // Agregar evaluacion
    public void addEvaluation(Evaluation evaluation) {

        if (evaluation == null) {

            throw new IllegalArgumentException(
                    "La evaluacion no puede ser null"
            );
        }

        double totalPercentage = 0;

        for (Evaluation e : evaluations) {

            totalPercentage += e.getPercentage();
        }

        // Validar porcentaje maximo
        if (totalPercentage +
            evaluation.getPercentage() > 100) {

            throw new IllegalArgumentException(
                    "El porcentaje total excede 100%"
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

            finalGrade +=
                    evaluation.calculateContribution();
        }

        return finalGrade;
    }

    // Buscar evaluacion
    public Evaluation searchEvaluation(String name) {

        for (Evaluation evaluation : evaluations) {

            if (evaluation.getName()
                    .equalsIgnoreCase(name)) {

                return evaluation;
            }
        }

        return null;
    }

    // Eliminar evaluacion
    public boolean removeEvaluation(String name) {

        Evaluation evaluation =
                searchEvaluation(name);

        if (evaluation != null) {

            evaluations.remove(evaluation);

            return true;
        }

        return false;
    }

    // Editar porcentaje evaluacion
    public void editEvaluationPercentage(
            String name,
            double newPercentage
    ) {

        Evaluation evaluation =
                searchEvaluation(name);

        if (evaluation == null) {

            throw new IllegalArgumentException(
                    "Evaluacion no encontrada"
            );
        }

        double totalPercentage = 0;

        for (Evaluation e : evaluations) {

            if (!e.getName()
                    .equalsIgnoreCase(name)) {

                totalPercentage +=
                        e.getPercentage();
            }
        }

        if (totalPercentage +
            newPercentage > 100) {

            throw new IllegalArgumentException(
                    "El porcentaje total excede 100%"
            );
        }

        evaluation.setPercentage(newPercentage);
    }

    // Editar nombre evaluacion
    public void editEvaluationName(
            String currentName,
            String newName
    ) {

        Evaluation evaluation =
                searchEvaluation(currentName);

        if (evaluation == null) {

            throw new IllegalArgumentException(
                    "Evaluacion no encontrada"
            );
        }

        evaluation.setName(newName);
    }

 // Editar evaluacion completa
 public void editEvaluation(
         String currentName,
         String newName,
         double newPercentage,
         double newScore
 ) {

     Evaluation evaluation =
             searchEvaluation(currentName);

     if (evaluation == null) {

         throw new IllegalArgumentException(
                 "Evaluacion no encontrada"
         );
     }

     double currentPercentage =
             evaluation.getPercentage();

     double total = 0;

     for (Evaluation e : evaluations) {

         total += e.getPercentage();
     }

     total =
             total
             - currentPercentage
             + newPercentage;

     if (total > 100) {

         throw new IllegalArgumentException(
                 "El porcentaje total excede 100%"
         );
     }

     evaluation.setName(newName);

     evaluation.setPercentage(newPercentage);

     // CAMBIAR NOTA
     if (evaluation instanceof WrittenExam) {

         ((WrittenExam) evaluation)
                 .setScore(newScore);

     } else if (
             evaluation instanceof LabEvaluation
     ) {

         ((LabEvaluation) evaluation)
                 .setScore(newScore);

     } else if (
             evaluation instanceof ProjectEvaluation
     ) {

         ((ProjectEvaluation) evaluation)
                 .setScore(newScore);
     }
 }
    @Override
    public String toString() {

        return "Curso: " + courseName;
    }
}