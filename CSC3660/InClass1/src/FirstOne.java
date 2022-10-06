public class FirstOne {
    public static void main(String[] args) {
//        System.out.printf("\n Hello World!!!");
//        int fruitCount = 0;
//        String fruit = "Apples";
//        double price = 2.99;
////        price = "banana";
//        System.out.printf("\n Fruit: %s Count: %s Price: %s", fruit, fruitCount, price);
//        Integer fCount = 0;
//        Double p = 7.7;

        int[] scores = {75, 85, 95};
        int large = getLargest(scores);
        int small = getSmallest(scores);
        int average = getAverage(scores);
        int[] scores2 = new int[10];
        System.out.printf("\nLargest score: %s", large);
        System.out.printf("\nSmallest score: %s", small);
        System.out.printf("\nAverage score: %s", average);
    }

    private static int getAverage(int[] scores) {
        int total = 0;
        int count = 0;
        for (int score : scores){
            total += score;
            count ++;
        }
        return total/count;
    }

    private static int getSmallest(int[] scores) {
        int smallest = Integer.MAX_VALUE;
        for(int score : scores){
            if(score < smallest){
                smallest = score;
            }
        }
        return smallest;
    }

    private static int getLargest(int[] scores) {
        int largest = Integer.MIN_VALUE;
        for(int num : scores){
            if (num >largest){
                largest = num;
            }
        }
        return largest;
    }
}