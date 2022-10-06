public class EmployeeDriver {
    public static void main(String[] args) {
        String[] employees = new String[6];
        employees[0] = "001;Jose;A;20000";
        employees[1] = "002;Jan;B;15000.24";
        employees[2] = "003;Jackie;C;12000.22";
        employees[3] = "004;Jamies;A;10000.12";
        employees[4] = "005;Jeff;A;20000.01";
        employees[5] = "006;Jessie;A;90000.01";
        EmployeeManager em = new EmployeeManager(employees);
        System.out.printf("\nAverage Salary of Employees A: %s" +
                "\nAverage Salary of Employees B: %s" +
                "\nAverage Salary of Employee C: %s",
                em.getAverageSalary('A'),
                em.getAverageSalary('B'),
                em.getAverageSalary('C'));
    }
}
