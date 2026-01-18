package missing.minimum.positive.number;

/**
 * Given an array with positive, negative and duplicate numbers
 * find the missing minimum positive number in linear time and constant space (O(n) & space to store 1 number)
 */
public class MissingNumber {
    public static void main(String[] args) {
//        int[] inputArray = {3,4,-1,1};
//        int[] inputArray = {1,2,0};
        int[] inputArray = {1,2,3};
        System.out.println(findMissingMinimumPositiveNumber(inputArray));
    }

    private static int findMissingMinimumPositiveNumber(int[] inputArray) {
        int missingNumber = 1; // 1 is the minimum positive number
        for(int i : inputArray) {
            if(i == missingNumber) {
                missingNumber++;
            }
        }
        if(missingNumber > inputArray.length) {
            return -1;
        }
        return missingNumber;
    }
}
