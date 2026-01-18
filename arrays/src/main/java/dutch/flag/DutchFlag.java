package dutch.flag;

import java.util.Arrays;

/**
 * This class provides a solution to the Dutch National Flag problem.
 * The Dutch National Flag problem is a classic algorithmic challenge
 * that involves sorting an array containing three distinct values
 * (such as 0, 1, and 2) so that all values of the same kind are grouped
 * together and appear in a specific order, similar to the three colors
 * of the Dutch flag. The goal is to perform this sorting in-place
 * with minimal passes over the array.
 */
public class DutchFlag {
    public static void main(String[] args) {
//        char[] input = {'R', 'B', 'G', 'R', 'G', 'G', 'B', 'G', 'B'}; // input type 1
        char[] input = {'R', 'G', 'R', 'G', 'G', 'B', 'G', 'B'};  // input type 2
        System.out.println("INPUT: "+(Arrays.toString(input)));
        System.out.println("OUTPUT: "+Arrays.toString(rearrange(input)));
    }

    private static char[] rearrange(char[] input) {
        int i = 0, l = input.length-1, k = 0;
        while(i < l) {
            while(input[i] == 'R') {
                i++;
                k++;
            }
            while(input[l] == 'G' ) {
                l--;
            }
            if(input[l] == 'B' && l > k) {
                swap(input, ++k, l);
            }
            if(input[l] == 'R') {
                swap(input, i, l);
                i++;
            }
            if (k >= l) {
                break;
            }
        }
        return input;
    }

    private static void swap(char[] input, int i, int l) {
        char temp = input[i];
        input[i] = input[l];
        input[l] = temp;
    }
}
