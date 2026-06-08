public class Manager extends Employee {
    @Override
    public double getSalary() {
        return 2.0 * super.getSalary();
    }

    @Override
    public double getBonus() {
        return 5000; // assumed bonus for Manager
    }
}
