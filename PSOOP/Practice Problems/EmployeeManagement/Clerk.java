public class Clerk extends Employee {
    @Override
    public double getSalary() {
        return 1.0 / 2.0 * super.getSalary();
    }

    @Override
    public double getBonus() {
        return 1000; // assumed bonus for Clerk
    }
}
