import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        // Hashset for potential gemstones(repeating characters)
        HashSet<Character> mySet = new HashSet<Character>();
        for(char c: arr[0].toCharArray()){
            mySet.add(c);
        }
        for(int i=1; i<arr.length; i++){
            // Hashset for current string's characters
            HashSet<Character> myCurrSet = new HashSet<Character>();
            for(char c: arr[i].toCharArray()){
                if(mySet.contains(c)){
                    myCurrSet.add(c);
                    // No reason to keep going over the current string
                    if(mySet.size()==myCurrSet.size()){
                        break;
                    }
                }
            }
            // Retains only the characters that appeared in the current string
            mySet.retainAll(myCurrSet);
        }
        return mySet.size();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
