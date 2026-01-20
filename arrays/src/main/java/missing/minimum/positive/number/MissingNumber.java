package missing.minimum.positive.number;

import java.util.Arrays;

/**
 * Given an array with positive, negative and duplicate numbers
 * find the missing minimum positive number in linear time and constant space (O(n) & space to store 1 number)
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] inputArray = {3,2,6,4,1,0};
//        int[] inputArray = {3,2,-1,1};
//        int[] inputArray = {1,2,0};
//        int[] inputArray = {1,2,3};
        System.out.println(findMissingMinimumPositiveNumber(inputArray));
    }

    private static int findMissingMinimumPositiveNumber(int[] inputArray) {
       boolean[] available = new boolean[inputArray.length];
       Arrays.fill(available, false);
       for(int i:inputArray) {
           if( i > 0 && i <= inputArray.length) {
               available[i-1] = true;
           }
       }
       int j = 0;
       for(boolean b:available) {
           if(!b) {
               return j+1;
           }
           j++;
       }
       return j+1;
    }
}
