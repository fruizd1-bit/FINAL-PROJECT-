package servicio;

import java.io.*;
import java.util.ArrayList;

import Dominio.*;

public class FileManager {

    // GUARDAR TODO
    public static void saveData(StudentManager manager) {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("database.csv")
                    );

            for (Student student : manager.getStudents()) {

                // SI EL ESTUDIANTE NO TIENE CURSOS
                if (student.getCourses().isEmpty()) {

                    writer.println(
                            student.getId() + "," +
                            student.getName() + "," +
                            student.getEmail() +
                            ",SIN_CURSO"
                    );

                } else {

                    for (Course course :
                            student.getCourses()) {

                        // SI EL CURSO NO TIENE EVALUACIONES
                        if (course.getEvaluations().isEmpty()) {

                            writer.println(
                                    student.getId() + "," +
                                    student.getName() + "," +
                                    student.getEmail() + "," +
                                    course.getCourseName() +
                                    ",SIN_EVALUACION"
                            );

                        } else {

                            for (Evaluation evaluation :
                                    course.getEvaluations()) {

                                double score = 0;

                                if (evaluation
                                        instanceof WrittenExam) {

                                    score =
                                            ((WrittenExam) evaluation)
                                                    .getScore();

                                } else if (
                                        evaluation
                                                instanceof LabEvaluation
                                ) {

                                    score =
                                            ((LabEvaluation) evaluation)
                                                    .getScore();

                                } else if (
                                        evaluation
                                                instanceof ProjectEvaluation
                                ) {

                                    score =
                                            ((ProjectEvaluation) evaluation)
                                                    .getScore();
                                }

                                writer.println(
                                        student.getId() + "," +
                                        student.getName() + "," +
                                        student.getEmail() + "," +
                                        course.getCourseName() + "," +
                                        evaluation.getName() + "," +
                                        evaluation.getPercentage() + "," +
                                        score + "," +
                                        evaluation.getClass()
                                                .getSimpleName()
                                );
                            }
                        }
                    }
                }
            }

            writer.close();

            System.out.println(
                    "Datos guardados correctamente"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error guardando datos"
            );
        }
    }

    // CARGAR TODO
    public static void loadData(StudentManager manager) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("database.csv")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];

                Student student =
                        manager.searchStudent(id);

                // SI EL ESTUDIANTE NO EXISTE
                if (student == null) {

                    student =
                            new Student(
                                    id,
                                    name,
                                    email
                            );

                    manager.addStudent(student);
                }

                // SI SOLO ES ESTUDIANTE
                if (data.length == 4
                        && data[3].equals("SIN_CURSO")) {

                    continue;
                }

                String courseName = data[3];

                Course course = null;

                for (Course c :
                        student.getCourses()) {

                    if (c.getCourseName()
                            .equals(courseName)) {

                        course = c;
                        break;
                    }
                }

                // SI EL CURSO NO EXISTE
                if (course == null) {

                    course = new Course(courseName);

                    student.addCourse(course);
                }

                // SI NO TIENE EVALUACIONES
                if (data.length == 5
                        && data[4]
                        .equals("SIN_EVALUACION")) {

                    continue;
                }

                String evalName = data[4];

                double percentage =
                        Double.parseDouble(data[5]);

                double score =
                        Double.parseDouble(data[6]);

                String type = data[7];

                Evaluation evaluation = null;

                switch (type) {

                    case "WrittenExam":

                        evaluation =
                                new WrittenExam(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;

                    case "LabEvaluation":

                        evaluation =
                                new LabEvaluation(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;

                    case "ProjectEvaluation":

                        evaluation =
                                new ProjectEvaluation(
                                        evalName,
                                        percentage,
                                        score
                                );

                        break;
                }

                if (evaluation != null) {

                    course.addEvaluation(evaluation);
                }
            }

            reader.close();

            System.out.println(
                    "Datos cargados correctamente"
            );

        } catch (IOException e) {

            System.out.println(
                    "No hay datos guardados"
            );
        }
    }
}