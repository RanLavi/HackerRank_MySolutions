import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        boolean samllest = true;
        int unsortednum = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            // Unsortednum is smaller than the element in the current index, copy this element one index forward
            if(unsortednum < arr[i]){
                arr[i+1] = arr[i];
                // Print current state of the array
                for(int j: arr)
                    System.out.print(j + " ");
                System.out.println();
            }
            // Unsortednum is bigger than the element in the current index, copy unsortednum to the index after the current one. Array is now sorted, so we break the loop
            else{
                arr[i+1] = unsortednum;
                samllest = false;
                break;
            }
        }
        // In case there isn't an element smaller than unsortednum, the loop won't place unsortednum. We'll treat this specific case here
        if(samllest)
            arr[0] = unsortednum;
        for(int i: arr)
            System.out.print(i + " ");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
