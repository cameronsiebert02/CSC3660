import java.util.ArrayDeque;
import java.util.Deque;

public class DriveStackEmployee_10_6 {
    public static void main(String[] args) {
        Deque<Employee> employees = getEmployees();
        showEmployees(employees);
        // Let's fire the last employee we added
        Employee last = employees.pop();
        System.out.printf("\nSorry: %s you're gone: %s", last.getName(), last.toString());
        showEmployees(employees);
        Double totSal = getTotalSalary(employees);
        System.out.printf("\nTotal Salary: %s", totSal);
        System.out.printf("\nYou would be fired next: %s", employees.peek());

        String s = reverseThisString("lastClassOfWeek");
        System.out.printf("\nS: %s", s);
    }

    private static String reverseThisString(String lastClassOfWeek) {
        // Write this using a stack (deque) instead of other ways
        StringBuilder retString = new StringBuilder();
        Deque<Character> theStack = new ArrayDeque<>();
        for(int i = 0; i < lastClassOfWeek.length(); i++){
            theStack.push(lastClassOfWeek.charAt(i));
        }
        for (Character c : theStack){
            retString.append(c.toString());
        }
        return retString.toString();
    }

    private static Double getTotalSalary(Deque<Employee> employees) {
        Double total = 0.0;
        for(Employee e : employees){
            total += e.getSalary();
        }
        return total;
    }

    private static void showEmployees(Deque<Employee> employees) {
        for(Employee e : employees){
            System.out.printf("\nEmployee: %s", e.toString());
        }
    }

    private static Deque<Employee> getEmployees() {
        Deque<Employee> employees = new ArrayDeque<>();
        employees.push(new Employee(1, "Abby", 100000.00));
        employees.push(new Employee(2, "Baker", 50000.00));
        employees.push(new Employee(3, "Cathy", 60000.00));
        employees.push(new Employee(4, "Dwight", 150000.00));
        return employees;
    }
}
