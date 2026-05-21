package Dominio;

public class Student {

    private String id;
    private String name;
    private String email;

    // Constructor
    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

        if (name == null || name.isEmpty()) {
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

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Correo invalido");
        }

        this.email = email;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "ID: " + id +
               " | Nombre: " + name +
               " | Email: " + email;
    }
}