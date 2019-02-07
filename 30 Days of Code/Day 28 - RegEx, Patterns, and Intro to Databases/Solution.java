import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        /* Start of part one of my code */
        // Creating a dynamic array to store first names of users with a valid gmail
        ArrayList<String> names = new ArrayList<String>();
        // Creating a pattern intance to use with the matcher later on
        Pattern p = Pattern.compile(".+@gmail.com$");
        /* End of part one of my code */

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            /* Start of part two of my code */
            // Creating a matcher with the pattern compared to the emailID
            Matcher m = p.matcher(emailID);
            // If emailID contains pattern, add the first name to the dynamic array
            if (m.matches()) {
                names.add(firstName);
            }
        }
        // Sorting the array alphabetically
        Collections.sort(names);
        // Printing the first name of every user with a valid gmail account
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
        /* End of part two of my code */

        scanner.close();
    }
}
