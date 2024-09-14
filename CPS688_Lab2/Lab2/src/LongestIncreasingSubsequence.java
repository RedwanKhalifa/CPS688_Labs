//Author Redwan Khalifa 501------
import java.util.*;

public class LongestIncreasingSubsequence {
    
    public static int[] longestIncreasingSubsequence(int[] array) {

        int[] value = new int[array.length], list = new int[array.length];
        List<Integer> organize = new ArrayList<>();

        Arrays.fill(value, 1); //Fill array with values
        Arrays.fill(list, -1);

        if (array == null || array.length == 0) { //let User know if array is empty or null, if so return array
            System.out.println("Array is empty or has null values");
            return array;
        }

        for (int i = 1; i < array.length; i++) { //For every place in the array compare that value and add to hierarcy
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && value[i] < value[j] + 1) {
                    value[i] = value[j] + 1;
                    list[i] = j;
                }
            }
        }

        for (int i = array.length-1; i >= 0; i = list[i]) { //Add relavant values to Arraylist
            organize.add(array[i]);
            if (list[i] == -1) {
                break;
            }
        }

        Collections.reverse(organize); //Reverse order of Arraylist

        int[] output = new int[organize.size()];

        for (int i = 0; i < organize.size(); i++) { //Transfer list to array to remove "[]" from output
            output[i] = organize.get(i);
        }

        return output;
    }

    public static void main (String[] args) {

        int[] Array = {10, 22, 9, 33, 21, 50, 41, 60};

        int[] lis = longestIncreasingSubsequence(Array);

        System.out.println("LIS = " + lis.length); //Print out values
        System.out.print("LIS is:");
        for (int i = 0; i < lis.length; i++) {
            System.out.print(" " + lis[i]);
        }
    }
}
