package Dominio;

public abstract class Evaluation {

    protected String name;
    protected double percentage;

    public Evaluation(String name, double percentage) {
    	setName(name);
    	setPercentage(percentage);
        
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setName(String name) {
    	if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre invalido");
        }

        this.name = name;
      
    }

    public void setPercentage(double percentage) {

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }

        this.percentage = percentage;
    }

    public abstract double calculateContribution();
}
