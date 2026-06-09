package servicio;



import java.util.ArrayList;
import Dominio.Career;
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
        
        FileManager.loadData(manager);
        	
        		ArrayList<Career> careers =
        		        new ArrayList<>();
        				initializeCareers(careers);

        Student selectedStudent = null;
        Course selectedCourse = null;

        
        		String adminUser = "umg";
        		String adminPassword = "umg24";

        		System.out.println("===== LOGIN =====");

        		System.out.print("Usuario: ");
        		String user = input.nextLine();

        		System.out.print("Password: ");
        		String password = input.nextLine();

        		if (!user.equals(adminUser)
        		        || !password.equals(adminPassword)) {

        		    System.out.println("Acceso denegado");

        		    input.close();

        		    return;
        		}

        		System.out.println("Acceso concedido");
        	
        
        int option = 0;

        while (option != 14) {

        			System.out.println(
        			"\n╔════════════════════════════════════╗"
        			);

        			System.out.println(
        			"║         CAMPUS LITE UMG           ║"
        			);

        			System.out.println(
        			"╠════════════════════════════════════╣"
        			);

        			System.out.println(
        			"║           ESTUDIANTES             ║"
        			);

        			System.out.println(
        			"║ 1. Registrar estudiante           ║"
        			);

        			System.out.println(
        			"║ 2. Mostrar estudiantes            ║"
        			);

        			System.out.println(
        			"║ 3. Seleccionar estudiante         ║"
        			);

        			System.out.println(
        			"║ 4. Editar estudiante              ║"
        			);

        			System.out.println(
        			"╠════════════════════════════════════╣"
        			);

        			System.out.println(
        			"║              CURSOS               ║"
        			);

        			System.out.println(
        			"║ 5. Mostrar carreras                    ║"
        			);

        			System.out.println(
        			"║ 6. Asignar cursos                 ║"
        			);

        			System.out.println(
        			"║ 7. Mostrar curso asignados            ║"
        			);

        			System.out.println(
        			"║ 8. Seleccionar curso                 ║"
        			);

        			System.out.println(
        			"╠════════════════════════════════════╣"
        			);

        			System.out.println(
        			"║           EVALUACIONES            ║"
        			);

        			System.out.println(
        			"║ 9. Agregar evaluacion             ║"
        			);

        			System.out.println(
        			"║ 10. Mostrar evaluaciones          ║"
        			);

        			System.out.println(
        			"║ 11. Editar evaluacion             ║"
        			);

        			System.out.println(
        			"║ 12. Eliminar evaluacion           ║"
        			);

        			System.out.println(
        			"╠════════════════════════════════════╣"
        			);

        			System.out.println(
        			"║             REPORTES              ║"
        			);

        			System.out.println(
        			"║ 13. Calcular nota final           ║"
        			);

        			System.out.println(
        			"║ 14. Salir                         ║"
        			);

        			System.out.println(
        			"╚════════════════════════════════════╝"
        			);

        			System.out.print(
        			"Seleccione una opcion: "
        			);
        	
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

                 System.out.println("Estudiante registrado correctamente");

             } catch (IllegalArgumentException e) {

                 System.out.println("Error: " + e.getMessage());
             }

             break;


         // MOSTRAR ESTUDIANTES
         case 2:

             System.out.println("\n===== ESTUDIANTES =====");

             manager.showStudents();

             break;


         // SELECCIONAR ESTUDIANTE
         case 3:

             System.out.println("Ingrese ID del estudiante:");

             String searchId = input.nextLine();

             selectedStudent = manager.searchStudent(searchId);

             selectedCourse = null;

             if (selectedStudent != null) {

                 System.out.println("Estudiante seleccionado:");
                 System.out.println(selectedStudent);

             } else {

                 System.out.println("Estudiante no encontrado");
             }

             break;


         // EDITAR ESTUDIANTE
         case 4:

             if (selectedStudent == null) {

                 System.out.println("Seleccione un estudiante primero");

                 break;
             }

             try {

                 System.out.println("Ingrese nuevo nombre:");
                 String newName = input.nextLine();

                 System.out.println("Ingrese nuevo email:");
                 String newEmail = input.nextLine();

                 selectedStudent.editStudent(newName, newEmail);

                 System.out.println("Estudiante actualizado correctamente");

             } catch (IllegalArgumentException e) {

                 System.out.println("Error: " + e.getMessage());
             }

             break;
          
          // MOSTRAR CARRERAS
          case 5:

              System.out.println(
                      "\n===== CARRERAS ====="
              );

              for (Career career : careers) {

                  System.out.println(
                          "- " + career.getName()
                  );
              }

              break;


          // ASIGNAR CURSO
          case 6:

              if (selectedStudent == null) {

                  System.out.println(
                          "Seleccione un estudiante primero"
                  );

                  break;
              }

              System.out.println(
                      "\n===== CARRERAS ====="
              );

              for (Career career : careers) {

                  System.out.println(
                          "- " + career.getName()
                  );
              }

              System.out.println(
                      "Ingrese nombre de la carrera:"
              );

              String careerName =
                      input.nextLine();

              Career selectedCareer = null;

              for (Career career : careers) {

                  if (
                          career.getName()
                                  .equalsIgnoreCase(
                                          careerName
                                  )
                  ) {

                      selectedCareer = career;
                  }
              }

              if (selectedCareer == null) {

                  System.out.println(
                          "Carrera no encontrada"
                  );

                  break;
              }

              System.out.println(
                      "\n===== CURSOS DISPONIBLES ====="
              );

              selectedCareer.showCourses();

              System.out.println(
                      "Ingrese curso a asignar:"
              );

              String courseName =
                      input.nextLine();

              boolean assigned = false;

              for (
                      Course course :
                      selectedCareer.getCourses()
              ) {

                  if (
                          course.getCourseName()
                                  .equalsIgnoreCase(
                                          courseName
                                  )
                  ) {

                      selectedStudent.addCourse(
                              new Course(
                                      course.getCourseName()
                              )
                      );

                      assigned = true;

                      break;
                  }
              }

              if (assigned) {

                  System.out.println(
                          "Curso asignado correctamente"
                  );

              } else {

                  System.out.println(
                          "Curso no encontrado"
                  );
              }

              break;


          // MOSTRAR CURSOS ASIGNADOS
          case 7:

              if (selectedStudent == null) {

                  System.out.println(
                          "Seleccione un estudiante primero"
                  );

                  break;
              }

              System.out.println(
                      "\n===== CURSOS ASIGNADOS ====="
              );

              if (
                      selectedStudent.getCourses()
                              .isEmpty()
              ) {

                  System.out.println(
                          "No hay cursos asignados"
                  );

              } else {

                  for (
                          Course course :
                          selectedStudent.getCourses()
                  ) {

                      System.out.println(course);
                  }
              }

              break;


          // SELECCIONAR CURSO
          case 8:

              if (selectedStudent == null) {

                  System.out.println(
                          "Seleccione un estudiante primero"
                  );

                  break;
              }

              if (
                      selectedStudent.getCourses()
                              .isEmpty()
              ) {

                  System.out.println(
                          "No hay cursos asignados"
                  );

                  break;
              }

              System.out.println(
                      "\n===== CURSOS ====="
              );

              for (
                      Course course :
                      selectedStudent.getCourses()
              ) {

                  System.out.println(
                          course.getCourseName()
                  );
              }

              System.out.println(
                      "Ingrese nombre del curso:"
              );

              String courseSearch =
                      input.nextLine();

              selectedCourse = null;

              for (
                      Course course :
                      selectedStudent.getCourses()
              ) {

                  if (
                          course.getCourseName()
                                  .equalsIgnoreCase(
                                          courseSearch
                                  )
                  ) {

                      selectedCourse = course;
                  }
              }

              if (selectedCourse != null) {

                  System.out.println(
                          "Curso seleccionado"
                  );

              } else {

                  System.out.println(
                          "Curso no encontrado"
                  );
              }

              break;

            		// AGREGAR EVALUACION
            		case 9:

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
            		                "Error: "
            		                + e.getMessage()
            		        );
            		    }

            		    break;


            		// MOSTRAR EVALUACIONES
            		case 10:

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

            		 // EDITAR EVALUACION
            		 case 11:

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

            		         System.out.println(
            		                 "Ingrese nuevo porcentaje:"
            		         );

            		         double newPercentage =
            		                 input.nextDouble();

            		         System.out.println(
            		                 "Ingrese nueva nota:"
            		         );

            		         double newScore =
            		                 input.nextDouble();

            		         input.nextLine();

            		         selectedCourse.editEvaluation(
            		                 currentName,
            		                 newName,
            		                 newPercentage,
            		                 newScore
            		         );

            		         System.out.println(
            		                 "Evaluacion actualizada correctamente"
            		         );

            		     } catch (IllegalArgumentException e) {

            		         System.out.println(
            		                 "Error: "
            		                 + e.getMessage()
            		         );
            		     }

            		 break;
            		 
            		// ELIMINAR EVALUACION
            		case 12:

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
            	FileManager.saveData(manager);
                System.out.println(
                        "Saliendo del sistema..."
                );
              
                break;

            default:

                System.out.println(
                        "Opcion invalida"
                );
            }
        }

        input.close();
    }
    		public static void initializeCareers(
    		        ArrayList<Career> careers
    		) {

    		    // INGENIERIA EN SISTEMAS
    		    Career systems =
    		            new Career(
    		                    "Ingenieria en Sistemas"
    		            );

    		    systems.addCourse(
    		            new Course("Programacion 1")
    		    );

    		    systems.addCourse(
    		            new Course("Base de Datos")
    		    );

    		    systems.addCourse(
    		            new Course("Redes")
    		    );

    		    systems.addCourse(
    		            new Course("Matematica Discreta")
    		    );

    		    systems.addCourse(
    		            new Course("Algoritmos")
    		    );

    		    careers.add(systems);

    		    // INGENIERIA INDUSTRIAL
    		    Career industrial =
    		            new Career(
    		                    "Ingenieria Industrial"
    		            );

    		    industrial.addCourse(
    		            new Course("Fisica")
    		    );

    		    industrial.addCourse(
    		            new Course("Calculo")
    		    );

    		    industrial.addCourse(
    		            new Course("Produccion")
    		    );

    		    industrial.addCourse(
    		            new Course("Estadistica")
    		    );

    		    industrial.addCourse(
    		            new Course("Logistica")
    		    );

    		    careers.add(industrial);

    		    // ADMINISTRACION
    		    Career administration =
    		            new Career(
    		                    "Administracion"
    		            );

    		    administration.addCourse(
    		            new Course("Contabilidad")
    		    );

    		    administration.addCourse(
    		            new Course("Marketing")
    		    );

    		    administration.addCourse(
    		            new Course("Finanzas")
    		    );

    		    administration.addCourse(
    		            new Course("Economia")
    		    );

    		    administration.addCourse(
    		            new Course("Recursos Humanos")
    		    );

    		    careers.add(administration);

    		    // DERECHO
    		    Career law =
    		            new Career(
    		                    "Derecho"
    		            );

    		    law.addCourse(
    		            new Course("Derecho Penal")
    		    );

    		    law.addCourse(
    		            new Course("Derecho Civil")
    		    );

    		    law.addCourse(
    		            new Course("Constitucion")
    		    );

    		    law.addCourse(
    		            new Course("Derecho Laboral")
    		    );

    		    law.addCourse(
    		            new Course("Derecho Mercantil")
    		    );

    		    careers.add(law);

    		    // ARQUITECTURA
    		    Career architecture =
    		            new Career(
    		                    "Arquitectura"
    		            );

    		    architecture.addCourse(
    		            new Course("Diseno")
    		    );

    		    architecture.addCourse(
    		            new Course("AutoCAD")
    		    );

    		    architecture.addCourse(
    		            new Course("Construccion")
    		    );

    		    architecture.addCourse(
    		            new Course("Dibujo Tecnico")
    		    );

    		    architecture.addCourse(
    		            new Course("Urbanismo")
    		    );
    		   //Kervin Garcia //prueba
    		    careers.add(architecture);
    		}
}