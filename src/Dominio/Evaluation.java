package Dominio;

public abstract class Evaluation {

    protected String name;
    protected double percentage;

    // Constructor
    public Evaluation(String name, double percentage) {

        setName(name);
        setPercentage(percentage);
    }

    // Getter nombre
    public String getName() {
        return name;
    }

    // Getter porcentaje
    public double getPercentage() {
        return percentage;
    }

    // Setter nombre
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Nombre invalido"
            );
        }

        this.name = name;
    }

    // Setter porcentaje
    public void setPercentage(double percentage) {

        if (percentage < 0 || percentage > 100) {

            throw new IllegalArgumentException(
                    "Invalid percentage"
            );
        }

        this.percentage = percentage;
    }

    // Metodo abstracto //
    public abstract double calculateContribution();
}