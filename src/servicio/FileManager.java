package servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Dominio.Student;

public class FileManager {

    private static final String FILE_NAME =
            "students.txt";

    // Guardar estudiantes
    public static void saveStudents(
            StudentManager manager
    ) {

        try (

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    )

        ) {

            for (Student student :
                    manager.getStudents()) {

                writer.write(
                        student.getId()
                        + ","
                        + student.getName()
                        + ","
                        + student.getEmail()
                );

                writer.newLine();
            }

            System.out.println(
                    "Estudiantes guardados correctamente"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar archivo"
            );
        }
    }

    // Cargar estudiantes
    public static void loadStudents(
            StudentManager manager
    ) {

        try (

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_NAME)
                    )

        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];

                Student student =
                        new Student(
                                id,
                                name,
                                email
                        );

                manager.addStudent(student);
            }

            System.out.println(
                    "Estudiantes cargados correctamente"
            );

        } catch (IOException e) {

            System.out.println(
                    "No existe archivo previo"
            );
        }
    }
}