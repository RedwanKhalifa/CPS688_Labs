//Author Redwan Khalifa 501------
import java.util.*;

public class RabinKarpSubstring {

    public static String algorithm(String text, String pattern) { //Returns correct output for index
        List<Integer> position = searchRKS(text, pattern);
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

    public static List<Integer> searchRKS(String text, String pattern) { //Rabin-Karp substring search algorithm
        List<Integer> solution = new ArrayList<>();
        int i, j, p = 0, t = 0, h = 1; //Initialize variables

        for (i = 0; i < pattern.length() - 1; i++) { //Find leading digit removal value
            h = (h * 256) % 11;
        }

        for (i = 0; i < pattern.length(); i++) { //Find hash value for pattern and text
            p = (256 * p + pattern.charAt(i)) % 11;
            t = (256 * t + text.charAt(i)) % 11;
        }

        for (i = 0; i <= text.length() - pattern.length(); i++) { //Comparing pattern to text
            if (p == t) {
                for (j = 0; j < pattern.length(); j++) { //Compare for each character at a time
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == pattern.length()) //Record match if verification is passed 
                    solution.add(i);
            }

            if(i < text.length() - pattern.length()) { //Find for next section of text
                t = (256 * (t - text.charAt(i) * h) + text.charAt(i + pattern.length())) % 11;

                if (t < 0) //Maintain positive value
                    t = (t + 11);
            }
        }
        return solution;
    }

public static void main(String[] args) {
    String text = "Hello World", pattern = "World";

    System.out.println(algorithm(text, pattern));
}
}