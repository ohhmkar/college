public class Employee {
    public double getSalary() {
        return 10000; // base salary
    }

    public double getBonus() {
        return 0; // default bonus
    }

    public void printPay() {
        double salary = getSalary();
        double bonus = getBonus();
        double total = salary + bonus;
        System.out.println(this.getClass().getSimpleName() + " :");
        System.out.println("  Salary = Rs. " + (int) salary);
        System.out.println("  Bonus  = Rs. " + (int) bonus);
        System.out.println("  Total  = Rs. " + (int) total);
        System.out.println();
    }
}
