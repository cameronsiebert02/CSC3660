public class BubbleSort {
    public static void main(String[] args) {

        int arr[] = { 64, 55, 12, 66, 91, 21, 121, 32, 33};
        int sLis[] = bubbleSort( arr );
        System.out.printf("\n Results are .... ");
        for ( int item : sLis) {
            System.out.printf("\n Item:%s", item);
        }
    }

    private static int[] bubbleSort(int[] arr) {
        // arr = { 5, 2, 9, 1}
        // n = 4      i = 0    j = 0
        // if(5 > 2) now its {2, 5, 9, 1}
        // j = 1 if(5 > 9) no
        // j = 2 if(9 > 1) now its {2, 5, 1, 9}
        // i = 1      j = 0
        // if(2 > 5) no
        // j = 1    if(5 > 1) now its {2, 1, 5, 9}
        // i = 2      j = 0
        // if(2 > 1) now its {1, 2, 5, 9}
        // Done
        int n = arr.length;
        for (int i=0; i<n-1; i++ ){
            // grab the left most item and move compare it.
            for (int j=0; j<n-i-1; j++ ){
                if ( arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}