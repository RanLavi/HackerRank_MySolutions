import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static void checkMagazine(String[] magazine, String[] note) {
        /* Start of my code */
        // Creating a hashmap for the words in the magazine and number of appearances
        HashMap<String, Integer> myMap = new HashMap<String, Integer>(); 
        for(int i=0; i<magazine.length; i++) {
            // Word already exists, plus appearances
            if (myMap.containsKey(magazine[i])) {
                myMap.put(magazine[i], myMap.get(magazine[i]) + 1);
            }
            // Word didn't appear before, add to keys and set value to 1
            else{
                myMap.put(magazine[i],1);
            }
        }
        // Checking if all the words in the note appear in myMap
        for(int i=0; i < note.length; i++){
            // If string appears in myMap substract one appearance and then, if number of appearances is 0, remove string from keys
            if (myMap.containsKey(note[i])){
                myMap.put(note[i], myMap.get(note[i]) - 1);
                if(myMap.get(note[i])==0)
                        myMap.remove(note[i]);
            }
            // If string doesn't appear in keys, print no and quit function
            else{
                System.out.print("No");
                return;
            }
        }
        // If all strings in the note were found in myMap, then print yes
        System.out.print("Yes");
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
