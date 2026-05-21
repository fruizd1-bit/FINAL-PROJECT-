package Dominio;

public class LabEvaluation extends Evaluation {

    private double score;

    public LabEvaluation(String name, double percentage, double score) {
        super(name, percentage);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Invalid score");
        }

        this.score = score;
    }

    @Override
    public double calculateContribution() {
        return (score * percentage) / 100;
    }
}