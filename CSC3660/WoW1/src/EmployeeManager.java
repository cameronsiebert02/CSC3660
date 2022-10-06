public class EmployeeManager {
    String[] inString;

    public EmployeeManager(String[] inString) {
        this.inString = inString;
    }

    public double getAverageSalary(char inchar){
        double total = 0;
        int count = 0;
        double average = 0;
        for(String item : inString){
            String[] toks = item.split(";");
            try {
                for (int i = 0; i < item.length(); i++) {
                    if (item.charAt(i) == inchar) {
                        total += Double.parseDouble(toks[3]);
                        count++;
                    }
                }
            }catch (Exception e){
                System.out.printf("\nIllegal Employee Data: %s", item);
            }
        }
        average = total/count;
        if (average > 0){
            return average;
        }
        return 0;
    }
}
