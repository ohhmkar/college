public class EmployeeManagement {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Employee intern = new Intern();
        Employee clerk = new Clerk();
        Employee manager = new Manager();

        System.out.println("Employee salary details:\n");

        emp.printPay();
        intern.printPay();
        clerk.printPay();
        manager.printPay();
    }
}
