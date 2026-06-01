package Dominio;

public abstract class Evaluation {

    // Constantes
    private static final double MIN_PERCENTAGE = 0;
    private static final double MAX_PERCENTAGE = 100;

    protected String name;
    protected double percentage;

    // Constructor vacío protegido
    protected Evaluation() {
    }

    // Constructor principal
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
                "El nombre no puede estar vacío"
            );
        }
        this.name = name;
    }

    // Setter porcentaje
    public void setPercentage(double percentage) {
        if (percentage < MIN_PERCENTAGE || percentage > MAX_PERCENTAGE) {
            throw new IllegalArgumentException(
                "El porcentaje debe estar entre 0 y 100"
            );
        }
        this.percentage = percentage;
    }

    // Verifica si la evaluación es válida
    public boolean isValid() {
        return name != null
                && !name.trim().isEmpty()
                && percentage >= MIN_PERCENTAGE
                && percentage <= MAX_PERCENTAGE;
    }

    // Representación en texto del objeto
    @Override
    public String toString() {
        return "Evaluation{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    /**
     * Calcula la contribución de la evaluación a la nota final.
     *
     * @return contribución calculada.
     */
    //kervin garcia
    public abstract double calculateContribution();
}