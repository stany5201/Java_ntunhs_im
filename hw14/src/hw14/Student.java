package hw14;

public class Student {
    private String name;
    private double weight;
    private double height;

    public Student(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    @Override
    public String toString() {
        return name + "," + height + "," + weight + "," + String.format("%.2f", calculateBMI());
    }
}
