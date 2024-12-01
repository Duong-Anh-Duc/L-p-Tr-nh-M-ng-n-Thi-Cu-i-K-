package RMI;
import java.io.Serializable;

public class Employee implements Serializable {
    private String id;
    private String name;
    private double baseSalary;
    private int experienceYears;
    private double finalSalary;
    private static final long serialVersionUID = 20241119L;
    public Employee(){
        this.id = "";
        this.name = "";
        this.baseSalary = 0.0;
        this.experienceYears = 0;
        this.finalSalary = 0.0;  
    }

    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", experienceYears=" + experienceYears + ", finalSalary=" + finalSalary + '}';
    }
    
}