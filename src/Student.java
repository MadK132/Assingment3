public class Student {
    private String barcode;
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        setGpa(gpa);
        setName(name);
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}