public class InClass_9_20_BinSearch {
    public static void main(String[] args) {
        int[] myList = {2, 4, 6, 8, 10, 12, 14};
        int tok = 2;
        boolean gotIt = linearSearch(myList, tok);
        System.out.printf("\nFound: %s Ctr: %s", gotIt, Counter.ctr);
        Counter.ctr = 0;
        int result = binarySearch(myList, tok);
        System.out.printf("\nResult: %s Ctr: %s", result, Counter.ctr);
    }

    private static int binarySearch(int[] myList, int tok) {
        int low = 0;
        int high = myList.length-1;
        int result = recursiveBinSearch(myList, tok, low, high);

        return result;
    }

    private static int recursiveBinSearch(int[] myList, int tok, int low, int high) {
        Counter.ctr += 1;
        int mid = (low + high) / 2;
        if(low > high){
            return -1;
        }
        if(tok < myList[mid]){
            return recursiveBinSearch(myList, tok, low, mid-1);
        }else if(tok == myList[mid]){
            return mid;
        }else {
            return recursiveBinSearch(myList, tok, mid+1, high);
        }
    }

    private static boolean linearSearch(int[] myList, int tok) {
        for(int item : myList){
            Counter.ctr += 1;
            if(item == tok){
                return true;
            }
        }
        return false;
    }
    public class Counter {
        public static int ctr = 0;
    }
}
