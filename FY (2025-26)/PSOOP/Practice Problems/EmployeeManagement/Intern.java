public class Intern extends Employee {
    @Override
    public double getSalary() {
        return 3.0 / 4.0 * super.getSalary();
    }

    @Override
    public double getBonus() {
        return 500; // assumed bonus for Intern
    }
}
