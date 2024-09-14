//Author Redwan Khalifa 501------
import java.util.*;

public class BoyerMooreSubstring {

    public static String algorithm(String text, String pattern) { //Returns correct output for index
        List<Integer> position = searchBMS(text, pattern);
        String index = "";

        if (position.isEmpty()) { //if pattern is not found
            return "Pattern " + pattern + " not found in text"; 
        } else {

            for (int i = 0; i < position.size(); i++) { //Adds all indices to a string
                if (i > 0) {
                    index += ", ";
                }
                index += position.get(i);
            }

            if (position.size() > 1) { //Returns index based on if 1 or more are present
                return "Pattern " + pattern + " found at indices " + index;
            } else {
                return "Pattern " + pattern + " found at index " + index;
            }
        }
    }

    public static List<Integer> searchBMS(String text, String pattern) { //Boyer-Moore substring search algorithm
        List<Integer> solution = new ArrayList<>();

        if (pattern.length() == 0) { //If no pattern was entered
            return solution;
        }

        int[] processChar = new int[256];
        processCharacter(pattern.toCharArray(), processChar);

        int s = 0;
        while (s <= (text.length() - pattern.length())) { 
            int i = pattern.length() - 1;

            while (i >= 0 && pattern.charAt(i) == text.charAt(s + i)) { //Compare Strings
                i--;
            }

            if (i < 0) {
                solution.add(s); //Save index
                s += (s + pattern.length() < text.length()) ? pattern.length() - processChar[text.charAt(s + pattern.length())] : 1; //Shift s
            } else {
                s += Math.max(1, i - processChar[text.charAt(s + i)]); //If pattern not found also shift s
            }
        }
        return solution;
    }

    public static void processCharacter(char[] pattern, int[] processChar) { //Preprocessing step
        Arrays.fill(processChar, -1);

        for (int i = 0; i < pattern.length; i++) {
            processChar[pattern[i]] = i; //save last occurance 
        }
    }

    public static void main(String[] args) {
        String text = "Hello World", pattern = "World";

        System.out.println(algorithm(text, pattern));
    }
}
