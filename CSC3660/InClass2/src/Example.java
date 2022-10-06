public class Example {



    public static void main(String[] args) {
        String inLine = "Jack,22,95.5";
        int[] scores = {45, 99, 66, 55, 22};
        int oddSum = getOddSum(scores);
        Double num = getDouble(inLine);
        System.out.printf("\nExtracted Double: %s", num);
        System.out.printf("\nOdd Sum: %s", oddSum);
    }

    private static int getOddSum(int[] scores) {
        int oddSum = 0;
        for(int score : scores){
            if(score%2 == 1 ){
                oddSum += score;
            }
        }
        return oddSum;
    }

    private static Double getDouble(String inLine) {
        double num = 0.0;
        for (int i = 0;i < inLine.length();i++){
            String[] toks = inLine.split(",");
            num = Double.parseDouble(toks[2]);
        }
        return num;
    }

}
