package Dominio;
import java.util.ArrayList;
public class Student {

    private String id;
    private String name;
    private String email;
    private ArrayList<Course> courses;
    
    // Constructor
    public Student(String id, String name, String email) {
    	setId(id);
        setName(name);
        setEmail(email);
       
        this.courses = new ArrayList<>();
    }

    // Getter ID
    public String getId() {
        return id;
    }

    // Setter ID
    public void setId(String id) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID invalido");
        }

        this.id = id;
    }

    // Getter Name
    public String getName() {
        return name;
    }

    // Setter Name
    public void setName(String name) {

    	if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Nombre invalido");
        }

        this.name = name;
    }

    // Getter Email
    public String getEmail() {
        return email;
    }

    // Setter Email
    public void setEmail(String email) {

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Correo invalido");
        }

        this.email = email;
    }
    public void addCourse(Course course) {

        if (course == null) {
            throw new IllegalArgumentException("Curso invalido");
        }

        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "ID: " + id +
               " | Nombre: " + name +
               " | Email: " + email;
    }
}